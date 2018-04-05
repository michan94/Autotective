package Autotective.controller;

import com.sun.rowset.JdbcRowSetImpl;
import Autotective.entity.Setting;

import javax.sql.rowset.JdbcRowSet;
import java.sql.SQLException;

public class SettingController {
    //JDBC drive name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/autotective";

    //Database credentials
    static final String USER = "root";
    static final String PASS = "testpass";

    private JdbcRowSet rowSet = null;

    public SettingController() {
        try {
            Class.forName(JDBC_DRIVER);
            rowSet = new JdbcRowSetImpl();
            rowSet.setUrl(DB_URL);
            rowSet.setUsername(USER);
            rowSet.setPassword(PASS);
            rowSet.setCommand("select * from setting");
            rowSet.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    //Create Setting
    public Setting create (Setting s) {
        try {
            rowSet.moveToInsertRow();
            rowSet.updateInt("gearNumber", s.getGearNumber());
            rowSet.updateInt("speedLimit", s.getSpeedLimit());
            rowSet.updateInt("testerID", s.getTesterID());
            rowSet.insertRow();
            rowSet.last();
            int newID = rowSet.getInt("settingID");
            s.setSettingID(newID);
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

    //Update Setting
    public Setting update (Setting s) {
        try {
            rowSet.updateInt("settingID", s.getSettingID());
            rowSet.updateInt("gearNumber", s.getGearNumber());
            rowSet.updateInt("speedLimit", s.getSpeedLimit());
            rowSet.updateInt("testerID", s.getTesterID());
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

    //Retrieve Setting
    public Setting currSession() {
        Setting s = new Setting();
        try {
            rowSet.moveToCurrentRow();
            rowSet.setInt("settingID", s.getSettingID());
            rowSet.setInt("gearNumber", s.getGearNumber());
            rowSet.setInt("speedLimit", s.getSpeedLimit());
            rowSet.setInt("testerID", s.getTesterID());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    //Delete Setting
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
