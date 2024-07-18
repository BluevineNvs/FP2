import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EX1 {
  public static void main(String[] args) {
    String jdbcUrl = "jdbc:mysql://localhost:3306/Library";
    String username = "Nikole"; 
    String password = "72725439"; 

    try {
      Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
      if (connection != null) {
        System.out.println("Si Finco la BD :)!");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
