package pl.booapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.booapp.dao.impl.ObjectForRentDAOStub;
import pl.booapp.dao.impl.ReservationDAOStub;
import pl.booapp.dao.impl.UserDAOStub;

@Configuration
@ComponentScan(basePackages = {
        "pl.booapp.controllers",
        "pl.booapp.services"
})
public class TestConfiguration {

    @Bean
    public ObjectForRentDAOStub objectForRentDAOStub() {
        return new ObjectForRentDAOStub();
    }

    @Bean
    public ReservationDAOStub reservationDAOStub() {
        return new ReservationDAOStub();
    }

    @Bean
    public UserDAOStub userDAOStub() {
        return new UserDAOStub();
    }
}


