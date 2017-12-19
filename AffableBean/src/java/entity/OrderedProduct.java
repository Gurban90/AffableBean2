/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gerben
 */
@Entity
@Table(name = "ordered_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderedProduct.findAll", query = "SELECT o FROM OrderedProduct o")
    , @NamedQuery(name = "OrderedProduct.findByCustommerOrderId", query = "SELECT o FROM OrderedProduct o WHERE o.custommerOrderId = :custommerOrderId")
    , @NamedQuery(name = "OrderedProduct.findByQuantity", query = "SELECT o FROM OrderedProduct o WHERE o.quantity = :quantity")})
public class OrderedProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "custommer_order_id")
    private Integer custommerOrderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private short quantity;
    @JoinColumn(name = "custommer_order_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private CustommerOrder custommerOrder;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Product productId;

    public OrderedProduct() {
    }

    public OrderedProduct(Integer custommerOrderId) {
        this.custommerOrderId = custommerOrderId;
    }

    public OrderedProduct(Integer custommerOrderId, short quantity) {
        this.custommerOrderId = custommerOrderId;
        this.quantity = quantity;
    }

    public Integer getCustommerOrderId() {
        return custommerOrderId;
    }

    public void setCustommerOrderId(Integer custommerOrderId) {
        this.custommerOrderId = custommerOrderId;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public CustommerOrder getCustommerOrder() {
        return custommerOrder;
    }

    public void setCustommerOrder(CustommerOrder custommerOrder) {
        this.custommerOrder = custommerOrder;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (custommerOrderId != null ? custommerOrderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderedProduct)) {
            return false;
        }
        OrderedProduct other = (OrderedProduct) object;
        if ((this.custommerOrderId == null && other.custommerOrderId != null) || (this.custommerOrderId != null && !this.custommerOrderId.equals(other.custommerOrderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OrderedProduct[ custommerOrderId=" + custommerOrderId + " ]";
    }
    
}
