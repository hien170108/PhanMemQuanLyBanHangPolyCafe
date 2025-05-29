/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.cafe.util;

import poly.cafe.entity.User;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 *
 * @author hngo2
 */
public class XAuth {

    public static User user = new User.Builder()
            .username("user1@gmail.com")
            .password("123")
            .enabled(true)
            .manager(true)
            .fullname("Nguyễn Văn Tèo")
            .photo("trump.png")
            .email("user1@gmail.com")
            .build(); // biến user này sẽ được thay thế sau khi đăng nhập
            
    public static void clear() {
        user = new User.Builder()
                .username("user1@gmail.com")
                .password("123")
                .enabled(true)
                .manager(true)
                .fullname("Nguyễn Văn Tèo")
                .photo("trump.png")
                .email("user1@gmail.com")
                .build();
    }

    public static String encrypt(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(text.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static boolean verify(String text, String hash) {
        return text.equals(hash);
    }
}
