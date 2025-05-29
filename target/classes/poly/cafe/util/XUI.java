package poly.cafe.util;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class XUI {
    private static boolean isDarkMode = false;
    
    public static void setupUI(JDialog dialog) {
        // Set FlatLaf look and feel
        try {
            UIManager.setLookAndFeel(isDarkMode ? new FlatDarkLaf() : new FlatLightLaf());
            SwingUtilities.updateComponentTreeUI(dialog);
        } catch (Exception ex) {
            System.err.println("Failed to initialize FlatLaf");
        }

        // Set dialog properties
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
    }
    
    public static void setupUI(JFrame frame) {
        // Set FlatLaf look and feel
        try {
            UIManager.setLookAndFeel(isDarkMode ? new FlatDarkLaf() : new FlatLightLaf());
            SwingUtilities.updateComponentTreeUI(frame);
        } catch (Exception ex) {
            System.err.println("Failed to initialize FlatLaf");
        }
    }
    
    public static void toggleTheme(JDialog dialog) {
        isDarkMode = !isDarkMode;
        setupUI(dialog);
    }
    
    public static void toggleTheme(JFrame frame) {
        isDarkMode = !isDarkMode;
        setupUI(frame);
    }
    
    public static boolean isDarkMode() {
        return isDarkMode;
    }
    
    public static void customizeButton(JButton button, Color backgroundColor) {
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
    public static void customizeTextField(JTextField textField) {
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(isDarkMode ? new Color(100, 100, 100) : new Color(204, 204, 204)),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
    }
    
    public static void customizePasswordField(JPasswordField passwordField) {
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passwordField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(isDarkMode ? new Color(100, 100, 100) : new Color(204, 204, 204)),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
    }
    
    public static void customizeLabel(JLabel label) {
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        label.setForeground(isDarkMode ? Color.WHITE : Color.BLACK);
    }
    
    public static void customizeTitle(JLabel label) {
        label.setFont(new Font("Segoe UI", Font.BOLD, 24));
        label.setForeground(isDarkMode ? Color.WHITE : new Color(51, 51, 51));
    }
    
    public static void setPanelPadding(JPanel panel, int top, int left, int bottom, int right) {
        panel.setBorder(new EmptyBorder(top, left, bottom, right));
        panel.setBackground(isDarkMode ? new Color(43, 43, 43) : Color.WHITE);
    }
    
    public static void customizeTable(JTable table) {
        table.setRowHeight(30);
        table.setSelectionBackground(new Color(0, 120, 212));
        table.setSelectionForeground(Color.WHITE);
        table.setBackground(isDarkMode ? new Color(43, 43, 43) : Color.WHITE);
        table.setForeground(isDarkMode ? Color.WHITE : Color.BLACK);
        table.setGridColor(isDarkMode ? new Color(100, 100, 100) : new Color(204, 204, 204));
    }
    
    public static ImageIcon loadIcon(String path, int width, int height) {
        try {
            ImageIcon originalIcon = new ImageIcon(path);
            Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImage);
        } catch (Exception e) {
            System.err.println("Failed to load icon: " + path);
            return null;
        }
    }
    
    /**
     * Thiết lập con trỏ hand cho tất cả các nút trong container
     * @param container Container chứa các nút cần thiết lập
     */
    public static void setHandCursor(Container container) {
        for (Component comp : container.getComponents()) {
            if (comp instanceof JButton) {
                comp.setCursor(new Cursor(Cursor.HAND_CURSOR));
            } else if (comp instanceof Container) {
                setHandCursor((Container) comp);
            }
        }
    }
} 