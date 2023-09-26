package g58137.chess.model;

/**
 *
 * @author Florian
 */
public enum Direction {
    NW(1,-1),N(1,0),NE(1,1),W(0,-1),E(0,1),SW(-1,-1),S(-1,0),SE(-1,1);
    
    private Integer deltaRow; // la ligne
    private Integer deltaColumn; // la colonne
    
    /**
     * Constructeur direction qui initialise deltaR et deltaC.
     * @param deltaR = la ligne
     * @param deltaC = la colonne
     */
    private Direction(Integer deltaR, Integer deltaC){
        deltaRow = deltaR;
        deltaColumn = deltaC;
    }

    /**
     * getter qui retourne la valeur de deltaRow.
     * @return un Integer qui représente valeur de deltaRow.
     */
    public Integer getDeltaRow() {
        return deltaRow;
    }
    
    /**
     * getter qui donne la valeur de deltaColumn.
     * @return un Integer qui représente valeur de deltaColumn.
     */
    public Integer getDeltaColumn() {
        return deltaColumn;
    }
}
