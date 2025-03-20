
package forum01.hotelreservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class Customers extends javax.swing.JFrame {

   
    private int key = 0;
    Connection conn = DBConnection.connect();
    
    
    public Customers() {
        initComponents();
        fetchRoomData();
    }

    private void fetchRoomData() {
    DefaultTableModel model = (DefaultTableModel) cTable.getModel();
    model.setRowCount(0);

    try {
        String query = "SELECT * FROM customer";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            String name = rs.getString("name");
            String phone = rs.getString("phone");
            String gender = rs.getString("gender");
            String address = rs.getString("address");
            int id       = rs.getInt("id");

            model.addRow(new Object[]{name, phone, gender, address,id});
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    cTable.getColumnModel().getColumn(4).setMinWidth(0);
    cTable.getColumnModel().getColumn(4).setMaxWidth(0);
    cTable.getColumnModel().getColumn(4).setWidth(0);
}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        roomBtn = new javax.swing.JLabel();
        customerBtn = new javax.swing.JLabel();
        bookingBtn = new javax.swing.JLabel();
        dashboardBtn = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        cName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cGender = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        cTable = new javax.swing.JTable();
        cDelete = new javax.swing.JButton();
        cAddBtn = new javax.swing.JButton();
        cEditBtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cPhone = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cAddress = new javax.swing.JTextArea();
        clearBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 255, 255));

        roomBtn.setBackground(new java.awt.Color(255, 255, 255));
        roomBtn.setFont(new java.awt.Font("Liberation Sans", 2, 36)); // NOI18N
        roomBtn.setForeground(new java.awt.Color(255, 255, 255));
        roomBtn.setText("Rooms");
        roomBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomBtnMouseClicked(evt);
            }
        });

        customerBtn.setBackground(new java.awt.Color(255, 255, 255));
        customerBtn.setFont(new java.awt.Font("Liberation Sans", 2, 36)); // NOI18N
        customerBtn.setForeground(new java.awt.Color(255, 255, 255));
        customerBtn.setText("Customers");
        customerBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerBtnMouseClicked(evt);
            }
        });

        bookingBtn.setBackground(new java.awt.Color(255, 255, 255));
        bookingBtn.setFont(new java.awt.Font("Liberation Sans", 2, 36)); // NOI18N
        bookingBtn.setForeground(new java.awt.Color(255, 255, 255));
        bookingBtn.setText("Bookings");

        dashboardBtn.setBackground(new java.awt.Color(255, 255, 255));
        dashboardBtn.setFont(new java.awt.Font("Liberation Sans", 2, 36)); // NOI18N
        dashboardBtn.setForeground(new java.awt.Color(255, 255, 255));
        dashboardBtn.setText("Dashboard");

        logoutBtn.setBackground(new java.awt.Color(255, 255, 255));
        logoutBtn.setFont(new java.awt.Font("Liberation Sans", 2, 36)); // NOI18N
        logoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        logoutBtn.setText("Logout");
        logoutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoutBtn)
                    .addComponent(roomBtn)
                    .addComponent(customerBtn)
                    .addComponent(bookingBtn)
                    .addComponent(dashboardBtn))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(roomBtn)
                .addGap(44, 44, 44)
                .addComponent(customerBtn)
                .addGap(44, 44, 44)
                .addComponent(bookingBtn)
                .addGap(44, 44, 44)
                .addComponent(dashboardBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
                .addComponent(logoutBtn)
                .addGap(88, 88, 88))
        );

        jPanel3.setBackground(new java.awt.Color(51, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        cName.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        cName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cNameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Name");

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Gender");

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Address");

        cGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", " " }));

        cTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"5", "5", "5", null, null},
                {"5", "5", "5", null, null},
                {"6", "5", "5", null, null},
                {"5", "5", "5", null, null}
            },
            new String [] {
                "Name", "Phone", "Gender", "Address", "ID"
            }
        ));
        cTable.setToolTipText("");
        cTable.setGridColor(new java.awt.Color(0, 0, 0));
        cTable.setRowHeight(25);
        cTable.setRowMargin(1);
        cTable.setShowGrid(true);
        cTable.setSurrendersFocusOnKeystroke(true);
        cTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(cTable);

        cDelete.setText("Delete");
        cDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cDeleteMouseClicked(evt);
            }
        });
        cDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cDeleteActionPerformed(evt);
            }
        });

        cAddBtn.setText("Add");
        cAddBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cAddBtnMouseClicked(evt);
            }
        });
        cAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cAddBtnActionPerformed(evt);
            }
        });

        cEditBtn.setText("Edit");
        cEditBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cEditBtnMouseClicked(evt);
            }
        });
        cEditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cEditBtnActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel11.setText("         Hotel Management System");

        jLabel12.setBackground(new java.awt.Color(0, 204, 0));
        jLabel12.setFont(new java.awt.Font("Liberation Sans", 3, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 255, 51));
        jLabel12.setText("Manage Customers");

        cPhone.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        cPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cPhoneActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setText("Phone");

        cAddress.setColumns(20);
        cAddress.setRows(5);
        jScrollPane2.setViewportView(cAddress);

        clearBtn.setText("Clear Value");
        clearBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearBtnMouseClicked(evt);
            }
        });
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cAddBtn)
                                .addGap(34, 34, 34)
                                .addComponent(cEditBtn)
                                .addGap(32, 32, 32)
                                .addComponent(cDelete)
                                .addGap(62, 62, 62))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cName)
                                            .addComponent(cGender, 0, 300, Short.MAX_VALUE)
                                            .addComponent(cPhone, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jScrollPane2)))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(123, 123, 123)
                                        .addComponent(clearBtn)))
                                .addGap(18, 18, 18)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(453, 453, 453)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(352, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel11)
                .addGap(53, 53, 53)
                .addComponent(jLabel12)
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cGender, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cEditBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(194, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void saveRoomData(boolean isEdit) {  
        if (cName.getText().isEmpty() || cGender.getSelectedIndex() == -1 || cPhone.getText().isEmpty() || cAddress.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Missing Data!!!");
            return;
        }
        PreparedStatement preparedStatement = null;
        try {
            String query;
            
            if (isEdit) {
                
                if (key == 0) {
                    JOptionPane.showMessageDialog(this, "No Customer selected for editing!");
                    return;
                }
                query = "UPDATE customer SET name = ?, phone = ?, gender = ?, address = ? WHERE id = ?";
                preparedStatement = conn.prepareStatement(query);
                
                preparedStatement.setInt(5, key);
            } else {
                query = "INSERT INTO customer (name, phone, gender, address) VALUES (?, ?, ?, ?)";
                preparedStatement = conn.prepareStatement(query);
            }

            preparedStatement.setString(1, cName.getText());
            preparedStatement.setString(2, cPhone.getText());
            preparedStatement.setString(3, cGender.getSelectedItem().toString());
            preparedStatement.setString(4, cAddress.getText());

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
            
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, isEdit ? "Customer updated successfully!" : "Customer added successfully!");
               clearData();
            
            } else {
                JOptionPane.showMessageDialog(this, "Operation failed! Please try again.");
            }
            
            fetchRoomData(); 
            cEditBtn.setText("Edit");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
}
    
    
    
    
    private void logoutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseClicked
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutBtnMouseClicked

    private void cNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cNameActionPerformed
    }//GEN-LAST:event_cNameActionPerformed

    private void cDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cDeleteActionPerformed
       if(key == 0 ){
            JOptionPane.showMessageDialog(this, "Please Select a Table row");
        }else{
            String deleteQuery = "DELETE FROM customer WHERE id = ?";
            try {
               PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
               pstmt.setInt(1, key);
               
                int rowsDeleted = pstmt.executeUpdate();
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(this, "Room deleted successfully!");
                    fetchRoomData();
                   clearData();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to delete room!");
                }
               
            } catch (SQLException ex) {
                Logger.getLogger(Rooms.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }//GEN-LAST:event_cDeleteActionPerformed

    private void cAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cAddBtnActionPerformed
        saveRoomData(false);
    }//GEN-LAST:event_cAddBtnActionPerformed

    private void cEditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cEditBtnActionPerformed
        saveRoomData(true);
    }//GEN-LAST:event_cEditBtnActionPerformed

    private void cPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cPhoneActionPerformed
        
    }//GEN-LAST:event_cPhoneActionPerformed

    private void roomBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomBtnMouseClicked
        new Rooms().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_roomBtnMouseClicked

    private void customerBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerBtnMouseClicked
        new Customers().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_customerBtnMouseClicked

    private void cAddBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cAddBtnMouseClicked
        
    }//GEN-LAST:event_cAddBtnMouseClicked

    private void cEditBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cEditBtnMouseClicked
    }//GEN-LAST:event_cEditBtnMouseClicked

    private void cDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cDeleteMouseClicked
    }//GEN-LAST:event_cDeleteMouseClicked

    private void cTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cTableMouseClicked
        DefaultTableModel model = (DefaultTableModel)cTable.getModel();
        int myIndex = cTable.getSelectedRow();
        
        
        key = (int) model.getValueAt(myIndex, 4);
        
        cName.setText(model.getValueAt(myIndex, 0).toString());
        cPhone.setText(model.getValueAt(myIndex, 1).toString());
        cGender.setSelectedItem(model.getValueAt(myIndex, 2).toString());
        cAddress.setText(model.getValueAt(myIndex, 3).toString());
        cEditBtn.setText("Update");
    }//GEN-LAST:event_cTableMouseClicked

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
    }//GEN-LAST:event_clearBtnActionPerformed

    private void clearBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearBtnMouseClicked
        clearData();
    }//GEN-LAST:event_clearBtnMouseClicked

    private void clearData(){
        cName.setText("");
        cPhone.setText("");
        cGender.setSelectedIndex(-1);
        cAddress.setText("");
        key = 0;
    }
    
    
   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bookingBtn;
    private javax.swing.JButton cAddBtn;
    private javax.swing.JTextArea cAddress;
    private javax.swing.JButton cDelete;
    private javax.swing.JButton cEditBtn;
    private javax.swing.JComboBox<String> cGender;
    private javax.swing.JTextField cName;
    private javax.swing.JTextField cPhone;
    private javax.swing.JTable cTable;
    private javax.swing.JButton clearBtn;
    private javax.swing.JLabel customerBtn;
    private javax.swing.JLabel dashboardBtn;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel logoutBtn;
    private javax.swing.JLabel roomBtn;
    // End of variables declaration//GEN-END:variables
}
