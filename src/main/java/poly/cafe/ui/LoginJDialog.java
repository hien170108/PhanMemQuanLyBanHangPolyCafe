/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package poly.cafe.ui;

import javax.swing.JFrame;
import poly.cafe.dao.UserDAO;
import poly.cafe.dao.impl.UserDAOImpl;
import poly.cafe.entity.User;
import poly.cafe.util.XActivity;
import poly.cafe.util.XAuth;
import poly.cafe.util.XDialog;
import poly.cafe.util.XIcon;
import poly.cafe.util.XUI;
import java.awt.Color;

/**
 *
 * @author DELL
 */
public class LoginJDialog extends javax.swing.JDialog implements LoginController {

    private UserDAO userDAO;
    private User user;

    /**
     * Creates new form LoginJDialog
     */
//    public LoginJDialog(java.awt.Frame parent, boolean modal) {
//        super(parent, modal);
//        initComponents();
//        this.userDAO = new UserDAOImpl();
//        this.init();
//    }

    public LoginJDialog(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.userDAO = new UserDAOImpl();
        this.init();
        getRootPane().setDefaultButton(btnLogin);
    }

    private void setupUI() {
        XUI.setupUI(this);
        
        // Set padding and margins
        XUI.setPanelPadding(jPanel1, 20, 20, 20, 20);
        XUI.setPanelPadding(jPanel2, 20, 20, 20, 20);
        
        // Customize title
        XUI.customizeTitle(jLabel1);
        
        // Customize buttons
        XUI.customizeButton(btnLogin, new Color(0, 204, 0));
        XUI.customizeButton(btnExit, new Color(255, 51, 51));
        XUI.customizeButton(btnChangePassword, new Color(51,51,255));
        
        // Customize text fields
        XUI.customizeTextField(txtUsername);
        XUI.customizeTextField(txtPassword);
        
        // Customize labels
        XUI.customizeLabel(jLabel2);
        XUI.customizeLabel(jLabel3);
        XUI.customizeLabel(jLabel4);

        // Set hand cursor for all buttons
        XUI.setHandCursor(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnChangePassword = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        tglbtnShowPassword = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Đăng nhập");
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poly/cafe/icons/login-image.png"))); // NOI18N
        jPanel2.add(jLabel4, java.awt.BorderLayout.LINE_START);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        btnExit.setBackground(new java.awt.Color(255, 51, 51));
        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("Kết thúc");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit);
        btnExit.setBounds(20, 320, 90, 30);

        btnLogin.setBackground(new java.awt.Color(0, 204, 0));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Đăng nhập");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin);
        btnLogin.setBounds(220, 280, 120, 30);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐĂNG NHẬP");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 40, 370, 60);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tên đăng nhập");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 120, 120, 20);
        jPanel1.add(txtUsername);
        txtUsername.setBounds(20, 150, 320, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Mật khẩu");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 200, 70, 20);

        btnChangePassword.setBackground(new java.awt.Color(51, 51, 255));
        btnChangePassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnChangePassword.setForeground(new java.awt.Color(255, 255, 255));
        btnChangePassword.setText("Quên mật khẩu");
        btnChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePasswordActionPerformed(evt);
            }
        });
        jPanel1.add(btnChangePassword);
        btnChangePassword.setBounds(190, 320, 150, 30);
        jPanel1.add(txtPassword);
        txtPassword.setBounds(20, 226, 320, 30);

        tglbtnShowPassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tglbtnShowPassword.setText("Hiện mật khẩu");
        tglbtnShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglbtnShowPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(tglbtnShowPassword);
        tglbtnShowPassword.setBounds(20, 280, 140, 30);

        jPanel2.add(jPanel1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 907, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        this.exit();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {
        this.login();
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        this.open();
    }//GEN-LAST:event_formWindowOpened

    private void tglbtnShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglbtnShowPasswordActionPerformed
        // TODO add your handling code here:
        if (tglbtnShowPassword.isSelected()) {
            txtPassword.setEchoChar((char) 0); // Show password
            tglbtnShowPassword.setText("Ẩn mật khẩu");
        } else {
            txtPassword.setEchoChar('•'); // Hide password
            tglbtnShowPassword.setText("Hiện mật khẩu");
        }
    }//GEN-LAST:event_tglbtnShowPasswordActionPerformed

    private void btnChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {
        ForgotPasswordJDialog dialog = new ForgotPasswordJDialog(this, true);
        dialog.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginJDialog dialog = new LoginJDialog(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToggleButton tglbtnShowPassword;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    @Override
    public void open() {
        this.setLocationRelativeTo(null);
    }

    @Override
    public void login() {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());
        
        if (username.isEmpty() || password.isEmpty()) {
            XDialog.alert("Vui lòng nhập đầy đủ thông tin!");
            return;
        }
        
        try {
            user = userDAO.findByUsername(username);
            if (user == null) {
                XDialog.alert("Tài khoản không tồn tại!");
                return;
            }
            
            if (!XAuth.verify(password, user.getPassword())) {
                XDialog.alert("Mật khẩu không đúng!");
                return;
            }
            
            if (!user.isEnabled()) {
                XDialog.alert("Tài khoản đã bị khóa!");
                return;
            }
            
            XActivity.logLogin(user);
            XDialog.info("Đăng nhập thành công!");
            XAuth.user = user;
            this.dispose();
            
            // Open main window
            PolyCafeJFrame mainFrame = new PolyCafeJFrame(user);
            mainFrame.setVisible(true);
            
        } catch (Exception e) {
            XDialog.alert("Lỗi đăng nhập: " + e.getMessage());
        }
    }

    @Override
    public void init() {
        this.setLocationRelativeTo(null);
        this.setIconImage(XIcon.getIcon("trump-small.png").getImage());
        this.setTitle("Đăng nhập");
        this.setupUI();
    }
}
