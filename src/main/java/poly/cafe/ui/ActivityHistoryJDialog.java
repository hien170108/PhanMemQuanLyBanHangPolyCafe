package poly.cafe.ui;

import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import poly.cafe.dao.ActivityLogDAO;
import poly.cafe.dao.impl.ActivityLogDAOImpl;
import poly.cafe.entity.ActivityLog;
import poly.cafe.entity.User;
import poly.cafe.util.XUI;

public class ActivityHistoryJDialog extends JDialog {
    private JTable tblActivity;
    private JComboBox<String> cboFilter;
    private JTextField txtSearch;
    private JButton btnSearch;
    private JButton btnRefresh;
    private JDateChooser dateFrom;
    private JDateChooser dateTo;
    private JButton btnFilter;
    
    private ActivityLogDAO activityLogDAO;
    private User currentUser;
    private DefaultTableModel model;
    
    public ActivityHistoryJDialog(javax.swing.JFrame parent, boolean modal, User currentUser) {
        super(parent, modal);
        this.currentUser = currentUser;
        this.activityLogDAO = new ActivityLogDAOImpl();
        initComponents();
        XUI.setupUI(this);
        XUI.setHandCursor(this);
        loadData();
    }
    
    // Add this constructor to support JDialog parent
    public ActivityHistoryJDialog(javax.swing.JDialog parent, boolean modal, User currentUser) {
        super(parent, modal);
        this.currentUser = currentUser;
        this.activityLogDAO = new ActivityLogDAOImpl();
        initComponents();
        loadData();
    }
    
    private void initComponents() {
        setTitle("Lịch sử hoạt động");
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        // Create table model
        model = new DefaultTableModel();
        model.addColumn("Thời gian");
        model.addColumn("Người dùng");
        model.addColumn("Hành động");
        model.addColumn("Chi tiết");
        
        // Create table
        tblActivity = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tblActivity);
        
        // Create filter panel
        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cboFilter = new JComboBox<>(new String[]{"Tất cả", "Theo người dùng", "Theo hành động", "Theo thời gian"});
        txtSearch = new JTextField(20);
        btnSearch = new JButton("Tìm kiếm");
        btnRefresh = new JButton("Làm mới");
        dateFrom = new JDateChooser();
        dateTo = new JDateChooser();
        btnFilter = new JButton("Lọc");
        
        filterPanel.add(new JLabel("Lọc theo:"));
        filterPanel.add(cboFilter);
        filterPanel.add(txtSearch);
        filterPanel.add(btnSearch);
        filterPanel.add(btnRefresh);
        filterPanel.add(new JLabel("Từ:"));
        filterPanel.add(dateFrom);
        filterPanel.add(new JLabel("Đến:"));
        filterPanel.add(dateTo);
        filterPanel.add(btnFilter);
        
        // Add components to dialog
        add(filterPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        
        // Add action listeners
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search();
            }
        });
        
        btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadData();
            }
        });
        
        btnFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterByDate();
            }
        });
        
        cboFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFilterVisibility();
            }
        });
        
        // Set font for buttons
        Font buttonFont = new Font("Arial", Font.PLAIN, 14);
        btnSearch.setFont(buttonFont);
        btnRefresh.setFont(buttonFont);
        btnFilter.setFont(buttonFont);
        
        // Initial filter visibility
        updateFilterVisibility();
    }
    
    private void updateFilterVisibility() {
        String selected = (String) cboFilter.getSelectedItem();
        txtSearch.setVisible(selected.equals("Theo người dùng") || selected.equals("Theo hành động"));
        dateFrom.setVisible(selected.equals("Theo thời gian"));
        dateTo.setVisible(selected.equals("Theo thời gian"));
        btnFilter.setVisible(selected.equals("Theo thời gian"));
    }
    
    private void loadData() {
        model.setRowCount(0);
        List<ActivityLog> logs = activityLogDAO.findAll();
        displayLogs(logs);
    }
    
    private void search() {
        String selected = (String) cboFilter.getSelectedItem();
        String searchText = txtSearch.getText().trim();
        List<ActivityLog> logs;
        
        switch (selected) {
            case "Theo người dùng":
                logs = activityLogDAO.findByUsername(searchText);
                break;
            case "Theo hành động":
                logs = activityLogDAO.findByAction(searchText);
                break;
            default:
                logs = activityLogDAO.findAll();
                break;
        }
        
        displayLogs(logs);
    }
    
    private void filterByDate() {
        Date from = dateFrom.getDate();
        Date to = dateTo.getDate();
        
        if (from == null || to == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khoảng thời gian!");
            return;
        }
        
        List<ActivityLog> logs = activityLogDAO.findByDateRange(from, to);
        displayLogs(logs);
    }
    
    private void displayLogs(List<ActivityLog> logs) {
        model.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        for (ActivityLog log : logs) {
            model.addRow(new Object[]{
                sdf.format(log.getTimestamp()),
                log.getUsername(),
                log.getAction(),
                log.getDetails()
            });
        }
    }
}