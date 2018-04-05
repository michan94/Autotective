package Autotective.controller;

import Autotective.UI.AddTesterUI;
import com.sun.rowset.JdbcRowSetImpl;
import Autotective.entity.Tester;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import javax.sql.rowset.JdbcRowSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class TesterController {
    //JDBC drive name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   // static final String DB_URL = "jdbc:mysql://localhost:3306/Autotective?autoReconnect=true&useSSL=false";
    static final String DB_URL = "jdbc:mysql://localhost:3306/autotective";

    //Database credentials
    static final String USER = "root";
    static final String PASS = "testpass";

    public JdbcRowSet rowSet = null;

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
    public void create (Tester t, AddTesterUI ui) {
        try {
            rowSet.moveToInsertRow();
            rowSet.updateInt("testerID", t.getTesterID());
            rowSet.updateString("fullName", t.getName());
            rowSet.insertRow();
            rowSet.moveToCurrentRow();
            
            reQuery();
            createTable(ui);
            
        } 
 
        catch (SQLException e) {
            // throw it for the duplicate id
            JOptionPane.showMessageDialog(null, "Duplicate ID is not allowed.");
            
            try {
                rowSet.setAutoCommit(false);
                rowSet.rollback();
                rowSet.setAutoCommit(true);
              
            } catch (SQLException e1) {
                e1.printStackTrace();
                // return null;
            }
            e.printStackTrace();
            // return t;
        }
         
        
        
    }
    
    
    // Do basic query again
    public void reQuery(){
        try {
            rowSet.setCommand("select * from tester");
            rowSet.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            
    
    }

    //Update Tester
    public Tester update (Tester t) {
        try {
            rowSet.updateInt("testerID", t.getTesterID());
            rowSet.updateString("fullName", t.getName());
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
            t.setName(rowSet.getString("fullName"));
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
    
    
    // Creates the table for the addTesterUI
    // you need to know how many columns that rowSet's table has
    // so that in each while iteration you addRow to the tester table
    // getString argument MUST MATCH with the query's column names
    // 
    // *** only use try and catch and do not include throws Exception to do method
    //      definiton
    
    public void createTable(AddTesterUI addTesterUI){
        
    DefaultTableModel testerTable = new DefaultTableModel(new String[] 
    {"Tester ID", "Name"},0);
    
    // while there is a row, get the data and add it as a row to the table
    try{
    while(rowSet.next()){
      
    int id = rowSet.getInt("testerID");
    String nm = rowSet.getString("fullName");
    testerTable.addRow(new Object[]{id, nm});
    }
    }
    catch(SQLException e1){
        JOptionPane.showMessageDialog(addTesterUI.getMostRecentFocusOwner(), ""
                + "Something went wrong!");
    }
    
    // sets the model of the addTesterUI's table with what it has created
    addTesterUI.testersTable.setModel(testerTable);
    }


}

