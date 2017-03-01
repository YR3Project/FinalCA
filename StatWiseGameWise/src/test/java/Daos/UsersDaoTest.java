/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;
import java.util.*;
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
    private final String TestDatabase = "testdb";
    public UsersDaoTest() {
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
     * Test of RegistorUser method, of class UsersDao.
     */
    @org.junit.Test
    public void testRegistorUser() {
       /* System.out.println("Register");
        UsersDao usrDao = new UsersDao(TestDatabase);
        
        Users u = new Users();
        u.setUserName("TestChris");
        u.setEmail("testemail@gmail.com");
        byte[] salt = null;
        
        boolean error = false;
        do
        {
            error = false;
            salt = Users.generateSalt();
            
            if(usrDao.GetCAlSalt(u.setUserName("TestChris")))) error = true;
                    
        }while(error);
        
        u.setSalt(salt);
        u.setPassword(Users.generateSaltedHash("Password12345", salt));
        u.setCreated(Users.getCurrentDate());
        u.setDue(Users.getCurrentDate());
        
        boolean expResult = true;
        boolean result;
        
        */
        
    }

    /**
     * Test of LogingInUser method, of class UsersDao.
     */
    @org.junit.Test
    public void testLogingInUser() {
        System.out.println("Login");
        
        String usrname = "ChrisTest";
        String password = "Password123";
        UsersDao usrDao = new UsersDao(TestDatabase);
        
        boolean expResult = true;
        boolean result = false;
        
        Users u = usrDao.LogingInUser(usrname, password);
        
        if(u == null)
        {
            result = true;
        }
        assertEquals(expResult, result);
        
    }

    /**
     * Test of GetCAlSalt method, of class UsersDao.
     */
    @org.junit.Test
    public void testGetCAlSalt() {
       
    }

    /**
     * Test of getUserbyName method, of class UsersDao.
     */
    @org.junit.Test
    public void testGetUserbyName() {
        System.out.println("Get user by name");
        String username = "BenTest";
        UsersDao usrDao = new UsersDao(TestDatabase);
        
        boolean expResult = true;
        boolean result = false;
        Users u = usrDao.getUserbyName(username);
        if(u != null )
        {
            result = true;
        }
        
        assertEquals(expResult, result);
    }

    /**
     * Test of GetName method, of class UsersDao.
     */
    @org.junit.Test
    public void testGetName() {
        System.out.println("Get name via email");
        
        String email = "ben.rose76@gmail.com";
        
        UsersDao usrDao = new UsersDao(TestDatabase);
        
        boolean expResult = true;
        boolean result = false;
        
        String u = usrDao.GetName(email);
        
        if(u != null)
        {
            result = true;
        }
        
        assertEquals(expResult, result);
    }
    
}
