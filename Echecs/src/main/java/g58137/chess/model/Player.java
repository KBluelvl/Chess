package g58137.chess.model;

/**
 *
 * @author Florian
 */
public class Player {
    
    private Color color;
    
    /**
     * Constructeur Player qui initialise un nouveau joueur de couleur donnée.
     * @param color = la couleur donnée.
     */
    public Player(Color color){
        this.color = color;
    }
    
    /**
     * Getter qui donne la valeur de color.
     * @return a valeur de color.
     */
    public Color getColor(){
        return color;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Player other = (Player) obj;
        if (this.color != other.color) {
            return false;
        }
        return true;
    }
    
    
}
