package net.servicelodge.servicelodge.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Person person;

    @OneToOne
    private Wing wing;

    @Column(nullable = false, length = 200, unique = true)
    private String username;

    @Column(nullable = false, length = 200)
    private String password;

    public Admin(long id, Person person, Wing wing, String username, String password) {
        this.id = id;
        this.person = person;
        this.wing = wing;
        this.username = username;
        this.password = password;
    }

    public Admin() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Person getPerson_id() {
        return person;
    }

    public void setPerson_id(Person person_id) {
        this.person = person_id;
    }

    public Wing getWing_id() {
        return wing;
    }

    public void setWing_id(Wing wing) {
        this.wing = wing;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
