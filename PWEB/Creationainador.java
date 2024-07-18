import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Creationainador {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/";
        String username = "Nikole";
        String password = "72725439";

        String databaseName = "Library";
        String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS " + databaseName;
        String useDatabaseQuery = "USE " + databaseName;
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Books (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "title VARCHAR(100), " +
                "author VARCHAR(100), " +
                "published_year INT)";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
                Statement statement = connection.createStatement()) {

            // Crear la base de datos
            statement.executeUpdate(createDatabaseQuery);
            System.out.println("La Base de Datos fue creada, o ya existe.");

            statement.executeUpdate(useDatabaseQuery);
            System.out.println("Usando la Base de Datos " + databaseName);

            // Crear la tabla
            statement.executeUpdate(createTableQuery);
            System.out.println("La Tabla 'Books' ya fue creada, o ya existe.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
