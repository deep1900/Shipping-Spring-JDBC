package com.northwind.shipping.model;

//
//+id:long {readonly}
//        +productName:string {len > 0, len <= 60, !whitespace, required}
//        +Quantity:int { len <= 30, !whitespace }

import com.fasterxml.jackson.annotation.JsonProperty;

public class PackingSlipDetails {
    @JsonProperty
    private int id;
    @JsonProperty
    private String productName;
    @JsonProperty
    private int quantity;

    public PackingSlipDetails() {
    }

    public PackingSlipDetails(int id, String productName, int quantity) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "PackingSlipDetails{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
