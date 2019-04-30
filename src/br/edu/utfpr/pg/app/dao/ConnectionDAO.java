package br.edu.utfpr.pg.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Vinicius vcandrade@utfpr.edu.br
 */
public class ConnectionDAO {

    private static ConnectionDAO connectionFactory = null;
    
    private static Connection conn;
    private final String driver;
    private final String user;
    private final String password;
    private final String url;

    private ConnectionDAO() {

        driver = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/countrycustomer";
        user = "root";
        password = "";
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {

        conn = null;
        Class.forName(driver);
        conn = DriverManager.getConnection(url, user, password);

        return conn;
    }

    public static ConnectionDAO getInstance() {
        
        if (connectionFactory == null) {
        
            connectionFactory = new ConnectionDAO();
        }
        
        return connectionFactory;
    }
}
