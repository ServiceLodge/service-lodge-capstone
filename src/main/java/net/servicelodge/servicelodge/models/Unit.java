package net.servicelodge.servicelodge.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="units")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 200, unique = true)
    private String unitName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unit")
    private List<Member> members;

    @ManyToOne
    @JoinColumn(name = "wing_id")
    private Wing wing;

    public Unit(long id, String unitName, List<Member> members) {
        this.id = id;
        this.unitName = unitName;
        this.members = members;

    }

    public Unit() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Wing getWing() {
        return wing;
    }

    public void setWing(Wing wing) {
        this.wing = wing;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}