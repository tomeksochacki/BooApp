package pl.booapp.dao;

import pl.booapp.model.ObjectForRent;

import java.util.List;

public interface IObjectForRentDAO {
    List<ObjectForRent> getAllObjectsForRent();
    void addObject(ObjectForRent objectForRent);
    ObjectForRent findObjectByObjectName(String name);
}
