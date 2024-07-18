import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EX2_2 {
  public static void main(String[] args) {
    String jdbcUrl = "jdbc:mysql://localhost:3306/Library";
    String username = "test";
    String password = "test";

    String updateQuery = "UPDATE Books SET published_year = ? WHERE title = ?";

    try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

      preparedStatement.setInt(1, 2010);
      preparedStatement.setString(2, "The Way of Kings");
      preparedStatement.executeUpdate();

      System.out.println("Record updated successfully!");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
