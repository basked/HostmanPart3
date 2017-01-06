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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    @NamedQuery(name = "Authors.findAll", query = "SELECT a FROM Authors a")
    , @NamedQuery(name = "Authors.findByAId", query = "SELECT a FROM Authors a WHERE a.aId = :aId")
    , @NamedQuery(name = "Authors.findByAName", query = "SELECT a FROM Authors a WHERE a.aName = :aName")})
public class Authors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "a_id", nullable = false)
    private Integer aId;
    @Basic(optional = false)
    @Column(name = "a_name", nullable = false, length = 150)
    private String aName;
    @JoinTable(name = "m2m_books_authors", joinColumns = {
        @JoinColumn(name = "a_id", referencedColumnName = "a_id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "b_id", referencedColumnName = "b_id", nullable = false)})
    @ManyToMany
    private Collection<Books> booksCollection;

    public Authors() {
    }

    public Authors(Integer aId) {
        this.aId = aId;
    }

    public Authors(Integer aId, String aName) {
        this.aId = aId;
        this.aName = aName;
    }

    public Integer getAId() {
        return aId;
    }

    public void setAId(Integer aId) {
        this.aId = aId;
    }

    public String getAName() {
        return aName;
    }

    public void setAName(String aName) {
        this.aName = aName;
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
        hash += (aId != null ? aId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Authors)) {
            return false;
        }
        Authors other = (Authors) object;
        if ((this.aId == null && other.aId != null) || (this.aId != null && !this.aId.equals(other.aId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Epam_DB.Authors[ aId=" + aId + " ]";
    }
    
}
