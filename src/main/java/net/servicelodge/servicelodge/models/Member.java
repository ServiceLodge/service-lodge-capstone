package net.servicelodge.servicelodge.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person_id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "member")
    private List<Unit> unit_id;

    @Column(nullable = false, length = 200, unique = true)
    private String username;

    @Column(nullable = false, length = 200)
    private String password;

    public Member(long id, Person person_id, List<Unit> unit_id, String username, String password) {
        this.id = id;
        this.person_id = person_id;
        this.unit_id = unit_id;
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
        return person_id;
    }

    public void setPerson_id(Person person_id) {
        this.person_id = person_id;
    }

    public List<Unit> getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(List<Unit> unit_id) {
        this.unit_id = unit_id;
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
