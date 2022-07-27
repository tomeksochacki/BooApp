package pl.booapp.dao.impl;

import org.springframework.stereotype.Repository;
import pl.booapp.dao.IUserDAO;
import pl.booapp.model.User;

@Repository
public class UserDAOStub implements IUserDAO {

    @Override
    public User getUserByName(String name) {
        return null;
    }

    @Override
    public void addUser(User user) {

    }
}
