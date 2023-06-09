public class Runner {
    public static void main(String[] args) {
        //1. Step: Create the connection
        JdbcUtils.connectToDatabase("localhost","Techpro","postgres","bursa16isvec46");
        //2. Step: Create Statement
        JdbcUtils.createStatement();

        //3. Step: Execute Query
        JdbcUtils.execute("CREATE TABLE workers( worker_id INT, worker_name VARCHAR(30), worker_salary SMALLINT)");
        JdbcUtils.dropTable("workers");
        //4. Step: Close Connection and Statement
        JdbcUtils.closeConnectionAndStatement();
    }
}
