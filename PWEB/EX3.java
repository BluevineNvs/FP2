import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EX3{
  public static void main(String[] args) {
    String jdbcUrl = "jdbc:mysql://localhost:3306/Library";
    String username = "Nikole";
    String password = "72725439";

    try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Books")) {

      while (resultSet.next()) {
        int id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        String author = resultSet.getString("author");
        int publishedYear = resultSet.getInt("published_year");
        System.out
            .println("ID: " + id + ", Title: " + title + ", Author: " + author + ", Año de Publicación: " + publishedYear);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
