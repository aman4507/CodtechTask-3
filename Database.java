import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final String URL = "jdbc:sqlite:inventory.db";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void createNewDatabase() {
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            if (conn != null) {
                String sql = "CREATE TABLE IF NOT EXISTS products (\n"
                        + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                        + " name TEXT NOT NULL,\n"
                        + " description TEXT,\n"
                        + " price REAL NOT NULL,\n"
                        + " quantity INTEGER NOT NULL\n"
                        + ");";
                stmt.execute(sql);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
