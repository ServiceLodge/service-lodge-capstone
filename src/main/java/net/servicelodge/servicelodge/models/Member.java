package net.servicelodge.servicelodge.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @Column(nullable = false, length = 200, unique = true)
    private String username;

    @Column(nullable = false, length = 200)
    private String password;

    public Member(long id, Person person, Unit unit, String username, String password) {
        this.id = id;
        this.person = person;
        this.unit = unit;
        this.username = username;
        this.password = password;
    }

    public Member() {

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
        this.person = person;
    }

    public Unit getUnit_id() {
        return unit;
    }

    public void setUnit_id(Unit unit) {
        this.unit = unit;
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
