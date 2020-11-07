/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author diegoa.torres
 */
public class DatabaseIT {
    
    public DatabaseIT() {
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
     * Test of loadTextFile method, of class Database.
     */
    @Test
    public void testLoadTextFile() throws Exception {
        System.out.println("loadTextFile");
        String csv = "";
        String csv2 = "";
        String csv3 = "";
        String sep = "";
        Database instance = new Database();
        instance.loadTextFile(csv, csv2, csv3, sep);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of serializacion method, of class Database.
     */
    @Test
    public void testSerializacion() {
        System.out.println("serializacion");
        Object o = null;
        Database.serializacion(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPerson method, of class Database.
     */
    @Test
    public void testAddPerson() {
        System.out.println("addPerson");
        Person p = null;
        Database instance = new Database();
        instance.addPerson(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Database.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        String key = "";
        Person p = null;
        Database instance = new Database();
        instance.update(key, p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateName method, of class Database.
     */
    @Test
    public void testUpdateName() {
        System.out.println("updateName");
        String key = "";
        Person pUpdate = null;
        Database instance = new Database();
        instance.updateName(key, pUpdate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateLastName method, of class Database.
     */
    @Test
    public void testUpdateLastName() {
        System.out.println("updateLastName");
        String key = "";
        Person pUpdate = null;
        Database instance = new Database();
        instance.updateLastName(key, pUpdate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateFullName method, of class Database.
     */
    @Test
    public void testUpdateFullName() {
        System.out.println("updateFullName");
        String key = "";
        Person pUpdate = null;
        Database instance = new Database();
        instance.updateFullName(key, pUpdate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateId method, of class Database.
     */
    @Test
    public void testUpdateId() {
        System.out.println("updateId");
        String key = "";
        Person pUpdate = null;
        Database instance = new Database();
        instance.updateId(key, pUpdate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of globalSearch method, of class Database.
     */
    @Test
    public void testGlobalSearch() {
        System.out.println("globalSearch");
        String id = "";
        Database instance = new Database();
        String expResult = "";
        String result = instance.globalSearch(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByFirstName method, of class Database.
     */
    @Test
    public void testSearchByFirstName() {
        System.out.println("searchByFirstName");
        String fname = "";
        Database instance = new Database();
        String expResult = "";
        String result = instance.searchByFirstName(fname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByLastName method, of class Database.
     */
    @Test
    public void testSearchByLastName() {
        System.out.println("searchByLastName");
        String lname = "";
        Database instance = new Database();
        String expResult = "";
        String result = instance.searchByLastName(lname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByFullName method, of class Database.
     */
    @Test
    public void testSearchByFullName() {
        System.out.println("searchByFullName");
        String fname = "";
        Database instance = new Database();
        String expResult = "";
        String result = instance.searchByFullName(fname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchById method, of class Database.
     */
    @Test
    public void testSearchById() {
        System.out.println("searchById");
        String idn = "";
        Database instance = new Database();
        String expResult = "";
        String result = instance.searchById(idn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
