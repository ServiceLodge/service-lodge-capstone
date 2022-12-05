package net.servicelodge.servicelodge.models;

import javax.persistence.*;

@Entity
@Table(name="member")
public class member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String person_id;

    @Column(nullable = false)
    private String unit_id;

    @Column(nullable = false, length = 200, unique = true)
    private String username;

    @Column(nullable = false, length = 200)
    private String password;

    public member(long id, String person_id, String unit_id, String username, String password) {
        this.id = id;
        this.person_id = person_id;
        this.unit_id = unit_id;
        this.username = username;
        this.password = password;
    }

    public member() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    public String getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(String unit_id) {
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
