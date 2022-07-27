package pl.booapp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.booapp.dao.IReservationDAO;
import pl.booapp.model.Reservation;
import pl.booapp.model.ReservationJoin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReservationDAO implements IReservationDAO {

    @Autowired
    Connection connection;

    public Reservation addReservation(Reservation reservation) {
        try {
            String sql = "INSERT INTO treservation (price, date, user_id, object_id) VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setDouble(1, reservation.getPrice());
            preparedStatement.setDate(2, new java.sql.Date(reservation.getDate().getTime()));
            preparedStatement.setInt(3, reservation.getUser().getId());
            preparedStatement.setInt(4, reservation.getObjectForRent().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reservation;
    }

    public List<ReservationJoin> getReservationForObjectByObjectName(String objectName) {
        List<ReservationJoin> result = new ArrayList<>();
        try {
            String sql = "SELECT tobject.name, treservation.id, treservation.price, treservation.date FROM tobject, treservation WHERE tobject.id = treservation.object_id AND tobject.name = ?";

            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

            preparedStatement.setString(1, objectName);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ReservationJoin reservationJoin = new ReservationJoin();
                reservationJoin.setName(rs.getString("tobject.name"));
                reservationJoin.setId(rs.getInt("treservation.id"));
                reservationJoin.setPrice(rs.getDouble("treservation.price"));
                reservationJoin.setDate(rs.getDate("treservation.date"));

                result.add(reservationJoin);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }

    public List<ReservationJoin> getReservationForUserByUserName(String userName) {
        List<ReservationJoin> result = new ArrayList<>();
        try {
            String sql = "SELECT tuser.name, treservation.id, treservation.price, treservation.date FROM treservation, tuser WHERE tuser.id = treservation.user_id AND tuser.name = ?";

            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

            preparedStatement.setString(1, userName);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ReservationJoin reservationJoin = new ReservationJoin();
                reservationJoin.setName(rs.getString("tuser.name"));
                reservationJoin.setId(rs.getInt("treservation.id"));
                reservationJoin.setPrice(rs.getDouble("treservation.price"));
                reservationJoin.setDate(rs.getDate("treservation.date"));

                result.add(reservationJoin);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }

    public Reservation updateReservation(Reservation reservation) {
        try {
            String sql = "UPDATE treservation SET price = ?, date = ? WHERE id = ?";
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

            preparedStatement.setDouble(1, reservation.getPrice());
            preparedStatement.setDate(2, new java.sql.Date(reservation.getDate().getTime()));
            preparedStatement.setInt(3, reservation.getId());


            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reservation;
    }

    public List<Reservation> getAllReservationsFromDBForObjectByObjectId(int objectId) {
        List<Reservation> result = new ArrayList<>();
        try {
            String sql = "SELECT * FROM treservation WHERE treservation.object_id = ?";

            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, objectId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                Reservation reservation = new Reservation();
                reservation.setId(rs.getInt("treservation.id"));
                reservation.setPrice(rs.getDouble("treservation.price"));
                reservation.setDate(rs.getDate("treservation.date"));
                reservation.setUserId(rs.getInt("treservation.user_id"));
                reservation.setObjectId(rs.getInt("treservation.object_id"));

                result.add(reservation);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;

    }

    @Override
    public void setAllReservationsFromDB(List<Reservation> allReservationsFromDB) {

    }

    @Override
    public List<Reservation> getAllReservationsFromDB() {
        return null;
    }
}
