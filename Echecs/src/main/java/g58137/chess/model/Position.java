package g58137.chess.model;

import java.util.Objects;

/**
 *
 * @author Florian
 */
public class Position {
    private Integer row; // la ligne
    private Integer column; // la colonne
    
    /**
     * constructeur Position qui initialise row et Column.
     * @param row = la ligne
     * @param Column = la colonne
     */
    public Position(Integer row, Integer Column){
        this.row = row;
        this.column = Column;
    }

    /**
     * getter qui récupère la valeur de row.
     * @return la valeur de row.
     */
    public Integer getRow() {
        return row;
    }
    /**
     * getter qui récupère la valeur de column.
     * @return la valeur de column.
     */
    public Integer getColumn() {
        return column;
    }
    
    /**
     * revenoie la nouvelle position obtenue en se déplaçant dans la direction donnée.
     * @param dir = direction donnée.
     * @return la nouvelle position.
     */
    public Position next(Direction dir){
        int aRow= this.row;
        int aColumn = this.column;
        int rowDir = dir.getDeltaRow();
        int columnDir = dir.getDeltaColumn();
        
        return new Position (aRow + rowDir, aColumn + columnDir);
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Position other = (Position) obj;
        if (!Objects.equals(this.row, other.row)) {
            return false;
        }
        if (!Objects.equals(this.column, other.column)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Position{" + "row=" + row + ", column=" + column + '}';
    }
}
