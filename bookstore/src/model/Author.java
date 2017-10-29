package model;

public class Author {
    private int ID;
    private String firstName;
    private String lastName;
    private int birthYear;

    public Author(int ID, String firstName, String lastName, int birthYear) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    public int getID() {
        return ID;
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
        return "[" + this.ID + ", " + this.firstName + ", " + this.lastName + ", " + this.birthYear + "]";
    }
}
