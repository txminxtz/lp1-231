package estacionamento;

import java.sql.*;

public class ConnectionFactory {

    String sJdbc = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/db_estacionamento";
    //String url = "jdbc:mysql://localhost/estudante?user=estudante&password=estudante&useSSl=true";
    String user = "root";
    String password = "bts4";

    public ConnectionFactory(){}

    public Connection createConnection() throws SQLException
    {
        try {
        
            Class.forName(sJdbc);
            return DriverManager.getConnection(url, user, password);
            //return DriverManager.getConnection(url);

        }
        catch (ClassNotFoundException e) {
            System.err.println("Conexao nao Estabelecida!");
            e.printStackTrace();
            return null;
        }
    }
}