/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Users;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
    private String testdb = "testdb";
    private UsersDao uDao = new UsersDao(testdb);
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
        String workingName = "ChrisJunit2";
        String password = "Password1";
        //Testing for case senitivity 
        String testName1 = "chrisJUNIT";
        String testName2 = "CHRISJUNIT";
        String testName3 = "chrisjunit";
       
        
        
        boolean expResult = true;
        boolean result = false;
        boolean result2 = false;
        boolean result3 = false;
        boolean result4 = false;
        boolean result5 = false;
        Users u = uDao.LogingInUser(workingName, password);
        Users u2 = uDao.LogingInUser(testName1, password);
        Users u3 = uDao.LogingInUser(testName2, password);
        Users u4 = uDao.LogingInUser(testName3, password);
        
        if(u != null) {
            result2 = true;
            assertEquals(expResult, result);
        }
        if(u2 != null)
        {
            result2 = true;
            assertEquals(expResult, result2);
        }if(u3 != null)
        {
            result3 = true;
            assertEquals(expResult, result3);
        }
        if(u4 != null)
        {
            result4 = true;
            assertEquals(expResult, result4);
        }
       
      
        
    }

    /**
     * Test of GetCAlSalt method, of class UsersDao.
     
    @Test
    public void testGetCAlSalt() {
        System.out.println("GetCAlSalt");
        String username = "";
        UsersDao instance = null;
        byte[] expResult = null;
        byte[] result = instance.GetCAlSalt(username);
        assertArrayEquals(expResult, result);
        
    }
    * /
    /**
     * Test of getUserbyName method, of class UsersDao.
     */
    @Test
    public void testGetUserbyName() {
        System.out.println("getUserbyName");
        String name = "ChrisJunit";
        
        boolean expResult = true;
        boolean result = false;
        Users u = uDao.getUserbyName(name);
        if(u != null)
        {
            result = true;
        }
        assertEquals(expResult, result);
       
    }

    /**
     * Test of GetName method, of class UsersDao.
     */
    @Test
    public void testGetName() {
        System.out.println("GetName");
        String email = "beartrap15@gmail.com";
       
        String expResult = "chips97";
        String result = uDao.GetName(email);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of GetEmail method, of class UsersDao.
     */
    @Test
    public void testGetEmail() {
        System.out.println("GetEmail");
        String name = "chips97";
        
        String expResult = "beartrap15@gmail.com";
        String result = uDao.GetEmail(name);
        assertEquals(expResult, result);
        
    }

    

    /**
     * Test of RegisterUser method, of class UsersDao.
     */
    @Test
    public void testRegisterUser() throws NoSuchAlgorithmException, NoSuchProviderException {
        System.out.println("RegisterUser");
        String uname = "ChrisJunit2";
        String pass = "Password1";
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        byte[] salt = getSalt();
			md.update(salt);
			byte[] bytes = md.digest(pass.getBytes());
			
                        StringBuilder sb = new StringBuilder();
			
                        for(int i=0; i< bytes.length ;i++)
			{
                            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			String generatedPassword = sb.toString();
        String email = "junit@gmaill.com";
         DateFormat df = new SimpleDateFormat("dd/MM/yy");
                        Date createdate = new Date();
                        Date expiredate = new Date();
                        Calendar c = Calendar.getInstance(); 
                        c.setTime(createdate); 
                        c.add(Calendar.DATE, 10);
                        expiredate = c.getTime();
        
        
        boolean expResult = true;
        boolean result = uDao.RegisterUser(uname, generatedPassword, email, salt, df.format(createdate), df.format(expiredate));
        assertEquals(expResult, result);
       
    }

    /**
     * Test of GetAuthorByID method, of class UsersDao.
     */
    @Test
    public void testGetAuthorByID() {
        System.out.println("GetAuthorByID");
        int ID = 48;
        
        String expResult = "BenRose";
        String result = uDao.GetAuthorByID(ID);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of EditProfile method, of class UsersDao.
     */
    @Test
    public void testEditProfile() {
        System.out.println("EditProfile");
        String username = "chips98";
        String email = "beartrap15@gmail.com";
        int id = 52;
        
        boolean expResult = true;
        boolean result = uDao.EditProfile(username, email, id);
        assertEquals(expResult, result);
        uDao.EditProfile("chips97", email, id);
        
    }
    //TODO LATER DONT FORGET
    //MIGHT NOT WORK SINCE I DUNNO HOW TO TEST FOR THIS TRIAL AND ERROR BABY
    /**
     * Test of ChangePassword method, of class UsersDao.
     
    @Test
    public void testChangePassword() {
        System.out.println("ChangePassword");
        String newpass = "";
        String oldpass = "";
        UsersDao instance = null;
        boolean expResult = false;
        boolean result = instance.ChangePassword(newpass, oldpass);
        assertEquals(expResult, result);
    }

    /**
     * Test of ChangeSalt method, of class UsersDao.
     
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
     
    @Test
    public void testGetAllUsers() {
        System.out.println("GetAllUsers");
        
        int expResult = 6;
        ArrayList<Users> result = uDao.GetAllUsers();
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of GetPicPath method, of class UsersDao.
     
    @Test
    public void testGetPicPath() {
        System.out.println("GetPicPath");
        int id = 48;
        
        String expResult = "Images/Profiles/35.jpg";
        String result = uDao.GetPicPath(id);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of ForgotPassword method, of class UsersDao.
     
    @Test
    public void testForgotPassword() {
        System.out.println("ForgotPassword");
        String newpass = "";
        String name = "";
        UsersDao instance = null;
        boolean expResult = false;
        boolean result = instance.ForgotPassword(newpass, name);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of ForgotPassSalt method, of class UsersDao.
     
    @Test
    public void testForgotPassSalt() {
        System.out.println("ForgotPassSalt");
        byte[] newsalt = null;
        String name = "";
        UsersDao instance = null;
        boolean expResult = false;
        boolean result = instance.ForgotPassSalt(newsalt, name);
        assertEquals(expResult, result);
        
    }
    */
    private byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException {
        //Always use a SecureRandom generator
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		//Create array for salt
		byte[] salt = new byte[16];
		//Get a random salt
		sr.nextBytes(salt);
		//return salt
		return salt;
    }
}
