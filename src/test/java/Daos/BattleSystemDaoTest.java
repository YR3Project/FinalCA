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
    private final String testdb = "testdb";
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
        

        String expResult1 = "Vi";
        String expResult2 = "Jayce";
        
        String result = bDao.getChampName(id).getChampName();
        String result2 = bDao.getChampName(id2).getChampName();
        
        assertEquals(expResult2, result2);
        assertEquals(expResult1, result);
        
        
        
    }

    /**
     * Test of getChampValue method, of class BattleSystemDao.
     */
    @Test
    public void testGetChampValue() {
        System.out.println("getChampValue");
        int id = 1;
        BattleSystemDao instance = null;
        double expResult = 52.1;
        String name = "Vi";
        double result = bDao.getChampValue(name);
        assertEquals(expResult, result, 00.00);
        
        
    }

    /**
     * Test of getChampPosition method, of class BattleSystemDao.
     */
    @Test
    public void testGetChampPosition() {
        System.out.println("getChampPosition");
        int id = 1;
        int id2 = 5;
       
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
        
        int expResult = 9;
        int expResult2 =9;
        
        ArrayList<BattleSystem> result = bDao.getChampsBasedOnPosition(position);
        ArrayList<BattleSystem> result2 = bDao.getChampsBasedOnPosition(position2);
        assertEquals(expResult, result.size());
        assertEquals(expResult2, result2.size());
       
        
    }
    
}
