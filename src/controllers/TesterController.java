package controllers;

import com.sun.rowset.JdbcRowSetImpl;
import entity.Tester;

import javax.sql.rowset.JdbcRowSet;
import java.sql.SQLException;

public class TesterController {
    //JDBC drive name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/Autotective";

    //Database credentials
    static final String USER = "tester";
    static final String PASS = "setting";

    private JdbcRowSet rowSet = null;

    public TesterController() {
        try {
            Class.forName(JDBC_DRIVER);
            rowSet = new JdbcRowSetImpl();
            rowSet.setUrl(DB_URL);
            rowSet.setUsername(USER);
            rowSet.setPassword(PASS);
            rowSet.setCommand("select * from tester");
            rowSet.execute();
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Create new Tester
    public Tester create (Tester t) {
        try {
            rowSet.moveToInsertRow();
            rowSet.updateInt("testerID", t.getTesterID());
            rowSet.updateString("name", t.getName());
            rowSet.insertRow();
            rowSet.moveToCurrentRow();
        } catch (SQLException e) {
            try {
                rowSet.rollback();
                t = null;
            } catch (SQLException e1) {
                e1.printStackTrace();
                return null;
            }
        }
        return t;
    }

    //Update Tester
    public Tester update (Tester t) {
        try {
            rowSet.updateInt("testerID", t.getTesterID());
            rowSet.updateString("name", t.getName());
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
        return t;
    }

    //Retrieve Tester
    public Tester currTester() {
        Tester t = new Tester();
        try {
            rowSet.moveToCurrentRow();
            t.setTesterID(rowSet.getInt("testerID"));
            t.setName(rowSet.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }

    //Delete Tester
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

