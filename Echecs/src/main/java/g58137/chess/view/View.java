package g58137.chess.view;

import g58137.chess.model.GameState;
import g58137.chess.model.Position;

/**
 *
 * @author Florian
 */
public interface View {
    /**
     * Affiche un titre et un message de bienvenue aux joueurs.
     */
    public void displayTitle();
    
    /**
     * Affiche le plateau de jeu.
     */
    public void displayBoard();
    
    /**
     * Affiche le joueur gagnant.
     */
    public void displayWinner();
    /**
     * Affiche un message invitant le joueur courant (blanc ou noir) à jouer.
     */
    public void displayPlayer();
    
    /**
     * Demande une position valide sur le plateau de jeu à l’utilisateur.
     *
     * @return une position valide sur le plateau
     */
    public Position askPosition();
    
    /**
     * Affiche le message d’erreur passé en paramètre
     *
     * @param message message d’erreur passé en paramètre.
     */
    public void displayError(String message);
    
    /**
     * Affiche un message.
     * 
     * @param message = message affiché.
     */
    public void displayMessage(String message);
    
    /**
     * affiche l'état du jeu.
     * 
     * @param  state l'état du jeu.
     */
    public void displayState(GameState state);
}
