package com.webbanquanao.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "category", schema = "web_ban_quan_ao", catalog = "")
public class CategoryEntity {
    private int cateId;
    private String cateName;

    @Id
    @Column(name = "cate_id")
    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    @Basic
    @Column(name = "cate_name")
    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntity that = (CategoryEntity) o;
        return cateId == that.cateId &&
                Objects.equals(cateName, that.cateName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cateId, cateName);
    }
}
