public class Contact implements Comparable<Contact>{
    private String socialSecurityNumber;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Contact(String phoneNumber, String firstName, String lastName, String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int compareTo(Contact o) {
        return phoneNumber.compareTo(o.phoneNumber);
    }

    public String toString(){
        return phoneNumber+" "+firstName+" "+lastName+" "+socialSecurityNumber;
    }
}
