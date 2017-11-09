package store;

import exception.InvalidAuthorException;
import exception.NoAuthorException;

import model.Author;
import store.layer.AuthorStore;

import java.sql.*;

public class SqlAuthorStore implements AuthorStore {
    private final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final String USER = "postgres";
    private final String PASS = "";

    private Connection connection;

    public SqlAuthorStore() {
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
    public Author[] getAllAuthor() throws NoAuthorException {
        connect();

        try (Statement statement = connection.createStatement()){
            ResultSet resultSetRowCount = statement.executeQuery("SELECT COUNT(*) AS count FROM author");

            int rowCount = 0;
            while(resultSetRowCount.next()) {
                rowCount = resultSetRowCount.getInt(1);
            }

            if (rowCount == 0) {
                throw new NoAuthorException();
            }

            Author[] authors = new Author[rowCount];

            ResultSet resultSet = statement.executeQuery("SELECT * FROM author");

            int i = 0;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int birthYear = resultSet.getInt("birth_year");

                authors[i] = new Author(id, firstName, lastName, birthYear);
                i++;
            }

            return authors;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        } finally {
            closeConnection();
        }
    }

    @Override
    public void addAuthor(Author author) throws InvalidAuthorException {
        connect();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT id FROM author");

            while (resultSet.next()) {
                if (resultSet.getInt(1) == author.getId()) {
                    throw new InvalidAuthorException(author.getId());
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        String addQuery = "INSERT INTO author (id, first_name, last_name, birth_year)" +
                "VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(addQuery)){
            statement.setInt(1, author.getId());
            statement.setString(2, author.getFirstName());
            statement.setString(3, author.getLastName());
            statement.setInt(4, author.getBirthYear());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            closeConnection();
        }
    }

    @Override
    public Author getAuthorById(int id) throws NoAuthorException {
        connect();

        String getQuery = "SELECT * FROM author WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(getQuery)) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                throw new NoAuthorException(id);
            }

            while(resultSet.next()) {
                int authorId = resultSet.getInt(1);
                String first_name = resultSet.getString(2);
                String last_name = resultSet.getString(3);
                int birth_year = resultSet.getInt(4);

                return new Author(authorId, first_name, last_name, birth_year);
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