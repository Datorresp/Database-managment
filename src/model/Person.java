package model;

/**
 *
 * @author diegoa.torres
 */
public class Person implements Comparable<Person>{

    public static final int MALE = 1;
    public static final int FEMALE = 2;
    private String firstName, lastName, fullName, id, photo, birthday, country;
    private int gender;
    private double height;

    public Person(String firstName, String lastName, String id, String photo, String birthday, String country, int gender, double height) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.id = id;
        this.photo = photo;
        this.birthday = birthday;
        this.country = country;
        this.gender = gender;
        this.height = height;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public int compareTo(Person o) {
        return this.id.compareTo(o.getId());
    }
    
    
}
