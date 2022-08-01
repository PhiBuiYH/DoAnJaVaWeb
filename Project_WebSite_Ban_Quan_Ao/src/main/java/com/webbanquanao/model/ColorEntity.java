package com.webbanquanao.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "color", schema = "web_ban_quan_ao", catalog = "")
public class ColorEntity {
    private int colorId;
    private String colorName;

    @Id
    @Column(name = "color_id")
    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    @Basic
    @Column(name = "color_name")
    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColorEntity that = (ColorEntity) o;
        return colorId == that.colorId &&
                Objects.equals(colorName, that.colorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colorId, colorName);
    }
}
