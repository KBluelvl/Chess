package g58137.chess.model;

import g58137.chess.model.pieces.Piece;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Florian
 */
public class Board {

    private Square[][] squares; // tableau de Square

    /**
     * Constructeur Board qui crée un Board de 8 x 8 Square
     * initialisé à null.
     */
    public Board() {
        squares = new Square[8][8];
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares.length; j++) {
                squares[i][j] = new Square(null);
            }
        }
    }

    /**
     * Getter qui retourne l'attribut squares.
     * @return l'attribut squares.
     */
    public Square[][] getSquares() {
        return squares;
    }

    /**
     * renvoie true si la position passée en paramètre est sur le plateau.
     *
     * @param pos = position donnée.
     * @return true si la position est sur le plateau sinon false.
     */
    public boolean contains(Position pos) {
        Integer row = pos.getRow();
        Integer column = pos.getColumn();
        
        return !(row < 0 || row > squares.length-1 || column < 0 || column > squares.length-1);
    }

    /**
     * place la pièce passée en paramètre sur le case correspondante du plateau.
     *
     * @param piece = piece donnée.
     * @param position = position donnée.
     * @throws IllegalArgumentException si le tableau ne contient pas la position donnée en paramètre.
     */
    public void setPiece(Piece piece, Position position) {
        if (!contains(position)) {
            throw new IllegalArgumentException("La position donnée n'est pas sur le platteau.");
        }
        Integer row = position.getRow();
        Integer column = position.getColumn();

        squares[column][row].setPiece(piece);
    }

    /**
     * renvoie la pièce située sur la case dont la position est passée en paramètre.
     *
     * @param pos = position donnée.
     * @return la case dont la position est passée en paramètre.
     * @throws IllegalArgumentException si le tableau ne contient pas la position donnée en paramètre.
     */
    public Piece getPiece(Position pos) {
        if (!contains(pos)) {
            throw new IllegalArgumentException("la position donnée n’est pas sur le plateau");
        }
        Integer row = pos.getRow();
        Integer column = pos.getColumn();

        return squares[column][row].getPiece();
    }

    /**
     * renvoie 6 pour la couleur BLACK et 1 pour la couleur WHITE.
     *
     * @param color = couleur donnée.
     * @return 6 pour la couleur BLACK et 1 pour la couleur WHITE.
     */
    public Integer getInitialPawnRow(Color color) {
        return color == Color.BLACK ? 6 : 1;
    }

    /**
     * supprime la pièce d'une case de position donnée en paramètre.
     *
     * @param pos = position donnée.
     * @throws IllegalArgumentException si le tableau ne contient pas la position donnée en paramètre.
     */
    public void dropPiece(Position pos) {
        if (!contains(pos)) {
            throw new IllegalArgumentException("La position donnée n'est pas sur le plateau");
        }
        setPiece(null, pos);
    }

    /**
     * renvoie true si la case en position donnée est libre sinon false.
     *
     * @param pos = position donnée
     * @return true si la case en position donnée est libre sinon false.
     * @throws IllegalArgumentException si le tableau ne contient pas la position donnée en paramètre.
     */
    public boolean isFree(Position pos) {
        if (!contains(pos)) {
            throw new IllegalArgumentException("la position donnée n'est pas sur le plateau");
        }
        Integer row = pos.getRow();
        Integer column = pos.getColumn();

        return squares[column][row].isFree();
    }

    /**
     * renvoie true si la case de position donnée contient une piece de couleur
     * opposé à la couleur reçue en paramètre.
     *
     * @param pos = position donnée.
     * @param col = couleur donnée.
     * @return true si la case de position donnée contient une piece de couleur opposé à celle reçue en paramètre.
     * @throws IllegalArgumentException si le tableau ne contient pas la position donnée en paramètre.
     */
    public boolean containsOppositeColor(Position pos, Color col) {
        if (!contains(pos)) {
            throw new IllegalArgumentException("la position donnée n'est pas sur le plateau");
        }
        if (isFree(pos)) {
            return false;
        }
        return this.getPiece(pos).getColor() != col;
    }

    /**
     * renvoie la liste de toutes les positions occupées par le joueur donnée(player).
     *
     * @param player = joueur donnée.
     * @return la liste de tout les positions occupées par un joueur.
     */
    public List<Position> getPositionOccupiedBy(Player player) {
        List<Position> nbPieces = new ArrayList();

        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                Position pos = new Position(j,i);
                // prends toutes les cases où il y'a une pièce.
                if (!isFree(pos)) {
                    // vérifie si c'est bien le pion du joueur.
                    if (player.getColor() == getPiece(pos).getColor()) {
                        nbPieces.add(new Position(j, i));
                    }
                }
            }
        }
        return nbPieces;
    }
    
    /**
     * rnevoie la position de la pièce passée en paramètre sur 
     * le plateau de jeu.
     * 
     * @param piece = pièce donnée.
     * @return  la position de la pièce.
     */
    public Position getPiecePosition (Piece piece){
        for(int i = 0; i<squares.length; i++){
            for(int j = 0;j<squares[i].length;j++){
            Position pos = new Position(j,i);
            if(getPiece(pos) == piece){
                return pos;
            }
            }
        }
        return null;
    }


    
    
}
