import java.sql.*;
import java.util.ArrayList;

public class DAO {
    DAO() {
        connection = "jdbc:sqlserver://DESKTOP-0UH5F0L\\SQLEXPRESS:1433;databaseName=JavaLb3;user=admin;password=admin";
    }
    DAO(String connection) {
        this.connection = connection;
    }

    public ArrayList<Client> getClients() {
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

    public ArrayList<Order> getOrders() {
        ArrayList<Order> orders = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(connection); Statement stmt = con.createStatement();) {
            String SQL = "SELECT * FROM dbo.[Order]";
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

    public ArrayList<Tour> getTours() {
        ArrayList<Tour> tours = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(connection); Statement stmt = con.createStatement();) {
            String SQL = "SELECT * FROM dbo.Tour";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                Tour tour = new Tour(rs.getInt("Id"), rs.getString("Name"), rs.getString("Description"),
                        rs.getInt("HotelID"), rs.getInt("Price"), rs.getInt("Rating"));

                tours.add(tour);
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }

        return tours;
    }

    public ArrayList<Hotel> getHotels() {
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

    public Boolean addClient(Client client) {
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

    private String connection;
}
