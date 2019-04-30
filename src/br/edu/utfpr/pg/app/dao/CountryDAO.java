/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.utfpr.pg.app.dao;

import br.edu.utfpr.pg.app.entity.Country;
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
public class CountryDAO {
    
    public void create(Country country) throws ClassNotFoundException, SQLException {
        
        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            ConnectionDAO connectionDAO = new ConnectionDAO();
            conn = connectionDAO.getConnection();

            stmt = conn.prepareStatement("INSERT INTO country(name, acronym, phone_digits) VALUES(?, ?, ?)");
            stmt.setString(1, country.getName());
            stmt.setString(2, country.getAcronym());
            stmt.setInt(3, country.getPhoneDigits());

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
    
    public ArrayList<Country> read() throws ClassNotFoundException, SQLException {

        ArrayList<Country> countries = new ArrayList<>();
        String sql = "SELECT * FROM country";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            ConnectionDAO connectionDAO = new ConnectionDAO();
            conn = connectionDAO.getConnection();

            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                Country country = new Country();
                
                country.setId(rs.getInt("id"));
                country.setName(rs.getString("name"));
                country.setAcronym(rs.getString("acronym"));
                country.setPhoneDigits(rs.getInt("phone_digits"));

                countries.add(country);
            }

            return countries;

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
    
    public Country read(int id) throws ClassNotFoundException, SQLException {
        
        String sql = "SELECT * FROM country WHERE id = " + id;

        Country country = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            ConnectionDAO connectionDAO = new ConnectionDAO();
            conn = connectionDAO.getConnection();

            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            if (rs.next()) {

                country = new Country();
                
                country.setId(rs.getInt("id"));
                country.setName(rs.getString("name"));
                country.setAcronym(rs.getString("acronym"));
                country.setPhoneDigits(rs.getInt("phone_digits"));
            }

            return country;

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
    
    public void update(Country country) throws ClassNotFoundException, SQLException {
        
        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            ConnectionDAO connectionDAO = new ConnectionDAO();
            conn = connectionDAO.getConnection();

            stmt = conn.prepareStatement("UPDATE country SET name = ?, acronym = ?, phone_digits = ? WHERE id = ?");
            stmt.setString(1, country.getName());
            stmt.setString(2, country.getAcronym());
            stmt.setInt(3, country.getPhoneDigits());
            stmt.setInt(4, country.getId());

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
            ConnectionDAO connectionDAO = new ConnectionDAO();
            conn = connectionDAO.getConnection();

            stmt = conn.prepareStatement("DELETE FROM country WHERE id = ?");
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
