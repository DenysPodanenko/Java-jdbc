public class Hotel {
    Hotel(Integer id, String name, Integer spaId, String address, String telephone) {
        this.id = id;
        this.name = name;
        this.spaId = spaId;
        this.address = address;
        this.telephone = telephone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpaId(Integer spaId) {
        this.spaId = spaId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getId() { return this.id; }
    public String getName() { return this.name; }
    public Integer getSpaId() { return this.spaId; }
    public String getAddress() { return this.address; }
    public String getTelephone() { return this.telephone; }

    private Integer id;
    private String name;
    private Integer spaId;
    private String address;
    private String telephone;
}
