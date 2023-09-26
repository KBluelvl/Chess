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
public class PawnTest {

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
        Position position = new Position(1,5);
        Board board = new Board();
        Pawn instance = new Pawn(Color.WHITE);
        List<Position> expResult = List.of(
                new Position(2,5),
                new Position(3,5)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesBlackInitialPosition() {
        System.out.println("getPossibleMoves");
        Position position = new Position(6,5);
        Board board = new Board();
        Pawn instance = new Pawn(Color.BLACK);
        List<Position> expResult = List.of(
                new Position(5,5),
                new Position(4,5)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesBlackMiddleBoard() {
        System.out.println("getPossibleMoves");
        Position position = new Position(5,5);
        Board board = new Board();
        Pawn instance = new Pawn(Color.BLACK);
        List<Position> expResult = List.of(
                new Position(4,5)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }

    @Test
    public void testGetPossibleMovesWhiteMiddleBoard() {
        System.out.println("getPossibleMoves");
        Position position = new Position(4,4);
        Board board = new Board();
        Pawn instance = new Pawn(Color.WHITE);
        List<Position> expResult = List.of(
                new Position(5,4)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesWhiteOnCorner() {
        System.out.println("getPossibleMoves");
        Position position = new Position(7,7);
        Board board = new Board();
        Pawn instance = new Pawn(Color.WHITE);
        List<Position> expResult = new ArrayList();
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesBlackOnCorner() {
        System.out.println("getPossibleMoves");
        Position position = new Position(0,0);
        Board board = new Board();
        Pawn instance = new Pawn(Color.BLACK);
        List<Position> expResult = new ArrayList();
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesWhiteNotFree1() {
        System.out.println("getPossibleMoves");
        Position position = new Position(1,6);
        Board board = new Board();
        board.setPiece(new Pawn(Color.WHITE), new Position(2,6));
        Pawn instance = new Pawn(Color.WHITE);
        List<Position> expResult = new ArrayList();
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesWhiteNotFree2() {
        System.out.println("getPossibleMoves");
        Position position = new Position(1,6);
        Board board = new Board();
        board.setPiece(new Pawn(Color.WHITE), new Position(3,6));
        Pawn instance = new Pawn(Color.WHITE);
        List<Position> expResult = List.of(
                new Position(2,6)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesBlackNotFree1() {
        System.out.println("getPossibleMoves");
        Position position = new Position(6,6);
        Board board = new Board();
        board.setPiece(new Pawn(Color.BLACK), new Position(5,6));
        Pawn instance = new Pawn(Color.BLACK);
        List<Position> expResult = new ArrayList();
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesBlackNotFree2() {
        System.out.println("getPossibleMoves");
        Position position = new Position(6,6);
        Board board = new Board();
        board.setPiece(new Pawn(Color.BLACK), new Position(4,6));
        Pawn instance = new Pawn(Color.BLACK);
        List<Position> expResult = List.of(
                new Position(5,6)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesBlackContainsOpponent1() {
        System.out.println("getPossibleMoves");
        Position position = new Position(6,6);
        Board board = new Board();
        board.setPiece(new Pawn(Color.WHITE), new Position(5,6));
        Pawn instance = new Pawn(Color.BLACK);
        List<Position> expResult = new ArrayList();
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesBlackContainsOpponent2() {
        System.out.println("getPossibleMoves");
        Position position = new Position(6,6);
        Board board = new Board();
        board.setPiece(new Pawn(Color.WHITE), new Position(4,6));
        Pawn instance = new Pawn(Color.BLACK);
        List<Position> expResult = List.of(
                new Position(5,6)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesBlackContainsOpponent3() {
        System.out.println("getPossibleMoves");
        Position position = new Position(6,6);
        Board board = new Board();
        board.setPiece(new Pawn(Color.WHITE), new Position(5,5));
        Pawn instance = new Pawn(Color.BLACK);
        List<Position> expResult = List.of(
                new Position(5,6),
                new Position(5,5),
                new Position(4,6)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesWhiteContainsOpponent1() {
        System.out.println("getPossibleMoves");
        Position position = new Position(1,5);
        Board board = new Board();
        board.setPiece(new Pawn(Color.BLACK), new Position(2,5));
        Pawn instance = new Pawn(Color.WHITE);
        List<Position> expResult = new ArrayList();
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesWhiteContainsOpponent2() {
        System.out.println("getPossibleMoves");
        Position position = new Position(1,2);
        Board board = new Board();
        board.setPiece(new Pawn(Color.BLACK), new Position(3,2));
        Pawn instance = new Pawn(Color.WHITE);
        List<Position> expResult = List.of(
                new Position(2,2)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesWhiteContainsOpponent3() {
        System.out.println("getPossibleMoves");
        Position position = new Position(4,2);
        Board board = new Board();
        board.setPiece(new Pawn(Color.BLACK), new Position(5,2));
        board.setPiece(new Pawn(Color.BLACK), new Position(5,3));
        board.setPiece(new Pawn(Color.BLACK), new Position(5,1));
        Pawn instance = new Pawn(Color.WHITE);
        List<Position> expResult = List.of(
                new Position(5,3),
                new Position(5,1)
        );
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesWhiteOnBorder() {
        System.out.println("getPossibleMoves");
        Position position = new Position(7,7);
        Board board = new Board();
        Pawn instance = new Pawn(Color.WHITE);
        List<Position> expResult = new ArrayList();
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesBlackOnBorder() {
        System.out.println("getPossibleMoves");
        Position position = new Position(0,4);
        Board board = new Board();
        Pawn instance = new Pawn(Color.BLACK);
        List<Position> expResult = new ArrayList();
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetCapturePositionsWithNoOpponent() {
        System.out.println("getCapturePositions");
        Position position = new Position(0,2);
        Board board = new Board();
        Pawn instance = new Pawn(Color.WHITE);
        List<Position> expResult = List.of(
                new Position(1,1),
                new Position(1,3)
        );
        board.setPiece(instance, position);
        List<Position> result = instance.getCapturePositions(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetCapturePositionsWithOneOpponent() {
        System.out.println("getCapturePositions");
        Position position = new Position(1,6);
        Board board = new Board();
        board.setPiece(new Pawn(Color.BLACK), new Position(2,5));
        Pawn instance = new Pawn(Color.WHITE);
        List<Position> expResult = List.of(
                new Position(2,7),
                new Position(2,5)
        );
        board.setPiece(instance, position);
        List<Position> result = instance.getCapturePositions(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    
    
    @Test
    public void testGetCapturePositionsWithTwoOpponent() {
        System.out.println("getCapturePositions");
        Position position = new Position(1,3);
        Board board = new Board();
        board.setPiece(new King(Color.BLACK), new Position(2,2));
        board.setPiece(new Pawn(Color.BLACK), new Position(2,4));
        Pawn instance = new Pawn(Color.WHITE);
        board.setPiece(instance, position);
        List<Position> expResult = List.of(
                new Position(2,2),
                new Position(2,4)
        );
        List<Position> result = instance.getCapturePositions(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    
}
