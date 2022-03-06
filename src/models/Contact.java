package src.models;

public class Contact implements Comparable<Contact> {

    private Long phoneNumber;
    private String name;

    public Contact(String name, String number) {
        this.phoneNumber = Long.valueOf(number);
        this.name = name;
    }

    public Contact() {
    }

    public Contact(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getUserId() {
        return phoneNumber;
    }

    public void setPhoneNumber(long userId) {
        this.phoneNumber = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Contac [name=" + name + ", phoneNumber=" + phoneNumber + "]";
    }

    @Override
    public int compareTo(Contact o) {

        return this.phoneNumber.compareTo(o.phoneNumber);
    }

    public String toLineText() {

        return this.name + ":" + this.phoneNumber.toString();
    }

}
