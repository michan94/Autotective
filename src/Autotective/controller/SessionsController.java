package Autotective.controller;

import Autotective.UI.TestsUI;
import com.sun.rowset.JdbcRowSetImpl;
import Autotective.entity.Sessions;

import javax.sql.rowset.JdbcRowSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SessionsController {
    //JDBC drive name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/autotective";

    //Database credentials
    static final String USER = "root";
    static final String PASS = "testpass";

    private JdbcRowSet rowSet = null;

    
    public SessionsController() {
        try {
            Class.forName(JDBC_DRIVER);
            rowSet = new JdbcRowSetImpl();
            rowSet.setUrl(DB_URL);
            rowSet.setUsername(USER);
            rowSet.setPassword(PASS);
            rowSet.setCommand("select * from sessions");
            rowSet.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Create Session
    public Sessions create (Sessions s) {
        try {
            rowSet.moveToInsertRow();
            rowSet.updateString("startTime", s.getStartTime());
            rowSet.updateString("endTime", s.getEndTime());
            rowSet.updateInt("testerID", s.getTesterID());
            rowSet.updateInt("carID", s.getCarID());
            rowSet.updateInt("settingID", s.getSettingID());
            rowSet.insertRow();
            rowSet.last();
            int newID = rowSet.getInt("seshID");
            s.setSeshID(newID);
        } catch (SQLException e) {
            try {
                rowSet.rollback();
                s = null;
            } catch (SQLException e1) {
                e1.printStackTrace();
                return null;
            }
            e.printStackTrace();
        }
        return s;
    }
    
    public void selectByID(int seshID) {
        try {
           rowSet.setCommand("SELECT * FROM sessions WHERE seshID = " + seshID);
           rowSet.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Update Sessions
    public Sessions update (Sessions s) {
        try {
            rowSet.next();
            rowSet.updateString("endTime", s.getEndTime());
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
        return s;
    }

    //Retrieve Session
    public Sessions currSession() {
        Sessions s = new Sessions();
        try {
            rowSet.moveToCurrentRow();
            rowSet.setInt("seshID", s.getSeshID());
            rowSet.setString("startTime", s.getStartTime());
            rowSet.setString("endTime", s.getEndTime());
            rowSet.setInt("testerID", s.getTesterID());
            rowSet.setInt("carID", s.getCarID());
            rowSet.setInt("settingID", s.getSettingID());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    //Delete Session
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
    
    
    public void createTable(TestsUI testsui){
    DefaultTableModel testTable = new DefaultTableModel(new String[] 
    {"Session", "Start", "End", "Tester", "Car", "Setting"},0);
    
    // while there is a row, get the data and add it as a row to the table
    try{
    while(rowSet.next()){
      
    int seshid = rowSet.getInt("seshID");
    String times = rowSet.getString("startTime");
    String timee = rowSet.getString("endTime");
    int testid = rowSet.getInt("testerID");
    int carid = rowSet.getInt("carID");
    int setid = rowSet.getInt("settingID");
    testTable.addRow(new Object[]{seshid, times, timee, testid,
    carid, setid});
    
    }
    }
    catch(SQLException e1){
        JOptionPane.showMessageDialog(testsui.getMostRecentFocusOwner(), ""
                + "Something went wrong!");
    }
    
    // sets the model of the addTesterUI's table with what it has created
    testsui.testsTable.setModel(testTable);
    }
}
