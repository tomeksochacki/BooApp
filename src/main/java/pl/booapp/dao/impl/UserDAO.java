package pl.booapp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.booapp.dao.IUserDAO;
import pl.booapp.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO implements IUserDAO {

    @Autowired
    Connection connection;

    public User getUserByName(String name) {
        try {
            String sql = "SELECT * FROM tuser WHERE name = ?";

            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, name);

            ResultSet rs = preparedStatement.executeQuery();
            if (!rs.next()) {
                return null;
            }

            return mapUser(rs);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    private int id;
    private String name;
    private User.Role role;
    private int reservationId;

    public void addUser(User user) {
        try {
            String sql = "INSERT INTO tuser (name, role, reservation_id) VALUES (?, ?, ?)";

            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getRole().toString());
            preparedStatement.setInt(3, user.getReservationId());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private User mapUser(ResultSet rs) {
        List<User> result = new ArrayList<>();
        try {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setRole(User.Role.valueOf(rs.getString("role")));
            user.setReservationId(rs.getInt("reservation_id"));

            result.add(user);

            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
