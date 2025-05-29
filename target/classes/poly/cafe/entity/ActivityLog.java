package poly.cafe.entity;

import java.util.Date;
import poly.cafe.util.XDate;

public class ActivityLog {
    private int id;
    private String username;
    private String action;
    private String details;
    private Date timestamp;
    
    public static final String DATE_PATTERN = "dd/MM/yyyy HH:mm:ss";
    
    public ActivityLog() {
        this.timestamp = new Date();
    }
    
    public ActivityLog(String username, String action, String details) {
        this();
        this.username = username;
        this.action = action;
        this.details = details;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getAction() {
        return action;
    }
    
    public void setAction(String action) {
        this.action = action;
    }
    
    public String getDetails() {
        return details;
    }
    
    public void setDetails(String details) {
        this.details = details;
    }
    
    public Date getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getFormattedTimestamp() {
        return XDate.format(timestamp, DATE_PATTERN);
    }
} 