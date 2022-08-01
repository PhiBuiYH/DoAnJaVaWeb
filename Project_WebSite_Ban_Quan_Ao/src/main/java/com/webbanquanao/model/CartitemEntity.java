package com.webbanquanao.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cartitem", schema = "web_ban_quan_ao")
public class CartitemEntity {
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "sku_id")
    private SkuEntity skuEntity;

    public SkuEntity getSkuEntity(){ return skuEntity; }

    public void setSkuEntity(SkuEntity skuEntity){ this.skuEntity = skuEntity; }

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private CartEntity cartEntity;

    public CartEntity getCartEntity() {
        return cartEntity;
    }

    public void setCartEntity(CartEntity cartEntity) {
        this.cartEntity = cartEntity;
    }

    //    @Id
//    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //    @Basic
//    @Column(name = "quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartitemEntity that = (CartitemEntity) o;
        return id == that.id &&
                Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity);
    }
}
