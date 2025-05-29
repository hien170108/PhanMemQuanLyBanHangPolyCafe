package poly.cafe.util;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class XEmail {
    private static final String EMAIL = "quanghien1701@gmail.com"; // Replace with your email
    private static final String PASSWORD = "jgpt vfxf nskw ltxl"; // Replace with your app password
    
    public static void sendVerificationCode(String toEmail, String code) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL, PASSWORD);
            }
        });
        
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(EMAIL));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
        message.setSubject("Mã xác thực đặt lại mật khẩu - Phần mềm PolyCafe");
        message.setText("Mã xác thực của bạn là: " + code + "\n\nMã này sẽ hết hạn sau 5 phút.");
        
        Transport.send(message);
    }
} 