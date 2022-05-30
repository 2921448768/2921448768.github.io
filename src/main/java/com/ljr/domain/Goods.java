package com.ljr.domain;

public class Goods {
    private Integer ItemID ;
    private String  commodity ;
    private Integer quantity ;
    private double  price ;

    public Integer getItemNumber() {
        return ItemID;
    }

    public void setItemNumber(Integer itemNumber) {
        ItemID = itemNumber;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
