import java.sql.*;

public class ExecuteQuery02 {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro","postgres","bursa16isvec46");
        Statement statement=con.createStatement();
        //1.Example: Find the company and number_of_employees whose number_of_employees is the second highest from the companies table
        //1. Way:
       String sql1="SELECT company,number_of_employees FROM companies ORDER BY number_of_employees DESC OFFSET 1 ROW LIMIT 1";
       ResultSet rs1=statement.executeQuery(sql1);
       while(rs1.next()){
           System.out.println(rs1.getString("company")+" "+rs1.getString("number_of_employees"));
       }
        //2.Example: Find the company names and number of employees whose number of employees is less than the average number of employees
        String sql2="SELECT company,number_of_employees FROM companies WHERE number_of_employees<(SELECT AVG(number_of_employees)  FROM companies)";
       ResultSet rs2=statement.executeQuery(sql2);
       while(rs2.next()){
           System.out.println(rs2.getString("company")+"--"+rs2.getString("number_of_employees"));
       }
        con.close();
        statement.close();
    }
}
