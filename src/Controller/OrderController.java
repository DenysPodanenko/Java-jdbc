package Controller;

import DAO.OrderDAO;
import Interface.IController;
import Model.Order;
import Model.Tour;

import java.util.ArrayList;

public class OrderController implements IController<Order> {
    public OrderController() {
        this.orders = new ArrayList<>();
        this.dao = new OrderDAO();
    }

    @Override
    public void updateObject() { this.orders = dao.getObject(); }

    @Override
    public ArrayList<Order> getAllObjects () { return this.orders; }

    @Override
    public Boolean addObject(Order order) { return this.dao.addObject(order); }

    @Override
    public Order getObjectById(Integer id) {
        for(Order order: orders) {
            if(order.getId().equals(id)) {
                return order;
            }
        }

        return null;
    }

    public ArrayList<Order> getTourOrders(Integer tourId) {
        ArrayList<Order> tourOrders = new ArrayList<>();

        for(Order order : orders) {
            if(order.getTour().getId().equals(tourId)) {
                tourOrders.add(order);
            }
        }

        return tourOrders;
    }

    private ArrayList<Order> orders;
    private OrderDAO dao;
}
