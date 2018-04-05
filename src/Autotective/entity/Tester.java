package Autotective.entity;

/**
 * Created by Mitchell Chan on 2018-03-23.
 */
public class Tester {
    private int testerID;
    private String name;
    
    public Tester(int testerID, String name) {
        this.testerID = testerID;
        this.name = name;
    }

    public Tester() {
    }

    public int getTesterID() {
        return testerID;
    }

    public void setTesterID(int testerID) {
        this.testerID = testerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
