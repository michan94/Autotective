package Autotective.controller;

import com.sun.rowset.JdbcRowSetImpl;
import javax.sql.rowset.JdbcRowSet;
import java.sql.*;

import Autotective.entity.Sensor;

public class SensorController {
    //JDBC drive name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/autotective";

    //Database credentials
    static final String USER = "root";
    static final String PASS = "testpass";

    private JdbcRowSet rowSet = null;

    

    public SensorController() {
        try {
            Class.forName(JDBC_DRIVER);
            rowSet = new JdbcRowSetImpl();
            rowSet.setUrl(DB_URL);
            rowSet.setUsername(USER);
            rowSet.setPassword(PASS);
            rowSet.setCommand("Select * from sensor");
            rowSet.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Sensor create (Sensor sensor) {
        try {
            rowSet.moveToInsertRow();
            rowSet.updateBoolean("status", sensor.getStatus());
            rowSet.updateString("sensType", sensor.getSensType());
            rowSet.updateInt("carID", sensor.getCarID());
            rowSet.insertRow();
            rowSet.moveToCurrentRow();
        } catch (SQLException e) {
            try {
                rowSet.rollback();
                sensor = null;
            } catch (SQLException e1) {
                e1.printStackTrace();
                return null;
            }

            e.printStackTrace();
        }
        return sensor;
    }

    public Sensor update (Sensor sensor) {
        try {
            rowSet.updateBoolean("status", sensor.getStatus());
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
        return sensor;
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
