import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MoodDAO {
    private final String DB_URL = "jdbc:mysql://localhost:3306/mood_tracker";  // MySQL connection URL
    private final String DB_USER = "root";  // Your MySQL username (e.g., "root")
    private final String DB_PASS = "Kanish@030805";  // Your MySQL password

    public MoodDAO() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            System.out.println("✅ Connected to MySQL");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveMood(String mood) {
        String insert = "INSERT INTO moods (mood) VALUES (?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement pstmt = conn.prepareStatement(insert)) {
            pstmt.setString(1, mood);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getAllMoods() {
        List<String> moods = new ArrayList<>();
        String query = "SELECT * FROM moods ORDER BY date DESC";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                moods.add(rs.getString("date") + " - Mood: " + rs.getString("mood"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return moods;
    }
}
