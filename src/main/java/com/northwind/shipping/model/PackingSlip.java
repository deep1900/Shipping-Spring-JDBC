package com.northwind.shipping.model;

//+id:long {readonly}
//        +shipName:string {len > 0, len <= 50, !whitespace, required}
//        +shipAddess:string { len <= 60, !whitespace }
//        +shipCity:string { len <= 30, !whitespace }
//        +shipRegion:string { len <= 24, !whitespace }
//        +shipPostalCode:string { len <= 24, !whitespace }
//        +shipCountry:string { len <= 24, !whitespace }
//        +orderNo:int

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PackingSlip
{
    @JsonProperty
    private int id;
    @JsonProperty
    private String shipAddress;
    @JsonProperty
    private String shipCity;
    @JsonProperty
    private String shipRegion;
    @JsonProperty
    private String shipPostalCode;
    @JsonProperty
    private String shipCountry;
    @JsonProperty
    private int orderNo;
    @JsonProperty
    private List<PackingSlipDetails> packingSlipDetailsList;

    public PackingSlip() {
    }

    public PackingSlip(int id, String shipAddress, String shipCity, String shipRegion, String shipPostalCode, String shipCountry, int orderNo, List<PackingSlipDetails> packingSlipDetailsList) {
        this.id = id;
        this.shipAddress = shipAddress;
        this.shipCity = shipCity;
        this.shipRegion = shipRegion;
        this.shipPostalCode = shipPostalCode;
        this.shipCountry = shipCountry;
        this.orderNo = orderNo;
        this.packingSlipDetailsList = packingSlipDetailsList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipRegion() {
        return shipRegion;
    }

    public void setShipRegion(String shipRegion) {
        this.shipRegion = shipRegion;
    }

    public String getShipPostalCode() {
        return shipPostalCode;
    }

    public void setShipPostalCode(String shipPostalCode) {
        this.shipPostalCode = shipPostalCode;
    }

    public String getShipCountry() {
        return shipCountry;
    }

    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public List<PackingSlipDetails> getPackingSlipDetailsList() {
        return packingSlipDetailsList;
    }

    public void setPackingSlipDetailsList(List<PackingSlipDetails> packingSlipDetailsList) {
        this.packingSlipDetailsList = packingSlipDetailsList;
    }

    @Override
    public String toString() {
        return "PackingSlip{" +
                "id=" + id +
                ", shipAddress='" + shipAddress + '\'' +
                ", shipCity='" + shipCity + '\'' +
                ", shipRegion='" + shipRegion + '\'' +
                ", shipPostalCode='" + shipPostalCode + '\'' +
                ", shipCountry='" + shipCountry + '\'' +
                ", orderNo=" + orderNo +
                ", packingSlipDetailsList=" + packingSlipDetailsList +
                '}';
    }
}
