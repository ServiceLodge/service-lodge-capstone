package net.servicelodge.servicelodge.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="wings")
public class Wing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 200, unique = true)
    private String wingName;

    @Column(nullable = false, length = 2)
    private String state;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wing")
    private List<Drill> drills;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wing")
    private List<Unit> units;

    public Wing(long id, String wingName, String state, List<Drill> drills, List<Unit> units) {
        this.id = id;
        this.wingName = wingName;
        this.state = state;
        this.drills = drills;
        this.units = units;
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

    public List<Drill> getDrills() {
        return drills;
    }

    public void setDrills(List<Drill> drills) {
        this.drills = drills;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }
}
