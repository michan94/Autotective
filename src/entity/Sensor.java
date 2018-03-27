package entity;

/**
 * Created by Mitchell Chan on 2018-03-23.
 */
public class Sensor {
    private String sensType;
    private Boolean status;
    private int carID;

    public String getSensType() {
        return sensType;
    }

    public void setSensType(String sensType) {
        this.sensType = sensType;
    }

    public Boolean isStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }
}
