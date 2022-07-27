package pl.booapp.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.booapp.dao.IObjectForRentDAO;
import pl.booapp.model.ObjectForRent;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class RestObjectForRentController {

    @Autowired
    IObjectForRentDAO objectForRentDAO;

    @RequestMapping(value = "/objects", method = RequestMethod.GET)
    public List<ObjectForRent> getAllObjectForRent() {
        return this.objectForRentDAO.getAllObjectsForRent();
    }

    @RequestMapping(value = "/objects", method = RequestMethod.POST)
    public ResponseEntity<ObjectForRent> addObject() {
        objectForRentDAO.addObject(new ObjectForRent(1, "Dom", 8000.00, 170.00, "W dobrym stanie dom.", 1));
        objectForRentDAO.addObject(new ObjectForRent(2, "Mieszkanie", 3500.00, 56.00, "Nowe mieszkanie trzy pokojowe mieszkanie, do wynajaecia.", 2));
        return ResponseEntity.ok().build();
    }
}
