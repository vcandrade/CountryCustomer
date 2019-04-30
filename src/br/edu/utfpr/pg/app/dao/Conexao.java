
package br.edu.utfpr.pg.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Vinicius 
 * vcandrade@utfpr.edu.br
 */

public class Conexao {

    private static Connection conn;
    private final String driver;
    private final String usuario;
    private final String senha;
    private final String url;

    public Conexao() {
        
        driver = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/countrycustomer";
        usuario = "root";
        senha = "";
    }

    public Connection conectar() throws ClassNotFoundException, SQLException {
        
        conn = null;
        Class.forName(driver);
        conn = DriverManager.getConnection(url, usuario, senha);        
        
        return conn;
    }
}

