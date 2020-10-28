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
public class ABBIT<K,E> {
    
    ABB<String, Person> instance;
    
    public ABBIT() {
        
        instance  = new ABB<>();
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    
    /**
     * SETUP 1.
     * 
     *                 ----I---  
     *                /        \
     *               D -------- J
     *             /   \     /    \
     *            A-----E---J------M
     */
    @BeforeEach
    public void setUp1() {
        
        Person p = new Person("Isabella", "Ortiz", "111111111", "ABC", "05/06/2001", "Colombia", 1, 1.50);
        Person p1 = new Person("Juan Camilo", "Guerra" , "100603596", "ABC", "10/04/2002", "Colombia", 1, 1.70);
        Person p2 = new Person("Diego", "Torres", "1193254110", "ABC", "14/12/2001", "Colombia", 1, 1.89);
        Person p3 = new Person("Manuela", "Perez" , "000000000", "ABC", "1/1/1111", "Colombia", 1, 1.73);
        Person p4 = new Person("Jorge", "Perez" , "000000001", "ABC", "1/1/1112", "Colombia", 1, 1.73);
        Person p5 = new Person("Ana", "Gonzales" , "000000001", "ABC", "1/1/1112", "Colombia", 1, 1.73);
        Person p6 = new Person("Ellen", "Torres" , "000000001", "ABC", "1/1/1112", "Colombia", 1, 1.73);
        String key = p.getFirstName();
        String key1 = p1.getFirstName();
        String key2 = p2.getFirstName();
        String key3 = p3.getFirstName();
        String key4 = p4.getFirstName();
        String key5 = p5.getFirstName();
        String key6 = p6.getFirstName();
        instance.insert(key, p);
        instance.insert(key1, p1);
        instance.insert(key2, p2);
        instance.insert(key3, p3);
        instance.insert(key4, p4);
        instance.insert(key5, p5);
        instance.insert(key6, p6);
    }
    
    @BeforeEach
    public void setUp2() {
        
//        Person p = new Person("Isabella", "Ortiz", "111111111", "ABC", "05/06/2001", "Colombia", 1, 1.50);
//        Person p1 = new Person("Juan Camilo", "Guerra" , "100603596", "ABC", "10/04/2002", "Colombia", 1, 1.70);
//        Person p2 = new Person("Diego", "Torres", "1193254110", "ABC", "14/12/2001", "Colombia", 1, 1.89);
//        String key = p.getFirstName();
//        String key1 = p1.getFirstName();
//        String key2 = p2.getFirstName();
//        ABB<String, Person> instance = new ABB<>();
//        instance.insert(key, p);
//        instance.insert(key1, p1);
//        instance.insert(key2, p2);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of insert method, of class ABB.
     *                  I
     *                /   \
     *             Null    Null
     */
    @Test
    public void testInsertRoot() {
        System.out.println("insert into Root");
        Person p = new Person("Isabella", "Ortiz", "111111111", "ABC", "05/06/2001", "Colombia", 1, 1.50);
        String key = p.getFirstName();
        ABB<String, Person> instance1 = new ABB<>();
        Node<String, Person> n = new Node<>(key, p);
        instance1.insert(key, p);
    }  
    
    /**
     * Test of insert method, of class ABB.
     * 
     *                  I
     *               /     \
     *           Null       J
     *                     / \
     *                 Null   Null
     * 
     */
    @Test
    public void testInsertRight1() {
        System.out.println("insert into Right");
        Person p = new Person("Isabella", "Ortiz", "111111111", "ABC", "05/06/2001", "Colombia", 1, 1.50);
        Person p1 = new Person("Juan Camilo", "Guerra" , "100603596", "ABC", "10/04/2002", "Colombia", 1, 1.70);
        String key = p.getFirstName();
        String key1 = p1.getFirstName();
        ABB<String, Person> instance2 = new ABB<>();
        Node<String, Person> n = new Node<>(key1, p1);
        instance2.insert(key, p);
        instance2.insert(key1, p1);
        assertEquals(instance2.getRoot().getRight().toString(), n.toString());
    }
    
    /**
     * Test of insert method, of class ABB.
     * 
     *                 ----I---  
     *                /        \
     *               D -------- J
     *              / \      /    \
     *          Null   Null Null   Null
     */
    @Test
    public void testInsertLeft1() {
        System.out.println("insert");
        Person p = new Person("Isabella", "Ortiz", "111111111", "ABC", "05/06/2001", "Colombia", 1, 1.50);
        Person p1 = new Person("Juan Camilo", "Guerra" , "100603596", "ABC", "10/04/2002", "Colombia", 1, 1.70);
        Person p2 = new Person("Diego", "Torres", "1193254110", "ABC", "14/12/2001", "Colombia", 1, 1.89);
        String key = p.getFirstName();
        String key1 = p1.getFirstName();
        String key2 = p2.getFirstName();
        ABB<String, Person> instance3 = new ABB<>();
        Node<String, Person> n = new Node<>(key2, p2);
        instance3.insert(key, p);
        instance3.insert(key1, p1);
        instance3.insert(key2, p2);
        assertEquals(instance3.getRoot().getLeft().toString(), n.toString());
    }
    
    /**
     * Test of insert method, of class ABB.
     * 
     *                 ----I---  
     *                /        \
     *               D -------- J
     *              / \      /    \
     *          Null   Null Null   M
     */
        @Test
    public void testInsertRight2() {
        System.out.println("insert into right right");
        Person p = new Person("Isabella", "Ortiz", "111111111", "ABC", "05/06/2001", "Colombia", 1, 1.50);
        Person p1 = new Person("Juan Camilo", "Guerra" , "100603596", "ABC", "10/04/2002", "Colombia", 1, 1.70);
        Person p2 = new Person("Diego", "Torres", "1193254110", "ABC", "14/12/2001", "Colombia", 1, 1.89);
        Person p3 = new Person("Manuela", "Perez" , "000000000", "ABC", "1/1/1111", "Colombia", 1, 1.73);
        String key = p.getFirstName();
        String key1 = p1.getFirstName();
        String key2 = p2.getFirstName();
        String key3 = p3.getFirstName();
        ABB<String, Person> instance4 = new ABB<>();
        Node<String, Person> n = new Node<>(key3, p3);
        instance4.insert(key, p);
        instance4.insert(key1, p1);
        instance4.insert(key2, p2);
        instance4.insert(key3, p3);
        assertEquals(instance4.getRoot().getRight().getRight().toString(), n.toString());
    }
    
    /**
     * Test of insert method, of class ABB.
     * 
     *                 ----I---  
     *                /        \
     *               D -------- J
     *              / \      /    \
     *          Null   Null J      M
     */
    public void testInsertLeft2() {
        System.out.println("insert into right right");
        Person p = new Person("Isabella", "Ortiz", "111111111", "ABC", "05/06/2001", "Colombia", 1, 1.50);
        Person p1 = new Person("Juan Camilo", "Guerra" , "100603596", "ABC", "10/04/2002", "Colombia", 1, 1.70);
        Person p2 = new Person("Diego", "Torres", "1193254110", "ABC", "14/12/2001", "Colombia", 1, 1.89);
        Person p3 = new Person("Manuela", "Perez" , "000000000", "ABC", "1/1/1111", "Colombia", 1, 1.73);
        Person p4 = new Person("Jorge", "Perez" , "000000001", "ABC", "1/1/1112", "Colombia", 1, 1.73);
        String key = p.getFirstName();
        String key1 = p1.getFirstName();
        String key2 = p2.getFirstName();
        String key3 = p3.getFirstName();
        String key4 = p4.getFirstName();
        ABB<String, Person> instance5 = new ABB<>();
        Node<String, Person> n = new Node<>(key4, p4);
        instance5.insert(key, p);
        instance5.insert(key1, p1);
        instance5.insert(key2, p2);
        instance5.insert(key3, p3);
        instance5.insert(key4, p4);
        assertEquals(instance5.getRoot().getRight().getLeft().toString(), n.toString());
    }

    /**
     * Test of deleteFromKey method, of class ABB.
     */
    @Test
    public void testDeleteFromKey() {
        System.out.println("deleteFromKey");
        setUp1();
        String key = "Isabella";
        instance.deleteFromKey(key);
        assertEquals(null, instance.getRoot());
    }


    /**
     * Test of search method, of class ABB.
     *       ------>   ----I---  
     *                /        \
     *               D -------- J
     *             /   \     /    \
     *            A-----E---J------M
     */    
    public void testSearchRoot() {
        System.out.println("search");
        setUp1();
        String key = "Isabella";
        Person result = instance.search(key);
        assertEquals(key, result.getFirstName());
        assertEquals(instance.getRoot().getType().getFirstName(), result.getFirstName());
    }

    /**
     * Test of search method, of class ABB.
     *                 ----I---  
     *                /        \
     *    ------>    D -------- J
     *             /   \     /    \
     *            A-----E---J------M
     */
    @Test
    public void testSearch2ndLvlLeft() {
        System.out.println("search");
        setUp1();
        String key = "Diego";
        Person result = instance.search(key);
        assertEquals(key, result.getFirstName());
        assertEquals(instance.getRoot().left.getType().getFirstName(), result.getFirstName());
    }
    
     /**
     * Test of search method, of class ABB.
     *                 ----I---  
     *                /        \
     *      ------>  D -------> J   
     *             /   \     /    \
     *            A-----E---J------M
     */
    public void testSearch2ndLvlRight() {
        System.out.println("search");
        setUp1();
        String key = "Juan Camilo";
        Person result = instance.search(key);
        assertEquals(key, result.getFirstName());
        assertEquals(instance.getRoot().right.getType().getFirstName(), result.getFirstName());
    }
    
    /**
     * Test of search method, of class ABB.
     *                 ----I---  
     *                /        \
     *               D -------- J   
     *             /   \     /    \
     *      ----> A-----E---J----->M
     */
    public void testSearch3rdLvlRightR() {
        System.out.println("search");
        setUp1();
        String key = "Manuela";
        Person result = instance.search(key);
        assertEquals(key, result.getFirstName());
        assertEquals(instance.getRoot().right.right.getType().getFirstName(), result.getFirstName());
    }
    
    
    /**
     * Test of search method, of class ABB.
     *                 ----I---  
     *                /        \
     *               D -------- J   
     *             /   \     /    \
     *      ----> A-----E-->J------M
     */    
    public void testSearch3rdLvlRightL() {
        System.out.println("search");
        setUp1();
        String key = "Jorge";
        Person result = instance.search(key);
        assertEquals(key, result.getFirstName());
        assertEquals(instance.getRoot().right.left.getType().getFirstName(), result.getFirstName());
    }

    /**
     * Test of search method, of class ABB.
     *                 ----I---  
     *                /        \
     *               D -------- J   
     *             /   \     /    \
     *      ----> A---->E---J------M
     */     
    public void testSearch3rdLvlLeftR() {
        System.out.println("search");
        setUp1();
        String key = "Ellen";
        Person result = instance.search(key);
        assertEquals(key, result.getFirstName());
        assertEquals(instance.getRoot().left.right.getType().getFirstName(), result.getFirstName());
    }
    
    /**
     * Test of search method, of class ABB.
     *                 ----I---  
     *                /        \
     *               D -------- J   
     *             /   \     /    \
     *      ----> A-----E---J------M
     */      
    public void testSearch3rdLvlLeftL() {
        System.out.println("search");
        setUp1();
        String key = "Ana";
        Person result = instance.search(key);
        assertEquals(key, result.getFirstName());
        assertEquals(instance.getRoot().left.left.getType().getFirstName(), result.getFirstName());
    }
    
    /**
     * Test of update method, of class ABB.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        String key = "Diego";
        Person p = new Person("DIEGO A", "TORRES", "111", "ABC", "1/1/2001", "EEUU", 1, 1.52);
        instance.update(key, p, p.getFirstName());
        //assertEquals(p.toString(), instance.getRoot().left.toString());
        assertEquals("DIEGO A", instance.getRoot().left.getKey());
    }
    
}
