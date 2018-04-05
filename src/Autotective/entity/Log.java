package Autotective.entity;

import java.sql.*;

/**
 * Created by Mitchell Chan on 2018-03-23.
 */
public class Log {
    private int logID;
    private String comment;
    private double latitude;
    private double longitude;
    private int speed;
    private int brake;
    private String typeOf;
    private int seshID;
    
    public Log(int id, String comment, double lat, double lon, int speed, int brake, String typeOf, int seshID) {
        this.logID = id;
        this.comment = comment;
        this.latitude = lat;
        this.longitude = lon;
        this.speed = speed;
        this.brake = brake;
        this.typeOf = typeOf;
        this.seshID = seshID;
    }

    public int getLogID() {
        return logID;
    }

    public void setLogID(int logID) {
        this.logID = logID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getBrake() {
        return brake;
    }

    public void setBrake(int brake) {
        this.brake = brake;
    }

    public String getTypeOf() {
        return typeOf;
    }

    public void setTypeOf(String typeOf) {
        this.typeOf = typeOf;
    }

    public int getSeshID() {
        return seshID;
    }

    public void setSeshID(int seshID) {
        this.seshID = seshID;
    }
}
