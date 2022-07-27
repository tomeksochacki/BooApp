package pl.booapp.services.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.booapp.configuration.TestConfiguration;
import pl.booapp.dao.IReservationDAO;
import pl.booapp.model.ObjectForRent;
import pl.booapp.model.Reservation;
import pl.booapp.model.User;
import pl.booapp.services.IReservationService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {TestConfiguration.class})
public class ReservationServiceTest {

    @Autowired
    IReservationService reservationService;

    @Autowired
    IReservationDAO reservationDAO;

    @Test
    public void addUniqueReservationForObjectTest() {
        User user = new User(1, "Tomek", User.Role.LANDLORD, 0);
        ObjectForRent objectForRent = new ObjectForRent(1, "Mieszkanie", 50.00, 120.00, "Super mieszkanie", 1);
        int objectId = 1;
        Calendar myCalendar = new GregorianCalendar(2015, 02, 11);
        Date myDate = myCalendar.getTime();
        Reservation newReservation = new Reservation(0, user, objectForRent, myDate, 400.00);

        this.reservationService.addNewUniqueReservationForObject(newReservation, objectId);

        int expectedReservationCount = 2;
        Assert.assertEquals(expectedReservationCount, this.reservationDAO.getAllReservationsFromDB().size());
        this.reservationDAO.setAllReservationsFromDB(new ArrayList<Reservation>());
    }

    @Test
    public void addNoUniqueReservationForObjectTest() {
        User user = new User(1, "Tomek", User.Role.LANDLORD, 0);
        ObjectForRent objectForRent = new ObjectForRent(1, "Mieszkanie", 50.00, 120.00, "Super mieszkanie", 1);
        int objectId = 1;
        Calendar myCalendar = new GregorianCalendar(2014, 02, 11);
        Date myDate = myCalendar.getTime();
        Reservation newReservation = new Reservation(0, user, objectForRent, myDate, 400.00);

        this.reservationService.addNewUniqueReservationForObject(newReservation, objectId);

        int expectedReservationCount = 1;
        Assert.assertEquals(expectedReservationCount, this.reservationDAO.getAllReservationsFromDB().size());
        this.reservationDAO.setAllReservationsFromDB(new ArrayList<Reservation>());
    }
}
