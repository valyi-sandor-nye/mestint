/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author valyis
 */
public class FoxAndHoundsAITest {
    
    public FoxAndHoundsAITest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of drawnPosition method, of class FoxAndHoundsGame.
     */
    @Test
    public void testDrawnPosition_01() {
        FoxAndHoundsPosition pos = new FoxAndHoundsPosition();
                boolean expResult = false;
        boolean result = new FoxAndHoundsGame().drawnPosition(pos);
        assertEquals(expResult, result);
        }

        @Test
    public void testDrawnPosition_02() {
        Character[][] matrix = new Character[][] {{' ',' ',' ',' '},{' ',' ',' ',' '},{'h',' ','h',' '},{' ','f',' ',' '}};
        FoxAndHoundsPosition pos = new FoxAndHoundsPosition();
        pos.setMatrix(matrix);
        boolean expResult = false;
        boolean result = new FoxAndHoundsGame().drawnPosition(pos);
        assertEquals(expResult, result);
        }

    /**
     * Test of wonPosition method, of class FoxAndHoundsGame. 
     * The fox cannot move, the game is won by the hounds
     */
    @Test
    public void testWonPosition_01() {
        Character[][] matrix = new Character[][] {{' ',' ',' ',' '},{' ',' ',' ',' '},{'h',' ','h',' '},{' ','f',' ',' '}};
        FoxAndHoundsPosition pos = new FoxAndHoundsPosition();
        pos.setMatrix(matrix);
        boolean hounds = false; 
        FoxAndHoundsGame instance = new FoxAndHoundsGame();
        boolean expResult = true;
        boolean result = instance.wonPosition(pos, hounds);
        assertEquals(expResult, result);
    }

    /**
     * Test of wonPosition method, of class FoxAndHoundsGame. 
     * The fox can move, the game is won by the hounds
     */
    @Test
    public void testWonPosition_02() {
        Character[][] matrix = new Character[][] {{'h',' ','h',' '},{' ',' ',' ',' '},{' ',' ',' ',' '},{' ','f',' ',' '}};
        FoxAndHoundsPosition pos = new FoxAndHoundsPosition();
        pos.setMatrix(matrix);
        boolean hounds = false; 
        FoxAndHoundsGame instance = new FoxAndHoundsGame();
        boolean expResult = false;
        boolean result = instance.wonPosition(pos, hounds);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testWonPosition_03() {
        Character[][] matrix = new Character[][] {{'h',' ','h',' '},{' ',' ',' ',' '},{' ',' ',' ',' '},{' ','f',' ',' '}};
        FoxAndHoundsPosition pos = new FoxAndHoundsPosition();
        pos.setMatrix(matrix);
        boolean fox = true; 
        FoxAndHoundsGame instance = new FoxAndHoundsGame();
        boolean expResult = false;
        boolean result = instance.wonPosition(pos, fox);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testWonPosition_04() {
        Character[][] matrix = new Character[][] {{'h',' ','f',' '},{' ',' ',' ',' '},{' ',' ',' ',' '},{' ','h',' ',' '}};
        FoxAndHoundsPosition pos = new FoxAndHoundsPosition();
        pos.setMatrix(matrix);
        boolean fox = true; 
        FoxAndHoundsGame instance = new FoxAndHoundsGame();
        boolean expResult = true;
        boolean result = instance.wonPosition(pos, fox);
        assertEquals(expResult, result);
    }

    

    /**
     * Test of positionEvaluation method, of class FoxAndHoundsGame.
     */
    @Test
    public void testPositionEvaluation_01() {
        Character[][] matrix = new Character[][] {{'h',' ','f',' '},{' ',' ',' ',' '},{' ',' ',' ',' '},{' ','h',' ',' '}};
        FoxAndHoundsPosition pos = new FoxAndHoundsPosition();
        pos.setMatrix(matrix);
        boolean fox = true; 
        FoxAndHoundsGame instance = new FoxAndHoundsGame();
        double expResult = 0.0;
        double result = instance.positionEvaluation(pos, fox);
        assertEquals(expResult, result,0.001);
    }

    @Test
    public void testPositionEvaluation_02() {
        Character[][] matrix = new Character[][] {{'h',' ',' ',' '},{' ',' ',' ',' '},{' ','f',' ',' '},{' ','h',' ',' '}};
        FoxAndHoundsPosition pos = new FoxAndHoundsPosition();
        pos.setMatrix(matrix);
        boolean fox = true; 
        FoxAndHoundsGame instance = new FoxAndHoundsGame();
        double expResult = 2.0;
        double result = instance.positionEvaluation(pos, fox);
        assertEquals(expResult, result,0.001);
    }

    @Test
    public void testPositionEvaluation_03() {
        Character[][] matrix = new Character[][] {{'h',' ','f',' '},{' ',' ',' ',' '},{' ',' ',' ',' '},{' ','h',' ',' '}};
        FoxAndHoundsPosition pos = new FoxAndHoundsPosition();
        pos.setMatrix(matrix);
        boolean hounds = false; 
        FoxAndHoundsGame instance = new FoxAndHoundsGame();
        double expResult = 3.0;
        double result = instance.positionEvaluation(pos, hounds);
        assertEquals(expResult, result,0.001);
    }

    

    /**
     * Test of possibleMoves method, of class FoxAndHoundsGame.
     */
    @Test
    public void testPossibleMoves_01_length() {
        Character[][] matrix = new Character[][] {{'h',' ','h',' '},{' ',' ',' ',' '},{' ',' ',' ',' '},{' ','f',' ',' '}};
        FoxAndHoundsPosition pos = new FoxAndHoundsPosition();
        pos.setMatrix(matrix);
        boolean player = true; 
        FoxAndHoundsGame instance = new FoxAndHoundsGame();
        Position[] result0 = instance.possibleMoves(pos, player);
        int result = result0.length;
        int expResult=2;
        assertEquals(expResult, result);      
    }
    
    
        /**
     * Test of possibleMoves method, of class FoxAndHoundsGame.
     */
    @Test
    public void testPossibleMoves_02_length() {
        Character[][] matrix = new Character[][] {{'h',' ','h',' '},{' ',' ',' ',' '},{' ',' ','f',' '},{' ',' ',' ',' '}};
        FoxAndHoundsPosition pos = new FoxAndHoundsPosition();
        pos.setMatrix(matrix);
        boolean player = true; 
        FoxAndHoundsGame instance = new FoxAndHoundsGame();
        Position[] result0 = instance.possibleMoves(pos, player);
        int result = result0.length;
        int expResult=4;
        assertEquals(expResult, result);   
    }

        /**
     * Test of possibleMoves method, of class FoxAndHoundsGame.
     */
    @Test
    public void testPossibleMoves_03_length() {
        Character[][] matrix = new Character[][] {{' ',' ',' ',' '},{' ','h',' ',' '},{'h',' ','f',' '},{' ',' ',' ',' '}};
        FoxAndHoundsPosition pos = new FoxAndHoundsPosition();
        pos.setMatrix(matrix);
        boolean player = false; 
        FoxAndHoundsGame instance = new FoxAndHoundsGame();
        Position[] result0 = instance.possibleMoves(pos, player);
        int result = result0.length;
        int expResult=1;
        Arrays.asList(result0).stream().forEach(x->{System.out.println("");instance.printPosition(x);});
        assertEquals(expResult, result);   
    }

    @Test
    public void testPossibleMoves_04_length() {
        Character[][] matrix = new Character[][] {{' ',' ',' ',' '},{' ',' ',' ',' '},{'h',' ','f',' '},{' ','h',' ',' '}};
        FoxAndHoundsPosition pos = new FoxAndHoundsPosition();
        pos.setMatrix(matrix);
        boolean player = false; 
        FoxAndHoundsGame instance = new FoxAndHoundsGame();
        Position[] result0 = instance.possibleMoves(pos, player);
        int result = result0.length;
        int expResult=0;
        Arrays.asList(result0).stream().forEach(x->{System.out.println("");instance.printPosition(x);});
        assertEquals(expResult, result);   
    }
    /**
     * Test of makeMove method, of class FoxAndHoundsGame.
     */
    @Test
    public void testMakeMove_01() {
        Character[][] matrix = new Character[][] {{' ',' ',' ',' '},{' ','h',' ',' '},{' ',' ','f',' '},{' ','h',' ',' '}};
        FoxAndHoundsPosition pos = new FoxAndHoundsPosition();
        pos.setMatrix(matrix);
        Move move = new FoxAndHoundsMove(1, 1, 2, 0);
        boolean player = false;
        FoxAndHoundsGame instance = new FoxAndHoundsGame();
        Position result = instance.makeMove(pos, player, move);
        Character[][] expMatrix = new Character[][] {{' ',' ',' ',' '},{' ',' ',' ',' '},{'h',' ','f',' '},{' ','h',' ',' '}};
        FoxAndHoundsPosition expPos = new FoxAndHoundsPosition();
        expPos.setMatrix(expMatrix);
        assertTrue(expPos.equals(result));
    }

    @Test
    public void testMakeMove_02() {
        Character[][] matrix = new Character[][] {{' ',' ',' ',' '},{' ','h',' ',' '},{' ',' ','f',' '},{' ','h',' ',' '}};
        FoxAndHoundsPosition pos = new FoxAndHoundsPosition();
        pos.setMatrix(matrix);
        Move move = new FoxAndHoundsMove(2, 2, 3, 3);
        boolean player = true;
        FoxAndHoundsGame instance = new FoxAndHoundsGame();
        Position result = instance.makeMove(pos, player, move);
        Character[][] expMatrix = new Character[][] {{' ',' ',' ',' '},{' ','h',' ',' '},{' ',' ',' ',' '},{' ','h',' ','f'}};
        FoxAndHoundsPosition expPos = new FoxAndHoundsPosition();
        expPos.setMatrix(expMatrix);
        assertTrue(expPos.equals(result));
    }
    

    
    
    
}
