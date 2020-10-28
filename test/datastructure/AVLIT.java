/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure;

import model.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author diegoa.torres
 */
public class AVLIT<K,V> {
    
    AVL<String, Person> instance;
    
    public AVLIT() {
        instance = new AVL<>();
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp1() {
        
        Person p1 = new Person("Juan", "Guerra", " ", "", "", "", 0, 0);
         instance.insert(p1.getFirstName(), p1);
    }
    
    @AfterEach
    public void tearDown() {
    }


    /**
     * Test of insert method, of class AVL.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        String key = "Diego";
        Person element = new Person("Diego", "Torres", "1193254110", "ABC", "", "", 1, 0);
        instance.insert(key, element);
        assertEquals(instance.getRoot().getLeft().getType().getCountry(), element.getFirstName());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class AVL.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Object key = null;
        Object element = null;
        Object newKey = null;
//        instance.update(key, element, newKey);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAVL method, of class AVL.
     */
    @Test
    public void testDeleteAVL() {
        System.out.println("deleteAVL");
        Object key = null;
        AVL instance = new AVL();
//        instance.deleteAVL(key);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    
    
}
