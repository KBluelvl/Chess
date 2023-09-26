package g58137.chess.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Florian
 */
public class PositionTest {

    /**
     * Test 1  of next method, of class Position.
     */
    @Test
    public void test1Next() {
        System.out.println("next1");
        Direction dir = Direction.NW;
        Position instance = new Position(5,5);
        Position expResult = new Position(6,4);
        Position result = instance.next(dir);
        assertEquals(expResult, result);
    }
    
    /**
     * Test 2  of next method, of class Position.
     */
    @Test
    public void test2Next() {
        System.out.println("next2");
        Direction dir = Direction.N;
        Position instance = new Position(5,5);
        Position expResult = new Position(6,5);
        Position result = instance.next(dir);
        assertEquals(expResult, result);
    }
    
    /**
     * Test 3 of next method, of class Position.
     */
    @Test
    public void test3Next() {
        System.out.println("next3");
        Direction dir = Direction.NE;
        Position instance = new Position(5,5);
        Position expResult = new Position(6,6);
        Position result = instance.next(dir);
        assertEquals(expResult, result);
    }
    
    /**
     * Test4  of next method, of class Position.
     */
    @Test
    public void test4Next() {
        System.out.println("next4");
        Direction dir = Direction.W;
        Position instance = new Position(5,5);
        Position expResult = new Position(5,4);
        Position result = instance.next(dir);
        assertEquals(expResult, result);
    }
    
    /**
     * Test5  of next method, of class Position.
     */
    @Test
    public void test5Next() {
        System.out.println("next5");
        Direction dir = Direction.E;
        Position instance = new Position(5,5);
        Position expResult = new Position(5,6);
        Position result = instance.next(dir);
        assertEquals(expResult, result);
    }
    
    /**
     * Test6  of next method, of class Position.
     */
    @Test
    public void test6Next() {
        System.out.println("next6");
        Direction dir = Direction.SW;
        Position instance = new Position(5,5);
        Position expResult = new Position(4,4);
        Position result = instance.next(dir);
        assertEquals(expResult, result);
    }
    
    /**
     * Test7  of next method, of class Position.
     */
    @Test
    public void test7Next() {
        System.out.println("next7");
        Direction dir = Direction.S;
        Position instance = new Position(5,5);
        Position expResult = new Position(4,5);
        Position result = instance.next(dir);
        assertEquals(expResult, result);
    }
    
    /**
     * Test8  of next method, of class Position.
     */
    @Test
    public void test8Next() {
        System.out.println("next8");
        Direction dir = Direction.SE;
        Position instance = new Position(5,5);
        Position expResult = new Position(4,6);
        Position result = instance.next(dir);
        assertEquals(expResult, result);
    }
    
}
