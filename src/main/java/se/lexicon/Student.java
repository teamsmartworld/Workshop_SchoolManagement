package se.lexicon;

public class Student {
    private int id;
    private String name;
    private String email;
    private String address;

    // Constructor
    public Student(int id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // toString
    @Override
    public String toString() {
        return "Student { " +
                "ID: " + id +
                ", Name: '" + name + '\'' +
                ", Email: '" + email + '\'' +
                ", Address: '" + address + '\'' +
                " }";
    }
}
