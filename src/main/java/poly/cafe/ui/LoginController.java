package poly.cafe.ui;

import javax.swing.JDialog;
import poly.cafe.util.XDialog;

public interface LoginController {
    void init();
    void open();
    void login();
    
    default void exit() {
        if (XDialog.confirm("Bạn muốn kết thúc?")) {
            System.exit(0);
        }
    }
    
    default void showJDialog(JDialog dialog) {
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}
