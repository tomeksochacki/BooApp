package pl.booapp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.booapp.dao.IReservationDAO;
import pl.booapp.model.Reservation;
import pl.booapp.services.IReservationService;

import java.util.List;

@Service
public class ReservationService implements IReservationService {

    @Autowired
    IReservationDAO reservationDAO;

    public Reservation addNewUniqueReservationForObject(Reservation newReservation, int objectId) {
        List<Reservation> allReservationsFromDB = this.reservationDAO.getAllReservationsFromDBForObjectByObjectId(objectId);
        for (Reservation reservation : allReservationsFromDB) {
            java.util.Date utilDateFromDB = reservation.getDate();
            java.sql.Date sqlDateFromDB = new java.sql.Date(utilDateFromDB.getTime());
            String dateFromDb = sqlDateFromDB.toString();

            java.util.Date utilDateFromNewReservation = newReservation.getDate();
            java.sql.Date sqlDateFromNewReservation = new java.sql.Date(utilDateFromNewReservation.getTime());
            String dateFromNewReservation = sqlDateFromNewReservation.toString();

            if (dateFromDb.equals(dateFromNewReservation)) {
                return null;
            }

        }
        return this.reservationDAO.addReservation(newReservation);
    }

    private String convertDate(String dateAsString) {
        String[] splitDateName = dateAsString.split(" ");
        String requiredReservationDateFormat = splitDateName[5] + "-";
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for (int i = 0; i <= months.length - 1; i++) {
            if (splitDateName[1].equals(months[i])) {
                int monthCorrection = i + 1;
                if (monthCorrection >= 10) {
                    requiredReservationDateFormat = requiredReservationDateFormat + monthCorrection;
                    break;
                } else {
                    requiredReservationDateFormat = requiredReservationDateFormat + 0 + monthCorrection;
                    break;
                }
            }
        }
        return requiredReservationDateFormat = requiredReservationDateFormat + "-" + splitDateName[2];
    }
}
