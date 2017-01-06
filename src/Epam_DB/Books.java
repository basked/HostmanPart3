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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    @NamedQuery(name = "Books.findAll", query = "SELECT b FROM Books b")
    , @NamedQuery(name = "Books.findByBId", query = "SELECT b FROM Books b WHERE b.bId = :bId")
    , @NamedQuery(name = "Books.findByBName", query = "SELECT b FROM Books b WHERE b.bName = :bName")
    , @NamedQuery(name = "Books.findByBYear", query = "SELECT b FROM Books b WHERE b.bYear = :bYear")
    , @NamedQuery(name = "Books.findByBQuantity", query = "SELECT b FROM Books b WHERE b.bQuantity = :bQuantity")})
public class Books implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "b_id", nullable = false)
    private Integer bId;
    @Basic(optional = false)
    @Column(name = "b_name", nullable = false, length = 150)
    private String bName;
    @Basic(optional = false)
    @Column(name = "b_year", nullable = false)
    private short bYear;
    @Basic(optional = false)
    @Column(name = "b_quantity", nullable = false)
    private short bQuantity;
    @JoinTable(name = "m2m_books_genres", joinColumns = {
        @JoinColumn(name = "b_id", referencedColumnName = "b_id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "g_id", referencedColumnName = "g_id", nullable = false)})
    @ManyToMany
    private Collection<Genres> genresCollection;
    @ManyToMany(mappedBy = "booksCollection")
    private Collection<Authors> authorsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sbBook")
    private Collection<Subscriptions> subscriptionsCollection;

    public Books() {
    }

    public Books(Integer bId) {
        this.bId = bId;
    }

    public Books(Integer bId, String bName, short bYear, short bQuantity) {
        this.bId = bId;
        this.bName = bName;
        this.bYear = bYear;
        this.bQuantity = bQuantity;
    }

    public Integer getBId() {
        return bId;
    }

    public void setBId(Integer bId) {
        this.bId = bId;
    }

    public String getBName() {
        return bName;
    }

    public void setBName(String bName) {
        this.bName = bName;
    }

    public short getBYear() {
        return bYear;
    }

    public void setBYear(short bYear) {
        this.bYear = bYear;
    }

    public short getBQuantity() {
        return bQuantity;
    }

    public void setBQuantity(short bQuantity) {
        this.bQuantity = bQuantity;
    }

    @XmlTransient
    public Collection<Genres> getGenresCollection() {
        return genresCollection;
    }

    public void setGenresCollection(Collection<Genres> genresCollection) {
        this.genresCollection = genresCollection;
    }
//basket
    @XmlTransient
    public Collection<Authors> getAuthorsCollection() {
        return authorsCollection;
    }

    public void setAuthorsCollection(Collection<Authors> authorsCollection) {
        this.authorsCollection = authorsCollection;
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
        hash += (bId != null ? bId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Books)) {
            return false;
        }
        Books other = (Books) object;
        if ((this.bId == null && other.bId != null) || (this.bId != null && !this.bId.equals(other.bId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Epam_DB.Books[ bId=" + bId + " ]";
    }

}
