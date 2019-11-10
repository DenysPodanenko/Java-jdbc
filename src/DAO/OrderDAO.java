package DAO;

import Interface.IDAO;
import Model.Client;
import Model.Order;
import Model.Tour;

import java.sql.*;
import java.util.ArrayList;

public class OrderDAO implements IDAO<Order> {
    public OrderDAO() {
        this.connection = "jdbc:sqlserver://DESKTOP-0UH5F0L\\SQLEXPRESS:1433;databaseName=JavaLb3;user=admin;password=admin";
    }

    public OrderDAO(String connection) { this.connection = connection; }

    @Override
    public ArrayList<Order> getObject() {
        ArrayList<Order> orders = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(connection); Statement stmt = con.createStatement();) {
            String SQL = "SELECT  dbo.[Order].Id, dbo.[Order].[Date],\n" +
                    "\tdbo.Client.Id as ClientId, dbo.Client.FirstName, dbo.Client.SecondName, dbo.Client.[Address], dbo.Client.Telephone, dbo.Client.Age,\n" +
                    "\tdbo.Tour.id as TourId, dbo.Tour.[Name], dbo.Tour.[Description], dbo.Tour.HotelID, dbo.Tour.Price, dbo.Tour.Rating\n" +
                    "FROM dbo.[Order]\n" +
                    "LEFT JOIN dbo.Client ON dbo.[Order].ClientID = dbo.Client.Id\n" +
                    "LEFT JOIN dbo.Tour on dbo.[Order].TourID = dbo.Tour.id";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                Order order = new Order(rs.getInt("Id"), rs.getString("Date"),
                        new Client(rs.getInt("ClientId"), rs.getString("FirstName"), rs.getString("SecondName"),
                                rs.getString("Address"), rs.getString("Telephone"), rs.getString("Email"),
                                rs.getInt("Age")),
                        new Tour(rs.getInt("TourId"), rs.getString("Name"), rs.getString("Description"),
                                rs.getInt("HotelID"), rs.getInt("Price"), rs.getInt("Rating")));

                orders.add(order);
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    @Override
    public Boolean addObject(Order order) {
        Boolean result = false;
        try (Connection con = DriverManager.getConnection(connection); Statement stmt = con.createStatement();) {
            String SQL = String.format("INSERT INTO dbo.Order VALUES (%d, '%s', '%d', '%d')",
                    order.getId(), order.getDate(), order.getClient().getId(), order.getTour().getId());
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
