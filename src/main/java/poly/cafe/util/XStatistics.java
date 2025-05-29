package poly.cafe.util;

import java.util.*;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import poly.cafe.entity.Bill;
import poly.cafe.entity.BillDetail;
import poly.cafe.entity.Drink;
import poly.cafe.dao.BillDetailDAO;
import poly.cafe.dao.impl.BillDetailDAOImpl;

public class XStatistics {
    
    private static final BillDetailDAO billDetailDao = new BillDetailDAOImpl();
    
    public static class SalesData {
        private final String label;
        private final double value;
        
        public SalesData(String label, double value) {
            this.label = label;
            this.value = value;
        }
        
        public String getLabel() { return label; }
        public double getValue() { return value; }
    }
    
    public static class ProductSales {
        private final Drink drink;
        private final int quantity;
        private final double revenue;
        
        public ProductSales(Drink drink, int quantity, double revenue) {
            this.drink = drink;
            this.quantity = quantity;
            this.revenue = revenue;
        }
        
        public Drink getDrink() { return drink; }
        public int getQuantity() { return quantity; }
        public double getRevenue() { return revenue; }
    }
    
    public static List<SalesData> getDailyRevenue(List<Bill> bills, int days) {
        Map<LocalDate, Double> dailyRevenue = new TreeMap<>();
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(days - 1);
        
        // Initialize all dates with zero revenue
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            dailyRevenue.put(date, 0.0);
        }
        
        // Calculate revenue for each day
        for (Bill bill : bills) {
            LocalDate billDate = bill.getCheckin().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
            if (!billDate.isBefore(startDate) && !billDate.isAfter(endDate)) {
                double revenue = calculateBillRevenue(bill);
                dailyRevenue.merge(billDate, revenue, Double::sum);
            }
        }
        
        // Convert to list of SalesData
        return dailyRevenue.entrySet().stream()
            .map(entry -> new SalesData(
                entry.getKey().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM")),
                entry.getValue()
            ))
            .collect(Collectors.toList());
    }
    
    public static List<SalesData> getWeeklyRevenue(List<Bill> bills, int weeks) {
        Map<LocalDate, Double> weeklyRevenue = new TreeMap<>();
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusWeeks(weeks - 1).with(TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY));
        
        // Initialize all weeks with zero revenue
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusWeeks(1)) {
            weeklyRevenue.put(date, 0.0);
        }
        
        // Calculate revenue for each week
        for (Bill bill : bills) {
            LocalDate billDate = bill.getCheckin().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
            LocalDate weekStart = billDate.with(TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY));
            if (!weekStart.isBefore(startDate) && !weekStart.isAfter(endDate)) {
                double revenue = calculateBillRevenue(bill);
                weeklyRevenue.merge(weekStart, revenue, Double::sum);
            }
        }
        
        // Convert to list of SalesData
        return weeklyRevenue.entrySet().stream()
            .map(entry -> new SalesData(
                "Tuần " + entry.getKey().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM")),
                entry.getValue()
            ))
            .collect(Collectors.toList());
    }
    
    public static List<SalesData> getMonthlyRevenue(List<Bill> bills, int months) {
        Map<LocalDate, Double> monthlyRevenue = new TreeMap<>();
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusMonths(months - 1).withDayOfMonth(1);
        
        // Initialize all months with zero revenue
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusMonths(1)) {
            monthlyRevenue.put(date, 0.0);
        }
        
        // Calculate revenue for each month
        for (Bill bill : bills) {
            LocalDate billDate = bill.getCheckin().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
            LocalDate monthStart = billDate.withDayOfMonth(1);
            if (!monthStart.isBefore(startDate) && !monthStart.isAfter(endDate)) {
                double revenue = calculateBillRevenue(bill);
                monthlyRevenue.merge(monthStart, revenue, Double::sum);
            }
        }
        
        // Convert to list of SalesData
        return monthlyRevenue.entrySet().stream()
            .map(entry -> new SalesData(
                entry.getKey().format(java.time.format.DateTimeFormatter.ofPattern("MM/yyyy")),
                entry.getValue()
            ))
            .collect(Collectors.toList());
    }
    
    public static List<ProductSales> getTopSellingProducts(List<Bill> bills, int limit) {
        Map<Drink, ProductSales> productSales = new HashMap<>();
        
        // Calculate sales for each product
        for (Bill bill : bills) {
            List<BillDetail> details = billDetailDao.findByBillId(bill.getId());
            for (BillDetail detail : details) {
                Drink drink = new Drink();
                drink.setId(detail.getDrinkId());
                drink.setName(detail.getDrinkName());
                
                int quantity = detail.getQuantity();
                double revenue = quantity * detail.getUnitPrice() * (1 - detail.getDiscount());
                
                productSales.merge(drink, 
                    new ProductSales(drink, quantity, revenue),
                    (old, new_) -> new ProductSales(
                        drink,
                        old.getQuantity() + new_.getQuantity(),
                        old.getRevenue() + new_.getRevenue()
                    )
                );
            }
        }
        
        // Sort by quantity and get top products
        return productSales.values().stream()
            .sorted(Comparator.comparing(ProductSales::getQuantity).reversed())
            .limit(limit)
            .collect(Collectors.toList());
    }
    
    private static double calculateBillRevenue(Bill bill) {
        return billDetailDao.findByBillId(bill.getId()).stream()
            .mapToDouble(detail -> 
                detail.getQuantity() * detail.getUnitPrice() * (1 - detail.getDiscount())
            )
            .sum();
    }
} 