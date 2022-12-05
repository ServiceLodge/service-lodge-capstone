package net.servicelodge.servicelodge.models;

import javax.persistence.*;

@Entity
@Table(name="wing")
public class Wing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 200, unique = true)
    private String wingName;

    @Column(nullable = false, length = 2)
    private String state;

    public Wing(long id, String wingName, String state) {
        this.id = id;
        this.wingName = wingName;
        this.state = state;
    }

    public Wing() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWingName() {
        return wingName;
    }

    public void setWingName(String wingName) {
        this.wingName = wingName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
