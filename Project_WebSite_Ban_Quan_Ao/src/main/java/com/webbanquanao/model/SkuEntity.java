package com.webbanquanao.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sku", schema = "web_ban_quan_ao", catalog = "")
public class SkuEntity {
    @Id
    @Column(name = "SKU_id")
    private int skuId;
    @Basic
    @Column(name = "quantity")
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "color_id")
    private ColorEntity colorEntity;

    @ManyToOne
    @JoinColumn(name = "size_id")
    private SizeEntity sizeEntity;
    @ManyToOne
    @JoinColumn(name = "pro_id")
    private ProductEntity productEntity;

    public ColorEntity getColorEntity() {
        return colorEntity;
    }

    public void setColorEntity(ColorEntity colorEntity) {
        this.colorEntity = colorEntity;
    }

    public SizeEntity getSizeEntity() {
        return sizeEntity;
    }

    public void setSizeEntity(SizeEntity sizeEntity) {
        this.sizeEntity = sizeEntity;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }


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
        SkuEntity skuEntity = (SkuEntity) o;
        return skuId == skuEntity.skuId &&
                Objects.equals(quantity, skuEntity.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skuId, quantity);
    }
}
