package net.servicelodge.servicelodge.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="units")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long wing_id;

    @Column(nullable = false, length = 200, unique = true)
    private String unitName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unit")
    private List<Member> members;

    public Unit(long id, long wing_id, String unitName) {
        this.id = id;
        this.wing_id = wing_id;
        this.unitName = unitName;
    }

    public Unit() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getWing_id() {
        return wing_id;
    }

    public void setWing_id(long wing_id) {
        this.wing_id = wing_id;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}