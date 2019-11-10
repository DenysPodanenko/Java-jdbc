package DAO;

import Interface.IDAO;
import Model.Hotel;

import java.sql.*;
import java.util.ArrayList;

public class HotelDAO implements IDAO<Hotel> {
    public HotelDAO() {
        this.connection = "jdbc:sqlserver://DESKTOP-0UH5F0L\\SQLEXPRESS:1433;databaseName=JavaLb3;user=admin;password=admin";
    }

    public HotelDAO(String connection) { this.connection = connection; }

    @Override
    public ArrayList<Hotel> getObject() {
        ArrayList<Hotel> hotels = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(connection); Statement stmt = con.createStatement();) {
            String SQL = "SELECT * FROM dbo.Hotel";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                Hotel hotel = new Hotel(rs.getInt("Id"), rs.getString("Name"), rs.getInt("SpaId"),
                        rs.getString("Address"), rs.getString("Telephone"));

                hotels.add(hotel);
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }

        return hotels;
    }

    @Override
    public Boolean addObject(Hotel hotel) {
        Boolean result = false;
        try (Connection con = DriverManager.getConnection(connection); Statement stmt = con.createStatement();) {
            String SQL = String.format("INSERT INTO dbo.Hotel VALUES (%d, '%s', '%d', '%s', '%s')",
                    hotel.getId(), hotel.getName(), hotel.getSpaId(), hotel.getAddress(), hotel.getTelephone());
            result = stmt.execute(SQL);
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    private String connection;
}
