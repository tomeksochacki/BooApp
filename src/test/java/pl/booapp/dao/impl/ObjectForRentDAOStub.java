package pl.booapp.dao.impl;

import org.springframework.stereotype.Repository;
import pl.booapp.dao.IObjectForRentDAO;
import pl.booapp.model.ObjectForRent;

import java.util.List;

@Repository
public class ObjectForRentDAOStub implements IObjectForRentDAO {
    @Override
    public List<ObjectForRent> getAllObjectsForRent() {
        return null;
    }

    @Override
    public void addObject(ObjectForRent objectForRent) {

    }

    @Override
    public ObjectForRent findObjectByObjectName(String name) {
        return null;
    }
}
