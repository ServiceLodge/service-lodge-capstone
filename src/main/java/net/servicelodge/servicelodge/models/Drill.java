package net.servicelodge.servicelodge.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="drills")
public class Drill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "wing_id")
    private Wing wing;

    @Column (nullable = false, length = 20, unique = true)
    private String name;

    @Column(nullable = false)
    private Date drillStartDate;

    @Column(nullable = false)
    private Date drillEndDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "drill")
    private List<Reservation> reservations;

    public Drill(long id, String name, Date drillStartDate, Date drillEndDate, List <Reservation> reservations) {
        this.id = id;
        this.name = name;
        this.drillStartDate = drillStartDate;
        this.drillEndDate = drillEndDate;
        this.reservations = reservations;
    }

    public Drill() {

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDrillStartDate() {
        return drillStartDate;
    }

    public void setDrillStartDate(Date drillStartDate) {
        this.drillStartDate = drillStartDate;
    }

    public Date getDrillEndDate() {
        return drillEndDate;
    }

    public void setDrillEndDate(Date drillEndDate) {
        this.drillEndDate = drillEndDate;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
