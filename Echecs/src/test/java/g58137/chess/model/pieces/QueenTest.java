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
public class QueenTest {

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
    public void testGetPossibleMovesWhiteInitialPosition() {
        System.out.println("getPossibleMoves");
        Position position = new Position(0, 3);
        Board board = new Board();
        Queen instance = new Queen(Color.WHITE);
        List<Position> expResult = List.of(
                new Position(0, 2), new Position(0, 1),
                new Position(0, 0), new Position(1, 2),
                new Position(2, 1), new Position(3, 0),
                new Position(1, 3), new Position(2, 3),
                new Position(3, 3), new Position(4, 3),
                new Position(5, 3), new Position(6, 3),
                new Position(1, 4), new Position(2, 5),
                new Position(3, 6), new Position(4, 7),
                new Position(0, 4), new Position(0, 5),
                new Position(0, 6), new Position(0, 7),
                new Position(7, 3)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }

    @Test
    public void testGetPossibleMovesWhiteContainsOpponent() {
        System.out.println("getPossibleMoves");
        Position position = new Position(0, 3);
        Board board = new Board();
        board.setPiece(new Pawn(Color.BLACK), new Position(6, 3));
        Queen instance = new Queen(Color.WHITE);
        List<Position> expResult = List.of(
                new Position(0, 2), new Position(0, 1),
                new Position(0, 0), new Position(1, 2),
                new Position(2, 1), new Position(3, 0),
                new Position(1, 3), new Position(2, 3),
                new Position(3, 3), new Position(4, 3),
                new Position(5, 3), new Position(6, 3),
                new Position(1, 4), new Position(2, 5),
                new Position(3, 6), new Position(4, 7),
                new Position(0, 4), new Position(0, 5),
                new Position(0, 6), new Position(0, 7)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }

    @Test
    public void testGetPossibleMovesWhiteMiddleBoard() {
        System.out.println("getPossibleMoves");
        Position position = new Position(3, 3);
        Board board = new Board();
        board.setPiece(new Pawn(Color.WHITE), new Position(4, 3));
        board.setPiece(new Pawn(Color.BLACK), new Position(3, 4));
        Queen instance = new Queen(Color.WHITE);
        List<Position> expResult = List.of(
                new Position(3, 4),new Position(4, 4),
                new Position(5, 5),new Position(6, 6),
                new Position(7, 7),new Position(2, 4),
                new Position(1, 5),new Position(0, 6),
                new Position(2, 3),new Position(1, 3),
                new Position(0, 3),new Position(2, 2),
                new Position(1, 1),new Position(0, 0),
                new Position(3, 2),new Position(3, 1),
                new Position(3, 0),new Position(4, 2),
                new Position(5, 1),new Position(6, 0)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesWhiteOnCorner() {
        System.out.println("getPossibleMoves");
        Position position = new Position(0, 7);
        Board board = new Board();
        Queen instance = new Queen(Color.WHITE);
        List<Position> expResult = List.of(
                new Position(0,6),new Position(0,5),
                new Position(0,4),new Position(0,3),
                new Position(0,2),new Position(0,1),
                new Position(0,0),new Position(1,6),
                new Position(2,5),new Position(3,4),
                new Position(4,3),new Position(5,2),
                new Position(6,1),new Position(7,0),
                new Position(1,7),new Position(2,7),
                new Position(3,7),new Position(4,7),
                new Position(5,7),new Position(6,7),
                new Position(7,7)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesWhiteNotFree1() {
        System.out.println("getPossibleMoves");
        Position position = new Position(1, 4);
        Board board = new Board();
        board.setPiece(new Pawn(Color.BLACK), new Position(2,4));
        board.setPiece(new Pawn(Color.BLACK), new Position(2,5));
        board.setPiece(new Pawn(Color.BLACK), new Position(1,5));
        board.setPiece(new Pawn(Color.BLACK), new Position(0,5));
        board.setPiece(new Pawn(Color.BLACK), new Position(0,4));
        board.setPiece(new Pawn(Color.BLACK), new Position(0,3));
        board.setPiece(new Pawn(Color.BLACK), new Position(1,3));
        board.setPiece(new Pawn(Color.BLACK), new Position(2,3));
        Queen instance = new Queen(Color.WHITE);
        List<Position> expResult = List.of(
                new Position(2,4),
                new Position(2,5),
                new Position(1,5),
                new Position(0,5),
                new Position(0,4),
                new Position(0,3),
                new Position(1,3),
                new Position(2,3)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesWhiteNotFree2() {
        System.out.println("getPossibleMoves");
        Position position = new Position(1, 4);
        Board board = new Board();
        board.setPiece(new Pawn(Color.WHITE), new Position(2,4));
        board.setPiece(new Pawn(Color.WHITE), new Position(2,5));
        board.setPiece(new Pawn(Color.WHITE), new Position(1,5));
        board.setPiece(new Pawn(Color.WHITE), new Position(0,5));
        board.setPiece(new Pawn(Color.WHITE), new Position(0,4));
        board.setPiece(new Pawn(Color.WHITE), new Position(0,3));
        board.setPiece(new Pawn(Color.WHITE), new Position(1,3));
        board.setPiece(new Pawn(Color.WHITE), new Position(2,3));
        Queen instance = new Queen(Color.WHITE);
        List<Position> expResult = new ArrayList();
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
}
