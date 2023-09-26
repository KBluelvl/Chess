package g58137.chess.model.pieces;

import g58137.chess.model.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Florian
 */
public class Knight extends Piece {
    public static final String BLACK_BOLD = "\033[1;30m";

    /**
     * fait appel au constructeur de la classe parent pour initialiser un
     * cavalier de couleur donnée.
     *
     * @param color = un couleur donnée.
     */
    public Knight(Color color) {
        super(color);
    }

    /**
     * revoie une liste de toutes les positions des déplacements possible pour
     * un cavalier en position donnée.
     *
     * @param position = une position donnée.
     * @param board = un plateau de jeu doonée.
     * @return une liste de toutes les positions des déplacements possible pour
     * un cavalier en position donnée.
     */
    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> deplacement = new ArrayList();
        knightMove(board, position, Direction.NE, deplacement);
        knightMove(board, position, Direction.NW, deplacement);
        knightMove(board, position, Direction.SE, deplacement);
        knightMove(board, position, Direction.SW, deplacement);
        return deplacement;
    }

    /**
     * vérifie si un cavalier peut se deplacer dans une direction donnée(par
     * rapport au jeu) et si oui ajoute la position dans la liste.
     *
     * @param board = le plateau de jeu donnée.
     * @param position = une position donnée.
     * @param dir = une direction donnée.
     * @param deplacement = la liste des déplacements du cavalier.
     */
    private void knightMove(Board board, Position position, Direction dir, List<Position> deplacement) {
        Position pos1 = position;
        Position pos2 = position;
        switch (dir) {
            case NE -> {
                pos1 = pos1.next(Direction.N).next(Direction.N).next(Direction.E);
                pos2 = pos2.next(Direction.E).next(Direction.E).next(Direction.N);
            }
            case NW -> {
                pos1 = pos1.next(Direction.N).next(Direction.N).next(Direction.W);
                pos2 = pos2.next(Direction.W).next(Direction.W).next(Direction.N);
            }
            case SE -> {
                pos1 = pos1.next(Direction.S).next(Direction.S).next(Direction.E);
                pos2 = pos2.next(Direction.E).next(Direction.E).next(Direction.S);
            }
            case SW -> {
                pos1 = pos1.next(Direction.S).next(Direction.S).next(Direction.W);
                pos2 = pos2.next(Direction.W).next(Direction.W).next(Direction.S);
            }
        }
        try {
            if (board.isFree(pos1)) {
                deplacement.add(pos1);
            }
            if (this.color != board.getPiece(pos1).color){
                deplacement.add(pos1);
            }
        } catch (Exception e) {}
        try {
            if (board.isFree(pos2)) {
                deplacement.add(pos2);
            }
            if (this.color != board.getPiece(pos2).color){
                deplacement.add(pos2);
            }
        } catch (Exception e) {}
    }

    @Override
    public String toString() {
        return color == Color.BLACK ? BLACK_BOLD+"♞" : "♞";
    }
}
