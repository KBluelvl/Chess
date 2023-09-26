package g58137.chess.model.pieces;

import g58137.chess.model.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Florian
 */
public class Queen extends Piece {
    public static final String BLACK_BOLD = "\033[1;30m";

    /**
     * fait appel au constructeur de la classe parent pour initialiser un reine de
     * couleur donnée.
     *
     * @param color = couleur donnée.
     */
    public Queen (Color color){
        super(color);
    }

    /**
     * revoie une liste de toutes les positions des déplacements possible pour
     * une reine en position donnée.
     *
     * @param position = position donnée.
     * @param board = plateau de jeu.
     * @return une liste de toutes les positions des déplacements possible pour
     * une reine en position donnée
     */
    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> deplacement = new ArrayList();
        line(board, position, Direction.E, deplacement);
        line(board, position, Direction.N, deplacement);
        line(board, position, Direction.S, deplacement);
        line(board, position, Direction.W, deplacement);
        diagonal(board, position, Direction.NW, deplacement);
        diagonal(board, position, Direction.NE, deplacement);
        diagonal(board, position, Direction.SW, deplacement);
        diagonal(board, position, Direction.SE, deplacement);
        
        return deplacement;
    }
    
    @Override
    public String toString() {
        return color == Color.BLACK ? BLACK_BOLD+"♛" : "♛";
    }
}
