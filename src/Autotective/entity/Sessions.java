package entity;

import java.sql.Time;

/**
 * Created by Mitchell Chan on 2018-03-23.
 */
public class Sessions {
    private int seshID;
    private Time startTime;
    private Time endTime;
    private int testerID;
    private int carID;
    private int settingID;

    public int getSeshID() {
        return seshID;
    }

    public void setSeshID(int seshID) {
        this.seshID = seshID;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
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
