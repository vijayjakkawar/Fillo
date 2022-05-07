package Fillo;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class Select_With_Where_Condition {


    public static void main(String[] args) throws FilloException {

        Fillo fillo=new Fillo();
        Connection con=fillo.getConnection("C://Users//hp//Desktop//testing study doc//Apache POI//loginData.xlsx");

        // one Way of executing the query

       /* String Query="Select * from Sheet1 where password = 'admin'";
        Recordset rs=con.executeQuery(Query);*/

        // Second Way of Executing query
        Recordset rs=con.executeQuery("select * from sheet1").where("password='admin123'");


        while (rs.next())
        {
            System.out.println(rs.getField("username")+"  "+rs.getField("password")+"  "+rs.getField("res")+"  ");
        }

        System.out.println("***********************************************");


        // printing data using multiple where condition

         String Query="Select * from Sheet1 where password = 'admin' and res='valid'";
         rs=con.executeQuery(Query);

        while (rs.next())
        {
            System.out.println(rs.getField("username")+"  "+rs.getField("password")+"  "+rs.getField("res")+"  ");
        }
















    }


}
