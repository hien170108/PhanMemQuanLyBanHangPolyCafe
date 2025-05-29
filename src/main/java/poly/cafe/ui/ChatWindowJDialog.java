package poly.cafe.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import javax.swing.text.*;
import poly.cafe.dao.ChatMessageDAO;
import poly.cafe.dao.impl.ChatMessageDAOImpl;
import poly.cafe.entity.ChatMessage;
import poly.cafe.entity.User;
import poly.cafe.ui.controller.ChatController;
import poly.cafe.util.XDialog;
import poly.cafe.util.XUI;

public class ChatWindowJDialog extends JDialog implements ChatController {
    private JTextPane txtMessages;
    private JTextArea txtMessage;
    private JTextField txtSearch;
    private JButton btnSend;
    private JButton btnClear;
    private JButton btnRefresh;
    private JButton btnSearch;
    
    private ChatMessageDAO chatMessageDAO;
    private User currentUser;
    private SimpleDateFormat dateFormat;
    
    public ChatWindowJDialog(javax.swing.JFrame parent, boolean modal, User currentUser) {
        super(parent, modal);
        this.currentUser = currentUser;
        this.chatMessageDAO = new ChatMessageDAOImpl();
        this.dateFormat = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        initComponents();
        loadData();
    }
    
    private void initComponents() {
        setTitle("Chat");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        
        // Create message display area
        txtMessages = new JTextPane();
        txtMessages.setEditable(false);
        txtMessages.setContentType("text/html");
        txtMessages.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
        txtMessages.setFont(new Font("Arial", Font.PLAIN, 14));
        
        // Set preferred width to match window width
        txtMessages.setPreferredSize(new Dimension(getWidth() - 40, getHeight()));
        
        JScrollPane scrollPane = new JScrollPane(txtMessages);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        // Create search panel
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtSearch = new JTextField(20);
        btnSearch = new JButton("Tìm kiếm");
        searchPanel.add(new JLabel("Tìm kiếm: "));
        searchPanel.add(txtSearch);
        searchPanel.add(btnSearch);
        
        // Create input panel
        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        // Create text area for message input
        txtMessage = new JTextArea();
        txtMessage.setRows(3);
        txtMessage.setLineWrap(true);
        txtMessage.setWrapStyleWord(true);
        txtMessage.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane messageScrollPane = new JScrollPane(txtMessage);
        
        // Create button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnSend = new JButton("Gửi");
        btnClear = new JButton("Xoá Tin Nhắn");
        btnRefresh = new JButton("Làm mới");
        
        buttonPanel.add(btnSend);
        buttonPanel.add(btnClear);
        buttonPanel.add(btnRefresh);
        
        inputPanel.add(messageScrollPane, BorderLayout.CENTER);
        inputPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        // Add components to dialog
        add(searchPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
        
        // Add action listeners
        btnSend.addActionListener(e -> sendMessage());
        btnClear.addActionListener(e -> clearMessages());
        btnRefresh.addActionListener(e -> refreshMessages());
        btnSearch.addActionListener(e -> searchMessages());
        
        // Add key listener for Enter key to send message, Shift+Enter to newline
        txtMessage.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (e.isShiftDown()) {
                        // Cho phép xuống dòng
                        txtMessage.append("\n");
                    } else {
                        e.consume();
                        sendMessage();
                    }
                }
            }
            
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        
        // Set font for buttons
        Font buttonFont = new Font("Arial", Font.PLAIN, 14);
        btnSend.setFont(buttonFont);
        btnClear.setFont(buttonFont);
        btnRefresh.setFont(buttonFont);
        btnSearch.setFont(buttonFont);
        
        // Only show clear button for managers
        btnClear.setVisible(currentUser.isManager());
        
        // Set hand cursor for all buttons
        XUI.setHandCursor(this);
    }
    
    private void loadData() {
        List<ChatMessage> messages = chatMessageDAO.findAll();
        setMessagesToPane(messages);
    }

    private void setMessagesToPane(List<ChatMessage> messages) {
        StringBuilder html = new StringBuilder(
            "<html><body style='font-family:Arial;font-size:14pt;word-break:break-word;word-wrap:break-word;'>"
        );
        for (int i = messages.size() - 1; i >= 0; i--) {
            ChatMessage message = messages.get(i);
            html.append("<div style='margin-bottom: 10px; word-break: break-word; word-wrap: break-word;'>")
                .append("<span style='font-weight: bold;'>")
                .append(dateFormat.format(message.getTimestamp()))
                .append("</span> ")
                .append("<span style='font-weight: bold;'>")
                .append(message.getSenderUsername())
                .append(":</span> ")
                .append("<span style='font-weight: normal;'>")
                .append(message.getContent().replace("\n", "<br>"))
                .append("</span></div>");
        }
        html.append("</body></html>");
        txtMessages.setText(html.toString());
        txtMessages.setCaretPosition(0);
    }
    
    private void searchMessages() {
        String searchText = txtSearch.getText().trim().toLowerCase();
        List<ChatMessage> messages = chatMessageDAO.findAll();
        if (!searchText.isEmpty()) {
            messages = messages.stream()
                .filter(m -> m.getContent().toLowerCase().contains(searchText))
                .toList();
        }
        setMessagesToPane(messages);
    }
    
    @Override
    public void sendMessage() {
        String content = txtMessage.getText().trim();
        if (content.isEmpty()) {
            XDialog.alert("Vui lòng nhập nội dung tin nhắn!");
            return;
        }
        
        ChatMessage message = new ChatMessage();
        message.setSenderUsername(currentUser.getUsername());
        message.setContent(content);
        message.setTimestamp(new Date());
        
        try {
            chatMessageDAO.create(message);
            txtMessage.setText("");
            loadData();
        } catch (Exception e) {
            XDialog.alert("Lỗi gửi tin nhắn: " + e.getMessage());
        }
    }
    
    @Override
    public void clearMessages() {
        if (!currentUser.isManager()) {
            XDialog.alert("Bạn không có quyền xóa tin nhắn!");
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Bạn có chắc chắn muốn xóa tất cả tin nhắn?",
            "Xác nhận",
            JOptionPane.YES_NO_OPTION
        );
        
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                chatMessageDAO.deleteAll();
                loadData();
            } catch (Exception e) {
                XDialog.alert("Lỗi xóa tin nhắn: " + e.getMessage());
            }
        }
    }
    
    @Override
    public void refreshMessages() {
        loadData();
    }
} 