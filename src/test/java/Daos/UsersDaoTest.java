/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Users;
import java.io.InputStream;
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
public class UsersDaoTest {
    final static String db = "testdb";
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
     * Test of LogingInUser method, of class UsersDao.
     */
    @Test
    public void testLogingInUser() {
        System.out.println("LogingInUser");
        String name = "BenRose";
        String password = "Brandytiggiroxy1";
        UsersDao instance = new UsersDao(db);
        boolean expResult = true;
        
        
        boolean result = true;
        
        Users u = instance.LogingInUser(name, password);
        
        if(u != null)
        {
            result = true;
        }
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
        String name = "BenRose";
        UsersDao instance = new UsersDao(db);
        boolean expResult = true;
        boolean result = false;
        Users u = instance.getUserbyName(name);
        if(u != null)
        {
            result = true;
        }
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of GetName method, of class UsersDao.
     */
    @Test
    public void testGetName() {
        System.out.println("GetName");
        String email = "ben.rose76@gmail.com";
        UsersDao instance = new UsersDao(db);
        String expResult = "BenRose";
        String result = instance.GetName(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of RegisterUser method, of class UsersDao.
     */
    @Test
    public void testRegisterUser_Users() {
        System.out.println("RegisterUser");
        Users u = null;
        UsersDao instance = null;
        int expResult = 0;
        int result = instance.RegisterUser(u);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of RegisterUser method, of class UsersDao.
     */
    @Test
    public void testRegisterUser_6args() {
        System.out.println("RegisterUser");
        String uname = "";
        String pass = "";
        String email = "";
        byte[] salt = null;
        String Created = "";
        String Due = "";
        UsersDao instance = null;
        boolean expResult = false;
        boolean result = instance.RegisterUser(uname, pass, email, salt, Created, Due);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of GetAuthorByID method, of class UsersDao.
     */
    @Test
    public void testGetAuthorByID() {
        System.out.println("GetAuthorByID");
        int ID = 29;
        UsersDao instance = new UsersDao(db);
        String expResult = "BenRose";
        String result = instance.GetAuthorByID(ID);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of EditProfile method, of class UsersDao.
     */
    @Test
    public void testEditProfile() {
        System.out.println("EditProfile");
        String username = "BenRose";
        String email = "ben.rose76@gmail.com";
        int id = 29;
        UsersDao instance = new UsersDao(db);
        boolean expResult = true;
        boolean result = instance.EditProfile(username, email, id);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of AddProfilePic method, of class UsersDao.
     */
    @Test
    public void testAddProfilePic() {
        System.out.println("AddProfilePic");
        InputStream photo = null;
        int id = 0;
        UsersDao instance = null;
        boolean expResult = false;
        boolean result = instance.AddProfilePic(photo, id);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of ChangePassword method, of class UsersDao.
     */
    @Test
    public void testChangePassword() {
        System.out.println("ChangePassword");
        String newpass = "Brandytiggiroxy1";
        String oldpass = "Brandytiggiroxy1";
        UsersDao instance = new UsersDao(db);
        boolean expResult = false;
        boolean result = instance.ChangePassword(newpass, oldpass);
        assertEquals(expResult, result);
        
        instance.ChangePassword(oldpass, newpass);
        
    }

    /**
     * Test of ChangeSalt method, of class UsersDao.
     */
    @Test
    public void testChangeSalt() {
        System.out.println("ChangeSalt");
        byte[] newsalt = null;
        byte[] oldsalt = null;
        UsersDao instance = null;
        boolean expResult = false;
        boolean result = instance.ChangeSalt(newsalt, oldsalt);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of ChangeDates method, of class UsersDao.
     */
    @Test
    public void testChangeDates() {
        System.out.println("ChangeDates");
        String Username = "";
        String cdate = "";
        String ddate = "";
        UsersDao instance = null;
        boolean expResult = false;
        boolean result = instance.ChangeDates(Username, cdate, ddate);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of GetCAlSaltch method, of class UsersDao.
     */
    @Test
    public void testGetCAlSaltch() {
        System.out.println("GetCAlSaltch");
        String pass = "";
        UsersDao instance = null;
        byte[] expResult = null;
        byte[] result = instance.GetCAlSaltch(pass);
        assertArrayEquals(expResult, result);
        
    }

    /**
     * Test of GetAllUsers method, of class UsersDao.
     */
    @Test
    public void testGetAllUsers() {
        System.out.println("GetAllUsers");
        UsersDao instance = new UsersDao(db);
        int expResult = 6;
        ArrayList<Users> result = instance.GetAllUsers();
        assertEquals(expResult, result.size());
        
    }
    
}
