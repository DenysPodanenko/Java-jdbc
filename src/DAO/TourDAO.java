package DAO;

import Interface.IDAO;
import Model.Hotel;
import Model.Tour;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.sql.*;
import java.util.ArrayList;

public class TourDAO implements IDAO<Tour> {
    public TourDAO() {
        this.connection = "jdbc:sqlserver://DESKTOP-0UH5F0L\\SQLEXPRESS:1433;databaseName=JavaLb3;user=admin;password=admin";
    }

    public TourDAO(String connection) { this.connection = connection; }

    @Override
    public ArrayList<Tour> getObject() {
        ArrayList<Tour> tours = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(connection); Statement stmt = con.createStatement();) {
            String SQL = "SELECT dbo.Tour.id, dbo.Tour.[Name], dbo.Tour.[Description], dbo.Tour.Price, dbo.Tour.Rating,\n" +
                    "\tdbo.Hotel.Id as HotelId, dbo.Hotel.[Name] as HotelName, dbo.Hotel.SpaId, dbo.Hotel.[Address], dbo.Hotel.Telephone\n" +
                    "FROM dbo.Tour\n" +
                    "LEFT JOIN dbo.Hotel ON dbo.Tour.HotelID = dbo.Hotel.Id";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                Tour tour = new Tour(rs.getInt("Id"), rs.getString("Name"), rs.getString("Description"),
                        new Hotel(rs.getInt("HotelId"), rs.getString("HotelName"), rs.getInt("SpaId"),
                                rs.getString("Address"), rs.getString("Telephone")),
                        rs.getInt("Price"), rs.getInt("Rating"));

                tours.add(tour);
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }

        return tours;
    }

    @Override
    public Boolean addObject(Tour tour) {
        Boolean result = false;
        try (Connection con = DriverManager.getConnection(connection); Statement stmt = con.createStatement();) {
            String SQL = String.format("INSERT INTO dbo.Tour VALUES (%d, '%s', '%s', '%d, %d, %d')",
                    tour.getId(), tour.getName(), tour.getDescription(), tour.getHotel().getId(), tour.getPrice(), tour.getRating());
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
