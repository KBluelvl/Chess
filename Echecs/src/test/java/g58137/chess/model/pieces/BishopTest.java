package g58137.chess.model.pieces;

import g58137.chess.model.Board;
import g58137.chess.model.Color;
import g58137.chess.model.Position;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Florian
 */
public class BishopTest {
    
    /*
     *      Permet de tester si deux listes de positions sont identiques à l'ordre
     *      des éléments prêts. Cette méthode est appelée
     *      par les méthodes de test.
     */
    private void assertEqualsIgnoringOrder(List<Position> expected, List<Position> actual) {
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(expected.containsAll(actual));
    }

    @Test
    public void testGetPossibleMovesInitialPosition() {
        System.out.println("getPossibleMoves");
        Position position = new Position(0,2);
        Board board = new Board();
        Bishop instance = new Bishop(Color.WHITE);
        List<Position> expResult = List.of(
                new Position(1,1),new Position(2,0),
                new Position(1,3),new Position(2,4),
                new Position(3,5),new Position(4,6),
                new Position(5,7)    
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesMiddleBoard() {
        System.out.println("getPossibleMoves");
        Position position = new Position(2,4);
        Board board = new Board();
        board.setPiece(new Knight(Color.WHITE), new Position(3,3));
        Bishop instance = new Bishop(Color.WHITE);
        List<Position> expResult = List.of(
                new Position(1,3),new Position(0,2),
                new Position(1,5),new Position(0,6),
                new Position(3,5),new Position(4,6),
                new Position(5,7)    
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
}
