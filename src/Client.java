public class Client {
    Client(Integer id, String firstName, String secondName, String address,
           String telephone, String email, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
        this.age = age;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() { return this.id; }
    public String getFirstName() { return this.firstName; }
    public String getSecondName() { return this.secondName; }
    public String getAddress() { return this.address; }
    public String getTelephone() { return this.telephone; }
    public String getEmail() { return this.email; }
    public Integer getAge() { return this.age; }

    private Integer id;
    private String firstName;
    private String secondName;
    private String address;
    private String telephone;
    private String email;
    private Integer age;
}
