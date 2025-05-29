package poly.cafe.ui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import poly.cafe.ui.manager.*;
import poly.cafe.util.XDialog;

public interface PolyCafeController {
    void init();
    
    default void exit() {
        if (XDialog.confirm("Bạn muốn kết thúc?")) {
            System.exit(0);
        }
    }
    
    default void showJDialog(JDialog dialog) {
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
    
    default void showWelcomeJDialog(JFrame frame) {
        this.showJDialog(new WelcomeJDialog(frame, true));
    }
    
    default void showLoginJDialog(JDialog dialog) {
        this.showJDialog(new LoginJDialog(dialog, true));
    }
    default void showRevenueManagerJDialog(JDialog dialog) {
        this.showJDialog(new RevenueManagerJDialog(dialog, true));
    }
    
    default void showChangePasswordJDialog(JFrame frame) {
        this.showJDialog(new ChangePasswordJDialog(frame, true));
    }
    
    default void showSalesJDialog(JFrame frame) {
        this.showJDialog(new SalesJDialog(frame, true));
    }
    default void showUserManagerJDialog(JFrame frame) {
        this.showJDialog(new UserManagerJDialog(frame, true));
    }
    
    default void showHistoryJDialog(JFrame frame) {
        this.showJDialog(new HistoryJDialog(frame, true));
    }
    
    default void showDrinkManagerJDialog(JFrame frame) {
        this.showJDialog(new DrinkManagerJDialog(frame, true));
    }
    
    default void showCategoryManagerJDialog(JFrame frame) {
        this.showJDialog(new CategoryManagerJDialog(frame, true));
    }
    
    default void showCardManagerJDialog(JFrame frame) {
        this.showJDialog(new CardManagerJDialog(frame, true));
    }
    
    default void showBillManagerJDialog(JFrame frame) {
        this.showJDialog(new BillManagerJDialog(frame, true));
    }
    default void showActivityHistoryJDialog(JDialog dialog) {
        this.showJDialog(new ActivityHistoryJDialog(dialog, true, null)); // Pass null or currentUser as needed
    }
}