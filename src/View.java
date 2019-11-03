import com.sun.org.apache.xpath.internal.operations.Or;
import org.omg.CORBA.INTERNAL;

import java.util.Map;

public class View {
    View(DB db) {
        this.db = db;
        db.UpdateBase();
    }

    public void getClients() {
        System.out.println("\n----CLIENTS----");
        for(Client client : db.getClients()) {
            System.out.println(String.format("id:%d; First Name:%s; Second Name:%s; Address:%s; Telephone:%s; E-mail:%s; Age:%d;",
                    client.getId(), client.getFirstName(), client.getSecondName(), client.getAddress(), client.getTelephone(),
                    client.getEmail(), client.getAge()));
        }
        System.out.println("------END------\n");
    }

    public void getOrders() {
        System.out.println("\n---ORDERS----");
        for(Order order : db.getOrders()) {
            System.out.println(String.format("id:%d; Date:%s; Client:%s %s; Tour:%s",
                    order.getId(), order.getDate(), db.getClientName(order.getClientId()).getKey(),
                    db.getClientName(order.getClientId()).getValue(), db.getTourName(order.getTourId())));
        }
        System.out.println("------END------\n");
    }

    public void getTours() {
        System.out.println("\n----TOURS----");
        for(Tour tour: db.getTours()) {
            System.out.println(String.format("id:%s, Name:%s; Description:%s; Hotel:%s; Price:%d; Rating:%d",
                    tour.getId(), tour.getName(), tour.getDescription(), db.getHotelName(tour.getHotelId()),
                    tour.getPrice(), tour.getRating()));
        }
        System.out.println("------END------\n");
    }

    public void getHotels() {
        System.out.println("\n----HOTELS----");
        for(Hotel hotel : db.getHotels()) {
            System.out.println(String.format("id:%d; Name:%s; Spa:%d; Address:%s; Telephone:%s",
                    hotel.getId(), hotel.getName(), hotel.getSpaId(), hotel.getAddress(), hotel.getTelephone()));
        }
        System.out.println("------END------\n");
    }

    public void getClientTelephones() {
        System.out.println("\n----TELEPHONE NUMBERS----");
        for(Map.Entry<Map.Entry<String, String>, String> clientTelephone : db.getClientTelephones().entrySet()) {
            System.out.println(String.format("First Name:%s; Second Name:%s; Telephone:%s;",
                    clientTelephone.getKey().getKey(), clientTelephone.getKey().getValue(), clientTelephone.getValue()));
        }
        System.out.println("------END------\n");
    }

    public void getClientOrders(Integer clientId) {
        System.out.println(String.format("\n----%s %s Orders----", db.getClientById(clientId).getFirstName(), db.getClientById(clientId).getSecondName()));
        for (Order order : db.getClientOrders(db.getClientById(clientId))) {
            System.out.println(String.format("id:%d; Date:%s; Tour:%s;",
                    order.getId(), order.getDate(), db.getTourName(order.getTourId())));
        }
        System.out.println("------END------\n");
    }

    public void getTourOrders(Integer tourId) {
        System.out.println(String.format("\n----%s Orders----", db.getTourName(tourId)));
        for(Order order : db.getTourOrders(db.getTourById(tourId))) {
            System.out.println(String.format("id:%d; Date:%s; Client:%s %s;",
                    order.getId(), order.getDate(), db.getClientName(order.getClientId()).getKey(), db.getClientName(order.getClientId()).getValue()));
        }
        System.out.println("------END------\n");
    }

    public void getTourPrices() {
        System.out.println("\n----TOUR PRICES----");
        for(Map.Entry<String, Integer> tourPrice : db.getTourPrices().entrySet()) {
            System.out.println(String.format("Tour Name:%s; Price:%d;",
                    tourPrice.getKey(), tourPrice.getValue()));
        }
        System.out.println("------END------\n");
    }

    public void getToursForHotel(Integer hotelId) {
        System.out.println(String.format("\n----Tours for Hotel '%s'----", db.getHotelById(hotelId).getName()));
        for(Tour tour : db.getToursForHotel(db.getHotelById(hotelId))) {
            System.out.println(String.format("id:%s; Name:%s; Description:%s; Hotel:%s; Price:%d; Rating:%d;",
                    tour.getId(), tour.getName(), tour.getDescription(), db.getHotelName(tour.getHotelId()),
                    tour.getPrice(), tour.getRating()));
        }
        System.out.println("------END------\n");
    }

    public void addClient(Client client) {
        Boolean result = db.addClient(client);
        if(result) {
            System.out.println("New client is added.");
        } else {
            System.out.println("New client is not added.");
        }
    }

    private DB db;
}
