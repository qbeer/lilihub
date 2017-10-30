package store;

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

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthyear() {
        return birthYear;
    }

    public void setBirthyear(int birthyear) {
        this.birthYear = birthyear;
    }

    @Override
    public String toString(){
        return String.format("Author[Name = %s %s, Id = %d, Year of birth = %d]",firstName,lastName,id,birthYear);
    }
}
