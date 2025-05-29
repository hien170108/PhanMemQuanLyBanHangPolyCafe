package poly.cafe.util;

import java.util.regex.Pattern;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class XValidation {
    
    // Email validation pattern
    private static final Pattern EMAIL_PATTERN = 
        Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    
    // Phone number validation pattern (Vietnamese format)
    private static final Pattern PHONE_PATTERN = 
        Pattern.compile("^(0|84)([0-9]{9})$");
    
    // Price validation pattern (positive number with up to 2 decimal places)
    private static final Pattern PRICE_PATTERN = 
        Pattern.compile("^\\d+(\\.\\d{1,2})?$");
    
    public static boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }
    
    public static boolean isValidPhone(String phone) {
        return phone != null && PHONE_PATTERN.matcher(phone).matches();
    }
    
    public static boolean isValidPrice(String price) {
        return price != null && PRICE_PATTERN.matcher(price).matches();
    }
    
    public static boolean isValidRequired(JTextField txt) {
        if (txt.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(txt, 
                "Vui lòng nhập đầy đủ thông tin!", 
                "Lỗi", JOptionPane.ERROR_MESSAGE);
            txt.requestFocus();
            return false;
        }
        return true;
    }
    
    public static boolean isValidEmail(JTextField txt) {
        if (!isValidEmail(txt.getText().trim())) {
            JOptionPane.showMessageDialog(txt, 
                "Email không hợp lệ!", 
                "Lỗi", JOptionPane.ERROR_MESSAGE);
            txt.requestFocus();
            return false;
        }
        return true;
    }
    
    public static boolean isValidPhone(JTextField txt) {
        if (!isValidPhone(txt.getText().trim())) {
            JOptionPane.showMessageDialog(txt, 
                "Số điện thoại không hợp lệ!", 
                "Lỗi", JOptionPane.ERROR_MESSAGE);
            txt.requestFocus();
            return false;
        }
        return true;
    }
    
    public static boolean isValidPrice(JTextField txt) {
        if (!isValidPrice(txt.getText().trim())) {
            JOptionPane.showMessageDialog(txt, 
                "Giá không hợp lệ!", 
                "Lỗi", JOptionPane.ERROR_MESSAGE);
            txt.requestFocus();
            return false;
        }
        return true;
    }
    
    public static boolean isValidSelection(JComboBox<?> cbo) {
        if (cbo.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(cbo, 
                "Vui lòng chọn một mục!", 
                "Lỗi", JOptionPane.ERROR_MESSAGE);
            cbo.requestFocus();
            return false;
        }
        return true;
    }
    
    public static boolean isValidQuantity(JTextField txt) {
        try {
            int quantity = Integer.parseInt(txt.getText().trim());
            if (quantity <= 0) {
                JOptionPane.showMessageDialog(txt, 
                    "Số lượng phải lớn hơn 0!", 
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
                txt.requestFocus();
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(txt, 
                "Số lượng không hợp lệ!", 
                "Lỗi", JOptionPane.ERROR_MESSAGE);
            txt.requestFocus();
            return false;
        }
    }
    
    public static boolean isValidDiscount(JTextField txt) {
        try {
            double discount = Double.parseDouble(txt.getText().trim());
            if (discount < 0 || discount > 1) {
                JOptionPane.showMessageDialog(txt, 
                    "Giảm giá phải từ 0 đến 1!", 
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
                txt.requestFocus();
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(txt, 
                "Giảm giá không hợp lệ!", 
                "Lỗi", JOptionPane.ERROR_MESSAGE);
            txt.requestFocus();
            return false;
        }
    }
} 