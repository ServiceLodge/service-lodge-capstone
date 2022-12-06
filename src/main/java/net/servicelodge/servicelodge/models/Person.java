package net.servicelodge.servicelodge.models;

import javax.persistence.*;

@Entity
@Table(name="persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 200)
    private String first_Name;

    @Column(nullable = false, length = 200)
    private String last_Name;

    @Column(nullable = false, length = 200, unique = true)
    private String email;

    @Column(nullable = false, length = 10, unique = true)
    private int phone_Number;

    public Person(long id, String first_Name, String last_Name, String email, int phone_Number) {
        this.id = id;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.email = email;
        this.phone_Number = phone_Number;
    }

    public Person() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return first_Name;
    }

    public void setFirstName(String firstName) {
        this.first_Name = firstName;
    }

    public String getLastName() {
        return last_Name;
    }

    public void setLastName(String lastName) {
        this.last_Name = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phone_Number;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phone_Number = phoneNumber;
    }
}
