package entity;

import java.sql.Timestamp;

/**
 * Created by Mitchell Chan on 2018-03-23.
 */
public class Session {
    private int seshID;
    private Timestamp startTime; //Unsure if will work?
    private Timestamp endTime; //Unsure if will work?
    private int testerID;
    private int carID;
    private int settingID;

    public int getSeshID() {
        return seshID;
    }

    public void setSeshID(int seshID) {
        this.seshID = seshID;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
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
