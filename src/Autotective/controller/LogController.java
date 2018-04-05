/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Autotective.controller;

import com.sun.rowset.JdbcRowSetImpl;
import javax.sql.rowset.JdbcRowSet;
import java.sql.*;

import Autotective.entity.Log;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Lyndon
 */

public class LogController {
    //JDBC drive name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/autotective";

    //Database credentials
    static final String USER = "root";
    static final String PASS = "testpass";

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
            e.printStackTrace();
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
    
    public void query(String sql) {
        try {
            rowSet.setCommand(sql);
            rowSet.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public DefaultTableModel basicQuery() {
        String sql = String.format("SELECT * FROM log");
        query(sql);
        return createTable();
    }
    
    public DefaultTableModel avgSpeedQuery() {
        String sql = String.format(
                "SELECT typeOf, AVG(speed) AS avg_speed " +
                "FROM Autotective.log " +
                "GROUP BY typeOf " +
                "ORDER BY AVG(speed)");
        query(sql);
        return createSpeedTable();
    }
    
    public DefaultTableModel maxSpeedQuery() {
        String sql = String.format(
                "SELECT MAX(avg_speed) AS m_speed " +
                "FROM (" + 
                    "SELECT typeOf, AVG(speed) AS avg_speed " +
                    "FROM Autotective.log " +
                    "GROUP BY typeOf " +
                    "ORDER BY AVG(speed) " +
                    ") AS  agr_speed");
        query(sql);
        return createMaxMinTable();
    }
    
    public DefaultTableModel minSpeedQuery() {
        String sql = String.format(
                "SELECT MIN(avg_speed) AS m_speed " +
                "FROM (" + 
                    "SELECT typeOf, AVG(speed) AS avg_speed " +
                    "FROM Autotective.log " +
                    "GROUP BY typeOf " +
                    "ORDER BY AVG(speed) " +
                    ") AS  agr_speed");
        query(sql);
        return createMaxMinTable();
    }
    
    public DefaultTableModel createMaxMinTable() {
        DefaultTableModel model = new DefaultTableModel(new String[] 
        {"Average Speed"},0);
            try {
                while(rowSet.next()){
                    double avg_speed = rowSet.getDouble("m_speed");
                    model.addRow(new Object[]{avg_speed});
                }
            }
            catch(SQLException e1){
                System.out.print(e1);
            }
        return model;    
    }
    
    public DefaultTableModel createSpeedTable() {
        DefaultTableModel model = new DefaultTableModel(new String[] 
        {"Type", "Average Speed"},0);
            try {
                while(rowSet.next()){
                    String type = rowSet.getString("typeOf");
                    double avg_speed = rowSet.getDouble("avg_speed");
                    model.addRow(new Object[]{type, avg_speed});
                }
            }
            catch(SQLException e1){
                System.out.print(e1);
            }
        return model;    
    }
    
    public DefaultTableModel createTable() {
        DefaultTableModel model = new DefaultTableModel(new String[] 
        {"Log", "Comment", "Latitude", "Longitude", "Speed", "Brake", "Type", "Session"},0);
            try {
                while(rowSet.next()){ 
                    int logID = rowSet.getInt("logID");
                    String comment = rowSet.getString("comment");
                    double latitude = rowSet.getDouble("latitude");
                    double longitude = rowSet.getDouble("longitude");
                    int speed = rowSet.getInt("speed");
                    int brake = rowSet.getInt("brake");
                    String type = rowSet.getString("typeOf");
                    int seshID = rowSet.getInt("seshID");
                    model.addRow(new Object[]{logID, comment, latitude, longitude, speed, 
                        brake, type, seshID});
                }
            }
            catch(SQLException e1){
                System.out.print(e1);
            }
        return model;    
    }
}
