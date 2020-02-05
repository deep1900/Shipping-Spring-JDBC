package com.northwind.shipping;

import org.springframework.stereotype.Component;

@Component
public class SqlStatements
{
   public static final  String sql = "SELECT `PackingSlips`.`PackingSlipID`,\n" +
            "    `PackingSlips`.`OrderID`,\n" +
            "    `PackingSlips`.`ShipName`,\n" +
            "    `PackingSlips`.`ShipAddress`,\n" +
            "    `PackingSlips`.`ShipCity`,\n" +
            "    `PackingSlips`.`ShipRegion`,\n" +
            "    `PackingSlips`.`ShipPostalCode`,\n" +
            "    `PackingSlips`.`ShipCountry`,\n" +
            "    `PackingSlips`.`Version`,\n" +
            "    `PackingSlips`.`ObjectID`\n" +
            "FROM `shipping-db`.`PackingSlips`;\n";

   public static final String sql2 = "DELETE FROM `shipping-db`.`PackingSlips`\n" +
           "WHERE PackingSlipID = ?;\n";

   public static final String sql3 = "SELECT * FROM `shipping-db`.PackingSlips where PackingSlipID= ?;\n";
}
