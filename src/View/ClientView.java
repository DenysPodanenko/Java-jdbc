package View;

import Controller.ClientController;
import Interface.IView;
import Model.Client;
import Model.Order;

import java.util.Map;

public class ClientView implements IView<Client> {
    public ClientView() {
        clientController = new ClientController();
    }

    @Override
    public void getObject() {
        System.out.println("\n----CLIENTS----");
        for(Client client : clientController.getAllObjects()) {
            System.out.println(String.format("id:%d; First Name:%s; Second Name:%s; Address:%s; Telephone:%s; E-mail:%s; Age:%d;",
                    client.getId(), client.getFirstName(), client.getSecondName(), client.getAddress(), client.getTelephone(),
                    client.getEmail(), client.getAge()));
        }
        System.out.println("------END------\n");
    }

    @Override
    public void addObject(Client client) {
        Boolean result = clientController.addObject(client);
        if(result) {
            System.out.println("New client is added.");
        } else {
            System.out.println("New client is not added.");
        }
    }

    public void getClientTelephones() {
        System.out.println("\n----TELEPHONE NUMBERS----");
        for(Map.Entry<Map.Entry<String, String>, String> clientTelephone : clientController.getClientTelephones().entrySet()) {
            System.out.println(String.format("First Name:%s; Second Name:%s; Telephone:%s;",
                    clientTelephone.getKey().getKey(), clientTelephone.getKey().getValue(), clientTelephone.getValue()));
        }
        System.out.println("------END------\n");
    }

    public void getClientOrders(Integer clientId) {
        System.out.println(String.format("\n----%s %s Orders----", clientController.getObjectById(clientId).getFirstName(), clientController.getObjectById(clientId).getSecondName()));
        for (Order order : clientController.getClientOrders(clientController.getObjectById(clientId))) {
            System.out.println(String.format("id:%d; Date:%s; Model.Tour:%s;",
                    order.getId(), order.getDate(), clientController.getObjectById(order.getTourId())));
        }
        System.out.println("------END------\n");
    }

    private ClientController clientController;
}
