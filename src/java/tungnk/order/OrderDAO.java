/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tungnk.order;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tungnk.util.DBUtil;

public class OrderDAO {

    public List<OrderDTO> getAllOrders() throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<OrderDTO> list = new ArrayList<>();

        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String query = "SELECT * FROM Orders";
                stm = con.prepareStatement(query);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int accountID = rs.getInt("accountID");
                    int orderID = rs.getInt("orderID");
                    Date orderDate = rs.getDate("orderDate");
                    String address = rs.getString("shipAddress");
                    String phone = rs.getString("phone");
                    list.add(new OrderDTO(orderID, accountID, orderDate, address, phone));
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

        return list;
    }

    public OrderDTO insertOrder(int accountID, Date date, String address, String phone) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        OrderDTO order = new OrderDTO(accountID, date, address, phone);
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String query = "INSERT INTO Orders(accountID, orderDate, shipAddress, phone) VALUES (?, ?, ?, ?)";
                stm = con.prepareStatement(query);
                stm.setInt(1, accountID);
                stm.setDate(2, date);
                stm.setString(3, address);
                stm.setString(4, phone);
                stm.executeUpdate();
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return order;
    }

    public int getLastOrderByAccountID(int accountID) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int id = 0;

        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String query = "SELECT * FROM Orders WHERE accountID = ? AND orderID = (SELECT max(orderID) FROM Orders)";
                stm = con.prepareStatement(query);
                stm.setInt(1, accountID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    id = rs.getInt("orderID");
                    return id;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return id;
    }

    public List<OrderDTO> getListOrderByID(int accountID) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<OrderDTO> list = new ArrayList<>();

        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String query = "SELECT * FROM Orders WHERE accountID = ?";
                stm = con.prepareStatement(query);
                stm.setInt(1, accountID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int orderID = rs.getInt("orderID");
                    Date orderDate = rs.getDate("orderDate");
                    String address = rs.getString("shipAddress");
                    String phone = rs.getString("phone");
                    list.add(new OrderDTO(orderID, accountID, orderDate, address, phone));
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

        return list;
    }

    public List<OrderDTO> getListOrderByDate(Date date1, Date date2) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<OrderDTO> list = new ArrayList<>();

        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String query = "SELECT * FROM Orders WHERE orderDate BETWEEN ? AND ?";
                stm = con.prepareStatement(query);
                stm.setDate(1, date1);
                stm.setDate(2, date2);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int accountID = rs.getInt("accountID");
                    int orderID = rs.getInt("orderID");
                    Date orderDate = rs.getDate("orderDate");
                    String address = rs.getString("shipAddress");
                    String phone = rs.getString("phone");
                    list.add(new OrderDTO(orderID, accountID, orderDate, address, phone));
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

        return list;
    }

    public double getRevenueByDate(Date date1, Date date2) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        double revenue = 0;

        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String query = "SELECT SUM(d.price * d.quantity) AS totalprice "
                        + "FROM Order_Details d "
                        + "INNER JOIN Orders o ON d.orderID = o.orderID "
                        + "INNER JOIN Products p ON p.productID = d.productID "
                        + "WHERE o.orderDate BETWEEN ? AND ?";
                stm = con.prepareStatement(query);
                stm.setDate(1, date1);
                stm.setDate(2, date2);
                rs = stm.executeQuery();
                if (rs.next()) {
                    revenue = rs.getDouble("totalprice");
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

        return revenue;
    }

}
