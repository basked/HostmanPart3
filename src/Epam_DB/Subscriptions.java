/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Epam_DB;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(catalog = "epam_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subscriptions.findAll", query = "SELECT s FROM Subscriptions s")
    , @NamedQuery(name = "Subscriptions.findBySbId", query = "SELECT s FROM Subscriptions s WHERE s.sbId = :sbId")
    , @NamedQuery(name = "Subscriptions.findBySbStart", query = "SELECT s FROM Subscriptions s WHERE s.sbStart = :sbStart")
    , @NamedQuery(name = "Subscriptions.findBySbFinish", query = "SELECT s FROM Subscriptions s WHERE s.sbFinish = :sbFinish")
    , @NamedQuery(name = "Subscriptions.findBySbIsActive", query = "SELECT s FROM Subscriptions s WHERE s.sbIsActive = :sbIsActive")})
public class Subscriptions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sb_id", nullable = false)
    private Integer sbId;
    @Basic(optional = false)
    @Column(name = "sb_start", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date sbStart;
    @Basic(optional = false)
    @Column(name = "sb_finish", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date sbFinish;
    @Basic(optional = false)
    @Column(name = "sb_is_active", nullable = false, length = 2)
    private String sbIsActive;
    @JoinColumn(name = "sb_book", referencedColumnName = "b_id", nullable = false)
    @ManyToOne(optional = false)
    private Books sbBook;
    @JoinColumn(name = "sb_subscriber", referencedColumnName = "s_id", nullable = false)
    @ManyToOne(optional = false)
    private Subscribers sbSubscriber;

    public Subscriptions() {
    }

    public Subscriptions(Integer sbId) {
        this.sbId = sbId;
    }

    public Subscriptions(Integer sbId, Date sbStart, Date sbFinish, String sbIsActive) {
        this.sbId = sbId;
        this.sbStart = sbStart;
        this.sbFinish = sbFinish;
        this.sbIsActive = sbIsActive;
    }

    public Integer getSbId() {
        return sbId;
    }

    public void setSbId(Integer sbId) {
        this.sbId = sbId;
    }

    public Date getSbStart() {
        return sbStart;
    }

    public void setSbStart(Date sbStart) {
        this.sbStart = sbStart;
    }

    public Date getSbFinish() {
        return sbFinish;
    }

    public void setSbFinish(Date sbFinish) {
        this.sbFinish = sbFinish;
    }

    public String getSbIsActive() {
        return sbIsActive;
    }

    public void setSbIsActive(String sbIsActive) {
        this.sbIsActive = sbIsActive;
    }

    public Books getSbBook() {
        return sbBook;
    }

    public void setSbBook(Books sbBook) {
        this.sbBook = sbBook;
    }

    public Subscribers getSbSubscriber() {
        return sbSubscriber;
    }

    public void setSbSubscriber(Subscribers sbSubscriber) {
        this.sbSubscriber = sbSubscriber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sbId != null ? sbId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subscriptions)) {
            return false;
        }
        Subscriptions other = (Subscriptions) object;
        if ((this.sbId == null && other.sbId != null) || (this.sbId != null && !this.sbId.equals(other.sbId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Epam_DB.Subscriptions[ sbId=" + sbId + " ]";
    }
    
}
