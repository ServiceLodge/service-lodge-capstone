package net.servicelodge.servicelodge.models;

import javax.persistence.*;

@Entity
@Table(name="reservation")
public class reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long member_id;

    @Column(nullable = false)
    private long drill_id;

    @Column(nullable = false)
    private String hotel_id;

    @Column(nullable = false, length = 200, unique = true)
    private String res_num;

    @Column(nullable = false)
    private String resStartDate;


    @Column(nullable = false)
    private String resEndDate;

    public reservation(long id, long member_id, long drill_id, String hotel_id, String res_num) {
        this.id = id;
        this.member_id = member_id;
        this.drill_id = drill_id;
        this.hotel_id = hotel_id;
        this.res_num = res_num;
    }

    public reservation() {

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

    public long getDrill_id() {
        return drill_id;
    }

    public void setDrill_id(long drill_id) {
        this.drill_id = drill_id;
    }

    public String getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getRes_num() {
        return res_num;
    }

    public void setRes_num(String res_num) {
        this.res_num = res_num;
    }
}
