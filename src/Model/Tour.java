package Model;

import org.omg.CORBA.INTERNAL;

public class Tour {
    public Tour(Integer id, String name, String description,
         Hotel hotel, Integer price, Integer rating) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.hotel = hotel;
        this.price = price;
        this.rating = rating;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHotelId(Hotel hotel) {
        this.hotel = hotel;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getId() { return this.id; }
    public String getName() { return this.name; }
    public String getDescription() { return this.description; }
    public Hotel getHotel() { return this.hotel; }
    public Integer getPrice() { return this.price; }
    public Integer getRating() { return rating; }

    private Integer id;
    private String name;
    private String description;
    private Hotel hotel;
    private Integer price;
    private Integer rating;
}
