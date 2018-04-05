package Autotective.entity;

import java.sql.Time;

/**
 * Created by Mitchell Chan on 2018-03-23.
 */
public class Sessions {
    private int seshID;
    private String startTime;
    private String endTime;
    private int testerID;
    private int carID;
    private int settingID;
    
    public Sessions() {   
    }
    
    public Sessions(int id, String st, String et, int test, int car, int set) {
        this.seshID = id;
        this.startTime = st;
        this.endTime = et;
        this.testerID = test;
        this.carID = car;
        this.settingID = set;
    }

    public int getSeshID() {
        return seshID;
    }

    public void setSeshID(int seshID) {
        this.seshID = seshID;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getTesterID() {
        return testerID;
    }

    public void setTesterID(int testerID) {
        this.testerID = testerID;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public int getSettingID() {
        return settingID;
    }

    public void setSettingID(int settingID) {
        this.settingID = settingID;
    }
}
