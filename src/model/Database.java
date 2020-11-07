package model;

import datastructure.AVL;
import datastructure.AVLInterface;
import datastructure.HashTable;
import datastructure.HashTableInterface;

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
 * @author diegoa.torres
 */
public class Database implements Serializable {

    public static final String PATH = "Final.txt";

    private HashTableInterface people;
    private AVLInterface name, lastName, fullName, id;

    public Database() {
        this.people = new HashTable();
        this.name = new AVL();
        this.lastName = new AVL();
        this.fullName = new AVL();
        this.id = new AVL();
    }

    public void loadTextFile(String csv, String csv2, String csv3, String sep, int n) throws IOException {

        if (csv != null && csv2 != null && csv3 != null) {

            File f = new File(csv);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            File f2 = new File(csv2);
            FileReader fr2 = new FileReader(f2);
            BufferedReader br2 = new BufferedReader(fr2);

            File f3 = new File(csv3);
            FileReader fr3 = new FileReader(f3);
            BufferedReader br3 = new BufferedReader(fr3);

            String line = br.readLine();
            String line2 = br2.readLine();
            String line3 = br3.readLine();

            while (line != null && line2 != null && line3 != null) {

                if (line.charAt(0) != '#' && line2.charAt(0) != '#' && line3.charAt(0) != '#') {


                    String[] parts = line.split(sep);
                    String[] parts2 = line2.split(sep);
                    String[] parts3 = line3.split(sep);

                    String finame = parts[0];
                    String lName = parts2[0];
                    String pcountry = parts3[0];

                    int gender = 0;
                    if (parts[1].equalsIgnoreCase("boy")) {

                        gender = 0;
                    } else {

                        gender = 1;
                    }


                    Person p1 = new Person(finame, lName, (int) Math.floor(Math.random() * 1000 + 100000) + "", "https://thispersondoesnotexist.com/", (int) Math.floor(Math.random() * 12 + 1) + "/" + (int) Math.floor(Math.random() * 31 + 1) + "/" + (int) Math.floor(Math.random() * 100 + 1920), pcountry, gender, Math.random() * 70 + 150);
                    name.insert(p1.getFirstName(), p1);
                    lastName.insert(p1.getLastName(), p1);
                    fullName.insert(p1.getFullName(), p1);
                    id.insert(p1.getId(), p1);
                    line = br.readLine();
                    line2 = br2.readLine();
                    line3 = br.readLine();
                }
            }
        }
    }

    public static void serializacion(Object o) {

        try {

            String rutaFichero = PATH;

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaFichero));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaFichero));

            oos.writeObject(o);
            oos.close();

//            Person readPerson = (Person) ois.readObject();
            ois.close();

        } catch (IOException ex) {

            ex.printStackTrace();
        }
    }

    public void addPerson(Person p) {

        people.insert(Math.random(), p);
        name.insert(p.getFirstName(), p);
        lastName.insert(p.getLastName(), p);
        fullName.insert(p.getFullName(), p);
        id.insert(p.getId(), p);
    }

    public void update(String key, Person p) {

        name.update(key, p, p.getFirstName());
        lastName.update(key, p, p.getLastName());
        fullName.update(key, p, p.getFullName());
        id.update(key, p, p.getId());
    }
    //in construction

    public void updateName(String key, Person pUpdate) {
        Person p = (Person) name.search(key);
        name.update(key, pUpdate, pUpdate.getFirstName());
        lastName.update(p.getLastName(), pUpdate, pUpdate.getLastName());
        fullName.update(p.getFullName(), pUpdate, pUpdate.getFullName());
        id.update(p.getId(), pUpdate, pUpdate.getFullName());
    }

    public void updateLastName(String key, Person pUpdate) {
        Person p = (Person) lastName.search(key);
        name.update(p.getFirstName(), p, pUpdate.getFirstName());
        lastName.update(key, p, pUpdate.getLastName());
        fullName.update(p.getFullName(), p, pUpdate.getFullName());
        id.update(p.getId(), p, pUpdate.getId());
    }

    public void updateFullName(String key, Person pUpdate) {
        Person p = (Person) fullName.search(key);
        name.update(p.getFirstName(), p, pUpdate.getFirstName());
        lastName.update(p.getLastName(), p, pUpdate.getLastName());
        fullName.update(key, p, pUpdate.getFullName());
        id.update(p.getId(), p, pUpdate.getId());
    }

    public void updateId(String key, Person pUpdate) {
        Person p = (Person) fullName.search(key);
        name.update(p.getFirstName(), p, pUpdate.getFirstName());
        lastName.update(p.getLastName(), p, pUpdate.getLastName());
        fullName.update(p.getFullName(), p, pUpdate.getFullName());
        id.update(key, p, pUpdate.getId());
    }

    //


    public String globalSearch(String id) {

        return people.search(id).toString();
    }

    public String searchByFirstName(String fname) {

        return name.search(fname).toString();
    }

    public String searchByLastName(String lname) {

        return lastName.search(lname).toString();
    }

    public String searchByFullName(String fname) {

        return fullName.search(fname).toString();
    }

    public String searchById(String idn) {

        return id.search(idn).toString();
    }

}
