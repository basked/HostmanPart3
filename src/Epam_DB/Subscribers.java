/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Epam_DB;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(catalog = "epam_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subscribers.findAll", query = "SELECT s FROM Subscribers s")
    , @NamedQuery(name = "Subscribers.findBySId", query = "SELECT s FROM Subscribers s WHERE s.sId = :sId")
    , @NamedQuery(name = "Subscribers.findBySName", query = "SELECT s FROM Subscribers s WHERE s.sName = :sName")})
public class Subscribers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "s_id", nullable = false)
    private Integer sId;
    @Basic(optional = false)
    @Column(name = "s_name", nullable = false, length = 150)
    private String sName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sbSubscriber")
    private Collection<Subscriptions> subscriptionsCollection;

    public Subscribers() {
    }

    public Subscribers(Integer sId) {
        this.sId = sId;
    }

    public Subscribers(Integer sId, String sName) {
        this.sId = sId;
        this.sName = sName;
    }

    public Integer getSId() {
        return sId;
    }

    public void setSId(Integer sId) {
        this.sId = sId;
    }

    public String getSName() {
        return sName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    @XmlTransient
    public Collection<Subscriptions> getSubscriptionsCollection() {
        return subscriptionsCollection;
    }

    public void setSubscriptionsCollection(Collection<Subscriptions> subscriptionsCollection) {
        this.subscriptionsCollection = subscriptionsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sId != null ? sId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subscribers)) {
            return false;
        }
        Subscribers other = (Subscribers) object;
        if ((this.sId == null && other.sId != null) || (this.sId != null && !this.sId.equals(other.sId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Epam_DB.Subscribers[ sId=" + sId + " ]";
    }
    
}
