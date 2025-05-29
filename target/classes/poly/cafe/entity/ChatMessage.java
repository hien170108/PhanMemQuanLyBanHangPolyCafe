package poly.cafe.entity;

import java.util.Date;
import poly.cafe.util.XDate;

public class ChatMessage {
    private int id;
    private String senderUsername;
    private String content;
    private Date timestamp;
    private boolean isRead;
    
    public static final String DATE_PATTERN = "dd/MM/yyyy HH:mm:ss";
    
    public ChatMessage() {
        this.timestamp = new Date();
        this.isRead = false;
    }
    
    public ChatMessage(int id, String senderUsername, String content, Date timestamp, boolean isRead) {
        this.id = id;
        this.senderUsername = senderUsername;
        this.content = content;
        this.timestamp = timestamp;
        this.isRead = isRead;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getSenderUsername() {
        return senderUsername;
    }
    
    public void setSenderUsername(String senderUsername) {
        this.senderUsername = senderUsername;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public Date getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    
    public boolean isIsRead() {
        return isRead;
    }
    
    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }
    
    public String getFormattedTimestamp() {
        return XDate.format(timestamp, DATE_PATTERN);
    }
} 