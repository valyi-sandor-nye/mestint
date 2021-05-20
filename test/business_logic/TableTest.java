/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business_logic;

import java.util.ArrayList;
import java.util.List;
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
public class TableTest {
    
    public TableTest() {
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
     * Test of getFoxPossibleMoves method, of class Table.
     */
    @Test
    public void testGetFoxPossibleMovesOnEmptyTableifNotDeterminedYet() {
        
        Table instance = Table.getEmptyTable(4);
        List<Move> expResult = null;
        List<Move> result = instance.getFoxPossibleMoves();
        boolean eddigOK = true;
        eddigOK = (result == expResult);
        assertEquals(expResult, result);       
    }

    /**
     * Test of getFoxPossibleMoves method, of class Table.
     */
    @Test
    public void testGetFoxPossibleMovesOnStarterTableifDeterminedAlready() {
        
        int N = 4;
        Table starterTable = Table.getStarterTable(N);
        starterTable.determineFoxPossibleMoves();
        List<Move> expResult = new ArrayList<Move>();
        expResult.add(new Move(new Fox(N-2,1)));
        List<Move> result = starterTable.getFoxPossibleMoves();
        boolean eddigOK = true;
        eddigOK = eddigOK && result.containsAll(expResult);
        eddigOK = eddigOK && expResult.containsAll(result);
        assertTrue(eddigOK);
        
    }
    
    
    
    /**
     * Test of getHoundsPossibleMoves method, of class Table.
     */
    @Test
    public void testGetHoundsPossibleMoves() {
        System.out.println("getHoundsPossibleMoves");
        Table instance = new Table();
        List<Move> expResult = null;
        List<Move> result = instance.getHoundsPossibleMoves();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isFoxOnMOve method, of class Table.
     */
    @Test
    public void testIsFoxOnMOve() {
        System.out.println("isFoxOnMOve");
        Table instance = new Table();
        Boolean expResult = null;
        Boolean result = instance.isFoxOnMOve();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFoxOnMove method, of class Table.
     */
    @Test
    public void testSetFoxOnMove() {
        System.out.println("setFoxOnMove");
        boolean b = false;
        Table instance = new Table();
        instance.setFoxOnMove(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTableSize method, of class Table.
     */
    @Test
    public void testSetTableSize() {
        System.out.println("setTableSize");
        int x = 0;
        Table instance = new Table();
        instance.setTableSize(x);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTableSize method, of class Table.
     */
    @Test
    public void testGetTableSize() {
        System.out.println("getTableSize");
        Table instance = new Table();
        int expResult = 0;
        int result = instance.getTableSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStarterTable method, of class Table.
     */
    @Test
    public void testGetStarterTable() {
        System.out.println("getStarterTable");
        int size = 0;
        Table expResult = null;
        Table result = Table.getStarterTable(size);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmptyTable method, of class Table.
     */
    @Test
    public void testGetEmptyTable() {
        System.out.println("getEmptyTable");
        int size = 0;
        Table expResult = null;
        Table result = Table.getEmptyTable(size);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of determineFoxPossibleMoves method, of class Table.
     */
    @Test
    public void testDetermineFoxPossibleMoves() {
        System.out.println("determineFoxPossibleMoves");
        Table instance = new Table();
        instance.determineFoxPossibleMoves();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of determineHoundsPossibleMoves method, of class Table.
     */
    @Test
    public void testDetermineHoundsPossibleMoves() {
        System.out.println("determineHoundsPossibleMoves");
        Table instance = new Table();
        instance.determineHoundsPossibleMoves();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of winHounds method, of class Table.
     */
    @Test
    public void testWinHounds() {
        System.out.println("winHounds");
        Table instance = new Table();
        boolean expResult = false;
        boolean result = instance.winHounds();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of winFox method, of class Table.
     */
    @Test
    public void testWinFox() {
        System.out.println("winFox");
        Table instance = new Table();
        boolean expResult = false;
        boolean result = instance.winFox();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doMove method, of class Table.
     */
    @Test
    public void testDoMove() {
        System.out.println("doMove");
        Move move = null;
        Table instance = new Table();
        instance.doMove(move);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Table.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Table instance = new Table();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doARandomHoundMove method, of class Table.
     */
    @Test
    public void testDoARandomHoundMove() {
        System.out.println("doARandomHoundMove");
        Table instance = new Table();
        instance.doARandomHoundMove();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doARandomFoxMove method, of class Table.
     */
    @Test
    public void testDoARandomFoxMove() {
        System.out.println("doARandomFoxMove");
        Table instance = new Table();
        instance.doARandomFoxMove();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
