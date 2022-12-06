package net.servicelodge.servicelodge.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "drill_id")
    private Drill drill;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @Column(nullable = false, length = 200)
    private String res_num;

    @Column(nullable = false)
    private Date resStartDate;


    @Column(nullable = false)
    private Date resEndDate;

    public Reservation(long id, Date resStartDate, Date resEndDate, String res_num) {
        this.id = id;
        this.res_num = res_num;
        this.resStartDate = resStartDate;
        this.resEndDate = resEndDate;
    }

    public Reservation() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Drill getDrill() {
        return drill;
    }

    public void setDrill(Drill drill) {
        this.drill = drill;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getRes_num() {
        return res_num;
    }

    public void setRes_num(String res_num) {
        this.res_num = res_num;
    }
}
