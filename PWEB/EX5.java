import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EX5 {
  public static void main(String[] args) {
    String jdbcUrl = "jdbc:mysql://localhost:3306/Library";
    String username = "Nikole";
    String password = "72725439";

    String insertQuery = "INSERT INTO Books (title, author, published_year) VALUES (?, ?, ?)";

    try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
      connection.setAutoCommit(false);

      try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

        preparedStatement.setString(1, "Outhbringer");
        preparedStatement.setString(2, "Brandon Sanderson");
        preparedStatement.setInt(3, 2017);
        preparedStatement.executeUpdate();

        preparedStatement.setString(1, "Rythm of War");
        preparedStatement.setString(2, "Brandon Sanderson");
        preparedStatement.setInt(3, 2020);
        preparedStatement.executeUpdate();

        connection.commit();
        System.out.println("Transacción hecha correctamente!");
      } catch (SQLException e) {
        connection.rollback();
        e.printStackTrace();
        System.out.println("Nos fuimos para atras porque metiste la pata, revisa que paso Jsjsjs.");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
