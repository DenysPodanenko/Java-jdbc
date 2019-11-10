package View;

import Controller.OrderController;
import Interface.IView;
import Model.Order;

public class OrderView implements IView<Order> {
    public OrderView() { this.orderController = new OrderController(); }

    @Override
    public void getObject() {
        System.out.println("\n---ORDERS----");
        for(Order order : orderController.getAllObjects()) {
            System.out.println(String.format("id:%d; Date:%s; Client:%s %s; Tour:%s",
                    order.getId(), order.getDate(), order.getClient().getFirstName(), order.getClient().getSecondName(),
                    order.getTour().getName()));
        }
        System.out.println("------END------\n");
    }

    @Override
    public void addObject(Order order) {
        Boolean result = orderController.addObject(order);
        if(result) {
            System.out.println("New hotel is added.");
        } else {
            System.out.println("New hotel is not added.");
        }
    }

    public void getTourOrders(Integer tourId) {
        System.out.println("\n----%s Orders----");
        for(Order order : orderController.getTourOrders(tourId)) {
            System.out.println(String.format("id:%d; Date:%s; Client:%s %s;",
                    order.getId(), order.getDate(), order.getClient().getFirstName(), order.getClient().getSecondName()));
        }
        System.out.println("------END------\n");
    }

    private OrderController  orderController;
}
