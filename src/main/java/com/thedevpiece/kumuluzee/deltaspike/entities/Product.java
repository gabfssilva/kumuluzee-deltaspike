package com.thedevpiece.kumuluzee.deltaspike.entities;

import com.thedevpiece.kumuluzee.deltaspike.entities.base.EntityResource;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author Gabriel Francisco <gabfssilva@gmail.com>
 */
@Entity
@Table(name = "products")
public class Product extends EntityResource<Product> {
    @Column
    private String description;
    @Column
    private BigDecimal value;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return id != null ? id.equals(product.id) : product.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public String resourceName() {
        return "product";
    }
}
