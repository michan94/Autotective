package Autotective.controller;

import com.sun.rowset.JdbcRowSetImpl;
import javax.sql.rowset.JdbcRowSet;
import java.sql.*;

import Autotective.entity.Car;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CarController {
    //JDBC drive name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    //static final String DB_URL = "jdbc:mysql://localhost:3306/Autotective?autoReconnect=true&useSSL=false";
    static final String DB_URL = "jdbc:mysql://localhost:3306/autotective";

    //Database credentials
    static final String USER = "root";
    static final String PASS = "testpass";
    private JdbcRowSet rowSet = null;

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
            rowSet.updateInt("carID", car.getCarID());
            rowSet.updateBoolean("tested", car.getTested());
            rowSet.insertRow();
            rowSet.moveToCurrentRow();
        } catch (SQLException e) {
            try {
                JOptionPane.showMessageDialog(null, "Duplicate ID is not allowed.");
                rowSet.rollback();
                car = null;
            } catch (SQLException e1) {
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

    public void delete() {
        try {
            rowSet.next();
            rowSet.deleteRow();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Delete failed, ID does not exist");
            try {
                rowSet.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }
    
    public void deleteByID(int carID) {
        selectByID(carID);
        delete();
    }
    
    public void selectByID(int carID) {
        try {
           rowSet.setCommand("SELECT * FROM car WHERE carID = " + carID);
           rowSet.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public JdbcRowSet queryValid() {
        String sql = String.format(
                "SELECT car.carID " +
                        "FROM ( " +
                            "SELECT distinct carID " +
                            "FROM sensor " +
                            "WHERE carID NOT IN ( " +
                                "SELECT carID " +
                                "FROM sensor " +
                                "WHERE status = false)) AS working_sensor " +
                                "JOIN car ON car.carID = working_sensor.carID " +
                                "WHERE car.carID NOT IN ( " +
                                    "SELECT carID " +
                                    "FROM sessions " +
                                    "WHERE endTime IS NULL)" +
                        "AND tested = false");
        query(sql);
        return rowSet;
    }
    
    public DefaultTableModel createTable(boolean selectCarID, boolean selectTested) {
        DefaultTableModel model = new DefaultTableModel();
        if (selectCarID && selectTested) {
            model = new DefaultTableModel(new String[] {"Car ID", "Tested"},0);
            try {
                while(rowSet.next()){ 
                    String carID = rowSet.getString("carID");
                    String tested = rowSet.getString("tested");
                    model.addRow(new Object[]{carID, tested});
                }
            }
            catch(SQLException e1){
                System.out.print(e1);
            }
            return model;
        } else if (selectCarID) {
            model = new DefaultTableModel(new String[] {"Car ID"},0);
            try {
                while(rowSet.next()){ 
                    String carID = rowSet.getString("carID");
                    model.addRow(new Object[]{carID});
                }
            }
            catch(SQLException e1){
                System.out.print(e1);
            }
        } else if (selectTested) {
            model = new DefaultTableModel(new String[] {"Tested"},0);
            try {
                while(rowSet.next()){ 
                    String tested = rowSet.getString("tested");
                    model.addRow(new Object[]{tested});
                }
            }
            catch(SQLException e1){
                System.out.print(e1);
            }
        }
        return model;
    }

    public void query(String sql) {
        try {
            rowSet.setCommand(sql);
            rowSet.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public DefaultTableModel basicQuery(boolean selectCarID, boolean selectTested) {
        String sql = String.format("SELECT * FROM car");
        query(sql);
        return createTable(selectCarID, selectTested);
    }

    public DefaultTableModel queryAvailableCars(boolean selectCarID, boolean selectTested) {
        String sql = String.format(
                "SELECT car.carID, tested " +
                        "FROM ( " +
                            "SELECT distinct carID " +
                            "FROM sensor " +
                            "WHERE carID NOT IN ( " +
                                "SELECT carID " +
                                "FROM sensor " +
                                "WHERE status = false)) AS working_sensor " +
                                "JOIN car ON car.carID = working_sensor.carID " +
                                "WHERE car.carID NOT IN ( " +
                                    "SELECT carID " +
                                    "FROM sessions " +
                                    "WHERE endTime IS NULL)" +
                        "AND tested = false");
        query(sql);
        return createTable(selectCarID, selectTested);
    }
}
