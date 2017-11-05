/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

/**
 *
 * @author PNMINH
 */
public class Author {

    private int id, birthYear;
    private String firstName, lastName;

    public Author(int id, int birthYear, String firstName, String lastName) {
        this.id = id;
        this.birthYear = birthYear;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the birthYear
     */
    public int getBirthYear() {
        return birthYear;
    }

    /**
     * @param birthYear the birthYear to set
     */
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
