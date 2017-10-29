package model;

public class Author {
    private int id;
    private String firstName;
    private String lastName;
    private int birthYear;

    public Author(int id, String firstName, String lastName, int birthYear) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    @Override
    public String toString() {
        return "[" + this.id + ", " + this.firstName + ", " + this.lastName + ", " + this.birthYear + "]";
    }
}
