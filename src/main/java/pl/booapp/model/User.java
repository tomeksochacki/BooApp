package pl.booapp.model;

public class User {
    private int id;
    private String name;
    private Role role;
    private int reservationId;

    public User() {
    }

    public User(int id, String name, Role role, int reservationId) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.reservationId = reservationId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public enum Role {
        LANDLORD,
        TENANT;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", reservationId=" + reservationId +
                '}';
    }
}
