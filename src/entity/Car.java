package entity;

/**
 * Created by Mitchell Chan on 2018-03-23.
 */
public class Car {
    private int carID;
    private Boolean tested;

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public Boolean isTested() {
        return tested;
    }

    public void setTested(Boolean tested) {
        this.tested = tested;
    }
}
