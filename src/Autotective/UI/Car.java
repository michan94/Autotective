/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Autotective.UI;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author ege
 */
@Entity
@Table(name = "car", catalog = "Autotective", schema = "")
@NamedQueries({
    @NamedQuery(name = "Car.findAll", query = "SELECT c FROM Car c")
    , @NamedQuery(name = "Car.findByCarID", query = "SELECT c FROM Car c WHERE c.carID = :carID")
    , @NamedQuery(name = "Car.findByTested", query = "SELECT c FROM Car c WHERE c.tested = :tested")})
public class Car implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "carID")
    private Integer carID;
    @Basic(optional = false)
    @Column(name = "tested")
    private String tested;

    public Car() {
    }

    public Car(Integer carID) {
        this.carID = carID;
    }

    public Car(Integer carID, String tested) {
        this.carID = carID;
        this.tested = tested;
    }

    public Integer getCarID() {
        return carID;
    }

    public void setCarID(Integer carID) {
        Integer oldCarID = this.carID;
        this.carID = carID;
        changeSupport.firePropertyChange("carID", oldCarID, carID);
    }

    public String getTested() {
        return tested;
    }

    public void setTested(String tested) {
        String oldTested = this.tested;
        this.tested = tested;
        changeSupport.firePropertyChange("tested", oldTested, tested);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carID != null ? carID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Car)) {
            return false;
        }
        Car other = (Car) object;
        if ((this.carID == null && other.carID != null) || (this.carID != null && !this.carID.equals(other.carID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Autotective.UI.Car[ carID=" + carID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
