package com.webbanquanao.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "promotion", schema = "web_ban_quan_ao", catalog = "")
public class PromotionEntity {
    private String newId;
    private String newName;
    private Date dateCreate;
    private String newCategory;
    private Date dateOpen;
    private Date dateClose;

    @Id
    @Column(name = "new_id")
    public String getNewId() {
        return newId;
    }

    public void setNewId(String newId) {
        this.newId = newId;
    }

    @Basic
    @Column(name = "new_name")
    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    @Basic
    @Column(name = "date_create")
    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Basic
    @Column(name = "new_category")
    public String getNewCategory() {
        return newCategory;
    }

    public void setNewCategory(String newCategory) {
        this.newCategory = newCategory;
    }

    @Basic
    @Column(name = "date_open")
    public Date getDateOpen() {
        return dateOpen;
    }

    public void setDateOpen(Date dateOpen) {
        this.dateOpen = dateOpen;
    }

    @Basic
    @Column(name = "date_close")
    public Date getDateClose() {
        return dateClose;
    }

    public void setDateClose(Date dateClose) {
        this.dateClose = dateClose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PromotionEntity that = (PromotionEntity) o;
        return Objects.equals(newId, that.newId) &&
                Objects.equals(newName, that.newName) &&
                Objects.equals(dateCreate, that.dateCreate) &&
                Objects.equals(newCategory, that.newCategory) &&
                Objects.equals(dateOpen, that.dateOpen) &&
                Objects.equals(dateClose, that.dateClose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newId, newName, dateCreate, newCategory, dateOpen, dateClose);
    }
}
