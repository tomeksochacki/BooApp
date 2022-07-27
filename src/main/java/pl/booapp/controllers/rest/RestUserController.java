package pl.booapp.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.booapp.dao.IUserDAO;
import pl.booapp.model.User;

@RestController
@RequestMapping(value = "/api")
public class RestUserController {

    @Autowired
    IUserDAO userDAO;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public User getUserByName(@RequestHeader String userName) {
        return this.userDAO.getUserByName(userName);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<User> addObject() {
        userDAO.addUser(new User(3, "Marek", User.Role.LANDLORD, 2));
        userDAO.addUser(new User(2, "Darek", User.Role.TENANT, 2));
        return ResponseEntity.ok().build();
    }
}
