package poly.cafe.dao;

import java.util.Date;
import java.util.List;
import poly.cafe.entity.ActivityLog;

public interface ActivityLogDAO {
    void create(ActivityLog entity);
    List<ActivityLog> findAll();
    List<ActivityLog> findByUsername(String username);
    List<ActivityLog> findByAction(String action);
    List<ActivityLog> findByDateRange(Date startDate, Date endDate);
} 