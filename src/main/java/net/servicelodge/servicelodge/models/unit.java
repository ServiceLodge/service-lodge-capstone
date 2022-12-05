package net.servicelodge.servicelodge.models;

import javax.persistence.*;

@Entity
@Table(name="unit")
public class unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long wing_id;

    @Column(nullable = false, length = 200, unique = true)
    private String unitName;

    public unit(long id, long wing_id, String unitName) {
        this.id = id;
        this.wing_id = wing_id;
        this.unitName = unitName;
    }

    public unit() {

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