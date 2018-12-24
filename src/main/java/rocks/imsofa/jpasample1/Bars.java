/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.imsofa.jpasample1;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "bars")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bars.findAll", query = "SELECT b FROM Bars b")
    , @NamedQuery(name = "Bars.findByName", query = "SELECT b FROM Bars b WHERE b.name = :name")
    , @NamedQuery(name = "Bars.findByAddr", query = "SELECT b FROM Bars b WHERE b.addr = :addr")
    , @NamedQuery(name = "Bars.findByLicense", query = "SELECT b FROM Bars b WHERE b.license = :license")})
public class Bars implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "addr")
    private String addr;
    @Basic(optional = false)
    @Column(name = "license")
    private String license;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bar")
    private Collection<Employee> employeeCollection;

    public Bars() {
    }

    public Bars(String name) {
        this.name = name;
    }

    public Bars(String name, String addr, String license) {
        this.name = name;
        this.addr = addr;
        this.license = license;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    @XmlTransient
    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bars)) {
            return false;
        }
        Bars other = (Bars) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rocks.imsofa.jpasample1.Bars[ name=" + name + " ]";
    }
    
}
