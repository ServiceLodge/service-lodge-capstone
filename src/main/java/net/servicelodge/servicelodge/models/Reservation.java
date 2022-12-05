package net.servicelodge.servicelodge.models;

import javax.persistence.*;

@Entity
@Table(name="reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long member_id;

    @ManyToOne
    @JoinColumn(name = "drill_id")
    private Drill drill_id;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel_id;

    @Column(nullable = false, length = 200, unique = true)
    private String res_num;

    @Column(nullable = false)
    private String resStartDate;


    @Column(nullable = false)
    private String resEndDate;

    public Reservation(long id, long member_id, Drill drill_id, Hotel hotel_id, String res_num) {
        this.id = id;
        this.member_id = member_id;
        this.drill_id = drill_id;
        this.hotel_id = hotel_id;
        this.res_num = res_num;
    }

    public Reservation() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMember_id() {
        return member_id;
    }

    public void setMember_id(long member_id) {
        this.member_id = member_id;
    }

    public Drill getDrill_id() {
        return drill_id;
    }

    public void setDrill_id(Drill drill_id) {
        this.drill_id = drill_id;
    }

    public Hotel getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Hotel hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getRes_num() {
        return res_num;
    }

    public void setRes_num(String res_num) {
        this.res_num = res_num;
    }
}
