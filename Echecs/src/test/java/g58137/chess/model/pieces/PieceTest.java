package g58137.chess.model.pieces;

import g58137.chess.model.Board;
import g58137.chess.model.Color;
import g58137.chess.model.Position;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Florian
 */
public class PieceTest {

    Board board;

    public PieceTest() {
    }

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testGetPossibleMovesP() {
        Position position = new Position(1, 1);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 1),
                new Position(3, 1)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    /**
     * ******* A vous d'écrire les autres cas. Veuillez faire attention à avoir
     * un plan de test complet (comme précisé dans l'énoncé)
     ***********
     */
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
    public void testGetPossibleMovesIsBlackInRandomPosition() {
        System.out.println("getPossibleMoves");
        Position position = new Position(3, 3);
        Board board = new Board();
        Piece instance = new Pawn(Color.BLACK);
        List<Position> expResult = new ArrayList();
        expResult.add(new Position(2, 3));
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPossibleMovesIsWhiteInRandomPosition() {
        System.out.println("getPossibleMoves");
        Position position = new Position(4, 5);
        Board board = new Board();
        Piece instance = new Pawn(Color.WHITE);
        List<Position> expResult = new ArrayList();
        expResult.add(new Position(5, 5));
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesIsBlackInFirstPosition() {
        System.out.println("getPossibleMoves");
        Position position = new Position(6, 6);
        Board board = new Board();
        Piece instance = new Pawn(Color.BLACK);
        List<Position> expResult = new ArrayList();
        expResult.add(new Position(5, 6));
        expResult.add(new Position(4, 6));
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesIsWhiteInFirstPosition() {
        System.out.println("getPossibleMoves");
        Position position = new Position(1, 1);
        Board board = new Board();
        Piece instance = new Pawn(Color.WHITE);
        List<Position> expResult = new ArrayList();
        expResult.add(new Position(3, 1));
        expResult.add(new Position(2, 1));
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesIsBlackInLastPosition() {
        System.out.println("getPossibleMoves");
        Position position = new Position(0, 0);
        Board board = new Board();
        Piece instance = new Pawn(Color.BLACK);
        List<Position> expResult = new ArrayList();
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesIsWhiteLastPosition() {
        System.out.println("getPossibleMoves");
        Position position = new Position(7, 7);
        Board board = new Board();
        Piece instance = new Pawn(Color.WHITE);
        List<Position> expResult = new ArrayList();
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesisBlackCanAttackOnePawn() {
        System.out.println("getPossibleMoves");
        Position position = new Position(5, 5);
        Board board = new Board();
        board.setPiece(new Pawn(Color.WHITE), new Position(4, 6));
        Piece instance = new Pawn(Color.BLACK);
        List<Position> expResult = new ArrayList();
        expResult.add(new Position(4, 5));
        expResult.add(new Position(4, 6));
        
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesIsWhiteCanAttackOnePawn() {
        System.out.println("getPossibleMoves");
        Position position = new Position(4, 4);
        Board board = new Board();
        board.setPiece(new Pawn(Color.BLACK), new Position(5,5));
        Piece instance = new Pawn(Color.WHITE);
        List<Position> expResult = new ArrayList();
        expResult.add(new Position(5, 5));
        expResult.add(new Position(5, 4));
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesIsBlackCanAttackTwoPawn() {
        System.out.println("getPossibleMoves");
        Position position = new Position(5, 4);
        Board board = new Board();
        board.setPiece(new Pawn(Color.WHITE), new Position(4, 3));
        board.setPiece(new Pawn(Color.WHITE), new Position(4, 5));
        Piece instance = new Pawn(Color.BLACK);
        List<Position> expResult = new ArrayList();
        expResult.add(new Position(4, 4));
        expResult.add(new Position(4, 3));
        expResult.add(new Position(4, 5));
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesIsWhiteCanAttackTwoPawn() {
        System.out.println("getPossibleMoves");
        Position position = new Position(3, 3);
        Board board = new Board();
        board.setPiece(new Pawn(Color.BLACK), new Position(4, 2));
        board.setPiece(new Pawn(Color.BLACK), new Position(4, 4));
        Piece instance = new Pawn(Color.WHITE);
        List<Position> expResult = new ArrayList();
        expResult.add(new Position(4, 3));
        expResult.add(new Position(4, 2));
        expResult.add(new Position(4, 4));
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesIsWhiteCanNotMove() {
        System.out.println("getPossibleMoves");
        Position position = new Position(3, 3);
        Board board = new Board();
        board.setPiece(new Pawn(Color.BLACK), new Position(4, 3));
        Piece instance = new Pawn(Color.WHITE);
        List<Position> expResult = new ArrayList();
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
    
    @Test
    public void testGetPossibleMovesIsBlackCanNotMove() {
        System.out.println("getPossibleMoves");
        Position position = new Position(5, 5);
        Board board = new Board();
        board.setPiece(new Pawn(Color.WHITE), new Position(4, 5));
        Piece instance = new Pawn(Color.BLACK);
        List<Position> expResult = new ArrayList();
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expResult, result);
    }
}    
