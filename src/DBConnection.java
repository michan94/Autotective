import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static void main (String args[]) {
        Connection connection = DriverManager.getConnection();
    }
}
