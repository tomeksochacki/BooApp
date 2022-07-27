package pl.booapp.dao;

import pl.booapp.model.User;

public interface IUserDAO {
    User getUserByName(String name);
    void addUser(User user);
}
