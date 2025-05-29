package poly.cafe.dao.impl;

import java.sql.ResultSet;
import java.util.List;
import poly.cafe.dao.UserDAO;
import poly.cafe.entity.User;
import poly.cafe.util.XJdbc;
import poly.cafe.util.XQuery;

public class UserDAOImpl implements UserDAO {
    private static final String findAllSql = "SELECT * FROM Users";
    private static final String findByIdSql = "SELECT * FROM Users WHERE Username = ?";
    private static final String findByUsernameSql = "SELECT * FROM Users WHERE Username = ?";
    private static final String createSql = "INSERT INTO Users (Username, Password, Fullname, Email, Manager, Enabled, Photo) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String updateSql = "UPDATE Users SET Password = ?, Fullname = ?, Email = ?, Manager = ?, Enabled = ?, Photo = ? WHERE Username = ?";
    private static final String deleteByIdSql = "DELETE FROM Users WHERE Username = ?";
    
    @Override
    public List<User> findAll() {
        return XQuery.getBeanList(User.class, findAllSql);
    }
    
    @Override
    public User findById(String id) {
        return XQuery.getSingleBean(User.class, findByIdSql, id);
    }
    
    @Override
    public User findByUsername(String username) {
        return XQuery.getSingleBean(User.class, findByUsernameSql, username);
    }
    
    @Override
    public void create(User user) {
        XQuery.execute(createSql, 
            user.getUsername(),
            user.getPassword(),
            user.getFullname(),
            user.getEmail(),
            user.isManager(),
            user.isEnabled(),
            user.getPhoto()
        );
    }
    
    @Override
    public void update(User user) {
        XQuery.execute(updateSql,
            user.getPassword(),
            user.getFullname(),
            user.getEmail(),
            user.isManager(),
            user.isEnabled(),
            user.getPhoto(),
            user.getUsername()
        );
    }
    
    @Override
    public void deleteById(String id) {
        XQuery.execute(deleteByIdSql, id);
    }
}
