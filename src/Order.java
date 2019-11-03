public class Order {
    Order(Integer id, String date, Integer clientId, Integer tourId) {
        this.id = id;
        this.date = date;
        this.clientId = clientId;
        this.tourId = tourId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public void setTourId(Integer tourId) {
        this.tourId = tourId;
    }

    public Integer getId() { return this.id; }
    public String getDate() { return this.date; }
    public Integer getClientId() { return this.clientId; }
    public Integer getTourId() { return this.tourId; }

    private Integer id;
    private String date;
    private Integer clientId;
    private Integer tourId;
}
