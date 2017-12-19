/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gerben
 */
@Entity
@Table(name = "custommer_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustommerOrder.findAll", query = "SELECT c FROM CustommerOrder c")
    , @NamedQuery(name = "CustommerOrder.findById", query = "SELECT c FROM CustommerOrder c WHERE c.id = :id")
    , @NamedQuery(name = "CustommerOrder.findByAmount", query = "SELECT c FROM CustommerOrder c WHERE c.amount = :amount")
    , @NamedQuery(name = "CustommerOrder.findByDateCreated", query = "SELECT c FROM CustommerOrder c WHERE c.dateCreated = :dateCreated")
    , @NamedQuery(name = "CustommerOrder.findByConfirmedNumber", query = "SELECT c FROM CustommerOrder c WHERE c.confirmedNumber = :confirmedNumber")})
public class CustommerOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private BigDecimal amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Basic(optional = false)
    @NotNull
    @Column(name = "confirmed_number")
    private int confirmedNumber;
    @JoinColumn(name = "custommer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Custommer custommerId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "custommerOrder")
    private OrderedProduct orderedProduct;

    public CustommerOrder() {
    }

    public CustommerOrder(Integer id) {
        this.id = id;
    }

    public CustommerOrder(Integer id, BigDecimal amount, Date dateCreated, int confirmedNumber) {
        this.id = id;
        this.amount = amount;
        this.dateCreated = dateCreated;
        this.confirmedNumber = confirmedNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getConfirmedNumber() {
        return confirmedNumber;
    }

    public void setConfirmedNumber(int confirmedNumber) {
        this.confirmedNumber = confirmedNumber;
    }

    public Custommer getCustommerId() {
        return custommerId;
    }

    public void setCustommerId(Custommer custommerId) {
        this.custommerId = custommerId;
    }

    public OrderedProduct getOrderedProduct() {
        return orderedProduct;
    }

    public void setOrderedProduct(OrderedProduct orderedProduct) {
        this.orderedProduct = orderedProduct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustommerOrder)) {
            return false;
        }
        CustommerOrder other = (CustommerOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CustommerOrder[ id=" + id + " ]";
    }
    
}
