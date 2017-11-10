package services;

import exceptions.InvalidIdException;
import exceptions.NoAuthorByIdException;
import exceptions.NoAuthorsException;
import store.Author;
import store.AuthorStore;

import java.sql.*;

public class DatabaseAuthorStore implements AuthorStore {

    private Connection connection;

    public DatabaseAuthorStore(){
        try {
            connection =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        }catch (SQLException e){
            System.out.println("Could not connect to server.");
            System.exit(1);
        }
    }

    @Override
    public Author getAuthorById(int id) throws NoAuthorByIdException {
        String getByIdQuery = "SELECT * FROM Authors WHERE id="+id+";";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getByIdQuery);
            if(resultSet.next()){
                return new Author(resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("birth_year"));
            }else{
                throw new NoAuthorByIdException();
            }
        }catch (SQLException e){
            System.out.println("Failed to getAuthorBy ID from server side");
            throw new NoAuthorByIdException();
        }
    }

    @Override
    public void addAuthor(Author newAuthor) throws InvalidIdException {
        String addAuthorQuery = "INSERT INTO Authors VALUES('"+
                newAuthor.getFirstName()+"','"+newAuthor.getLastName()+"',"+
                String.valueOf(newAuthor.getId())+","+
                String.valueOf(newAuthor.getBirthyear())+");";
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(addAuthorQuery);
        }catch (SQLException e){
            System.out.println("Failed to add new Author to database.");
            throw new InvalidIdException();
        }
    }

    @Override
    public Author[] getAllAuthors() throws NoAuthorsException {
        String numberOfEntriesQuery = "SELECT COUNT(*) AS count FROM Authors;";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(numberOfEntriesQuery);
            if(resultSet.next()) {
                Author[] authors = new Author[resultSet.getInt("count")];
                String getAuthorQuery = "SELECT * FROM Authors;";
                resultSet = statement.executeQuery(getAuthorQuery);
                int i = 0;
                while (resultSet.next()){
                    int localId = resultSet.getInt("id");
                    String localFirstName = resultSet.getString("first_name");
                    String localLastName = resultSet.getString("last_name");
                    int localBirthYear = resultSet.getInt("birth_year");
                    authors[i] = new Author(localId, localFirstName, localLastName, localBirthYear);
                    i++;
                }
                return authors;
            }else {
                throw new NoAuthorsException();
            }
        } catch (SQLException e) {
            System.out.println("Failed to count entries in database.");
            throw new NoAuthorsException();
        }
    }
}
