package g58137.chess.model;

import g58137.chess.model.pieces.Piece;

/**
 *
 * @author Florian
 */
public class Square {
    
    private Piece piece;
    
    /**
     * Constructeur Player qui initialise une piece donnée.
     * @param piece = la piece donnée.
     */
    public Square(Piece piece){
        this.piece = piece;
    }
    
    /**
     * getter qui donne la valeur de piece.
     * @return la valeur de piece.
     */
    public Piece getPiece(){
        return piece;
    }

    /**
     * setter qui donne une valeur à l'attribut piece.
     * @param piece = piece donnée.
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    
    /**
     * montre si la case est vide
     * @return true si la case est vide sinon false.
     */
    public boolean isFree(){
        return piece == null;
    }  
}
