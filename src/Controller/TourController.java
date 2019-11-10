package Controller;

import DAO.TourDAO;
import Interface.IController;
import Model.Hotel;
import Model.Tour;

import java.util.ArrayList;
import java.util.HashMap;

public class TourController implements IController<Tour> {
    public TourController() {
        this.tours = new ArrayList<>();
        this.dao = new TourDAO();
    }

    @Override
    public void updateObject() { this.tours = dao.getObject(); }

    @Override
    public ArrayList<Tour> getAllObjects() { return this.tours; }

    @Override
    public Boolean addObject(Tour tour) { return this.dao.addObject(tour); }

    @Override
    public Tour getObjectById(Integer id) {
        for(Tour tour: tours) {
            if(tour.getId().equals(id)) {
                return tour;
            }
        }

        return null;
    }

    public String getTourName(Integer tourId) {
        for(Tour tour : tours) {
            if(tour.getId().equals(tourId)) {
                return tour.getName();
            }
        }

        return "Model.Tour was not found";
    }

    public HashMap<String, Integer> getTourPrices() {
        HashMap<String,Integer> toursPrice = new HashMap<>();

        for(Tour tour : tours) {
            toursPrice.put(tour.getName(), tour.getPrice());
        }

        return toursPrice;
    }

    public ArrayList<Tour> getToursForHotel(Integer hotelId) {
        ArrayList<Tour> toursForHotel = new ArrayList<>();

        for(Tour tour : tours) {
            if(tour.getHotel().getId().equals(hotelId)) {
                toursForHotel.add(tour);
            }
        }

        return toursForHotel;
    }

    private ArrayList<Tour> tours;
    private TourDAO dao;
}
