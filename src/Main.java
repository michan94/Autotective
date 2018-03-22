import java.sql.*;

public class Main {
    //JDBC drive name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/Autotective"; //

    //Database credentials
    static final String USER = "tester";
    static final String PASS = "setting";

        public static void main (String args[]) {
            Connection conn = null;
            Statement stmt = null;
            try {
                //Register JDBC Driver
                Class.forName(JDBC_DRIVER);

                //Open Connection
                System.out.println("Connecting to database...");
                conn = DriverManager.getConnection(DB_URL,USER,PASS);

                //Query Execution
                System.out.println("Creating statement...");
                stmt = conn.createStatement();
                String sql;
                sql = "SELECT id, first last, age FROM Employees"; //Change these to our project
                ResultSet rs = stmt.executeQuery(sql);

                //Extract data from result set
                while(rs.next()) {
                //Retrieve by column name
                    int id = rs.getInt("id");
                    int age = rs.getInt("age");
                    String first = rs.getString("first");
                    String last = rs.getString("last");

                    //Display Values
                    System.out.println("ID: " + id);
                    System.out.println(", Age: " + age);
                    System.out.println(", First: " + first);
                    System.out.println(", Last: " + last);
                }

                //Clean-up environment
                rs.close();
                stmt.close();
                conn.close();
            }catch (SQLException se) {
                //Handle errors for JDBC
                se.printStackTrace();
            }catch (Exception e) {
                //Handle errors for Class.forName
                e.printStackTrace();
            }finally {
                //finally block used to close resources
                try {
                    if (stmt != null) {
                        stmt.close();
                    }
                }catch (SQLException se2) {
                    //Nothing we can do
                }
                try {
                    if (conn != null) {
                        conn.close();
                    }
                }catch (SQLException se) {
                    se.printStackTrace();
                }// end finally try
            }//end try
            System.out.println("Goodbye!");
        }
}
