package View;

import Controller.HotelController;
import Interface.IView;
import Model.Hotel;

public class HotelView implements IView<Hotel> {
    public HotelView() { this.hotelController = new HotelController(); }

    @Override
    public void getObject() {
        System.out.println("\n----HOTELS----");
        for(Hotel hotel : hotelController.getAllObjects()) {
            System.out.println(String.format("id:%d; Name:%s; Spa:%d; Address:%s; Telephone:%s",
                    hotel.getId(), hotel.getName(), hotel.getSpaId(), hotel.getAddress(), hotel.getTelephone()));
        }
        System.out.println("------END------\n");
    }

    @Override
    public void addObject(Hotel hotel) {
        Boolean result = hotelController.addObject(hotel);
        if(result) {
            System.out.println("New hotel is added.");
        } else {
            System.out.println("New hotel is not added.");
        }
    }

    private HotelController hotelController;
}
