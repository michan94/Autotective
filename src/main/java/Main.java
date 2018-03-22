import java.sql.*;

public class Main {
    //JDBC drive name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/Autotective";

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
                sql = "SELECT name, owner, species, sex, birth, death FROM pet"; //Change these to our project
                ResultSet rs = stmt.executeQuery(sql);

                //Extract data from result set
                while(rs.next()) {
                //Retrieve by column name
                    String name = rs.getString("name");
                    String owner = rs.getString("owner");
                    String species = rs.getString("species");
                    String sex = rs.getString("sex");
                    Date birth = rs.getDate("birth");
                    Date death = rs.getDate("death");

                    //Display Values
                    System.out.println("Name: " + name);
                    System.out.println(", Owner: " + owner);
                    System.out.println(", Species: " + species);
                    System.out.println(", Sex: " + sex);
                    System.out.println(", Birth: " + birth);
                    System.out.println(", Death: " + death);
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
