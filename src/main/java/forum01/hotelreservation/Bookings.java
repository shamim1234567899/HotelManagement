
package forum01.hotelreservation;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Bookings extends javax.swing.JFrame {

    
    
    Connection conn;
    private int key = 0;
    
    public Bookings() {
        initComponents();
        
        try {
        conn = DBConnection.connect();
        loadRooms();
        loadCustomers();
        fetchRoomData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to connect to the database: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    private Map<Integer, String> roomsMap;
    private Map<Integer,String> customersMap;
    
    public static Map<Integer, String> getRoomsMap(Connection conn) {
        Map<Integer, String> rooms = new HashMap<>();
        String query = "SELECT id, name FROM room";

        try (PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                rooms.put(id, name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rooms;
    }
    
    public static Map<Integer,String> getCustomerMap(Connection conn){
        Map<Integer,String> customers = new HashMap<>();
        String query = "SELECT id, name FROM customer";
        try(PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                customers.put(id, name);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return customers;
    }
    
    
    
    private void loadRooms() {
        bRoom.removeAllItems();
        roomsMap = getRoomsMap(conn);
        for (String roomName : roomsMap.values()) {
            bRoom.addItem(roomName);
        }
    }
    
    private void loadCustomers(){
        bCustomer.removeAllItems();
        customersMap = getCustomerMap(conn);
        for (String customerName : customersMap.values()) {
            bCustomer.addItem(customerName);
        }
        
    }
    
    
    private void fetchRoomData() {
    DefaultTableModel model = (DefaultTableModel) bTable.getModel();
    model.setRowCount(0);

        try {
            String query = "SELECT b.id, r.name AS room_name, c.name AS customer_name, b.booking_date, b.duration, b.cost " +
                       "FROM booking b " +
                       "JOIN room r ON b.room = r.id " +
                       "JOIN customer c ON b.customer = c.id";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String roomName = rs.getString("room_name");
                String customerName = rs.getString("customer_name");
                String date = rs.getString("booking_date");
                int duration = rs.getInt("duration");
                int id       = rs.getInt("id");
                int cost    = rs.getInt("cost");

                model.addRow(new Object[]{roomName, customerName, date, duration,cost,id});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    
    private void saveRoomData(boolean isEdit) {  
        
            String selectedRoomName = (String) bRoom.getSelectedItem();
            String selectedCustomerName = (String) bCustomer.getSelectedItem();
            java.util.Date utilDate = bDate.getDate();

            // Validate inputs
            if (selectedRoomName == null || selectedCustomerName == null || utilDate == null) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Missing Data", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int durationDays;
            int cost;
            
        PreparedStatement preparedStatement = null;
        try {
            String query;
            Integer selectedRoomId = null;
            Integer selectedCustomerId = null;
            
            durationDays = Integer.parseInt(bDurationDays.getText());
            cost = Integer.parseInt(bCost.getText());
            
            if (durationDays <= 0 || cost <= 0) {
                JOptionPane.showMessageDialog(this, "Duration and cost must be positive numbers!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            
            for (Map.Entry<Integer, String> entry : roomsMap.entrySet()) {
                if (entry.getValue().equals(selectedRoomName)) {
                    selectedRoomId = entry.getKey();
                    break;
                }
            }
        
            for (Map.Entry<Integer, String> entry : customersMap.entrySet()) {
                if (entry.getValue().equals(selectedCustomerName)) {
                    selectedCustomerId = entry.getKey();
                    break;
                }
            }
            
            if (selectedRoomId == null || selectedCustomerId == null) {
                JOptionPane.showMessageDialog(this, "Invalid room or customer selection!", "Selection Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            
            if (isEdit) {
                // Update existing booking
                query = "UPDATE booking SET room = ?, customer = ?, booking_date = ?, duration = ?, cost = ? WHERE id = ?";
            } else {
                // Insert new booking
                query = "INSERT INTO booking (room, customer, booking_date, duration, cost) VALUES (?, ?, ?, ?, ?)";
            }

            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                
                
                pstmt.setInt(1, selectedRoomId);
                pstmt.setInt(2, selectedCustomerId);
                pstmt.setDate(3, sqlDate);
                pstmt.setInt(4, durationDays);
                pstmt.setDouble(5, cost);
                
                if (isEdit) {
                    
                    if (key == 0) {
                        JOptionPane.showMessageDialog(this, "No Customer selected for editing!");
                        return;
                    }
                    pstmt.setInt(6, key);
                }

                int rowsAffected = pstmt.executeUpdate();
                System.out.println("Rows affected: " + rowsAffected);

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, isEdit ? "Customer updated successfully!" : "Customer added successfully!");
                    clearData();
                    
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to save booking!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
                fetchRoomData();
            }
            

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


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        roomBtn2 = new javax.swing.JLabel();
        customerBtn1 = new javax.swing.JLabel();
        bookingBtn1 = new javax.swing.JLabel();
        dashboardBtn1 = new javax.swing.JLabel();
        logoutBtn1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bTable = new javax.swing.JTable();
        bDelete = new javax.swing.JButton();
        bAdd = new javax.swing.JButton();
        bEdit = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        bDate = new com.toedter.calendar.JDateChooser();
        bCost = new javax.swing.JTextField();
        bDurationDays = new javax.swing.JTextField();
        bCustomer = new javax.swing.JComboBox<>();
        bRoom = new javax.swing.JComboBox<>();
        clearBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));

        roomBtn2.setBackground(new java.awt.Color(255, 255, 255));
        roomBtn2.setFont(new java.awt.Font("Liberation Sans", 2, 36)); // NOI18N
        roomBtn2.setForeground(new java.awt.Color(255, 255, 255));
        roomBtn2.setText("Rooms");
        roomBtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomBtn2MouseClicked(evt);
            }
        });

        customerBtn1.setBackground(new java.awt.Color(255, 255, 255));
        customerBtn1.setFont(new java.awt.Font("Liberation Sans", 2, 36)); // NOI18N
        customerBtn1.setForeground(new java.awt.Color(255, 255, 255));
        customerBtn1.setText("Customers");
        customerBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerBtn1MouseClicked(evt);
            }
        });

        bookingBtn1.setBackground(new java.awt.Color(255, 255, 255));
        bookingBtn1.setFont(new java.awt.Font("Liberation Sans", 2, 36)); // NOI18N
        bookingBtn1.setForeground(new java.awt.Color(255, 255, 255));
        bookingBtn1.setText("Bookings");

        dashboardBtn1.setBackground(new java.awt.Color(255, 255, 255));
        dashboardBtn1.setFont(new java.awt.Font("Liberation Sans", 2, 36)); // NOI18N
        dashboardBtn1.setForeground(new java.awt.Color(255, 255, 255));
        dashboardBtn1.setText("Dashboard");

        logoutBtn1.setBackground(new java.awt.Color(255, 255, 255));
        logoutBtn1.setFont(new java.awt.Font("Liberation Sans", 2, 36)); // NOI18N
        logoutBtn1.setForeground(new java.awt.Color(255, 255, 255));
        logoutBtn1.setText("Logout");
        logoutBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutBtn1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoutBtn1)
                    .addComponent(roomBtn2)
                    .addComponent(customerBtn1)
                    .addComponent(bookingBtn1)
                    .addComponent(dashboardBtn1))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(roomBtn2)
                .addGap(44, 44, 44)
                .addComponent(customerBtn1)
                .addGap(44, 44, 44)
                .addComponent(bookingBtn1)
                .addGap(44, 44, 44)
                .addComponent(dashboardBtn1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutBtn1)
                .addGap(88, 88, 88))
        );

        jPanel7.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Room");

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Booking Date");

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Cost");

        bTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"5", "5", "5", null, null, null},
                {"5", "5", "5", null, null, null},
                {"6", "5", "5", null, null, null},
                {"5", "5", "5", null, null, null}
            },
            new String [] {
                "Room", "Customer", "Date", "Duration", "Cost", "Id"
            }
        ));
        bTable.setToolTipText("");
        bTable.setGridColor(new java.awt.Color(0, 0, 0));
        bTable.setRowHeight(25);
        bTable.setRowMargin(1);
        bTable.setShowGrid(true);
        bTable.setSurrendersFocusOnKeystroke(true);
        bTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bTable);

        bDelete.setText("Delete");
        bDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteActionPerformed(evt);
            }
        });

        bAdd.setText("Add");
        bAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddActionPerformed(evt);
            }
        });

        bEdit.setText("Edit");
        bEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 153));
        jLabel11.setText("Hotel Management System");

        jLabel12.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 153));
        jLabel12.setText("Manage Booking");

        jLabel13.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setText("Customer");

        jLabel9.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("Duration In Days");

        bCost.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        bCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCostActionPerformed(evt);
            }
        });

        bDurationDays.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        bDurationDays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDurationDaysActionPerformed(evt);
            }
        });

        bCustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        bRoom.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        bRoom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        bRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRoomActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(388, 388, 388))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(bDate, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(bCost, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bDurationDays, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(bAdd)
                                        .addGap(34, 34, 34)
                                        .addComponent(bEdit)
                                        .addGap(32, 32, 32)
                                        .addComponent(bDelete))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(420, 420, 420)
                        .addComponent(jLabel11)))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addGap(49, 49, 49)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(bRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bDate, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(bDurationDays, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCost, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(190, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void roomBtn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomBtn2MouseClicked
        new Rooms().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_roomBtn2MouseClicked

    private void customerBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerBtn1MouseClicked
        new Customers().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_customerBtn1MouseClicked

    private void logoutBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtn1MouseClicked
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutBtn1MouseClicked

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        if(key == 0 ){
            JOptionPane.showMessageDialog(this, "Please Select a Table row");
        }else{
            String deleteQuery = "DELETE FROM booking WHERE id = ?";
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
    }//GEN-LAST:event_bDeleteActionPerformed

    private void bAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddActionPerformed
        try {
            
            saveRoomData(false); 
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to add booking: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_bAddActionPerformed

    private void bEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditActionPerformed
        saveRoomData(true);
    }//GEN-LAST:event_bEditActionPerformed

    private void bCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCostActionPerformed
       
    }//GEN-LAST:event_bCostActionPerformed

    private void bDurationDaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDurationDaysActionPerformed
    }//GEN-LAST:event_bDurationDaysActionPerformed

    private void bRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRoomActionPerformed
    }//GEN-LAST:event_bRoomActionPerformed

    private void bTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bTableMouseClicked
        DefaultTableModel model = (DefaultTableModel)bTable.getModel();
        int myIndex = bTable.getSelectedRow();
        
        
        key = (int) model.getValueAt(myIndex, 5);
        
        
        String roomName = (String) model.getValueAt(myIndex, 0);
        String customerName = (String) model.getValueAt(myIndex, 1);
        String bookingDate = model.getValueAt(myIndex, 2).toString();
        int durationDays = (int) model.getValueAt(myIndex, 3);
        int cost = (int) model.getValueAt(myIndex, 4);

      
        bRoom.setSelectedItem(roomName);
        bCustomer.setSelectedItem(customerName);
        bDate.setDate(java.sql.Date.valueOf(bookingDate));
        bDurationDays.setText(String.valueOf(durationDays));
        bCost.setText(String.valueOf(cost));
        

    }//GEN-LAST:event_bTableMouseClicked

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
       
    }//GEN-LAST:event_clearBtnActionPerformed

    private void clearBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearBtnMouseClicked
        clearData();
    }//GEN-LAST:event_clearBtnMouseClicked

    private void clearData(){
         bRoom.setSelectedIndex(-1);
        bCustomer.setSelectedIndex(-1);
        bDate.setDate(null);
        bDurationDays.setText("");
        bCost.setText("");
        key = 0;
    }
    
    
    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bookings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAdd;
    private javax.swing.JTextField bCost;
    private javax.swing.JComboBox<String> bCustomer;
    private com.toedter.calendar.JDateChooser bDate;
    private javax.swing.JButton bDelete;
    private javax.swing.JTextField bDurationDays;
    private javax.swing.JButton bEdit;
    private javax.swing.JComboBox<String> bRoom;
    private javax.swing.JTable bTable;
    private javax.swing.JLabel bookingBtn1;
    private javax.swing.JButton clearBtn;
    private javax.swing.JLabel customerBtn1;
    private javax.swing.JLabel dashboardBtn1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logoutBtn1;
    private javax.swing.JLabel roomBtn2;
    // End of variables declaration//GEN-END:variables
}
