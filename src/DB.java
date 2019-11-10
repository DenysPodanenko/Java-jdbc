//import Model.Client;
//import Model.Hotel;
//import Model.Order;
//import Model.Tour;
//
//import java.util.AbstractMap;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//public class DB {
//    DB() {
//        this.clients = new ArrayList<>();
//        this.orders = new ArrayList<>();
//        this.tours = new ArrayList<>();
//        this.hotels = new ArrayList<>();
//        this.dao = new DAO();
//    }
//
//    public void UpdateBase() {
//        this.clients = dao.getClients();
//        this.orders = dao.getOrders();
//        this.tours = dao.getTours();
//        this.hotels = dao.getHotels();
//    }
//
//    public ArrayList<Client> getClients() { return this.clients; }
//    public ArrayList<Order> getOrders() { return this.orders; }
//    public ArrayList<Tour> getTours() { return this.tours; }
//    public ArrayList<Hotel> getHotels() { return this.hotels; }
//
//    public Client getClientById(Integer clientId) {
//        for(Client client : clients) {
//            if(client.getId().equals(clientId)) {
//                return client;
//            }
//        }
//
//        return null;
//    }
//
//    public Map.Entry<String, String> getClientName(Integer clientId) {
//        for(Client client : clients) {
//            if(client.getId().equals(clientId)) {
//                return new AbstractMap.SimpleEntry<String, String>(client.getFirstName(), client.getSecondName());
//            }
//        }
//
//        return new AbstractMap.SimpleEntry<String, String>("FName was not found", "SName was not found");
//    }
//
//    public HashMap<Map.Entry<String, String>, String> getClientTelephones() {
//        HashMap<Map.Entry<String, String>, String> clientTelephones = new HashMap<>();
//
//        for(Client client : clients) {
//            clientTelephones.put(new AbstractMap.SimpleEntry<String, String>(client.getFirstName(), client.getSecondName()), client.getTelephone());
//        }
//
//        return clientTelephones;
//    }
//
//    public ArrayList<Order> getClientOrders(Client client) {
//        ArrayList<Order> clientOrders = new ArrayList<>();
//
//        for(Order order: orders) {
//            if(order.getClientId().equals(client.getId())) {
//                clientOrders.add(order);
//            }
//        }
//
//        return clientOrders;
//    }
//
//    public ArrayList<Order> getTourOrders(Tour tour) {
//        ArrayList<Order> tourOrders = new ArrayList<>();
//
//        for(Order order : orders) {
//            if(order.getTourId().equals(tour.getId())) {
//                tourOrders.add(order);
//            }
//        }
//
//        return tourOrders;
//    }
//
//    public Tour getTourById(Integer tourId) {
//        for(Tour tour : tours) {
//            if(tour.getId().equals(tourId)) {
//                return tour;
//            }
//        }
//
//        return null;
//    }
//
//    public String getTourName(Integer tourId) {
//        for(Tour tour : tours) {
//            if(tour.getId().equals(tourId)) {
//                return tour.getName();
//            }
//        }
//
//        return "Model.Tour was not found";
//    }
//
//    public HashMap<String, Integer> getTourPrices() {
//        HashMap<String,Integer> toursPrice = new HashMap<>();
//
//        for(Tour tour : tours) {
//            toursPrice.put(tour.getName(), tour.getPrice());
//        }
//
//        return toursPrice;
//    }
//
//    public ArrayList<Tour> getToursForHotel(Hotel hotel) {
//        ArrayList<Tour> toursForHotel = new ArrayList<>();
//
//        for(Tour tour : tours) {
//            if(tour.getHotelId().equals(hotel.getId())) {
//                toursForHotel.add(tour);
//            }
//        }
//
//        return toursForHotel;
//    }
//
//    public Boolean addClient(Client client) {
//        boolean result = dao.addClient(client);
//        if(result) { this.UpdateBase(); }
//
//        return result;
//    }
//
//    public Hotel getHotelById(Integer hotelId) {
//        for(Hotel hotel: hotels) {
//            if(hotel.getId().equals(hotelId)) {
//                return hotel;
//            }
//        }
//
//        return null;
//    }
//
//    public String getHotelName(Integer hotelId) {
//        for(Hotel hotel : hotels) {
//            if(hotel.getId().equals(hotelId)) {
//                return hotel.getName();
//            }
//        }
//
//        return "Hotel was not found";
//    }
//
//    private ArrayList<Client> clients;
//    private ArrayList<Order> orders;
//    private ArrayList<Tour> tours;
//    private ArrayList<Hotel> hotels;
//
//    private DAO dao;
//}
