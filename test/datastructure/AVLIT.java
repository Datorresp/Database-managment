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

import java.io.Serializable;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author diegoa.torres
 * @param <K>
 * @param <V>
 */
public class AVLIT<K,V> implements Serializable {
    
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

    @BeforeEach
    public void setUp2() {
        Person p = new Person("Laura", "Calderon", "111111111", "ABC", "14/2/2001", "Colombia", 2, 1.50);
        Person p1 = new Person("Juan Camilo", "Guerra" , "100603596", "ABC", "10/4/2002", "Colombia", 1, 1.70);
        Person p2 = new Person("Diego", "Torres", "1193254110", "ABC", "14/12/2001", "Colombia", 1, 1.89);
        Person p3 = new Person("Maria", "Angelica" , "1024578412", "ABC", "1/1/2001", "Colombia", 2, 1.73);
        Person p4 = new Person("Carlos", "Perez" , "1002587456", "ABC", "18/1/2003", "Colombia", 1, 1.73);
        Person p5 = new Person("Ana", "Gonzales" , "123582147", "ABC", "11/10/2000", "Colombia", 2, 1.73);
        Person p6 = new Person("Gloria", "Elena" , "1003256145", "ABC", "1/5/2000", "Colombia", 1, 1.73);

        instance.insert(p.getFirstName(), p);
        instance.insert(p1.getFirstName(), p1);
        instance.insert(p2.getFirstName(), p2);
        instance.insert(p3.getFirstName(), p3);
        instance.insert(p4.getFirstName(), p4);
        instance.insert(p5.getFirstName(), p5);
        instance.insert(p6.getFirstName(), p6);
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
        String key = "10";
        Person element = new Person("Diego", "Torres", "1193254110", "ABC", "", "", 1, 0);
        instance.insert(key, element);
        assertEquals(instance.getRoot().getLeft().getType().getCountry(), element.getFirstName());
    }

    @Test
    public void testInsert1() {
        System.out.println("insert1");
        setUp2();
        String key = "Laura";
        assertEquals(key, instance.search(key));
    }

    @Test
    public void testInsert2() {
        System.out.println("insert2");
        setUp2();
        String key = "Juan Camilo";
        assertEquals(key, instance.search(key));
    }

    @Test
    public void testInsert3() {
        System.out.println("insert3");
        setUp2();
        String key = "Diego";
        assertEquals(key, instance.search(key));
    }

    @Test
    public void testInsert4() {
        System.out.println("insert4");
        setUp2();
        String key = "Maria";
        assertEquals(key, instance.search(key));
    }

    @Test
    public void testInsert5() {
        System.out.println("insert5");
        setUp2();
        String key = "Carlos";
        assertEquals(key, instance.search(key));
    }

    @Test
    public void testInsert6() {
        System.out.println("insert6");
        setUp2();
        String key = "Ana";
        assertEquals(key, instance.search(key));
    }

    @Test
    public void testInsert7() {
        System.out.println("insert7");
        setUp2();
        String key = "Gloria";
        assertEquals(key, instance.search(key));
    }

    /**
     * Test of update method, of class AVL.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        setUp1();
        String key = "Juan";
        Person upp = new Person("Diego", "Torres", "1193254110", "ABC", "", "", 1, 0);
        Person element = upp;
        Person newKey = upp;
        instance.update(key, element, newKey.getFirstName());
        assertNotNull(instance.search(upp.getFirstName()));
    }

    /**
     * Test of deleteAVL method, of class AVL.
     */
//    @Test
//    public void testDeleteAVL() {
//        System.out.println("deleteAVL");
//        setUp1();
//        String key = "Juan";
//        instance.deleteAVL(key);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
    
    
}
