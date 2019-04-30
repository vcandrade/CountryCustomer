/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.pg.app.gui;

import br.edu.utfpr.pg.app.dao.CountryDAO;
import br.edu.utfpr.pg.app.dao.CustomerDAO;
import br.edu.utfpr.pg.app.entity.Country;
import br.edu.utfpr.pg.app.entity.Customer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vinic
 */
public class CustomerWindow extends javax.swing.JFrame {

    private CustomerDAO customerDAO;
    
    public CustomerWindow() {

        initComponents();
        this.txtId.setEnabled(false);
        
        this.customerDAO = new CustomerDAO();

        this.updateCountryComponent();
        this.updateTable();
    }

    private void updateCountryComponent() {

        try {

            CountryDAO countryDAO = new CountryDAO();
            ArrayList<Country> countries = countryDAO.read();

            for (Country country : countries) {

                this.cbbCountry.addItem(country.getName());
            }

        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(CustomerWindow.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
    private void updateTable() {
        
        try {
            
            CountryDAO countryDAO = new CountryDAO();
            
            DefaultTableModel modeloTabela = (DefaultTableModel) tblCutomer.getModel();
            modeloTabela.fireTableDataChanged();
            modeloTabela.setRowCount(0);
            
            for (Customer customer : this.customerDAO.read()) {
            
                Country country = countryDAO.read(customer.getCountry().getId());
                customer.setCountry(country);
                
                String[] data = {String.valueOf(customer.getId()), customer.getName(), customer.getPhone(), String.valueOf(customer.getAge()), customer.getCountry().getName()};
                modeloTabela.addRow(data);
            }
        
        } catch (ClassNotFoundException | SQLException ex) {
         
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
       
        }
    }
    
    private void cleanComponents() {
        
        this.txtId.setText("");
        this.txtName.setText("");
        this.txtPhone.setText("");
        this.txtAge.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        cbbCountry = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCutomer = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Customer Management");

        jLabel1.setText("Id");

        jLabel2.setText("Name");

        jLabel3.setText("Phone");

        jLabel4.setText("Age");

        jLabel5.setText("Country");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        tblCutomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Phone", "Age", "Country"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCutomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblCutomerMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblCutomer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(cbbCountry, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAge)
                            .addComponent(txtPhone)
                            .addComponent(txtName)
                            .addComponent(txtId))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnCreate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed

        try {
           
            CountryDAO countryDAO = new CountryDAO();
            ArrayList<Country> countries = countryDAO.read();
            
            Customer customer = new Customer();
            
            for (Country country : countries) {
                
                if(country.getName().equals(this.cbbCountry.getSelectedItem().toString())) {
                   
                    customer.setCountry(country);
                }
            }
            
            customer.setName(this.txtName.getText());
            customer.setPhone(this.txtPhone.getText());
            customer.setAge(new Integer(this.txtAge.getText()));
            
            customerDAO.create(customer);

        } catch (ClassNotFoundException | SQLException ex) {
           
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
       
        } finally {
            
            this.cleanComponents();
            this.updateTable();
            
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        try {
            
            CountryDAO countryDAO = new CountryDAO();
            ArrayList<Country> countries = countryDAO.read();
          
            Customer customer = new Customer();
            customer.setId(new Integer(this.txtId.getText()));
            customer.setName(this.txtName.getText());
            customer.setPhone(this.txtPhone.getText());
            customer.setAge(new Integer(this.txtAge.getText()));
            
            for (Country country : countries) {
                
                if(country.getName().equals(this.cbbCountry.getSelectedItem().toString())) {
                   
                    customer.setCountry(country);
                }
            }
            
            customerDAO.update(customer);
        
        } catch (ClassNotFoundException | SQLException ex) {
         
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
       
        } finally {
            
            this.cleanComponents();
            this.updateTable();
            
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        
        try {
          
            customerDAO.delete(new Integer(this.txtId.getText()));
        
        } catch (ClassNotFoundException | SQLException ex) {
         
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
       
        } finally {
            
            this.cleanComponents();
            this.updateTable();
            
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        
        this.dispose();
        
    }//GEN-LAST:event_btnCloseActionPerformed

    private void tblCutomerMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCutomerMouseReleased

        this.txtId.setText(this.tblCutomer.getValueAt(this.tblCutomer.getSelectedRow(), 0).toString());
        this.txtName.setText(this.tblCutomer.getValueAt(this.tblCutomer.getSelectedRow(), 1).toString());
        this.txtPhone.setText(this.tblCutomer.getValueAt(this.tblCutomer.getSelectedRow(), 2).toString());
        this.txtAge.setText(this.tblCutomer.getValueAt(this.tblCutomer.getSelectedRow(), 3).toString());
        this.cbbCountry.setSelectedItem(this.tblCutomer.getValueAt(this.tblCutomer.getSelectedRow(), 4).toString());
        
    }//GEN-LAST:event_tblCutomerMouseReleased

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbbCountry;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCutomer;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
