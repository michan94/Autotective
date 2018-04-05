package Autotective.entity;

/**
 * Created by Mitchell Chan on 2018-03-23.
 */
public class Car {
    private int carID;
    private boolean tested;
    
    public Car(int carID, boolean tested) {
        this.carID = carID;
        this.tested = tested;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }


    public boolean getTested() {
        return tested;
    }

    public void setTested(boolean tested) {
        this.tested = tested;
    }
}
