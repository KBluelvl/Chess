package g58137.chess.model.pieces;

import g58137.chess.model.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Florian
 */
public class KingTest {

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
        Position position = new Position(0,4);
        Board board = new Board();
        King instance = new King(Color.WHITE);
        List<Position> expResult = List.of(
                new Position(0,3),
                new Position(1,3),
                new Position(1,4),
                new Position(1,5),
                new Position(0,5)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesMiddleBoard() {
        System.out.println("getPossibleMoves");
        Position position = new Position(4,4);
        Board board = new Board();
        King instance = new King(Color.WHITE);
        List<Position> expResult = List.of(
                new Position(3,4),
                new Position(3,3),
                new Position(4,3),
                new Position(5,3),
                new Position(5,4),
                new Position(5,5),
                new Position(4,5),
                new Position(3,5)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesOnCorner() {
        System.out.println("getPossibleMoves");
        Position position = new Position(0,0);
        Board board = new Board();
        King instance = new King(Color.WHITE);
        List<Position> expResult = List.of(
                new Position(1,0),
                new Position(1,1),
                new Position(0,1)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesNotFree() {
        System.out.println("getPossibleMoves");
        Position position = new Position(6,6);
        Board board = new Board();
        board.setPiece(new Pawn(Color.BLACK), new Position(7,6));
        board.setPiece(new Knight(Color.BLACK), new Position(7,7));
        board.setPiece(new Pawn(Color.BLACK), new Position(6,7));
        board.setPiece(new Knight(Color.BLACK), new Position(5,6));
        board.setPiece(new Knight(Color.BLACK), new Position(5,5));
        board.setPiece(new Knight(Color.BLACK), new Position(5,7));
        board.setPiece(new Knight(Color.BLACK), new Position(6,5));
        board.setPiece(new Knight(Color.BLACK), new Position(7,5));
        King instance = new King(Color.BLACK);
        List<Position> expResult = new ArrayList();
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
      
    @Test
    public void testGetPossibleMovesContainsOpponent() {
        System.out.println("getPossibleMoves");
        Position position = new Position(0,0);
        Board board = new Board();
        board.setPiece(new Pawn(Color.BLACK), new Position(0,1));
        board.setPiece(new Pawn(Color.BLACK), new Position(1,1));
        King instance = new King(Color.WHITE);
        List<Position> expResult = List.of(
                new Position(1,0),
                new Position(0,1),
                new Position(1,1)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesOnBorder() {
        System.out.println("getPossibleMoves");
        Position position = new Position(0,0);
        Board board = new Board();
        King instance = new King(Color.WHITE);
        List<Position> expResult = List.of(
                new Position(1,0),
                new Position(0,1),
                new Position(1,1)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
}
