package apt.tutorial;

public class Restaurant {
    private String name ="";
    private  String address="";
    private String type= " Sit down";
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString(){
        String str = "Name: "+ name + "\n" + "Address: " + address + "\n" + type;
        return str;
    }
}
