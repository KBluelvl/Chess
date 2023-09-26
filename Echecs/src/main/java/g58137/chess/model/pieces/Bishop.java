package g58137.chess.model.pieces;

import g58137.chess.model.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Florian
 */
public class Bishop extends Piece{
    public static final String BLACK_BOLD = "\033[1;30m";
    
    /**
     * fait appel au constructeur de la classe parent pour initialiser un fou de
     * couleur donnée.
     *
     * @param color = couleur donnée.
     */
    public Bishop(Color color){
        super(color);
    }

    /**
     * revoie une liste de toutes les positions des déplacements possible pour
     * un fou en position donnée.
     *
     * @param position = position donnée.
     * @param board = plateau de jeu donnée.
     * @return une liste de toutes les positions des déplacements possible pour
     * un fou en position donnée.
     */
    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> deplacement = new ArrayList();
        
        diagonal(board, position, Direction.NW, deplacement);
        diagonal(board, position, Direction.NE, deplacement);
        diagonal(board, position, Direction.SW, deplacement);
        diagonal(board, position, Direction.SE, deplacement);
        
        return deplacement;
    }

    @Override
    public String toString() {
        return color == Color.BLACK ? BLACK_BOLD+"♝" : "♝";
    }
}
