package pl.booapp.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.booapp.dao.IReservationDAO;
import pl.booapp.model.Reservation;
import pl.booapp.model.ReservationJoin;
import pl.booapp.services.IReservationService;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class RestReservationController {

    @Autowired
    IReservationDAO reservationDAO;

    @Autowired
    IReservationService reservationService;

    @RequestMapping(value = "/addReservation", method = RequestMethod.POST)
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation newReservation, @RequestHeader int objectId) {
        if (reservationService.addNewUniqueReservationForObject(newReservation, objectId) == null) {
            return ResponseEntity.status(409).build();
        }
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/editReservation", method = RequestMethod.POST)
    public Reservation editReservation(@RequestBody Reservation reservation) {
        return this.reservationDAO.updateReservation(reservation);
    }

    @RequestMapping(value = "/reservations", method = RequestMethod.GET)
    public List<ReservationJoin> getAllReservationsForUserByUserName(@RequestHeader String userName) {
        return this.reservationDAO.getReservationForUserByUserName(userName);
    }

    @RequestMapping(value = "/reservations", method = RequestMethod.POST)
    public List<ReservationJoin> getReservationForObjectByObjectName(@RequestHeader String objectName) {
        return this.reservationDAO.getReservationForObjectByObjectName(objectName);
    }
}
