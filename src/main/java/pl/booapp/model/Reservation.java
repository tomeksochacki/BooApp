package pl.booapp.model;

import java.util.Date;

public class Reservation {

    private int id;
    private User user;
    private ObjectForRent objectForRent;
    private double price;
    private Date date;
    private int userId;
    private int objectId;

    public Reservation() {
    }

    public Reservation(User user, ObjectForRent objectForRent, double price) {
        this.user = user;
        this.objectForRent = objectForRent;
        this.date = new Date();
        this.price = price + (objectForRent.getUnitPrice() * this.price);
    }

    public Reservation(int reservationId, User user, ObjectForRent objectForRent, double price) {
        this.id = reservationId;
        this.user = user;
        this.objectForRent = objectForRent;
        this.date = new Date();
        this.price = price + (objectForRent.getUnitPrice() * this.price);
    }

    public Reservation(int reservationId, User user, ObjectForRent objectForRent, Date date, double price) {
        this.id = reservationId;
        this.user = user;
        this.objectForRent = objectForRent;
        this.date = date;
        this.price = price + (objectForRent.getUnitPrice() * this.price);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ObjectForRent getObjectForRent() {
        return objectForRent;
    }

    public void setObjectForRent(ObjectForRent objectForRent) {
        this.objectForRent = objectForRent;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", user=" + user +
                ", objectForRent=" + objectForRent +
                ", price=" + price +
                ", date=" + date +
                ", userId=" + userId +
                ", objectId=" + objectId +
                '}';
    }
}
