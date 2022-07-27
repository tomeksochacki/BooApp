package pl.booapp.dao;

import pl.booapp.model.Reservation;
import pl.booapp.model.ReservationJoin;

import java.util.List;

public interface IReservationDAO {
    Reservation addReservation(Reservation reservation);
    List<ReservationJoin> getReservationForObjectByObjectName(String objectName);
    List<ReservationJoin> getReservationForUserByUserName(String userName);
    Reservation updateReservation(Reservation reservation);
    List<Reservation> getAllReservationsFromDBForObjectByObjectId(int objectId);
    void setAllReservationsFromDB(List<Reservation> allReservationsFromDB);
    List<Reservation> getAllReservationsFromDB();
}
