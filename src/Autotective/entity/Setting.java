package Autotective.entity;

/**
 * Created by Mitchell Chan on 2018-03-23.
 */
public class Setting {
    private int settingID;
    private int gearNumber;
    private int speedLimit;
    private int testerID;
    
    public Setting(int id, int gear, int speed, int test) {
        this.settingID = id;
        this.gearNumber = gear;
        this.speedLimit = speed;
        this.testerID = test;
    }
    
    public Setting() {
    }

    public int getSettingID() {
        return settingID;
    }

    public void setSettingID(int settingID) {
        this.settingID = settingID;
    }

    public int getGearNumber() {
        return gearNumber;
    }

    public void setGearNumber(int gearNumber) {
        this.gearNumber = gearNumber;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public int getTesterID() {
        return testerID;
    }

    public void setTesterID(int testerID) {
        this.testerID = testerID;
    }
}
