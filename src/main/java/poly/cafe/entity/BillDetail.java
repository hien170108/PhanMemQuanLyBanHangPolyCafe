package poly.cafe.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Data
public class BillDetail {
    private Long id;
    private Long billId;
    private String drinkId;
    private double unitPrice;
    private double discount;
    private int quantity;
    
    private String drinkName;

    public BillDetail() {
    }

    public BillDetail(Long id, Long billId, String drinkId, double unitPrice, double discount, int quantity, String drinkName) {
        this.id = id;
        this.billId = billId;
        this.drinkId = drinkId;
        this.unitPrice = unitPrice;
        this.discount = discount;
        this.quantity = quantity;
        this.drinkName = drinkName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public String getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(String drinkId) {
        this.drinkId = drinkId;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }
    
}