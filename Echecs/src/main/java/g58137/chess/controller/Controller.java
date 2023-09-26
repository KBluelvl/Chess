package g58137.chess.controller;

import g58137.chess.model.*;
import g58137.chess.view.*;

/**
 *
 * @author Florian
 */
public class Controller {

    private View view;
    private Model model;

    /**
     * Constructeur Controlleur qui initialise les interfaces Model et View.
     *
     * @param model = interface donnée.
     * @param view = autre interface donnée.
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * remplie les conditions suivantes : 1) Afficher le plateau de jeu et
     * inviter le joueur courant à jouer, 2) Demander une position de départ et
     * d'arrivée, 3) Jouer le coup (après avoir vérifier sa validité) 4)
     * Vérifier si le jeu est terminé, et mettre gameIsOver à jour
     */
    public void play() {
        Model game = new Game();
        View view = new TextView(game);

        // un bouléen qui vérifie si la partie est finie.
        boolean gameIsOver = false;

        // on affiche un titre et un message de bienvenue aux joueurs.
        view.displayTitle();

        // on prépare le plateau de jeu.
        game.start();

        // un booléen qui vérifie si la position est cohérente.
        boolean goodPosition = false;

        Position départ = null;
        Position arrivé;

        while (!gameIsOver) { // boucle tant que la partie n'est pas fini.
            view.displayPlayer();
            view.displayState(game.getState());
            view.displayBoard();
            // (re)vérifie si la partie est finie.
            while (!goodPosition) {
                départ = view.askPosition();
                try {
                    // c'est mon pion ?
                    if (game.isCurrentPlayerPosition(départ)) { // oui, c'est mon pion.
                        // mon pion peut bouger ?
                        if (game.getPossibleMoves(départ).isEmpty()) { // non, il ne peut pas bouger.
                            view.displayError("Ce pion ne peut pas se déplacer.");
                        } else { // oui, il peut bouger.
                            goodPosition = true;
                        }
                    } else { // non, ce n'est pas mon pion.
                        view.displayError("Ce n'est pas votre pion.");
                    }
                } catch (Exception e) { // non, une exception est provoquée car pas de pièce à cette position.
                    view.displayError(e.getMessage());
                }
            }
            goodPosition = false;
            while (!goodPosition) {
                view.displayMessage("Où voulez vous allez ?");
                arrivé = view.askPosition();
                try {
                    // bon déplacement ?
                    game.movePiecePosition(départ, arrivé);
                    // oui
                    goodPosition = true;
                } catch (Exception e) { // non, une exception est provoquée. 
                    view.displayError(e.getMessage());
                    goodPosition = true;
                }
            }
            goodPosition = false;
            gameIsOver = game.getState() == GameState.CHECK_MATE || game.getState() == GameState.STALE_MATE;
        }
        // affiche le gagnant
        view.displayWinner();
    }
}
