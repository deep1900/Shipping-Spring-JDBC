package com.northwind.shipping.repository;

import com.northwind.shipping.SqlStatements;
import com.northwind.shipping.model.PackingSlip;
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
        String sqlToFindPackage = sqlStatements.sql3;
        String statement;
        conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(sqlToFindPackage);
        ps.setLong(1,id);
        ResultSet resultSet = ps.executeQuery();
        if(!resultSet.next()){
            statement = "404";
            conn.close();
            return statement;
        }

        else{
            PreparedStatement ps1 = conn.prepareStatement(Sql);
            ps1.setLong(1,id);
            boolean rs = ps1.execute();
            if(rs=true){
                statement = "200";
            }
            else{
                statement="500";
            }
            conn.close();
            return statement;
        }


    }

    @Override
    public PackingSlip getPackingSlipById(long id) throws SQLException {
        Connection conn = null;
        String sql = SqlStatements.sql3;
        conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        PackingSlip  packingSlip = new PackingSlip();
        while (rs.next()){
            packingSlip.setId(rs.getInt("PackingSlipID"));
            packingSlip.setOrderNo(rs.getInt("OrderID"));
            packingSlip.setShipAddress(rs.getString("ShipAddress"));
            packingSlip.setShipCity(rs.getString("ShipCity"));
            packingSlip.setShipPostalCode(rs.getString("ShipPostalCode"));
            packingSlip.setShipCountry(rs.getString("ShipCountry"));
        }
            return packingSlip;
    }
}
