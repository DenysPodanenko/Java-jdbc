package Controller;

import DAO.HotelDAO;
import Interface.IController;
import Model.Hotel;

import java.util.ArrayList;

public class HotelController implements IController<Hotel> {
    public HotelController() {
        this.hotels = new ArrayList<>();
        this.dao = new HotelDAO();
    }

    @Override
    public void updateObject() { this.hotels = dao.getObject(); }

    @Override
    public ArrayList<Hotel> getAllObjects() { return this.hotels; }

    @Override
    public Boolean addObject(Hotel hotel) { return this.dao.addObject(hotel); }

    @Override
    public Hotel getObjectById(Integer id) {
        for(Hotel hotel: hotels) {
            if(hotel.getId().equals(id)) {
                return hotel;
            }
        }

        return null;
    }

    public String getHotelNameById(Integer Id) {
        for(Hotel hotel : hotels) {
            if(hotel.getId().equals(Id)) {
                return hotel.getName();
            }
        }

        return "Hotel was not found";
    }

    private ArrayList<Hotel> hotels;
    private HotelDAO dao;
}
