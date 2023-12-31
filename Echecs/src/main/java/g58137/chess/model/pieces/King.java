package g58137.chess.model.pieces;

import g58137.chess.model.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Florian
 */
public class King extends Piece {
    public static final String BLACK_BOLD = "\033[1;30m";

    /**
     * fait appel au constructeur de la classe parent pour initialiser un roi de
     * couleur donnée.
     *
     * @param color = couleur donnée.
     */
    public King(Color color) {
        super(color);
    }

    /**
     * revoie une liste de toutes les positions des déplacements possible pour
     * un roi en position donnée.
     *
     * @param position = position donnée.
     * @param board = plateau de jeu donnée.
     * @return une liste de toutes les positions des déplacements possible pour
     * un roi en position donnée.
     */
    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> deplacement = new ArrayList();
        kingMove(board, position, Direction.E, deplacement);
        kingMove(board, position, Direction.N, deplacement);
        kingMove(board, position, Direction.NE, deplacement);
        kingMove(board, position, Direction.NW, deplacement);
        kingMove(board, position, Direction.S, deplacement);
        kingMove(board, position, Direction.SE, deplacement);
        kingMove(board, position, Direction.SW, deplacement);
        kingMove(board, position, Direction.W, deplacement);
        return deplacement;
    }

    public String getName(){
        return color + "King";
    }

    /**
     * vérifie si un roi peut se deplacer dans une direction donnée(par rapport
     * au jeu) et si oui ajoute la position dans la liste.
     *
     * @param board = plateau de jeu donnée.
     * @param position = position donnée.
     * @param dir = direction donnée.
     * @param deplacement = la liste des déplacements du roi.
     */
    private void kingMove(Board board, Position position, Direction dir, List<Position> deplacement) {
        Position pos = position.next(dir);
        try {
            if (board.isFree(pos)) {
                deplacement.add(pos);
            } else if (this.color != board.getPiece(pos).color){
                deplacement.add(pos);
            }
            if(getInitialKingRow(color).equals(position.getRow()) &&
                board.getPiece(pos) == null && board.getPiece(pos.next(dir)) == null){
                if(dir == Direction.E){
                    deplacement.add(pos.next(dir));
                } else if (dir == Direction.W && board.getPiece(pos.next(dir).next(dir)) == null) {
                    deplacement.add(pos.next(dir));
                }
            }
        } catch (Exception e) {}
    }

    /**
     * renvoie 7 pour la couleur BLACK et 0 pour la couleur WHITE.
     *
     * @param color = couleur donnée.
     * @return 7 pour la couleur BLACK et 0 pour la couleur WHITE.
     */
    public Integer getInitialKingRow(Color color) {
        return color == Color.BLACK ? 7 : 0;
    }

    @Override
    public String toString() {
        return color == Color.BLACK ? BLACK_BOLD+"♚" : "♚";
    }
}
