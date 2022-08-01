package com.webbanquanao.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cart", schema = "web_ban_quan_ao")
public class CartEntity {
    @Id
    @Column(name = "id")
    private int id = 0;
    @Basic
    @Column(name = "buyDate")
    private Date buyDate;

    @Basic
    @Column(name = "note")
    private String note;

    @Basic
    @Column(name = "action")
    private Boolean action;

    @Basic
    @Column(name = "status")
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<CartitemEntity> cartitemEntities;

    @ManyToOne
    @JoinColumn(name = "u_id")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "c_id")
    private CustomerEntity customerEntity;

    //   @Id
    //   @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //    @Basic
//    @Column(name = "buyDate")
    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public String getNote() { return note; }

    public void setNote(String note) { this.note = note; }

    //    @Basic
//    @Column(name = "action")
    public Boolean getAction() {
        return action;
    }

    public void setAction(Boolean action) {
        this.action = action;
    }

    public List<CartitemEntity> getCartitemEntities() { return cartitemEntities; }

    public void setCartitemEntities(List<CartitemEntity> cartitemEntities) { this.cartitemEntities = cartitemEntities; }

    public UserEntity getUserEntity() { return userEntity; }

    public void setUserEntity(UserEntity userEntity) { this.userEntity = userEntity; }

    public CustomerEntity getCustomerEntity() { return customerEntity; }

    public void setCustomerEntity(CustomerEntity customerEntity) { this.customerEntity = customerEntity; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartEntity that = (CartEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(buyDate, that.buyDate) &&
                Objects.equals(note, that.note) &&
                Objects.equals(action, that.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, buyDate, note, action);
    }
}
