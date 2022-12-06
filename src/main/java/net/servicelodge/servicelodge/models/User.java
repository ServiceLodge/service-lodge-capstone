package net.servicelodge.servicelodge.models;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 200)
    private String first_Name;

    @Column(nullable = false, length = 200)
    private String last_Name;

    @Column(nullable = false, length = 200, unique = true)
    private String email;

    @Column(nullable = false, length = 8)
    private String password;

    @Column(nullable = false, length = 10, unique = true)
    private int phone_Number;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @Column(nullable = false)
    boolean is_admin;

    public User(long id, String first_Name, String last_Name, String email, String password, int phone_Number, boolean is_admin) {
        this.id = id;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.email = email;
        this.password = password;
        this.phone_Number = phone_Number;
        this.is_admin = is_admin;
    }

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone_Number() {
        return phone_Number;
    }

    public void setPhone_Number(int phone_Number) {
        this.phone_Number = phone_Number;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }
}
