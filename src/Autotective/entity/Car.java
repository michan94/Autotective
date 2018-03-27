package entity;

/**
 * Created by Mitchell Chan on 2018-03-23.
 */
public class Car {
    private int carID;
    private String tested;

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String isTested() {
        return tested;
    }

    public void setTested(String tested) {
        this.tested = tested;
    }
}
