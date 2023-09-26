package g58137.chess.model;

import g58137.chess.model.pieces.Piece;
import java.util.List;

/**
 *
 * @author Florian
 */
public interface Model {
    
    /**
     * Start the game: create the pieces and put them on the board, initialize
     * the current player to 'WHITE'.
     */
    public void start();
    
    /**
     * Getter for the current player.
     *
     * @return the current player.
     */
    public Player getCurrentPlayer();
    
    /**
     * Getter for the second player.
     *
     * @return the player that is waiting
     */
    public Player getOppositePlayer();

    /**
     * Get the possible moves for the piece located at
     * the specified position.
     *
     * @param position the position of the piece
     * @return the liste of admissible positions.
     */
    public List<Position> getPossibleMoves(Position position);
    
    /**
     * Get the piece of the board located on a given position
     *
     * @param pos the position
     * @return the piece located at P
     * @throws IllegalArgumentException pos  is not located on the board.
     */
    public Piece getPiece(Position pos);
    
    /**
     * Check if the square at the given position is occupied
     * by a piece of the current player.
     *
     * @param pos the postion
     * @return true if the position is occupied by a piece
     * of the current player, false otherwise.
     * @throws IllegalArgumentException if the position is not located on the board.
     */
    public boolean isCurrentPlayerPosition(Position pos);
    
    /**
     * Moves a piece from one position of the chess board to
     * another one. If the game is not over, change
     * the current player.
     *
     * @param oldPos the current position
     * @param newPos the new position of the board where to put the piece
     * @throws IllegalArgumentException if
     *                                  1) oldPos or newPos are not located on the board, or
     *                                  2) oldPos does not contain a piece, or
     *                                  3) the piece does not belong to the current player, or
     *                                  4) the move is not valid for the piece located at position oldPos                                 
     */
    public void movePiecePosition(Position oldPos, Position newPos);
    
    /**
     * Recupère la valeur de l'attribut state.
     * 
     * @return la valeur de l'attribut state.
     */
    public GameState getState();
    
    /**
     * vérifie que le déplacement d’une pièce de la position oldPos vers la position newPos est bien valide
     * 
     * @param oldPos = un position donnée.
     * @param newPos = un position donnée.
     * @return true si le déplacement d’une pièce de la position oldPos vers la position newPos est bien valide sinon false.
     */
    public boolean isValidMove(Position oldPos, Position newPos);
}
