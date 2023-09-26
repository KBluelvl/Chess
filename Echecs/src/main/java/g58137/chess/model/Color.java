package g58137.chess.model;

/**
 *
 * @author Florian
 */
public enum Color {
    WHITE, BLACK;
     
    /**
     * retourne une couleur de couleur opposé à la couleur courante.
     * @return une couleur de couleur opposé à la couleur courante.
     */
    public Color opposite(){
        return this == BLACK ? WHITE : BLACK;
    }
}
