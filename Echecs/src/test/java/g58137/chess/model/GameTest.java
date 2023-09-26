package g58137.chess.model;

import g58137.chess.model.pieces.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Florian
 */
public class GameTest {

    @Test
    public void testGetCurrentPlayerIsNull() {
        System.out.println("getCurrentPlayer");
        Game instance = new Game();
        Player expResult = null;
        Player result = instance.getCurrentPlayer();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetCurrentPlayerIsWhite() {
        System.out.println("getCurrentPlayer");
        Game instance = new Game();
        instance.start();
        Player expResult = new Player(Color.WHITE);
        Player result = instance.getCurrentPlayer();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetOppositePlayerIsBlack() {
        System.out.println("getOppositePlayer");
        Game instance = new Game();
        instance.start();
        Player expResult = new Player(Color.BLACK);
        Player result = instance.getOppositePlayer();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPossibleMoves1() {
        System.out.println("getPossibleMoves");
        Position position = new Position(1, 2);
        Game instance = new Game();
        instance.start();
        List<Position> expResult = List.of(
                new Position(2, 2),
                new Position(3, 2)
        );
        List<Position> result = instance.getPossibleMoves(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPossibleMoves2() {
        System.out.println("getPossibleMoves");
        Position position = new Position(6, 4);
        Game instance = new Game();
        instance.start();
        List<Position> expResult = List.of(
                new Position(5, 4),
                new Position(4, 4)
        );
        List<Position> result = instance.getPossibleMoves(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPossibleMoves3() {
        System.out.println("getPossibleMoves");
        Position position = new Position(6, 4);
        Game instance = new Game();
        instance.start();
        List<Position> expResult = List.of(
                new Position(5, 4),
                new Position(4, 4)
        );
        List<Position> result = instance.getPossibleMoves(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPossibleMoves4() {
        System.out.println("getPossibleMoves");
        Position position = new Position(2, 0);
        Game instance = new Game();
        instance.start();
        instance.getBoard().setPiece(new Pawn(Color.WHITE), position);
        List<Position> expResult = List.of(
                new Position(3, 0)
        );
        List<Position> result = instance.getPossibleMoves(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPieceWhenWhite() {
        System.out.println("getPiece");
        Position pos = new Position(1, 1);
        Game instance = new Game();
        instance.start();
        Piece expResult = new Pawn(Color.WHITE);
        Piece result = instance.getPiece(pos);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPieceWhenBlack() {
        System.out.println("getPiece");
        Position pos = new Position(6, 6);
        Game instance = new Game();
        instance.start();
        Piece expResult = new Pawn(Color.BLACK);
        Piece result = instance.getPiece(pos);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsCurrentPlayerPositionIsWhitePiece() {
        System.out.println("isCurrentPlayerPosition");
        Position pos = new Position(1, 1);
        Game instance = new Game();
        instance.start();
        boolean expResult = true;
        boolean result = instance.isCurrentPlayerPosition(pos);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsCurrentPlayerPositionIsBlackPiece() {
        System.out.println("isCurrentPlayerPosition");
        Position pos = new Position(6, 6);
        Game instance = new Game();
        instance.start();
        instance.setCurrentPlayer(new Player(Color.BLACK));
        boolean expResult = true;
        boolean result = instance.isCurrentPlayerPosition(pos);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsCurrentPlayerPositionIsNotMyPiece() {
        System.out.println("isCurrentPlayerPosition");
        Position pos = new Position(6, 6);
        Game instance = new Game();
        instance.start();
        boolean expResult = false;
        boolean result = instance.isCurrentPlayerPosition(pos);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsValidMoveWhenValid() {
        System.out.println("isValidMove");
        Position oldPos = new Position(1, 0);
        Position newPos = new Position(2, 0);
        Game instance = new Game();
        instance.start();
        boolean expResult = true;
        boolean result = instance.isValidMove(oldPos, newPos);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsValidMoveWhenNotValid() {
        System.out.println("isValidMove");
        Position oldPos = new Position(6, 3);
        Position newPos = new Position(5, 3);
        Game instance = new Game();
        instance.start();
        instance.movePiecePosition(new Position(1, 4), new Position(3, 4));
        instance.movePiecePosition(new Position(6, 4), new Position(4, 4));
        instance.movePiecePosition(new Position(0, 5), new Position(4, 1));
        boolean expResult = false;
        boolean result = instance.isValidMove(oldPos, newPos);
        assertEquals(expResult, result);
    }

    @Test
    public void stateIsPLAY() {
        Game instance = new Game();
        instance.start();
        boolean expResult = true;
        boolean result = instance.getState() == GameState.PLAY;
        assertEquals(expResult, result);
    }

    @Test
    public void stateIsCHECK() {
        Game instance = new Game();
        instance.start();
        instance.movePiecePosition(new Position(1, 4), new Position(3, 4));
        instance.movePiecePosition(new Position(6, 3), new Position(4, 3));
        instance.movePiecePosition(new Position(0, 5), new Position(4, 1));
        GameState expResult = GameState.CHECK;
        GameState result = instance.getState();
        assertEquals(expResult, result);
    }

    @Test
    public void stateIsCHECK_MATE() {
        Game instance = new Game();
        instance.start();
        instance.movePiecePosition(new Position(1, 6), new Position(3, 6));
        instance.movePiecePosition(new Position(6, 4), new Position(4, 4));
        instance.movePiecePosition(new Position(1, 5), new Position(2, 5));
        instance.movePiecePosition(new Position(7, 3), new Position(3, 7));
        GameState expResult = GameState.CHECK_MATE;
        GameState result = instance.getState();
        assertEquals(expResult, result);
    }

    @Test
    public void stateIsCHECK_MATE2() {
        Game instance = new Game();
        instance.start();
        instance.movePiecePosition(new Position(1, 4), new Position(3, 4));
        instance.movePiecePosition(new Position(6, 4), new Position(4, 4));
        instance.movePiecePosition(new Position(0, 5), new Position(3, 2));
        instance.movePiecePosition(new Position(7, 1), new Position(5, 2));
        instance.movePiecePosition(new Position(0, 3), new Position(4, 7));
        instance.movePiecePosition(new Position(7, 6), new Position(5, 5));
        instance.movePiecePosition(new Position(4, 7), new Position(6, 5));
        GameState expResult = GameState.CHECK_MATE;
        GameState result = instance.getState();
        assertEquals(expResult, result);
    }

    @Test
    public void stateIsSTALE_MATE1() {
        Game instance = new Game();
        instance.start();
        instance.movePiecePosition(new Position(1, 4), new Position(2, 4));
        instance.movePiecePosition(new Position(6, 0), new Position(4, 0));
        instance.movePiecePosition(new Position(0, 3), new Position(4, 7));
        instance.movePiecePosition(new Position(7, 0), new Position(5, 0));
        instance.movePiecePosition(new Position(4, 7), new Position(4, 0));
        instance.movePiecePosition(new Position(6, 7), new Position(4, 7));
        instance.movePiecePosition(new Position(1, 7), new Position(3, 7));
        instance.movePiecePosition(new Position(5, 0), new Position(5, 7));
        instance.movePiecePosition(new Position(4, 0), new Position(6, 2));
        instance.movePiecePosition(new Position(6, 5), new Position(5, 5));
        instance.movePiecePosition(new Position(6, 2), new Position(6, 3));
        instance.movePiecePosition(new Position(7, 4), new Position(6, 5));
        instance.movePiecePosition(new Position(6, 3), new Position(6, 1));
        instance.movePiecePosition(new Position(7, 3), new Position(2, 3));
        instance.movePiecePosition(new Position(6, 1), new Position(7, 1));
        instance.movePiecePosition(new Position(2, 3), new Position(6, 7));
        instance.movePiecePosition(new Position(7, 1), new Position(7, 2));
        instance.movePiecePosition(new Position(6, 5), new Position(5, 6));
        instance.movePiecePosition(new Position(7, 2), new Position(5, 4));
        GameState expResult = GameState.STALE_MATE;
        GameState result = instance.getState();
        assertEquals(expResult, result);
    }

    @Test
    public void stateIsSTALE_MATE() {
        System.out.println("isValidMove");
        Game instance = new Game();
        instance.start();

        for (int i = 0; i < 8; i++) {
            instance.getBoard().dropPiece(new Position(0, i));
            instance.getBoard().dropPiece(new Position(1, i));
            instance.getBoard().dropPiece(new Position(6, i));
            instance.getBoard().dropPiece(new Position(7, i));
        }
        instance.getBoard().setPiece(new Pawn(Color.BLACK), new Position(4, 0));
        instance.getBoard().setPiece(new Pawn(Color.WHITE), new Position(2, 0));
        instance.movePiecePosition(new Position(2, 0), new Position(3, 0));
        GameState expResult = GameState.STALE_MATE;
        GameState result = instance.getState();
        assertEquals(expResult, result);
    }

    @Test
    public void whitePawnPromote() {
        Game instance = new Game();
        instance.getBoard().setPiece(new Pawn(Color.WHITE), new Position(6, 0));
        instance.setCurrentPlayer(new Player(Color.WHITE));
        instance.movePiecePosition(new Position(6, 0), new Position(7, 0));
        String expResult = "♕";
        String result = instance.getPiece(new Position(7, 0)).toString();
        assertEquals(expResult, result);
    }

    @Test
    public void blackPawnPromote() {
        Game instance = new Game();
        instance.getBoard().setPiece(new Pawn(Color.BLACK), new Position(1, 0));
        instance.setCurrentPlayer(new Player(Color.BLACK));
        instance.movePiecePosition(new Position(1, 0), new Position(0, 0));
        String expResult = "♛";
        String result = instance.getPiece(new Position(0, 0)).toString();
        assertEquals(expResult, result);
    }

    @Test
    public void whitePawnDoNotPromote() {
        Game instance = new Game();
        instance.start();
        instance.movePiecePosition(new Position(1, 1), new Position(2, 1));
        String expResult = "♙";
        String result = instance.getPiece(new Position(2, 1)).toString();
        assertEquals(expResult, result);
    }

    @Test
    public void blackPawnDoNotPromote() {
        Game instance = new Game();
        instance.start();
        instance.movePiecePosition(new Position(1, 1), new Position(2, 1));
        instance.movePiecePosition(new Position(6, 5), new Position(5, 5));
        String expResult = "♟";
        String result = instance.getPiece(new Position(5, 5)).toString();
        assertEquals(expResult, result);
    }

    @Test
    public void FlyingBishopMove() {
        Game instance = new Game();
        instance.setCurrentPlayer(new Player(Color.WHITE));
        Position pos = new Position(0, 0);
        instance.getBoard().setPiece(new FlyingBishop(Color.WHITE), pos);

        List<Position> result = instance.getPossibleMoves(pos);
        List<Position> expResult = List.of(
                new Position(1, 1),
                new Position(2, 2),
                new Position(3, 3),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7)
        );
        assertEquals(expResult, result);
    }
    
    @Test
    public void FlyingBishopMoveWithAllies() {
        Game instance = new Game();
        instance.setCurrentPlayer(new Player(Color.WHITE));
        Position pos = new Position(0, 0);
        instance.getBoard().setPiece(new FlyingBishop(Color.WHITE), pos);
        instance.getBoard().setPiece(new Pawn(Color.WHITE), new Position(1,1));
        instance.getBoard().setPiece(new Pawn(Color.WHITE), new Position(4,4));
        List<Position> result = instance.getPossibleMoves(pos);
        List<Position> expResult = List.of(
                new Position(2, 2),
                new Position(3, 3),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7)
        );
        assertEquals(expResult, result);
    }
    
    @Test
    public void FlyingBishopMoveWithOpponents() {
        Game instance = new Game();
        instance.setCurrentPlayer(new Player(Color.WHITE));
        Position pos = new Position(0, 0);
        instance.getBoard().setPiece(new FlyingBishop(Color.WHITE), pos);
        instance.getBoard().setPiece(new Pawn(Color.BLACK), new Position(1,1));
        instance.getBoard().setPiece(new Pawn(Color.BLACK), new Position(4,4));
        List<Position> result = instance.getPossibleMoves(pos);
        List<Position> expResult = List.of(
                new Position(1, 1),
                new Position(2, 2),
                new Position(3, 3),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7)
        );
        assertEquals(expResult, result);
    }
    
    @Test
    public void FlyingBishopMoveWithOpponentsAndAllies() {
        Game instance = new Game();
        instance.setCurrentPlayer(new Player(Color.WHITE));
        Position pos = new Position(0, 0);
        instance.getBoard().setPiece(new FlyingBishop(Color.WHITE), pos);
        instance.getBoard().setPiece(new Pawn(Color.BLACK), new Position(1,1));
        instance.getBoard().setPiece(new Pawn(Color.WHITE), new Position(2,2));
        instance.getBoard().setPiece(new Pawn(Color.BLACK), new Position(4,4));
        List<Position> result = instance.getPossibleMoves(pos);
        List<Position> expResult = List.of(
                new Position(1, 1),
                new Position(3, 3),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7)
        );
        assertEquals(expResult, result);
    }
    
    @Test
    public void FlyingBishopMoveWithOpponentsAndAllies2() {
        Game instance = new Game();
        instance.setCurrentPlayer(new Player(Color.WHITE));
        Position pos = new Position(0, 7);
        instance.getBoard().setPiece(new FlyingBishop(Color.BLACK), pos);
        instance.getBoard().setPiece(new Pawn(Color.WHITE), new Position(1,6));
        instance.getBoard().setPiece(new Pawn(Color.WHITE), new Position(2,5));
        instance.getBoard().setPiece(new Pawn(Color.BLACK), new Position(3,4));
        List<Position> result = instance.getPossibleMoves(pos);
        List<Position> expResult = List.of(
                new Position(1, 6),
                new Position(2, 5),
                new Position(4, 3),
                new Position(5, 2),
                new Position(6, 1),
                new Position(7, 0)
        );
        assertEquals(expResult, result);
    }
}
