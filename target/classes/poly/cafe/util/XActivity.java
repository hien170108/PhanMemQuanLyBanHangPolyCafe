package poly.cafe.util;

import java.util.Date;
import poly.cafe.dao.ActivityLogDAO;
import poly.cafe.dao.impl.ActivityLogDAOImpl;
import poly.cafe.entity.ActivityLog;
import poly.cafe.entity.User;

public class XActivity {
    private static final ActivityLogDAO activityLogDAO = new ActivityLogDAOImpl();
    
    public static void log(User user, String action, String details) {
        if (user == null) return;
        
        ActivityLog log = new ActivityLog();
        log.setUsername(user.getUsername());
        log.setAction(action);
        log.setDetails(details);
        log.setTimestamp(new Date());
        
        activityLogDAO.create(log);
    }
    
    public static void logLogin(User user) {
        log(user, "Đăng nhập", "Đăng nhập vào hệ thống");
    }
    
    public static void logLogout(User user) {
        log(user, "Đăng xuất", "Đăng xuất khỏi hệ thống");
    }
    
    public static void logCreate(User user, String entity, String details) {
        log(user, "Tạo mới " + entity, details);
    }
    
    public static void logUpdate(User user, String entity, String details) {
        log(user, "Cập nhật " + entity, details);
    }
    
    public static void logDelete(User user, String entity, String details) {
        log(user, "Xóa " + entity, details);
    }
    
    public static void logImport(User user, String entity, String details) {
        log(user, "Nhập " + entity, details);
    }
    
    public static void logExport(User user, String entity, String details) {
        log(user, "Xuất " + entity, details);
    }
} 