public class Patient {
    int ID;
    String name;
    String address;
    String phone_number;

    public Patient(int ID, String name, String phone_number, String address) {
        this.ID = ID;
        this.name = name;
        this.address = "Address: " + address;
        this.phone_number = phone_number;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

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

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    public String toString(){
        return this.ID+"\t"+this.name+"\t"+this.phone_number+"\t"+this.address;
    }
    public String format(){
        return this.ID+" "+this.name+" "+this.phone_number+" "+this.address;
    }
}
