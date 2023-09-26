package g58137.chess.model.pieces;

import g58137.chess.model.Board;
import g58137.chess.model.Color;
import g58137.chess.model.Position;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Florian
 */
public class KnightTest {
    
    public KnightTest() {
    }

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
        Position position = new Position(0,1);
        Board board = new Board();
        Knight instance = new Knight(Color.WHITE);
        List<Position> expResult = List.of(
                new Position(2,2),
                new Position(2,0),
                new Position(1,3)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesMiddleBoard() {
        System.out.println("getPossibleMoves");
        Position position = new Position(3,3);
        Board board = new Board();
        Knight instance = new Knight(Color.BLACK);
        List<Position> expResult = List.of(
                new Position(1,4),
                new Position(2,5),
                new Position(4,5),
                new Position(5,4),
                new Position(1,2),
                new Position(2,1),
                new Position(4,1),
                new Position(5,2)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesOnCorner() {
        System.out.println("getPossibleMoves");
        Position position = new Position(0,0);
        Board board = new Board();
        Knight instance = new Knight(Color.WHITE);
        List<Position> expResult = List.of(
                new Position(1,2),
                new Position(2,1)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesPositionNotFree() {
        System.out.println("getPossibleMoves");
        Position position = new Position(7,7);
        Board board = new Board();
        board.setPiece(new Pawn(Color.BLACK), new Position(6,5));
        board.setPiece(new Knight(Color.BLACK), new Position(5,6));
        Knight instance = new Knight(Color.BLACK);
        List<Position> expResult = new ArrayList();
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesContainsOpponent() {
        System.out.println("getPossibleMoves");
        Position position = new Position(5,5);
        Board board = new Board();
        board.setPiece(new Pawn(Color.BLACK), new Position(7,6));
        board.setPiece(new Knight(Color.BLACK), new Position(3,4));
        Knight instance = new Knight(Color.WHITE);
        List<Position> expResult = List.of(
                new Position(7,6),
                new Position(3,4),
                new Position(7,4),
                new Position(6,3),
                new Position(4,3),
                new Position(3,6),
                new Position(4,7),
                new Position(6,7)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesOnBorder() {
        System.out.println("getPossibleMoves");
        Position position = new Position(0,3);
        Board board = new Board();
        Knight instance = new Knight(Color.WHITE);
        List<Position> expResult = List.of(
                new Position(1,1),
                new Position(2,2),
                new Position(2,4),
                new Position(1,5)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
}
