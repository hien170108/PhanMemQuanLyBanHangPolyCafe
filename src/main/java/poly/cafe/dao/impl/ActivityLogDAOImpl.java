package poly.cafe.dao.impl;

import java.util.Date;
import java.util.List;
import poly.cafe.dao.ActivityLogDAO;
import poly.cafe.entity.ActivityLog;
import poly.cafe.util.XJdbc;
import poly.cafe.util.XQuery;

public class ActivityLogDAOImpl implements ActivityLogDAO {
    private final String createSql = "INSERT INTO ActivityLogs(Username, Action, Details, Timestamp) VALUES(?, ?, ?, ?)";
    private final String findAllSql = "SELECT * FROM ActivityLogs ORDER BY Timestamp DESC";
    private final String findByUsernameSql = "SELECT * FROM ActivityLogs WHERE Username = ? ORDER BY Timestamp DESC";
    private final String findByActionSql = "SELECT * FROM ActivityLogs WHERE Action = ? ORDER BY Timestamp DESC";
    private final String findByDateRangeSql = "SELECT * FROM ActivityLogs WHERE Timestamp BETWEEN ? AND ? ORDER BY Timestamp DESC";

    @Override
    public void create(ActivityLog entity) {
        Object[] values = {
            entity.getUsername(),
            entity.getAction(),
            entity.getDetails(),
            entity.getTimestamp()
        };
        XJdbc.executeUpdate(createSql, values);
    }

    @Override
    public List<ActivityLog> findAll() {
        return XQuery.getBeanList(ActivityLog.class, findAllSql);
    }

    @Override
    public List<ActivityLog> findByUsername(String username) {
        return XQuery.getBeanList(ActivityLog.class, findByUsernameSql, username);
    }

    @Override
    public List<ActivityLog> findByAction(String action) {
        return XQuery.getBeanList(ActivityLog.class, findByActionSql, action);
    }

    @Override
    public List<ActivityLog> findByDateRange(Date startDate, Date endDate) {
        return XQuery.getBeanList(ActivityLog.class, findByDateRangeSql, startDate, endDate);
    }
} 