package net.servicelodge.servicelodge.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="hotels")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 255, unique = true)
    private String name;

    @Column(nullable = false, length = 100, unique = true)
    private String address;

    @Column(nullable = false, length = 100)
    private String city;

    @Column(nullable = false, length = 2)
    private String state;

    @Column(nullable = false, length = 7)
    private int zip;

    @Column(nullable = false, length = 20, unique = true)
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel")
    private List<Reservation> reservations;

    public Hotel(long id, String name, String address, String city, String state, int zip, String phoneNumber, List<Reservation> reservations) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.reservations = reservations;
    }

    public Hotel() {

    }

    public Hotel(Hotel copy) {
        id = copy.id;
        name = copy.name;
        address = copy.address;
        city = copy.city;
        state = copy.state;
        zip = copy.zip;
        phoneNumber = copy.phoneNumber;
        reservations = copy.reservations;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public String getFullAddress(){
        return this.getAddress() + ", " + this.getCity() + ", " + this.getState() + " " + this.getZip();
    }
}
