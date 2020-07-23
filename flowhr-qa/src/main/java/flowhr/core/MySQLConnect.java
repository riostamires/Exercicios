package flowhr.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnect {

    public static Connection getConnection() throws SQLException {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://192.168.0.68:3306/flowhr?serverTimezone=UTC","admflowhrbd","NTlabsbd@321");
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return connection;
    }

    public static void main(String[] args) throws SQLException {
        MySQLConnect.getConnection();
    }


}
