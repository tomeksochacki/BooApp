package pl.booapp.dao.impl;

import org.springframework.stereotype.Repository;
import pl.booapp.dao.IReservationDAO;
import pl.booapp.model.ObjectForRent;
import pl.booapp.model.Reservation;
import pl.booapp.model.ReservationJoin;
import pl.booapp.model.User;

import java.util.*;

@Repository
public class ReservationDAOStub implements IReservationDAO {
    public void setAllReservationsFromDB(List<Reservation> allReservationsFromDB) {
        this.allReservationsFromDB = allReservationsFromDB;
    }

    public List<Reservation> allReservationsFromDB = new ArrayList<>();

    public List<Reservation> getAllReservationsFromDB() {
        return allReservationsFromDB;
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        this.allReservationsFromDB.add(reservation);
        return reservation;
    }

    @Override
    public List<ReservationJoin> getReservationForObjectByObjectName(String objectName) {
        return null;
    }

    @Override
    public List<ReservationJoin> getReservationForUserByUserName(String userName) {
        return null;
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return null;
    }

    @Override
    public List<Reservation> getAllReservationsFromDBForObjectByObjectId(int objectId) {
        User user = new User(1, "Tomek", User.Role.LANDLORD, 0);
        Calendar myCalendar = new GregorianCalendar(2014, 02, 11);
        Date myDate = myCalendar.getTime();
        ObjectForRent objectForRent = new ObjectForRent(1, "Mieszkanie", 50.00, 120.00, "Super mieszkanie", 1);
        Reservation reservationInDB = new Reservation(0, user, objectForRent, myDate, 100.00);
        this.allReservationsFromDB.add(reservationInDB);
        return allReservationsFromDB;
    }
}
