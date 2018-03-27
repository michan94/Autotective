package controller;

import com.sun.rowset.JdbcRowSetImpl;
import javax.sql.rowset.JdbcRowSet;
import java.sql.*;

import entity.Log;

public class LogController {
    //JDBC drive name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/Autotective";

    //Database credentials
    static final String USER = "tester";
    static final String PASS = "setting";

    private JdbcRowSet rowSet = null;

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public LogController() {
        try {
            Class.forName(JDBC_DRIVER);
            rowSet = new JdbcRowSetImpl();
            rowSet.setUrl(DB_URL);
            rowSet.setUsername(USER);
            rowSet.setPassword(PASS);
            rowSet.setCommand("Select * from log");
            rowSet.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Log create (Log log) {
        try {
            rowSet.moveToInsertRow();
            rowSet.updateString("comment", log.getComment());
            rowSet.updateString("typeOf", log.getTypeOf());
            rowSet.updateInt("speed", log.getSpeed());
            rowSet.updateInt("brake", log.getBrake());
            rowSet.updateInt("seshID", log.getSeshID());
            rowSet.updateDouble("latitude", log.getLatitude());
            rowSet.updateDouble("longitude", log.getLongitude());
            rowSet.insertRow();
            rowSet.moveToCurrentRow();
        } catch (SQLException e) {
            try {
                rowSet.rollback();
                log = null;
            } catch (SQLException e1) {
                e1.printStackTrace();
                return null;
            }

            e.printStackTrace();
        }
        return log;
    }

    public Log update (Log log) {
        try {
            rowSet.updateString("comment", log.getComment());
            rowSet.updateRow();
            rowSet.moveToCurrentRow();
        } catch (SQLException e) {
            try {
                rowSet.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return log;
    }

    public void delete() {
        try {
            rowSet.moveToCurrentRow();
            rowSet.deleteRow();
        } catch (SQLException e) {
            try {
                rowSet.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
