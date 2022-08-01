package com.webbanquanao.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "size", schema = "web_ban_quan_ao", catalog = "")
public class SizeEntity {
    private int sizeId;
    private String sizeName;

    @Id
    @Column(name = "Size_id")
    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    @Basic
    @Column(name = "Size_name")
    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SizeEntity that = (SizeEntity) o;
        return sizeId == that.sizeId &&
                Objects.equals(sizeName, that.sizeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sizeId, sizeName);
    }
}
