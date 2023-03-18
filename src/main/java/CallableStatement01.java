import java.sql.*;

public class CallableStatement01 {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro","postgres","bursa16isvec46");
        Statement statement=con.createStatement();
        //1.Example: Create a function which uses 2 parameters and return the sum of the parameters
        //1st Step: Type code to create function
        String sql1="CREATE OR REPLACE FUNCTION additionF(x NUMERIC,y NUMERIC) RETURNS NUMERIC LANGUAGE plpgsql AS $$ BEGIN RETURN x+y; END$$";
        //2nd Step: Execute the function
        statement.execute(sql1);
        //3rd Step: Prepare the Callable Statement
        CallableStatement cs=con.prepareCall("{? = call additionF(?,?)}");
        //4th Step:Use registerOutParameter() method for result container and use setInt(), setString ... for parameters
        cs.registerOutParameter(1,Types.NUMERIC);
        cs.setInt(2,6);
        cs.setInt(3,4);
        //5th Step: Execute callable statement
        cs.execute();
        //6th Step: Print the result
        System.out.println(cs.getObject(1));
        //2.Example: Create a function which calculates the volume of cone
      String sql2="CREATE OR REPLACE FUNCTION volumeOfCone(r NUMERIC,h NUMERIC) RETURNS NUMERIC LANGUAGE plpgsql AS $$ BEGIN RETURN r*r*h*3.14/3; END$$";
       statement.execute(sql2);
       CallableStatement cs1=con.prepareCall("{? = call volumeOfCone(?,?)}");
       cs1.registerOutParameter(1,Types.NUMERIC);
       cs1.setInt(2,2);
       cs1.setInt(3,6);
       cs1.execute();
        System.out.println(cs1.getObject(1));
        System.out.printf("%.2f",cs1.getObject(1));
        con.close();
        statement.close();
    }
}
