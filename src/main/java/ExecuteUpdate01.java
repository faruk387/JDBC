import java.sql.*;

public class ExecuteUpdate01 {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro","postgres","bursa16isvec46");
        Statement statement=con.createStatement();
        //1.Example: Update the number of employees to 16000 if the number of employees is less than the average number of employees
      String sql1="UPDATE companies SET number_of_employees=16000 WHERE number_of_employees<(SELECT AVG(number_of_employees)  FROM companies)";
      int numOfRowsUpdated=statement.executeUpdate(sql1);
        System.out.println("numOfRowsUpdated "+numOfRowsUpdated);

        String sql2 = "SELECT * FROM companies";
        ResultSet resultSet=statement.executeQuery(sql2);

        while(resultSet.next()){
            System.out.println(resultSet.getString(1)+"--"+resultSet.getString(2)+"--"+resultSet.getString(3));
        }
        con.close();
        statement.close();

    }
}
