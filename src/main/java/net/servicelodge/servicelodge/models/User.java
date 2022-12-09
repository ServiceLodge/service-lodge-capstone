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
    private String username;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false, length = 10, unique = true)
    private String phone_Number;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @Column(nullable = false)
    boolean is_admin;

    public User(long id, String first_Name, String last_Name, String username, String password, String phone_Number, boolean is_admin) {
        this.id = id;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.username = username;
        this.password = password;
        this.phone_Number = phone_Number;
        this.is_admin = is_admin;
    }

    public User(String first_Name, String last_Name, String username, String password, String phone_Number, Unit unit, boolean is_admin) {
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.username = username;
        this.password = password;
        this.phone_Number = phone_Number;
        this.unit = unit;
        this.is_admin = is_admin;
    }

    public User() {}

    public User(User copy) {
        id = copy.id;
        username = copy.username;
        first_Name = copy.first_Name;
        last_Name = copy.last_Name;
        password = copy.password;
        is_admin = copy.is_admin;
        unit = copy.unit;
        phone_Number = copy.phone_Number;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_Number() {
        return phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
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
