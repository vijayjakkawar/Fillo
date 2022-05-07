package Fillo;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class Select_With_Where_Like_condition {

    public static void main(String[] args) throws FilloException {

        Fillo fillo=new Fillo();
        Connection con=fillo.getConnection("C://Users//hp//Desktop//testing study doc//Apache POI//loginData.xlsx");


        String Query="Select * from Sheet1 where password = 'admin'";
        Recordset rs=con.executeQuery(Query);

        // Second Way of Executing query
         rs=con.executeQuery("select * from sheet1").where("password='admin123'");


        while (rs.next())
        {
            System.out.println(rs.getField("username")+"  "+rs.getField("password")+"  "+rs.getField("res")+"  ");
        }

        rs.close();
        con.close();



    }
}
