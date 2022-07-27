package pl.booapp.services;

import pl.booapp.model.Reservation;

public interface IReservationService {
    Reservation addNewUniqueReservationForObject(Reservation newReservation, int objectId);
}
