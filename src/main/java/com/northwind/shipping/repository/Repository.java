package com.northwind.shipping.repository;

import com.northwind.shipping.model.PackingSlip;

import java.sql.SQLException;
import java.util.List;

public interface Repository
{
    public List<PackingSlip> getPackingSlipDetails() throws SQLException;
    public String deletePackingSlipDetails(long id) throws SQLException;
    PackingSlip getPackingSlipById(long id) throws SQLException;
    public String updatePackingSlips(PackingSlip packingSlip) throws SQLException;
}
