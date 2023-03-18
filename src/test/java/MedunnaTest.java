import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MedunnaTest {
    /*
   Given
     User connects to the database
     (Host name: medunna.com, Database name: medunna_db, Usename: medunna_user, Password: medunna_pass_987))

   When
     User sends the query to get the names of created_by column from "room" table

   Then
     Verify that there are some rooms created by "john doe".

   And
     User closes the connection
  */
   // User connects to the database
    @Test
    public  void MedunnaTest() {
        // User connects to the database

        JdbcUtils.connectToDatabase("medunna.com","medunna_db","medunna_user","medunna_pass_987");
        JdbcUtils.createStatement();
        List<Object> list= JdbcUtils.getColumnList("room","created_by");

       boolean isExist=list.stream().anyMatch(t->t.equals("john doe"));
       assertTrue(isExist);
       JdbcUtils.closeConnectionAndStatement();

       }



}
