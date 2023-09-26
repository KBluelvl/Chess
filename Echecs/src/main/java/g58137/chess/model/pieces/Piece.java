package g58137.chess.model.pieces;

import g58137.chess.model.*;
import java.util.List;

/**
 *
 * @author Florian
 */
public abstract class Piece {

    Color color;

    /**
     * Le constructeur piece initialise la pièce avec la couleur donnée.
     *
     * @param color = couleur
     */
    public Piece(Color color) {
        this.color = color;
    }

    /**
     * getter qui récupère la valeur de color.
     *
     * @return la valeur de color(la couleur).
     */
    public Color getColor() {
        return color;
    }

    /**
     * revoie une liste de toutes les positions des déplacements possible pour
     * une piece en position donnée.
     *
     * @param position = position donnée.
     * @param board = plateau de jeu.
     * @return une liste de toutes les positions des déplacements possible pour
     * une piece en position donnée
     */
    public abstract List<Position> getPossibleMoves(Position position, Board board);

    /**
     * renvoie les positions en lesquelles le pion peut capturer une pièce
     * adverse.
     *
     * @param position = position donnée.
     * @param board = plateau de jeu.
     * @return une liste des positions en lesquelles le pion peut capturer une
     * pièce adverse.
     */
    public List<Position> getCapturePositions(Position position, Board board) {
        return  getPossibleMoves(position, board);
    }

    /**
     * vérifie si la piece peut attaquer une autre piece et si oui ajoute la
     * position dans une liste donnée.
     *
     * @param board = le plateau de jeu donnée.
     * @param position = la position donnée.
     * @param attaque = la direction de l'attaque.
     * @param deplacement = liste des deplacement possible.
     */
    protected void peutAttaquer(Board board, Position position, Direction attaque, List<Position> deplacement) {
        Position pos = position.next(attaque);

        if (board.contains(pos)) {
            if (board.containsOppositeColor(pos, color)) {
                deplacement.add(pos);
            }
        }
    }

    /**
     * Vérifie si la piece peut avancer d'une ou deux cases et si oui ajoute la
     * position dans une liste donnée.
     *
     * @param board = le plateau de jeu donnée.
     * @param position = la position donnée.
     * @param mouvement = la direction du mouvement
     * @param deplacement = liste des deplacement possible.
     */
    protected void peutAvancer(Board board, Position position, Direction mouvement, List<Position> deplacement) {
        Position pos = position.next(mouvement);
        // peut avancer d'une case ?
        if (isEmptyPosition(board, pos)) {
            deplacement.add(pos);
            // peut avancer de deux cases ?
            if (board.getInitialPawnRow(color).equals(position.getRow())) {
                pos = pos.next(mouvement);
                if (isEmptyPosition(board, pos)) {
                    deplacement.add(pos);
                }
            }
        }
    }

    /**
     * Vérifie si la position donnée est dans le plateau et qu'aucune piece
     * n'occupe cette position.
     *
     * @param board = le plateau de jeu donnée.
     * @param pos = la position donnée.
     * @return true si la position donnée est dans le plateau et qu'aucune piece
     * n'occupe cette position sinon false.
     */
    protected boolean isEmptyPosition(Board board, Position pos) {
        if (board.contains(pos)) {
            return board.isFree(pos);
        }
        return false;
    }

    /**
     * renvoie false si la case en position donnée contient une piece de la
     * couleur
     *
     * @param board = le plateau de jeu donnée.
     * @param pos = la position donnée.
     * @param col = une couleur donnée.
     * @return
     */
    protected boolean dontContainsColor(Board board, Position pos, Color col) {
        if (!board.contains(pos)) {
            throw new IllegalArgumentException("La position donnée n'est pas sur le platteau.");
        }
        if (board.isFree(pos)) {
            return true;
        }
        return this.getColor() != col;
    }

    protected boolean containsColor(Board board, Position pos, Color col){
        if (!board.contains(pos)) {
            throw new IllegalArgumentException("La position donnée n'est pas sur le platteau.");
        }
        if (board.isFree(pos)) {
            return false;
        }
        return this.color == col;
    }
    
    protected void line(Board board, Position position, Direction dir, List<Position> deplacement) {
        Position pos = position;
        try{
        switch (dir) {
            case E -> {
                pos = pos.next(Direction.E);
                    while (true) {
                        if (board.containsOppositeColor(pos, color)) {
                            deplacement.add(pos);
                            break;
                        }
                        if(containsColor(board, pos, color)){
                            break;
                        }
                        deplacement.add(pos);
                        pos = pos.next(Direction.E);
                        
                    }
                }
            case N -> {
                pos = pos.next(Direction.N);
                    while (true) {
                        if (board.containsOppositeColor(pos, color)) {
                            deplacement.add(pos);
                            break;
                        }
                        if(containsColor(board, pos, color)){
                            break;
                        }
                        deplacement.add(pos);
                        pos = pos.next(Direction.N);
                        
                    }
                    
                }
            case S -> {
                pos = pos.next(Direction.S);
                    while (true) {
                        if (board.containsOppositeColor(pos, color)) {
                            deplacement.add(pos);
                            break;
                        }
                        if(containsColor(board, pos, color)){
                            break;
                        }
                        deplacement.add(pos);
                        pos = pos.next(Direction.S);
                    }
                    
                }
            case W -> {
                pos = pos.next(Direction.W);
                    while (true) {
                        if (board.containsOppositeColor(pos, color)) {
                            deplacement.add(pos);
                            break;
                        }
                        if(containsColor(board, pos, color)){
                            break;
                        }
                        deplacement.add(pos);
                        pos = pos.next(Direction.W);
                    }
                } 
            } 
        } catch(Exception e){}
    }

    protected void diagonal(Board board, Position position, Direction dir, List<Position> deplacement) {
        Position pos = position;
        try {
            switch (dir) {
                case NE -> {
                    pos = pos.next(Direction.NE);
                    while (true) {
                        if (board.containsOppositeColor(pos, color)) {
                            deplacement.add(pos);
                            break;
                        }
                        if(containsColor(board, pos, color)){
                            break;
                        }
                        deplacement.add(pos);
                        pos = pos.next(Direction.NE);
                    }
                }
                case NW -> {
                    pos = pos.next(Direction.NW);
                    while (true) {
                        if (board.containsOppositeColor(pos, color)) {
                            deplacement.add(pos);
                            break;
                        }
                        if(containsColor(board, pos, color)){
                            break;
                        }
                        deplacement.add(pos);
                        pos = pos.next(Direction.NW);
                    }
                }
                case SE -> {
                    pos = pos.next(Direction.SE);
                    while (true) {
                        if (board.containsOppositeColor(pos, color)) {
                            deplacement.add(pos);
                            break;
                        }
                        if(containsColor(board, pos, color)){
                            break;
                        }
                        deplacement.add(pos);
                        pos = pos.next(Direction.SE);
                    }
                }
                case SW -> {
                    pos = pos.next(Direction.SW);
                    while (true) {
                        if (board.containsOppositeColor(pos, color)) {
                            deplacement.add(pos);
                            break;
                        }
                        if(containsColor(board, pos, color)){
                            break;
                        }
                        deplacement.add(pos);
                        pos = pos.next(Direction.SW);
                    }
                }
            }
        } catch (Exception e) {}
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Piece other = (Piece) obj;
        if (this.color != other.color) {
            return false;
        }
        return true;
    }

}
