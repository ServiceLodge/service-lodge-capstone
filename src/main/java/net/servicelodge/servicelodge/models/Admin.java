package net.servicelodge.servicelodge.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "admin")
    private Person person_id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "admin")
    private List<Wing> wing_id;

    @Column(nullable = false, length = 200, unique = true)
    private String username;

    @Column(nullable = false, length = 200)
    private String password;

    public Admin(long id, Person person_id, List<Wing> wing_id, String username, String password) {
        this.id = id;
        this.person_id = person_id;
        this.wing_id = wing_id;
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
        return person_id;
    }

    public void setPerson_id(Person person_id) {
        this.person_id = person_id;
    }

    public List<Wing> getWing_id() {
        return wing_id;
    }

    public void setWing_id(List<Wing> wing_id) {
        this.wing_id = wing_id;
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
