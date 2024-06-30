/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tungnk.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tungnk.util.DBUtil;

/**
 *
 * @author ktung
 */
public class AccountDAO {

    public AccountDTO checkLogin(String userName, String password) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        AccountDTO user = null;
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String query = "SELECT * FROM Account WHERE username = ? AND password = ?";
                stm = con.prepareStatement(query);
                stm.setString(1, userName);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getString("fullName");
                    boolean isAdmin = rs.getBoolean("isAdmin");
                    String phone = rs.getString("phone");
                    String address = rs.getString("address");
                    user = new AccountDTO(userName, password, fullName, isAdmin, phone, address);
                    return user;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return user;
    }

    public boolean checkExisted(String userName) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String query = "SELECT * FROM Account WHERE username = ?";
                stm = con.prepareStatement(query);
                stm.setString(1, userName);
                rs = stm.executeQuery();
                if (!rs.next()) {
                    return false;
                }
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }

        }
        return true;
    }

    public boolean checkIsAdmin(String userName) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String query = "SELECT * FROM Account WHERE username = ?";
                stm = con.prepareStatement(query);
                stm.setString(1, userName);
                rs = stm.executeQuery();
                if (rs.next()) {
                    boolean isAdmin = rs.getBoolean("isAdmin");
                    if (isAdmin) {
                        return true;
                    }
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean insertNewUser(String username, String password, String fullName, boolean isAdmin, String phone, String address) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtil.makeConnection();
            boolean isExisted = checkExisted(username);
            if (con != null && !isExisted) {
                String query = "INSERT INTO Account(username, password, fullname, isAdmin, phone, address) VALUES (?, ?, ?, ?, ?, ?)";
                stm = con.prepareStatement(query);
                stm.setString(1, username);
                stm.setString(2, password);
                stm.setString(3, fullName);
                stm.setBoolean(4, isAdmin);
                stm.setString(5, phone);
                stm.setString(6, address);
                stm.executeUpdate();
                return true;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
    public int getIDByUserName(String username) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int id = 0;
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String query = "SELECT * FROM Account WHERE username = ?";
                stm = con.prepareStatement(query);
                stm.setString(1, username);
                rs = stm.executeQuery();
                if (rs.next()) {
                    id = rs.getInt("accountID");
                    return id;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return id;
    }
}
