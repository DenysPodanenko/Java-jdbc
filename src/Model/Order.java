package Model;

public class Order {
    public Order(Integer id, String date, Client client, Tour tour) {
        this.id = id;
        this.date = date;
        this.client = client;
        this.tour = tour;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setTourId(Tour tour) {
        this.tour = tour;
    }

    public Integer getId() { return this.id; }
    public String getDate() { return this.date; }
    public Client getClient() { return this.client; }
    public Tour getTour() { return this.tour; }

    private Integer id;
    private String date;
    private Client client;       // todo Model.Client
    private Tour tour;         // todo Model.Tour
}
