import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/snakegame";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connnection");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    public static void saveHighScore(String username, int score) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO high_scores (username, score) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setInt(2, score);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getHighScore() {
        
        try (Connection connection = getConnection()) {
            String q;
            q = "SELECT * FROM high_scores";
            return q;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Null";
    }
    

    public static void displayHighScores() {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM high_scores ORDER BY score DESC LIMIT 10";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String username = resultSet.getString("username");
                    int score = resultSet.getInt("score");
                    System.out.println(username + ": " + score);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
