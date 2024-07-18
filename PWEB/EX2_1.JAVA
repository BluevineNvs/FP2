import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EX2_1{
  public static void main(String[] args) {
    String jdbcUrl = "jdbc:mysql://localhost:3306/Library";
    String username = "test";
    String password = "test";

    String insertQuery = "INSERT INTO Books (title, author, published_year) VALUES (?, ?, ?)";

    try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

      preparedStatement.setString(1, "The Way of Kings");
      preparedStatement.setString(2, "Brandon Sanderson");
      preparedStatement.setInt(3, 2001);
      preparedStatement.executeUpdate();

      preparedStatement.setString(1, "Words of Radiance");
      preparedStatement.setString(2, "Brandon Sanderson");
      preparedStatement.setInt(3, 2002);
      preparedStatement.executeUpdate();

      preparedStatement.setString(1, "Warbreaker");
      preparedStatement.setString(2, "Brandon Sanderson");
      preparedStatement.setInt(3, 2003);
      preparedStatement.executeUpdate();

      System.out.println("Que buenos libros!, Fueron insertador correctamente!");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
