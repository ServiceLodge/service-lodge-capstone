package net.servicelodge.servicelodge.models;

import javax.persistence.*;

@Entity
@Table(name="admin")
public class admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String person_id;

    @Column(nullable = false)
    private String wing_id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    public admin(long id, String person_id, String wing_id, String username, String password) {
        this.id = id;
        this.person_id = person_id;
        this.wing_id = wing_id;
        this.username = username;
        this.password = password;
    }

    public admin() {

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

    public String getWing_id() {
        return wing_id;
    }

    public void setWing_id(String wing_id) {
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
