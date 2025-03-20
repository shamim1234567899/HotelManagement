
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

public class Rooms extends javax.swing.JFrame {

   
    
    private int key = 0;
    
    public Rooms() {
        initComponents();
        fetchRoomData();
    }
    
    Connection conn = DBConnection.connect();
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rRoomBtn = new javax.swing.JLabel();
        rCustomerBtn = new javax.swing.JLabel();
        rBookingBtn = new javax.swing.JLabel();
        rDashboardBtn = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        rName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rPrice = new javax.swing.JTextField();
        rStatus = new javax.swing.JComboBox<>();
        rCat = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        rTable = new javax.swing.JTable();
        rDelete = new javax.swing.JButton();
        rAdd = new javax.swing.JButton();
        rEdit = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        clearData = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 255, 255));

        rRoomBtn.setBackground(new java.awt.Color(255, 255, 255));
        rRoomBtn.setFont(new java.awt.Font("Liberation Sans", 2, 36)); // NOI18N
        rRoomBtn.setForeground(new java.awt.Color(255, 255, 255));
        rRoomBtn.setText("Rooms");

        rCustomerBtn.setBackground(new java.awt.Color(255, 255, 255));
        rCustomerBtn.setFont(new java.awt.Font("Liberation Sans", 2, 36)); // NOI18N
        rCustomerBtn.setForeground(new java.awt.Color(255, 255, 255));
        rCustomerBtn.setText("Customers");

        rBookingBtn.setBackground(new java.awt.Color(255, 255, 255));
        rBookingBtn.setFont(new java.awt.Font("Liberation Sans", 2, 36)); // NOI18N
        rBookingBtn.setForeground(new java.awt.Color(255, 255, 255));
        rBookingBtn.setText("Bookings");

        rDashboardBtn.setBackground(new java.awt.Color(255, 255, 255));
        rDashboardBtn.setFont(new java.awt.Font("Liberation Sans", 2, 36)); // NOI18N
        rDashboardBtn.setForeground(new java.awt.Color(255, 255, 255));
        rDashboardBtn.setText("Dashboard");

        logoutBtn.setBackground(new java.awt.Color(255, 255, 255));
        logoutBtn.setFont(new java.awt.Font("Liberation Sans", 3, 36)); // NOI18N
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
                    .addComponent(rRoomBtn)
                    .addComponent(rCustomerBtn)
                    .addComponent(rBookingBtn)
                    .addComponent(rDashboardBtn))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(rRoomBtn)
                .addGap(44, 44, 44)
                .addComponent(rCustomerBtn)
                .addGap(44, 44, 44)
                .addComponent(rBookingBtn)
                .addGap(44, 44, 44)
                .addComponent(rDashboardBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        rName.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        rName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rNameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Name");

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Categories");

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Status");

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Price");

        rPrice.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        rPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rPriceActionPerformed(evt);
            }
        });

        rStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Free", "Unlocked", " " }));

        rCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VIP", "Double Bed", "Single Bed", "Family", " ", " " }));

        rTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"2", "5", "5", "5", null},
                {"5", "5", "5", "5", null},
                {"5", "6", "5", "5", null},
                {"5", "5", "5", "5", null}
            },
            new String [] {
                "Room Name", "Category", "Status", "Price", "ID"
            }
        ));
        rTable.setToolTipText("");
        rTable.setGridColor(new java.awt.Color(0, 0, 0));
        rTable.setRowHeight(25);
        rTable.setRowMargin(1);
        rTable.setShowGrid(true);
        rTable.setSurrendersFocusOnKeystroke(true);
        rTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(rTable);

        rDelete.setText("Delete");
        rDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rDeleteActionPerformed(evt);
            }
        });

        rAdd.setText("Add");
        rAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rAddActionPerformed(evt);
            }
        });

        rEdit.setText("Edit");
        rEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rEditActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 204, 153));
        jLabel11.setText("Hotel Management System");

        jLabel12.setFont(new java.awt.Font("Liberation Sans", 3, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 153));
        jLabel12.setText("Manage Rooms");

        clearData.setText("Clear Value");
        clearData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearDataMouseClicked(evt);
            }
        });
        clearData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(rAdd)
                        .addGap(34, 34, 34)
                        .addComponent(rEdit)
                        .addGap(32, 32, 32)
                        .addComponent(rDelete)
                        .addGap(62, 62, 62))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rPrice)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rName)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rCat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(clearData)))
                        .addGap(25, 25, 25)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 414, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(396, 396, 396)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(31, 31, 31)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(rName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rCat, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clearData, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(201, Short.MAX_VALUE))
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
    
    
    
    private void logoutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseClicked
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutBtnMouseClicked

    
  private void fetchRoomData() {
    DefaultTableModel model = (DefaultTableModel) rTable.getModel();
    model.setRowCount(0);

    try {
        String query = "SELECT * FROM room";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            String name = rs.getString("name");
            String type = rs.getString("type");
            String status = rs.getString("status");
            String price = rs.getString("number");
            int id       = rs.getInt("id");

            model.addRow(new Object[]{name, type, status, price,id});
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    rTable.getColumnModel().getColumn(4).setMinWidth(0);
    rTable.getColumnModel().getColumn(4).setMaxWidth(0);
    rTable.getColumnModel().getColumn(4).setWidth(0);
}
    
    private void rEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rEditActionPerformed

        saveRoomData(true);
    }//GEN-LAST:event_rEditActionPerformed

    private void rAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rAddActionPerformed

        saveRoomData(false);
        
    }//GEN-LAST:event_rAddActionPerformed

    private void saveRoomData(boolean isEdit) {  
    if (rName.getText().isEmpty() || rCat.getSelectedIndex() == -1 || rStatus.getSelectedIndex() == -1 || rPrice.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Missing Data!!!");
        return;
    }
        PreparedStatement preparedStatement = null;
        try {
            String query;
            
            if (isEdit) {
                
                if (key == 0) {
                    JOptionPane.showMessageDialog(this, "No room selected for editing!");
                    return;
                }
                query = "UPDATE room SET name = ?, number = ?, type = ?, status = ? WHERE id = ?";
                preparedStatement = conn.prepareStatement(query);
                
                preparedStatement.setInt(5, key);
            } else {
                query = "INSERT INTO room (name, number, type, status) VALUES (?, ?, ?, ?)";
                preparedStatement = conn.prepareStatement(query);
            }

            preparedStatement.setString(1, rName.getText());
            preparedStatement.setString(2, rPrice.getText());
            preparedStatement.setString(3, rCat.getSelectedItem().toString());
            preparedStatement.setString(4, rStatus.getSelectedItem().toString());

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
            
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, isEdit ? "Room updated successfully!" : "Room added successfully!");
                clearData();
            
            } else {
                JOptionPane.showMessageDialog(this, "Operation failed! Please try again.");
            }
            
            fetchRoomData(); 
            rEdit.setText("Edit");

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
    
    
    private void rDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rDeleteActionPerformed
        if(key == 0 ){
            JOptionPane.showMessageDialog(this, "Please Select a Table row");
        }else{
            String deleteQuery = "DELETE FROM room WHERE id = ?";
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
    }//GEN-LAST:event_rDeleteActionPerformed

    private void rPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rPriceActionPerformed
        
    }//GEN-LAST:event_rPriceActionPerformed

    private void rNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rNameActionPerformed
        
    }//GEN-LAST:event_rNameActionPerformed

    private void rTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rTableMouseClicked
        DefaultTableModel model = (DefaultTableModel)rTable.getModel();
        int myIndex = rTable.getSelectedRow();
        
        
        key = (int) model.getValueAt(myIndex, 4);
        
        rName.setText(model.getValueAt(myIndex, 0).toString());
        rCat.setSelectedItem(model.getValueAt(myIndex, 1).toString());
        rStatus.setSelectedItem(model.getValueAt(myIndex, 2).toString());
        rPrice.setText(model.getValueAt(myIndex, 3).toString());
        rEdit.setText("Update");
    }//GEN-LAST:event_rTableMouseClicked

    private void clearDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearDataActionPerformed
    }//GEN-LAST:event_clearDataActionPerformed

    private void clearDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearDataMouseClicked
        JOptionPane.showMessageDialog(this, "Data was clear from filed");
        clearData();
    }//GEN-LAST:event_clearDataMouseClicked

    
    private void clearData(){
        rName.setText("");
        rPrice.setText("");
        rCat.setSelectedIndex(-1);
        rStatus.setSelectedIndex(-1);
        key = 0;
    }
    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rooms().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearData;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logoutBtn;
    private javax.swing.JButton rAdd;
    private javax.swing.JLabel rBookingBtn;
    private javax.swing.JComboBox<String> rCat;
    private javax.swing.JLabel rCustomerBtn;
    private javax.swing.JLabel rDashboardBtn;
    private javax.swing.JButton rDelete;
    private javax.swing.JButton rEdit;
    private javax.swing.JTextField rName;
    private javax.swing.JTextField rPrice;
    private javax.swing.JLabel rRoomBtn;
    private javax.swing.JComboBox<String> rStatus;
    private javax.swing.JTable rTable;
    // End of variables declaration//GEN-END:variables
}
