package Fillo;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.apache.commons.collections4.functors.WhileClosure;

import java.util.ArrayList;
import java.util.List;

public class ReadingDataUsingFillo {

    public static void main(String[] args) throws FilloException {

        Fillo fillo=new Fillo();
        Connection con=fillo.getConnection("C://Users//hp//Desktop//testing study doc//Apache POI//loginData.xlsx");

        String Query="Select * from Sheet1";
        Recordset rs=con.executeQuery(Query);

        List<String> data= new ArrayList<String>();


    // to print All the Excel Data
        while (rs.next())
        {
            System.out.println(rs.getField("username")+"  "+rs.getField("password")+"  "+rs.getField("res")+"  ");
        data.add(rs.getField("username"));
        }

        // to read the data from the List

        System.out.println("First user Name From the List"+"  "+data.get(0));

        // to print the size of the rows in sheet
        System.out.println(" Total No Of Rows"+rs.getCount());

        // to print the first rows Data in sheet
        rs.moveFirst();
        System.out.println(rs.getField("username")+"  "+rs.getField("password")+"  "+rs.getField("res")+"  ");

        // to print the next rows Data in sheet
        rs.moveNext();
        System.out.println(rs.getField("username")+"  "+rs.getField("password")+"  "+rs.getField("res")+"  ");

        // to print the Last rows Data in sheet
        rs.moveLast();
        System.out.println(rs.getField("username")+"  "+rs.getField("password")+"  "+rs.getField("res")+"  ");

        // to print the previous rows Data in sheet
        rs.movePrevious();
        System.out.println(rs.getField("username")+"  "+rs.getField("password")+"  "+rs.getField("res")+"  ");

        // to get the total  coloumn size in the sheet
        int totalcols=rs.getFieldNames().size(); // 3
        System.out.println(totalcols);

        // to get the total  coloumn names
        String first_col_names=rs.getFieldNames().get(0);
        System.out.println(first_col_names);

        // close the connection
        rs.close();
        con.close();


    }
}
