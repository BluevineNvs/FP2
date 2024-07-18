import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EX4 {
  public static void main(String[] args) {
    String jdbcUrl = "jdbc:mysql://localhost:3306/Library";
    String username = "Nikole";
    String password = "72725439";

    String deleteQuery = "DELETE FROM Books WHERE id = ?";

    try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

      preparedStatement.setInt(1, 1);
      preparedStatement.executeUpdate();

      System.out.println("Un Libraso a pasado a Mejor Vida :C!");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
