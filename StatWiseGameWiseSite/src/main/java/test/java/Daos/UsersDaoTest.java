/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Users;
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
public class UsersDaoTest {
     private static UsersDao userDao;
    public UsersDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        userDao = new UsersDao("finalprojecttest");
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
     * Test of RegistorUser method, of class UsersDao.
     */
    @Test
    public void testRegistorUser() {
        System.out.println("RegistorUser");
        String uname = "";
        String pass = "";
        String email = "";
        byte[] salt = null;
        String Created = "";
        String Due = "";
        UsersDao instance = null;
        boolean expResult = false;
        boolean result = instance.RegistorUser(uname, pass, email, salt, Created, Due);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of LogingInUser method, of class UsersDao.
     */
    @Test
    public void testLogingInUser() {
        System.out.println("LogingInUser");
        String name = "AdminChris";
        String password = "Password1";
        Users result = userDao.LogingInUser(name, password);
        Users expResult = new Users(4,"AdminChris", "admin@admin.com", "Placeholder1", 1 ,"", "07/01/2017", "25/12/2017");
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of GetCAlSalt method, of class UsersDao.
     */
    @Test
    public void testGetCAlSalt() {
        System.out.println("GetCAlSalt");
        String username = "";
        UsersDao instance = null;
        byte[] expResult = null;
        byte[] result = instance.GetCAlSalt(username);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserbyName method, of class UsersDao.
     */
    @Test
    public void testGetUserbyName() {
        System.out.println("getUserbyName");
        String name = "AdminChris";
        
        Users expResult = null;
        Users result = userDao.getUserbyName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }
    
}
