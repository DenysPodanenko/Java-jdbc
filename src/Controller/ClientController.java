package Controller;

import DAO.ClientDAO;
import Interface.IController;
import Model.Client;
import Model.Order;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClientController implements IController<Client> {
    public ClientController() {
        this.clients = new ArrayList<>();
        this.dao = new ClientDAO();
    }

    @Override
    public void updateObject() {
        this.clients = dao.getObject();
    }

    @Override
    public ArrayList<Client> getAllObjects() {
        return this.clients;
    }

    @Override
    public Boolean addObject(Client client) {
        boolean result = dao.addObject(client);
        if(result) { this.updateObject(); }

        return result;
    }

    @Override
    public Client getObjectById(Integer id) {
        for(Client client : clients) {
            if(client.getId().equals(id)) {
                return client;
            }
        }

        return null;
    }

    public Map.Entry<String, String> getClientName(Integer id) {
        for(Client client : clients) {
            if(client.getId().equals(id)) {
                return new AbstractMap.SimpleEntry<String, String>(client.getFirstName(), client.getSecondName());
            }
        }

        return new AbstractMap.SimpleEntry<String, String>("FName was not found", "SName was not found");
    }

    public HashMap<Map.Entry<String, String>, String> getClientTelephones() {
        HashMap<Map.Entry<String, String>, String> clientTelephones = new HashMap<>();

        for(Client client : clients) {
            clientTelephones.put(new AbstractMap.SimpleEntry<String, String>(client.getFirstName(), client.getSecondName()), client.getTelephone());
        }

        return clientTelephones;
    }

    public ArrayList<Order> getClientOrders(Client client) {
        return dao.getClientOrders(client);
    }

    private ArrayList<Client> clients;
    private ClientDAO dao;
}
