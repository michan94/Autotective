package controllers;

import com.sun.rowset.JdbcRowSetImpl;
import entity.Sessions;

import javax.sql.rowset.JdbcRowSet;
import java.sql.SQLException;

public class SessionsController {
    //JDBC drive name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/Autotective";

    //Database credentials
    static final String USER = "tester";
    static final String PASS = "setting";

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
            rowSet.updateInt("seshID", s.getSeshID());
            rowSet.updateTime("startTime", s.getStartTime());
            rowSet.updateTime("endTime", s.getEndTime());
            rowSet.updateInt("testerID", s.getTesterID());
            rowSet.updateInt("carID", s.getCarID());
            rowSet.updateInt("settingID", s.getSettingID());
            rowSet.insertRow();
            rowSet.moveToCurrentRow();
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

    //Update Sessions
    public Sessions update (Sessions s) {
        try {
            rowSet.updateInt("seshID", s.getSeshID());
            rowSet.updateTime("startTime", s.getStartTime());
            rowSet.updateTime("endTime", s.getEndTime());
            rowSet.updateInt("testerID", s.getTesterID());
            rowSet.updateInt("carID", s.getCarID());
            rowSet.updateInt("settingID", s.getSettingID());
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
            rowSet.setTime("startTime", s.getStartTime());
            rowSet.setTime("endTime", s.getEndTime());
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
}
