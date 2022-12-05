package net.servicelodge.servicelodge.models;

import javax.persistence.*;

@Entity
@Table(name="drill")
public class drill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long wing_id;

    @Column (nullable = false, length = 20, unique = true)
    private String name;

    @Column(nullable = false)
    private long drillStartDate;

    @Column(nullable = false)
    private long drillEndDate;

    public drill(long id, long wing_id, String name, long drillStartDate, long drillEndDate) {
        this.id = id;
        this.wing_id = wing_id;
        this.name = name;
        this.drillStartDate = drillStartDate;
        this.drillEndDate = drillEndDate;
    }

    public drill() {

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDrillStartDate() {
        return drillStartDate;
    }

    public void setDrillStartDate(long drillStartDate) {
        this.drillStartDate = drillStartDate;
    }

    public long getDrillEndDate() {
        return drillEndDate;
    }

    public void setDrillEndDate(long drillEndDate) {
        this.drillEndDate = drillEndDate;
    }
}
