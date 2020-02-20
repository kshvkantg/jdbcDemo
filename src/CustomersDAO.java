import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class CustomersDAO {
    public Customers getCustomerName(int rollNo){
        Customers s = new Customers();
        s.customerId = rollNo;
        s.customerName = "";
        try {
           String url = "jdbc:mysql://localhost:3306/mysql?verifyServerCertificate=false&useSSL=true";
           String uName = "root";
           String pass = "Kshv@wrkfr28";
           String query = "SELECT * from Customers";
           String insertQuery = "INSERT INTO Customers (CustomerID,CustomerName, ContactName, Address, City, PostalCode, Country) " +
                   "VALUES (4,'keshav kant','kshv','1637/11 mahavirNAgar','ambala','134003','India')";

           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection(url, uName, pass);
           Statement st = con.createStatement();
           st.executeUpdate(insertQuery);
           ResultSet rs = st.executeQuery(query);

           while (rs.next()) {
               String name = rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4)
                       + " " + rs.getString(5) + " " + rs.getInt(6) + " " + rs.getString(7);
               System.out.println(name);
           }

           return s;
       }
       catch (Exception e){
           System.out.println(e);
       }
       return s;
    }
}
