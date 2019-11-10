package View;

import Controller.TourController;
import Interface.IView;
import Model.Tour;

import java.util.Map;

public class TourView implements IView<Tour> {
    public TourView() { this.tourController = new TourController(); }

    @Override
    public void getObject() {
        System.out.println("\n----TOURS----");
        for(Tour tour: tourController.getAllObjects()) {
            System.out.println(String.format("id:%s, Name:%s; Description:%s; Hotel:%s; Price:%d; Rating:%d",
                    tour.getId(), tour.getName(), tour.getDescription(), tour.getHotel().getName(),
                    tour.getPrice(), tour.getRating()));
        }
        System.out.println("------END------\n");
    }

    @Override
    public void addObject(Tour tour) {
        Boolean result = tourController.addObject(tour);
        if(result) {
            System.out.println("New hotel is added.");
        } else {
            System.out.println("New hotel is not added.");
        }
    }

    public void getToursForHotel(Integer hotelId) {
        System.out.println("\n----Tours for Model.Hotel '%s'----");
        for(Tour tour : tourController.getToursForHotel(hotelId)) {
            System.out.println(String.format("id:%s; Name:%s; Description:%s; Hotel:%s; Price:%d; Rating:%d;",
                    tour.getId(), tour.getName(), tour.getDescription(), tour.getHotel().getName(),
                    tour.getPrice(), tour.getRating()));
        }
        System.out.println("------END------\n");
    }

    public void getTourPrices() {
        System.out.println("\n----TOUR PRICES----");
        for(Map.Entry<String, Integer> tourPrice : tourController.getTourPrices().entrySet()) {
            System.out.println(String.format("Model.Tour Name:%s; Price:%d;",
                    tourPrice.getKey(), tourPrice.getValue()));
        }
        System.out.println("------END------\n");
    }

    private TourController tourController;
}
