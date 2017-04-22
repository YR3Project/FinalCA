/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.BattleSystem;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PC
 */
public class BattleSystemDaoTest {
    private String testdb = "testdb";
    BattleSystemDao bDao = null;
    public BattleSystemDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        bDao = new BattleSystemDao(testdb);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getChampName method, of class BattleSystemDao.
     */
    @Test
    public void testGetChampName() {
        System.out.println("getChampName");
        int id = 1;
        int id2 = 2;
        
        int id4 = 7;
        

        String expResult1 = "Vi";
        String expResult2 = "Jayce";
        String expResult3 = null;
        String result = bDao.getChampName(id).getChampName();
        String result2 = bDao.getChampName(id2).getChampName();
        BattleSystem result3 = bDao.getChampName(id4);
        assertEquals(expResult2, result2);
        assertEquals(expResult1, result);
        assertNull(expResult3, result3);
        
        
    }

    /**
     * Test of getChampValue method, of class BattleSystemDao.
     */
    @Test
    public void testGetChampValue() {
        System.out.println("getChampValue");
        int id = 1;
        BattleSystemDao instance = null;
        int expResult = 52;
        String name = "Vi";
        int result = bDao.getChampValue(name);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getChampPosition method, of class BattleSystemDao.
     */
    @Test
    public void testGetChampPosition() {
        System.out.println("getChampPosition");
        int id = 1;
        int id2 = 5;
        BattleSystemDao instance = null;
        String expResult = "Jung";
        String expResult2 = "Mid";
        String result = bDao.getChampPosition(id);
        String result2 = bDao.getChampPosition(id2);
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
        
    }

    /**
     * Test of getChampsBasedOnPosition method, of class BattleSystemDao.
     */
    @Test
    public void testGetChampsBasedOnPosition() {
        System.out.println("getChampsBasedOnPosition");
        String position = "Top";
        String position2 = "Support";
        BattleSystemDao instance = null;
        int expResult = 2;
        int expResult2 = 1;
        
        ArrayList<BattleSystem> result = bDao.getChampsBasedOnPosition(position);
        ArrayList<BattleSystem> result2 = bDao.getChampsBasedOnPosition(position2);
        assertEquals(expResult, result.size());
        assertEquals(expResult2, result2.size());
       
        
    }
    
}
