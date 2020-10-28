package model;

import datastructure.AVL;
import datastructure.AVLInterface;
import datastructure.HashTable;
import datastructure.HashTableInterface;
import datastructure.RBT;
import datastructure.RBTInterface;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author diegoa.torres
 */
public class Database implements Serializable{

    private HashTableInterface people;
    private AVLInterface name, lastName, fullName;
    private RBTInterface id;

    public Database() {
        this.people = new HashTable();
        this.name = new AVL();
        this.lastName = new AVL();
        this.fullName = new AVL();
        this.id = new RBT();
    }

    public Person loadTextFile(String csv, String sep)throws IOException{
          
        Person p = null;


        if (csv != null) {

            File f = new File (csv);
            FileReader fr = new  FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            int i = 0;

            String line = br.readLine();

            while (line != null) {

                if (line.charAt(0) != '#') {

                    String[] parts = line.split(sep);
//                    String id = parts[0];
//                    String name = parts[1];
//                    String LastName = parts[2];


//                    DECLARE OBJECT
//                    ADD OBJECT
                    line = br.readLine();
                    i++; 

                }
            }
        }
        return p;
    }
    
    public void serializacion (Object o){

        try{

            String rutaFichero = "Final.txt";

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaFichero));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaFichero));

            oos.writeObject(o);
            oos.close();

            Person readPerson = (Person) ois.readObject();
            ois.close();


        }catch (IOException ex) {

            System.out.println(ex.getMessage());
        }catch (ClassNotFoundException ex) {

            System.out.println(ex.getMessage());
        }             
    }
    
    public void addPerson(Person p){
        
        people.insert(Math.random(), p);
        name.insert(p.getFirstName(), p);
        lastName.insert(p.getLastName(), p);
        fullName.insert(p.getFullName(), p);
        id.insert(p.getId(), p);
    }
    
    public void update(String key, Person p){
        
        name.update(key, p, p.getFirstName());
        lastName.update(key, p, p.getLastName());
        fullName.update(key, p, p.getFullName());
        id.update(key, p, p.getId());
    }
    
    public String globalSearch(String id){
        
        return people.search(id).toString();
    }
    
    public String searchByFirstName(String fname){
        
        return name.search(fname).toString();
    }
    
    public String searchByLastName(String lname){
        
        return lastName.search(lname).toString();
    }
    
    public String searchByFullName(String fname){
        
        return fullName.search(fname).toString();
    }
    
    public String searchById(String idn){
        
        return "";
    }
    
    
}
