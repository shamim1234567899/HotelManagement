
package forum01.hotelreservation;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import com.toedter.calendar.JDateChooser; 


public class HotelManagementSystem extends JFrame {
    
    private final Color TEAL_COLOR = new Color(0, 102, 102);
    private final Color DARK_TEAL = new Color(0, 85, 85);
    private final Color BACKGROUND_COLOR = new Color(245, 245, 245);
    private final Color WHITE = new Color(255, 255, 255);
    private final Color TEXT_COLOR = new Color(70, 70, 70);
    private final Color LIGHT_GRAY = new Color(230, 230, 230);
   
    private JPanel sidebarPanel;
    private JPanel contentPanel;
    private JPanel headerPanel;
    private JPanel formPanel;
    private JPanel tablePanel;
    
    private JComboBox<String> roomComboBox;
    private JComboBox<String> customerComboBox;
    private JDateChooser dateChooser;
    private JTextField durationField;
    private JTextField costField;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton clearButton;
    
    private JTable bookingsTable;
    private DefaultTableModel tableModel;
    
    private String[] rooms = {"anowar hossen", "akash"};
    private String[] customers = {"shakib", "anowar"};
    private Object[][] bookingData = {
        {"anowar hossen", "shakib", "2025-03-06", "99", "$23", "2"},
        {"akash", "anowar", "2025-03-01", "888", "$8999", "4"},
        {"akash", "anowar", "2025-03-29", "88888", "$888899", "5"},
        {"akash", "anowar", "2025-03-29", "88888000", "$99999", "6"}
    };
    
    public HotelManagementSystem() {
        setTitle("Hotel Management System");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(BACKGROUND_COLOR);
        
        // Initialize components
        initComponents();
        
        // Add components to frame
        add(sidebarPanel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void initComponents() {
        // Initialize sidebar
        initSidebar();
        
        // Initialize content panel
        contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(WHITE);
        
        // Initialize header
        initHeader();
        contentPanel.add(headerPanel, BorderLayout.NORTH);
        
        // Initialize main content
        JPanel mainContent = new JPanel(new BorderLayout());
        mainContent.setBackground(WHITE);
        mainContent.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Title section
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(WHITE);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        
        JLabel titleLabel = new JLabel("Manage Booking");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(TEXT_COLOR);
        
        JLabel subtitleLabel = new JLabel("Create and manage room bookings.");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitleLabel.setForeground(new Color(150, 150, 150));
        
        titlePanel.add(titleLabel, BorderLayout.NORTH);
        titlePanel.add(subtitleLabel, BorderLayout.CENTER);
        
        mainContent.add(titlePanel, BorderLayout.NORTH);
        
        // Form and table panel
        JPanel formTablePanel = new JPanel(new GridBagLayout());
        formTablePanel.setBackground(WHITE);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        
        // Initialize form
        initForm();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        gbc.weighty = 1.0;
        formTablePanel.add(formPanel, gbc);
        
        // Initialize table
        initTable();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.7;
        formTablePanel.add(tablePanel, gbc);
        
        mainContent.add(formTablePanel, BorderLayout.CENTER);
        contentPanel.add(mainContent, BorderLayout.CENTER);
    }
    
    private void initSidebar() {
        sidebarPanel = new JPanel(new BorderLayout());
        sidebarPanel.setPreferredSize(new Dimension(250, getHeight()));
        sidebarPanel.setBackground(TEAL_COLOR);
        
        // Logo panel
        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        logoPanel.setBackground(TEAL_COLOR);
        
        JLabel logoLabel = new JLabel("HotelPro");
        logoLabel.setFont(new Font("Arial", Font.BOLD, 20));
        logoLabel.setForeground(WHITE);
        logoPanel.add(logoLabel);
        
        sidebarPanel.add(logoPanel, BorderLayout.NORTH);
        
        // Menu items
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBackground(TEAL_COLOR);
        
        String[] menuItems = {"Dashboard", "Rooms", "Customers", "Bookings", "Logout"};
        boolean[] isActive = {false, false, false, true, false};
        
        for (int i = 0; i < menuItems.length; i++) {
            JPanel menuItem = createMenuItem(menuItems[i], isActive[i]);
            if (i == menuItems.length - 1) {
                // Add spacing before logout
                menuPanel.add(Box.createVerticalGlue());
            }
            menuPanel.add(menuItem);
        }
        
        sidebarPanel.add(menuPanel, BorderLayout.CENTER);
    }
    
    private JPanel createMenuItem(String text, boolean isActive) {
        JPanel menuItem = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 15));
        menuItem.setMaximumSize(new Dimension(250, 50));
        
        if (isActive) {
            menuItem.setBackground(DARK_TEAL);
        } else {
            menuItem.setBackground(TEAL_COLOR);
            menuItem.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    menuItem.setBackground(DARK_TEAL);
                    menuItem.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }
                
                @Override
                public void mouseExited(MouseEvent e) {
                    menuItem.setBackground(TEAL_COLOR);
                }
            });
        }
        
        JLabel menuLabel = new JLabel(text);
        menuLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        menuLabel.setForeground(WHITE);
        
        menuItem.add(menuLabel);
        return menuItem;
    }
    
    private void initHeader() {
        headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(WHITE);
        headerPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 1, 0, LIGHT_GRAY),
            BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));
        
        JLabel titleLabel = new JLabel("Hotel Management System");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        titleLabel.setForeground(TEXT_COLOR);
        
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.setBackground(WHITE);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
        JLabel dateLabel = new JLabel(dateFormat.format(new Date()));
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        dateLabel.setForeground(new Color(150, 150, 150));
        
        JPanel avatarPanel = new JPanel();
        avatarPanel.setPreferredSize(new Dimension(32, 32));
        avatarPanel.setBackground(LIGHT_GRAY);
        avatarPanel.setBorder(new RoundedBorder(16));
        
        rightPanel.add(dateLabel);
        rightPanel.add(Box.createHorizontalStrut(15));
        rightPanel.add(avatarPanel);
        
        headerPanel.add(titleLabel, BorderLayout.WEST);
        headerPanel.add(rightPanel, BorderLayout.EAST);
    }
    
    private void initForm() {
        formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(WHITE);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
            new RoundedBorder(8),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        
        // Room selection
        JPanel roomPanel = createFormGroup("Room");
        roomComboBox = new JComboBox<>(rooms);
        roomComboBox.setPreferredSize(new Dimension(0, 35));
        roomPanel.add(roomComboBox);
        formPanel.add(roomPanel);
        formPanel.add(Box.createVerticalStrut(15));
        
        // Customer selection
        JPanel customerPanel = createFormGroup("Customer");
        customerComboBox = new JComboBox<>(customers);
        customerComboBox.setPreferredSize(new Dimension(0, 35));
        customerPanel.add(customerComboBox);
        formPanel.add(customerPanel);
        formPanel.add(Box.createVerticalStrut(15));
        
        // Booking date
        JPanel datePanel = createFormGroup("Booking Date");
        dateChooser = new JDateChooser();
        dateChooser.setPreferredSize(new Dimension(0, 35));
        dateChooser.setDate(new Date());
        datePanel.add(dateChooser);
        formPanel.add(datePanel);
        formPanel.add(Box.createVerticalStrut(15));
        
        // Duration
        JPanel durationPanel = createFormGroup("Duration In Days");
        durationField = new JTextField();
        durationField.setPreferredSize(new Dimension(0, 35));
        durationPanel.add(durationField);
        formPanel.add(durationPanel);
        formPanel.add(Box.createVerticalStrut(15));
        
        // Cost
        JPanel costPanel = createFormGroup("Cost");
        costField = new JTextField();
        costField.setPreferredSize(new Dimension(0, 35));
        costPanel.add(costField);
        formPanel.add(costPanel);
        formPanel.add(Box.createVerticalStrut(20));
        
        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        buttonPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        buttonPanel.setBackground(WHITE);
        
        addButton = createButton("Add", true);
        editButton = createButton("Edit", false);
        deleteButton = createButton("Delete", false);
        
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        
        formPanel.add(buttonPanel);
        formPanel.add(Box.createVerticalStrut(15));
        
        // Clear button
        JPanel clearPanel = new JPanel(new BorderLayout());
        clearPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        clearPanel.setBackground(WHITE);
        
        clearButton = createButton("Clear Value", false);
        clearPanel.add(clearButton, BorderLayout.CENTER);
        
        formPanel.add(clearPanel);
    }
    
    private JPanel createFormGroup(String labelText) {
        JPanel panel = new JPanel(new BorderLayout(0, 5));
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        panel.setBackground(WHITE);
        
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setForeground(TEXT_COLOR);
        
        panel.add(label, BorderLayout.NORTH);
        
        return panel;
    }
    
    private JButton createButton(String text, boolean isPrimary) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        
        if (isPrimary) {
            button.setBackground(TEAL_COLOR);
            button.setForeground(WHITE);
            button.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        } else {
            button.setBackground(WHITE);
            button.setForeground(TEXT_COLOR);
            button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(LIGHT_GRAY, 1),
                BorderFactory.createEmptyBorder(7, 14, 7, 14)
            ));
        }
        
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setCursor(new Cursor(Cursor.HAND_CURSOR));
                if (isPrimary) {
                    button.setBackground(DARK_TEAL);
                } else {
                    button.setBackground(LIGHT_GRAY);
                }
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                if (isPrimary) {
                    button.setBackground(TEAL_COLOR);
                } else {
                    button.setBackground(WHITE);
                }
            }
        });
        
        return button;
    }
    
    private void initTable() {
        tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBackground(WHITE);
        tablePanel.setBorder(BorderFactory.createCompoundBorder(
            new RoundedBorder(8),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        
        String[] columnNames = {"Room", "Customer", "Date", "Duration", "Cost", "ID"};
        tableModel = new DefaultTableModel(bookingData, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        bookingsTable = new JTable(tableModel);
        bookingsTable.setRowHeight(40);
        bookingsTable.setShowVerticalLines(false);
        bookingsTable.setGridColor(LIGHT_GRAY);
        bookingsTable.getTableHeader().setBackground(LIGHT_GRAY);
        bookingsTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        bookingsTable.getTableHeader().setPreferredSize(new Dimension(0, 40));
        bookingsTable.setSelectionBackground(new Color(240, 240, 240));
        
        JScrollPane scrollPane = new JScrollPane(bookingsTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        
        tablePanel.add(scrollPane, BorderLayout.CENTER);
    }
    
    // Custom rounded border
    private class RoundedBorder extends AbstractBorder {
        private int radius;
        
        RoundedBorder(int radius) {
            this.radius = radius;
        }
        
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(LIGHT_GRAY);
            g2d.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
            g2d.dispose();
        }
        
        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius / 2, this.radius / 2, this.radius / 2, this.radius / 2);
        }
        
        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.left = insets.right = insets.top = insets.bottom = this.radius / 2;
            return insets;
        }
    }
    
    public static void main(String[] args) {
        try {
            // Set system look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(() -> new HotelManagementSystem());
    }
}
