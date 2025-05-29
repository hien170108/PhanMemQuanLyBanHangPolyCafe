package poly.cafe.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Data
public class Bill {
    private Long id;
    private String username;
    private Integer cardId;
    @Builder.Default
    private Date checkin = new Date();
    private Date checkout;
    private int status;

    public Bill() {
    }

    public Bill(Long id, String username, Integer cardId, Date checkout, int status) {
        this.id = id;
        this.username = username;
        this.cardId = cardId;
        this.checkout = checkout;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public enum Status {
        Servicing, Completed, Canceled;
    }
    public static final String DATE_PATTERN = "HH:mm:ss dd-MM-yyyy";
}