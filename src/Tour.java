import org.omg.CORBA.INTERNAL;

public class Tour {
    Tour(Integer id, String name, String description,
         Integer hotelId, Integer price, Integer rating) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.hotelId = hotelId;
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

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
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
    public Integer getHotelId() { return this.hotelId; }
    public Integer getPrice() { return this.price; }
    public Integer getRating() { return rating; }

    private Integer id;
    private String name;
    private String description;
    private Integer hotelId;
    private Integer price;
    private Integer rating;
}
