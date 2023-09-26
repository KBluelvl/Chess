package g58137.chess.model.pieces;

import g58137.chess.model.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Florian
 */
public class Pawn extends Piece {
    public static final String BLACK_BOLD = "\033[1;30m";

    /**
     * fait appel au constructeur de la classe parent pour initialiser un pion
     * de couleur donnée.
     *
     * @param color = couleur donnée.
     */
    public Pawn(Color color) {
        super(color);
    }

    /**
     * revoie une liste de toutes les positions des déplacements possible pour
     * un pion en position donnée.
     *
     * @param position = position donnée.
     * @param board = plateau de jeu.
     * @return une liste de toutes les positions des déplacements possible pour
     * une pion en position donnée
     */
    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> deplacement = new ArrayList();
        boolean isBlack = this.color == Color.BLACK;
        if (isBlack) {
            peutAvancer(board, position, Direction.S, deplacement);
            peutAttaquer(board, position, Direction.SW, deplacement);
            peutAttaquer(board, position, Direction.SE, deplacement);
        } else {
            peutAvancer(board, position, Direction.N, deplacement);
            peutAttaquer(board, position, Direction.NW, deplacement);
            peutAttaquer(board, position, Direction.NE, deplacement);
        }
        return deplacement;
    }

    /**
     * rajoute dans la liste capture une position avec un mouvement donnée.
     *
     * @param board = le plateau de jeu donnée.
     * @param position = position donnée.
     * @param direction
     * @param capture
     */
    private void peutCapturer(Board board, Position position, Direction direction, List<Position> capture) {
        Position pos = position.next(direction);
        if (board.contains(pos)) {
            if (board.getPiece(pos) != null) {
                if (board.getPiece(position).color != board.getPiece(pos).getColor()){
               capture.add(pos); 
            }
            } else {
                capture.add(pos);
            }
            
        }
    }

    /**
     * renvoie les positions en lesquelles le pion peut capturer une pièce
     * adverse.
     *
     * @param position = position donnée.
     * @param board = le plateau de jeu donnée.
     * @return une liste de de toutes les positions en lesquelles le pion peut
     * capturer une pièce adverse.
     */
    @Override
    public List<Position> getCapturePositions(Position position, Board board) {
        if (board.getPiece(position) != this) {
            throw new IllegalArgumentException("cette position ne contient pas la piece");
        }
        List<Position> capture = new ArrayList();
        boolean isBlack = this.color == Color.BLACK;
        if (isBlack) {
            peutCapturer(board, position, Direction.SE, capture);
            peutCapturer(board, position, Direction.SW, capture);
        } else {
            peutCapturer(board, position, Direction.NE, capture);
            peutCapturer(board, position, Direction.NW, capture);
        }
        return capture;
    }

    @Override
    public String toString() {
        return color == Color.BLACK ? BLACK_BOLD+"♙" : "♙";
    }
}
