package com.northwind.shipping.repository;

import com.northwind.shipping.SqlStatements;
import com.northwind.shipping.model.PackingSlip;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositoryImpl implements Repository {

    private DataSource dataSource;
    private SqlStatements sqlStatements;



    public RepositoryImpl(DataSource dataSource, SqlStatements sqlStatements) {
        this.dataSource = dataSource;
        this.sqlStatements = sqlStatements;
    }



    @Override
    public List<PackingSlip> getPackingSlipDetails() throws SQLException {
        Connection conn = null;
        String sql = sqlStatements.sql;
        conn= dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery(sql);
        List<PackingSlip> packingSlipList = new ArrayList<>();
        while(rs.next()){
            PackingSlip  packingSlip = new PackingSlip();
            packingSlip.setId(rs.getInt("PackingSlipID"));
            packingSlip.setOrderNo(rs.getInt("OrderID"));
            packingSlip.setShipAddress(rs.getString("ShipAddress"));
            packingSlip.setShipCity(rs.getString("ShipCity"));
            packingSlip.setShipPostalCode(rs.getString("ShipPostalCode"));
            packingSlip.setShipCountry(rs.getString("ShipCountry"));
            packingSlipList.add(packingSlip);
        }

        return packingSlipList;


    }

    @Override
    public String deletePackingSlipDetails(@PathVariable long id) throws SQLException {
        Connection conn = null;
        String Sql = sqlStatements.sql2;
        conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(Sql);
        ps.setLong(1, id);
        boolean rs = ps.execute();
        String Statement = null;
        if(rs = true){
            Statement = "Shipping Detail is Deleted";
        }
        else{
            Statement = "Shipping Detail is not Deleted Please Check your Code";
        }


            return Statement;
    }
}
