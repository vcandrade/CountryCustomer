/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.utfpr.pg.app.dao;

import br.edu.utfpr.pg.app.entity.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Vinicius
 */
public class CustomerDAO {

    public void create(Customer customer) throws ClassNotFoundException, SQLException {
        
        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            Conexao conexao = new Conexao();
            conn = conexao.conectar();

            stmt = conn.prepareStatement("INSERT INTO customer(name, phone, age, country) VALUES(?, ?, ?, ?)");
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getPhone());
            stmt.setInt(3, customer.getAge());
            stmt.setInt(4, customer.getCountry().getId());

            stmt.execute();

        } finally {

            if ((stmt != null) && !stmt.isClosed()) {
                stmt.close();
            }
            if ((conn != null) && !conn.isClosed()) {
                conn.close();
            }
        }
    }

    public ArrayList<Customer> read() throws ClassNotFoundException, SQLException {

        ArrayList<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customer";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            Conexao conexao = new Conexao();
            conn = conexao.conectar();

            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                Customer customer = new Customer();
                
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setPhone(rs.getString("phone"));
                customer.setAge(rs.getInt("age"));
                customer.getCountry().setId(rs.getInt("country"));

                customers.add(customer);
            }

            return customers;

        } finally {

            if ((rs != null) && !rs.isClosed()) {
                rs.close();
            }
            if ((stmt != null) && !stmt.isClosed()) {
                stmt.close();
            }
            if ((conn != null) && !conn.isClosed()) {
                conn.close();
            }
        }
    }

    public void update(Customer customer) throws ClassNotFoundException, SQLException {
        
        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            Conexao conexao = new Conexao();
            conn = conexao.conectar();

            stmt = conn.prepareStatement("UPDATE customer SET name = ?, phone = ?, age = ?, country = ? WHERE id = ?");
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getPhone());
            stmt.setInt(3, customer.getAge());
            stmt.setInt(4, customer.getCountry().getId());
            stmt.setInt(5, customer.getId());

            stmt.execute();

        } finally {

            if ((stmt != null) && !stmt.isClosed()) {
                stmt.close();
            }
            if ((conn != null) && !conn.isClosed()) {
                conn.close();
            }
        }
    }

    public void delete(int id) throws ClassNotFoundException, SQLException {
        
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            Conexao conexao = new Conexao();
            conn = conexao.conectar();

            stmt = conn.prepareStatement("DELETE FROM customer WHERE id = ?");
            stmt.setInt(1, id);

            stmt.execute();

        } finally {

            if ((stmt != null) && !stmt.isClosed()) {
                stmt.close();
            }
            if ((conn != null) && !conn.isClosed()) {
                conn.close();
            }
        }
    }
}
