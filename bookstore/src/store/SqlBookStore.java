package store;

import exception.InvalidIsbnException;
import exception.NoBookException;

import model.Book;
import store.layer.BookStore;

import java.sql.*;


public class SqlBookStore implements BookStore {
    private final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final String USER = "postgres";
    private final String PASS = "";

    private Connection connection;

    public SqlBookStore() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Driver not found");
        }
    }

    private void connect() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            System.err.println("Cannot connect to the server");
            System.exit(1);
        }
    }

    private void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println("Cannot close connection");
        }
    }

    @Override
    public Book[] getAllBook() throws NoBookException {
        connect();

        try (Statement statement = connection.createStatement()){
            ResultSet resultSetRowCount = statement.executeQuery("SELECT COUNT(*) AS count FROM book");

            int rowCount = 0;
            while(resultSetRowCount.next()) {
                rowCount = resultSetRowCount.getInt(1);
            }

            if (rowCount == 0) {
                throw new NoBookException();
            }

            Book[] books = new Book[rowCount];

            ResultSet resultSet = statement.executeQuery("SELECT * FROM book");

            int i = 0;
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String isbn = resultSet.getString("isbn");
                int authorId = resultSet.getInt("author_id");

                books[i] = new Book(title, isbn, authorId);
                i++;
            }

            return books;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        } finally {
            closeConnection();
        }
    }

    @Override
    public void addBook(Book book) throws InvalidIsbnException {
        connect();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT isbn FROM book");

            while (resultSet.next()) {
                if (resultSet.getString(1).equals(book.getIsbn())) {
                    throw new InvalidIsbnException(book.getIsbn());
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        String addQuery = "INSERT INTO book (title, isbn, author_id)" +
                "VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(addQuery)){
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getIsbn());
            statement.setInt(3, book.getAuthorId());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            closeConnection();
        }
    }

    @Override
    public Book getBookByIsbn(String isbn) throws NoBookException {
        connect();

        String getQuery = "SELECT * FROM book WHERE isbn = ?";
        try (PreparedStatement statement = connection.prepareStatement(getQuery)) {
            statement.setString(1, isbn);

            ResultSet resultSet = statement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                throw new NoBookException(isbn);
            }

            while(resultSet.next()) {
                String title = resultSet.getString(1);
                String isbn_field = resultSet.getString(2);
                int authorId = resultSet.getInt(3);

                return new Book(title, isbn_field, authorId);
            }

            return null;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        } finally {
            closeConnection();
        }
    }
}
