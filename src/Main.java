import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import org.omg.PortableInterceptor.INACTIVE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        View view = new View(new DB());
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
                    view.getClients();
                    break;
                case ("Orders"):
                    view.getOrders();
                    break;
                case ("Tours"):
                    view.getTours();
                    break;
                case ("Hotels"):
                    view.getHotels();
                    break;
                case ("Client Telephones"):
                    view.getClientTelephones();
                    break;
                case ("Tour Prices"):
                    view.getTourPrices();
                    break;
                case ("Exit"):
                    program = false;
                    break;
                default:
                    if(clientOrderPattern.matcher(command).find()) {
                        matcher = clientOrderPattern.matcher(command);
                        matcher.matches();
                        view.getClientOrders(Integer.parseInt(matcher.group(1)));
                        break;
                    } else if (tourOrdersPattern.matcher(command).find()) {
                        matcher = tourOrdersPattern.matcher(command);
                        matcher.matches();
                        view.getTourOrders(Integer.parseInt(matcher.group(1)));
                        break;
                    } else if (tourForHotels.matcher(command).find()) {
                        matcher = tourForHotels.matcher(command);
                        matcher.matches();
                        view.getToursForHotel(Integer.parseInt(matcher.group(1)));
                        break;
                    } else if (addClient.matcher(command).find()) {
                        matcher = addClient.matcher(command);
                        matcher.matches();
                        view.addClient(new Client(Integer.parseInt(matcher.group(1)), matcher.group(2), matcher.group(3), matcher.group(4),
                                matcher.group(5), matcher.group(6), Integer.parseInt(matcher.group(7))));
                    } else {
                        System.out.println("No such command.");
                        break;
                    }

            }
        }
    }
}