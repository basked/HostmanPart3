/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Epam_DB;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(catalog = "epam_db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"g_name"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Genres.findAll", query = "SELECT g FROM Genres g")
    , @NamedQuery(name = "Genres.findByGId", query = "SELECT g FROM Genres g WHERE g.gId = :gId")
    , @NamedQuery(name = "Genres.findByGName", query = "SELECT g FROM Genres g WHERE g.gName = :gName")})
public class Genres implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "g_id", nullable = false)
    private Integer gId;
    @Basic(optional = false)
    @Column(name = "g_name", nullable = false, length = 150)
    private String gName;
    @ManyToMany(mappedBy = "genresCollection")
    private Collection<Books> booksCollection;

    public Genres() {
    }

    public Genres(Integer gId) {
        this.gId = gId;
    }

    public Genres(Integer gId, String gName) {
        this.gId = gId;
        this.gName = gName;
    }

    public Integer getGId() {
        return gId;
    }

    public void setGId(Integer gId) {
        this.gId = gId;
    }

    public String getGName() {
        return gName;
    }

    public void setGName(String gName) {
        this.gName = gName;
    }

    @XmlTransient
    public Collection<Books> getBooksCollection() {
        return booksCollection;
    }

    public void setBooksCollection(Collection<Books> booksCollection) {
        this.booksCollection = booksCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gId != null ? gId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genres)) {
            return false;
        }
        Genres other = (Genres) object;
        if ((this.gId == null && other.gId != null) || (this.gId != null && !this.gId.equals(other.gId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Epam_DB.Genres[ gId=" + gId + " ]";
    }
    
}
