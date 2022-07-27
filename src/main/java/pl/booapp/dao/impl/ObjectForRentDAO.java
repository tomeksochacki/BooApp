package pl.booapp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.booapp.dao.IObjectForRentDAO;
import pl.booapp.model.ObjectForRent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ObjectForRentDAO implements IObjectForRentDAO {

    @Autowired
    Connection connection;

    public List<ObjectForRent> getAllObjectsForRent() {
        List<ObjectForRent> result = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tobject";

            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                result.add(mapObject(rs));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public void addObject(ObjectForRent objectForRent) {
        try {
            String sql = "INSERT INTO tobject (name, unitprice, area, description, reservation_id) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, objectForRent.getName());
            preparedStatement.setDouble(2, objectForRent.getUnitPrice());
            preparedStatement.setDouble(3, objectForRent.getArea());
            preparedStatement.setString(4, objectForRent.getDescription());
            preparedStatement.setInt(5, objectForRent.getReservationId());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ObjectForRent findObjectByObjectName(String name) {
        try {
            String sql = "SELECT * FROM tobject WHERE name = ?";

            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();

            if (!rs.next()) {
                return null;
            }

            return mapObject(rs);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    private ObjectForRent mapObject(ResultSet rs) {
        List<ObjectForRent> result = new ArrayList<>();
        try {
            ObjectForRent objectForRent = new ObjectForRent();
            objectForRent.setId(rs.getInt("id"));
            objectForRent.setName(rs.getString("name"));
            objectForRent.setUnitPrice(rs.getDouble("unitprice"));
            objectForRent.setArea(rs.getDouble("area"));
            objectForRent.setDescription(rs.getString("description"));
            objectForRent.setReservationId(rs.getInt("reservation_id"));

            result.add(objectForRent);

            return objectForRent;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}