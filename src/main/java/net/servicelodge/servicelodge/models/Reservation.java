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
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "drill_id")
    private Drill drill;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @Column(nullable = false, length = 100)
    private String resNum;

    public Reservation(long id, User user, Drill drill, Hotel hotel, String resNum) {
        this.id = id;
        this.user = user;
        this.drill = drill;
        this.hotel = hotel;
        this.resNum = resNum;
    }

    public Reservation() {}

    public Reservation(Reservation copy) {
        id = copy.id;
        user = copy.user;
        drill = copy.drill;
        hotel = copy.hotel;
        resNum = copy.resNum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getResNum() {
        return resNum;
    }

    public void setResNum(String resNum) {
        this.resNum = resNum;
    }
}
