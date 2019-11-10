package DAO;

import Interface.IDAO;
import Model.Client;
import Model.Order;

import java.sql.*;
import java.util.ArrayList;

public class ClientDAO implements IDAO<Client> {
    public ClientDAO() {
        this.connection = "jdbc:sqlserver://DESKTOP-0UH5F0L\\SQLEXPRESS:1433;databaseName=JavaLb3;user=admin;password=admin";
    }

    ClientDAO(String connection) { this.connection = connection; }

    @Override
    public ArrayList<Client> getObject() {
        ArrayList<Client> clients = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(connection); Statement stmt = con.createStatement();) {
            String SQL = "SELECT * FROM dbo.Client";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                Client client = new Client(rs.getInt("Id"), rs.getString("FirstName"),
                        rs.getString("SecondName"), rs.getString("Address"), rs.getString("Telephone"),
                        rs.getString("Email"), rs.getInt("Age"));

                clients.add(client);
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }

    @Override
    public Boolean addObject(Client client) {
        Boolean result = false;
        try (Connection con = DriverManager.getConnection(connection); Statement stmt = con.createStatement();) {
            String SQL = String.format("INSERT INTO dbo.Client VALUES (%d, '%s', '%s', '%s', '%s', '%s', %d)",
                    client.getId(), client.getFirstName(), client.getSecondName(), client.getAddress(), client.getTelephone(),
                    client.getEmail(), client.getAge());
            result = stmt.execute(SQL);
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public ArrayList<Order> getClientOrders(Client client) {
        ArrayList<Order> orders = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(connection); Statement stmt = con.createStatement();) {
            String SQL = "SELECT  dbo.[Order].Id, dbo.[Order].[Date], dbo.[Order].ClientID, dbo.[Order].TourID\n" +
                    "FROM dbo.[Order]\n" +
                    "LEFT JOIN dbo.Client ON dbo.[Order].ClientID = dbo.Client.Id\n" +
                    "WHERE dbo.[Order].ClientID = " + client.getId().toString();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                Order order = new Order(rs.getInt("Id"), rs.getString("Date"),
                        rs.getInt("ClientID"), rs.getInt("TourID"));

                orders.add(order);
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    private String connection;
}
