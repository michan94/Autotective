package controller;

import com.sun.rowset.JdbcRowSetImpl;
import javax.sql.rowset.JdbcRowSet;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

import entity.Car;

public class CarController {
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

    public CarController() {
        try {
            Class.forName(JDBC_DRIVER);
            rowSet = new JdbcRowSetImpl();
            rowSet.setUrl(DB_URL);
            rowSet.setUsername(USER);
            rowSet.setPassword(PASS);
            rowSet.setCommand("Select * from car");
            rowSet.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Car create (Car car) {
        try {
            rowSet.moveToInsertRow();
            rowSet.updateBoolean("tested", car.getTested());
            rowSet.insertRow();
            rowSet.moveToCurrentRow();
        } catch (SQLException e) {
            try {
                rowSet.rollback();
                car = null;
            } catch (SQLException e1) {
                e1.printStackTrace();
                return null;
            }

            e.printStackTrace();
        }
        return car;
    }

    public Car update (Car car) {
        try {
            rowSet.updateBoolean("tested", car.getTested());
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
        return car;
    }

    public void delete () {
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

    public JTable query(String sql) {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Car ID", "Tested"}, 0);
        int countObjects = 0;
        try {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                countObjects++;
                model.addRow(new Object[]{
                        rs.getString("car.carID"),
                        rs.getString("car.testing")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (countObjects == 0) {
//            JOptionPane.showMessageDialog(null,
//                    "No results.");
            return null;
        }
        JTable resultTable = new JTable(model);
        resultTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        return resultTable;
    }


    public JTable queryByCarID (int carID) {
        String sql = String.format("SELECT * FROM car WHERE carID = %s;", carID);
        return query(sql);
    }

    public JTable queryAvailableCars () {
        String sql = String.format(
                "SELECT car.carID, tested " +
                        "FROM ( " +
                        "SELECT distinct carID" +
                        "FROM sensor " +
                        "WHERE carID NOT IN ( " +
                        "SELECT carID " +
                        "FROM Autotective.sensor " +
                        "WHERE status = false)) AS working_sensor " +
                        "JOIN Autotective.car ON car.carID = working_sensor.carID " +
                        "WHERE car.carID NOT IN ( " +
                        "SELECT carID " +
                        "FROM Autotective.sessions " +
                        "WHERE endTime IS NULL)" +
                        "AND tested = true;" +
                        "carID);");
        return query(sql);
    }
}
