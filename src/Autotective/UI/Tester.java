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
@Table(name = "tester", catalog = "Autotective", schema = "")
@NamedQueries({
    @NamedQuery(name = "Tester.findAll", query = "SELECT t FROM Tester t")
    , @NamedQuery(name = "Tester.findByTesterID", query = "SELECT t FROM Tester t WHERE t.testerID = :testerID")
    , @NamedQuery(name = "Tester.findByFullName", query = "SELECT t FROM Tester t WHERE t.fullName = :fullName")})
public class Tester implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "testerID")
    private Integer testerID;
    @Column(name = "fullName")
    private String fullName;

    public Tester() {
    }

    public Tester(Integer testerID) {
        this.testerID = testerID;
    }

    public Integer getTesterID() {
        return testerID;
    }

    public void setTesterID(Integer testerID) {
        Integer oldTesterID = this.testerID;
        this.testerID = testerID;
        changeSupport.firePropertyChange("testerID", oldTesterID, testerID);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        String oldFullName = this.fullName;
        this.fullName = fullName;
        changeSupport.firePropertyChange("fullName", oldFullName, fullName);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (testerID != null ? testerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tester)) {
            return false;
        }
        Tester other = (Tester) object;
        if ((this.testerID == null && other.testerID != null) || (this.testerID != null && !this.testerID.equals(other.testerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Autotective.UI.Tester[ testerID=" + testerID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
