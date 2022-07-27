package pl.booapp.model;

public class ObjectForRent {

    private int id;
    private String name;
    private Double unitPrice;
    private Double area;
    private String description;
    private int reservationId;
    private Reservation reservation;

    public ObjectForRent() {
    }

    public ObjectForRent(int id, String name, Double unitPrice, Double area, String description, int reservationId) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.area = area;
        this.description = description;
        this.reservationId = reservationId;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    @Override
    public String toString() {
        return "ObjectForRent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", area=" + area +
                ", description='" + description + '\'' +
                ", reservationId=" + reservationId +
                ", reservation=" + reservation +
                '}';
    }
}
