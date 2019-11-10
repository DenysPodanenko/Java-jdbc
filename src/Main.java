import Model.Client;
import View.ClientView;
import View.HotelView;
import View.OrderView;
import View.TourView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        ClientView clientView = new ClientView();
        HotelView hotelView = new HotelView();
        OrderView orderView = new OrderView();
        TourView tourView = new TourView();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern clientOrderPattern = Pattern.compile("^GetClientOrders (\\d*)$");
        Pattern tourOrdersPattern = Pattern.compile("^GetTourOrders (\\d*)$");
        Pattern tourForHotels = Pattern.compile("^GetToursForHotel (\\d*)$");
        Pattern addClient = Pattern.compile("^AddClient (\\d*) (\\w*) (\\w*) (\\w*) (\\w*) (\\D*) (\\d*)$");

        Matcher matcher;
        Boolean program = true;

        while(program) {
            String command = reader.readLine();
            switch (command) {
                case ("Clients"):
                    clientView.getObject();
                    break;
                case ("Orders"):
                    orderView.getObject();
                    break;
                case ("Tours"):
                    tourView.getObject();
                    break;
                case ("Hotels"):
                    hotelView.getObject();
                    break;
                case ("Client Telephones"):
                    clientView.getClientTelephones();
                    break;
                case ("Tour Prices"):
                    tourView.getTourPrices();
                    break;
                case ("Exit"):
                    program = false;
                    break;
                default:
                    if(clientOrderPattern.matcher(command).find()) {
                        matcher = clientOrderPattern.matcher(command);
                        matcher.matches();
                        clientView.getClientOrders(Integer.parseInt(matcher.group(1)));
                        break;
                    } else if (tourOrdersPattern.matcher(command).find()) {
                        matcher = tourOrdersPattern.matcher(command);
                        matcher.matches();
                        orderView.getTourOrders(Integer.parseInt(matcher.group(1)));
                        break;
                    } else if (tourForHotels.matcher(command).find()) {
                        matcher = tourForHotels.matcher(command);
                        matcher.matches();
                        tourView.getToursForHotel(Integer.parseInt(matcher.group(1)));
                        break;
                    } else if (addClient.matcher(command).find()) {
                        matcher = addClient.matcher(command);
                        matcher.matches();
                        clientView.addObject(new Client(Integer.parseInt(matcher.group(1)), matcher.group(2), matcher.group(3), matcher.group(4),
                                matcher.group(5), matcher.group(6), Integer.parseInt(matcher.group(7))));
                    } else {
                        System.out.println("No such command.");
                        break;
                    }

            }
        }
    }
}