package com.ljr.domain;

import java.util.Date;

public class Sale {
    private Integer id;
    private Integer ItemID;
    private Integer quantity;
    private String commodity ;
    private double Totalamount ;
    private String time ;


    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", ItemID=" + ItemID +
                ", quantity=" + quantity +
                ", commodity='" + commodity + '\'' +
                ", Totalamount=" + Totalamount +
                ", time='" + time + '\'' +
                '}';
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemID() {
        return ItemID;
    }

    public void setItemID(Integer itemID) {
        ItemID = itemID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public double getTotalAmount() {
        return Totalamount;
    }

    public void setTotalAmount(double totalAmount) {
        Totalamount = totalAmount;
    }
}
