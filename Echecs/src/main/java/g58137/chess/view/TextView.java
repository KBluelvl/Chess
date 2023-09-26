package g58137.chess.view;

import g58137.chess.model.*;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 *
 * @author Florian
 */
public class TextView implements View {

    private Model model;
    private Scanner clavier = new Scanner(System.in);
    private final String ANSI_RESET = "\u001B[0m";
    public static final String WHITE_BACKGROUND_BRIGHT  = "\033[0;107m";
    public static final String BLACK_BRIGHT = "\033[0;90m";

    /**
     * Constructeur TextView qui initialise l'attribut model.
     *
     * @param model = interface model donnée.
     */
    public TextView(Model model) {
        this.model = model;
    }

    /**
     * affiche un titre et un message de bienvenue aux joueurs.
     */
    @Override
    public void displayTitle() {
        System.out.println("Les Échecs :");
        System.out.println("Bienvenue sur ce jeu");
    }

    /**
     * affiche le plateau de jeu.
     */
    @Override
    public void displayBoard() {
        try{
        for (int i = 7; i >= 0; i--) {
            System.setOut(new PrintStream(System.out, true, "UTF8")); // Pour les consoles
            System.out.print(i + 1);
            for (int j = 0; j < 8; j++) {
                displaySquare(i,j);
            }
            System.out.println("");
        }
        System.out.println("  a   b   c   d   e   f   g   h");
    } catch(UnsupportedEncodingException e){
            System.out.println("Une UnsupportedEncodingException est detecté : "+e.getMessage());
        }
    }

    /**
     * Affiche un carré du plateau de jeu.
     * @param i position sur l'axe y
     * @param j position sur l'axe x
     */
    private void displaySquare(int i, int j){
        Position pos = new Position(i, j);
        boolean isPieceNull = model.getPiece(pos) == null;
        boolean isEvenRow = i % 2 == 0;
        boolean isEvenColumn = j % 2 == 0;
        if (isEvenRow) {
            if (isPieceNull && isEvenColumn) {
                System.out.print(WHITE_BACKGROUND_BRIGHT +"    "+ ANSI_RESET);
            } else if (isPieceNull) {
                System.out.print(BLACK_BRIGHT +"    "+ ANSI_RESET);
            } else if (isEvenColumn) {
                System.out.print(WHITE_BACKGROUND_BRIGHT +" "+ model.getPiece(pos) +"  "+ ANSI_RESET);
            } else {
                System.out.print(BLACK_BRIGHT +" "+ model.getPiece(pos) +"  "+ ANSI_RESET);
            }
        } else {
            if (model.getPiece(pos) == null && isEvenColumn) {
                System.out.print(BLACK_BRIGHT +"    "+ ANSI_RESET);
            } else if (model.getPiece(pos) == null) {
                System.out.print(WHITE_BACKGROUND_BRIGHT +"    "+ ANSI_RESET);
            } else if (isEvenColumn) {
                System.out.print(BLACK_BRIGHT +" "+ model.getPiece(pos)+"  "+ ANSI_RESET);
            } else {
                System.out.print(WHITE_BACKGROUND_BRIGHT +" "+ model.getPiece(pos)+"  "+ ANSI_RESET);
            }
        }
    }

    /**
     * affiche le joueur gagnant.
     */
    @Override
    public void displayWinner() {
        if (model.getCurrentPlayer().getColor() == Color.BLACK) {
            System.out.println("Les noirs ont gagné.");
        } else {
            System.out.println("Les blancs ont gagné.");
        }
    }

    /**
     * affiche un message invitant le joueur courant (blanc ou noir) à jouer.
     */
    @Override
    public void displayPlayer() {
        if (model.getCurrentPlayer().getColor() == Color.BLACK) {
            System.out.println("Au tour des noirs");
        } else {
            System.out.println("Au tour des blancs");
        }
        System.out.println("Quel pion voulez vous deplacer ?(Colonne puis ligne)");
    }

    /**
     * demande une position valide sur le plateau de jeu à l’utilisateur.
     *
     * @return une position valide sur le plateau
     */
    @Override
    public Position askPosition() {
        Position pos = null;
        boolean estCorrect;

        do {
            try {
                estCorrect = true;
                System.out.println("Veuillez entrez une position.");
                String coordonnée = clavier.nextLine();
                pos = changeInPosition(coordonnée);
            } catch (Exception e) {
                System.out.println("cette position n'existe pas.");
                estCorrect = false;
            }
        } while (!estCorrect);

        return pos;
    }

    /**
     * affiche le message d’erreur passé en paramètre
     *
     * @param message = message d’erreur passé en paramètre.
     */
    @Override
    public void displayError(String message) {
        System.out.println(message);
    }

    /**
     * recupère une chaine de charactère de type chffreLettre et la transforme
     * en position.
     *
     * @param move = chaine de caratères représentant un position sur le
     * plateau.
     * @return une position crée à partir du string reçue en paramètre.
     */
    private Position changeInPosition(String move) {
        char PremièreLettre = move.toLowerCase().charAt(0);
        char DeuxièmeLettre = move.toLowerCase().charAt(1);

        Integer column;
        column = switch (PremièreLettre) {
            case 'a' ->
                0;
            case 'b' ->
                1;
            case 'c' ->
                2;
            case 'd' ->
                3;
            case 'e' ->
                4;
            case 'f' ->
                5;
            case 'g' ->
                6;
            case 'h' ->
                7;
            default ->
                throw new IllegalArgumentException();
        };
        Integer row = switch (DeuxièmeLettre) {
            case '1' ->
                0;
            case '2' ->
                1;
            case '3' ->
                2;
            case '4' ->
                3;
            case '5' ->
                4;
            case '6' ->
                5;
            case '7' ->
                6;
            case '8' ->
                7;
            default ->
                throw new IllegalArgumentException();
        };
        return new Position(row, column);
    }

    /**
     * affiche un message.
     * 
     * @param message = message affiché.
     */
    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    } 

    /**
     * affiche l'état du jeu.
     * 
     * @param  state = l'état du jeu.
     */
    @Override
    public void displayState(GameState state) {
        switch (state) {
            case CHECK -> System.out.println("Vous êtes en Echec.");
            case CHECK_MATE -> System.out.println("Echec et Mat");
            case STALE_MATE -> System.out.println("Egalité");
            default -> { System.out.println(state);
            }
        }
    }
}
