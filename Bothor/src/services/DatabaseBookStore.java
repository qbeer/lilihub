package services;

import exceptions.InvalidIsbnException;
import exceptions.NoBookByIsbnException;
import exceptions.NoBooksException;
import store.Book;
import store.BookStore;

import java.sql.*;

public class DatabaseBookStore implements BookStore {

    private Connection connection;

    public DatabaseBookStore(){
        try {
            connection =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        }catch (SQLException e){
            System.out.println("Could not connect to server.");
            System.exit(1);
        }
    }

    @Override
    public Book[] getAllBooks() throws NoBooksException {
        String numberOfEntriesQuery = "SELECT COUNT(*) AS count FROM Books;";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(numberOfEntriesQuery);
            if(resultSet.next()) {
                int a = resultSet.getInt("count");
                Book[] books = new Book[resultSet.getInt("count")];
                String getBookQuery = "SELECT * FROM Books;";
                resultSet = statement.executeQuery(getBookQuery);
                int i = 0;
                while (resultSet.next()){
                    int localId = resultSet.getInt("author_id");
                    String localIsbn = resultSet.getString("isbn");
                    String localTitle = resultSet.getString("title");
                    books[i] = new Book(localIsbn, localTitle, localId);
                    i++;
                }
                return books;
            }else {
                throw new NoBooksException();
            }
        } catch (SQLException e) {
            System.out.println("Failed to count entries in database.");
            throw new NoBooksException();
        }
    }

    @Override
    public void addBook(Book newBook) throws InvalidIsbnException {
        String addBookQuery = "INSERT INTO Books VALUES('"+newBook.getTitle()+"','"+
                newBook.getIsbn()+"',"+String.valueOf(newBook.getAuthorId())+");";
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(addBookQuery);
        }catch (SQLException e){
            System.out.println("Failed to add new Book to database.");
            throw new InvalidIsbnException();
        }
    }

    @Override
    public Book getBookByIsbn(String isbn) throws NoBookByIsbnException {
        String getByIsbnQuery = "SELECT * FROM Books WHERE isbn='"+isbn+"';";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getByIsbnQuery);
            if(resultSet.next()){
                return new Book(resultSet.getString("isbn"),
                        resultSet.getString("title"),
                        resultSet.getInt("author_id"));
            }else{
                throw new NoBookByIsbnException();
            }
        }catch (SQLException e){
            System.out.println("Failed to getBookBy ISBN from server side");
            throw new NoBookByIsbnException();
        }

    }

}
