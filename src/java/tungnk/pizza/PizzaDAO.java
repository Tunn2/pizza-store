/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tungnk.pizza;

import bestseller.tungnk.BestSellerDTO;
import com.sun.corba.se.spi.oa.OADefault;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tungnk.util.DBUtil;

/**
 *
 * @author ktung
 */
public class PizzaDAO {

    public List<PizzaDTO> getData() throws ClassNotFoundException, SQLException {
        List<PizzaDTO> list = new ArrayList<>();
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String query = "SELECT * FROM Products";
                stm = con.prepareStatement(query);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("productID");
                    String name = rs.getString("productName");
                    int supplierID = rs.getInt("supplierID");
                    int categoryID = rs.getInt("categoryID");
                    int quantity = rs.getInt("quantity");
                    double price = rs.getDouble("price");
                    String image = rs.getString("image");
                    String description = rs.getString("description");
                    boolean isSale = rs.getBoolean("isSale");

                    list.add(new PizzaDTO(id, name, supplierID, categoryID, price, quantity, image, description, isSale));
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

    public List<PizzaDTO> getPizzaByName(String search) throws SQLException, ClassNotFoundException {
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement stm = null;
        List<PizzaDTO> list = new ArrayList<>();
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String query = "SELECT * FROM Products WHERE productName LIKE ?";
                stm = con.prepareStatement(query);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("productID");

                    String name = rs.getString("productName");
                    int supplierID = rs.getInt("supplierID");
                    int categoryID = rs.getInt("categoryID");
                    int quantity = rs.getInt("quantity");
                    double price = rs.getDouble("price");
                    String image = rs.getString("image");
                    String description = rs.getString("description");
                    boolean isSale = rs.getBoolean("isSale");

                    list.add(new PizzaDTO(id, name, supplierID, categoryID, price, quantity, image, description, isSale));
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

    public List<PizzaDTO> getPizzaByCategory(int categoryID) throws SQLException, ClassNotFoundException {
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement stm = null;
        List<PizzaDTO> list = new ArrayList<>();
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String query = "SELECT * FROM Products WHERE categoryID = ?";
                stm = con.prepareStatement(query);
                stm.setInt(1, categoryID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("productID");

                    String name = rs.getString("productName");
                    int supplierID = rs.getInt("supplierID");
                    int quantity = rs.getInt("quantity");
                    double price = rs.getDouble("price");
                    String image = rs.getString("image");
                    String description = rs.getString("description");
                    boolean isSale = rs.getBoolean("isSale");

                    list.add(new PizzaDTO(id, name, supplierID, categoryID, price, quantity, image, description, isSale));
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

    public List<PizzaDTO> getPizzaByPrice(double price1, double price2) throws SQLException, ClassNotFoundException {
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement stm = null;
        List<PizzaDTO> list = new ArrayList<>();
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String query = "SELECT * FROM Products WHERE price BETWEEN ? AND ?";
                stm = con.prepareStatement(query);
                stm.setDouble(1, price1);
                stm.setDouble(2, price2);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("productID");

                    String name = rs.getString("productName");
                    int supplierID = rs.getInt("supplierID");
                    int categoryID = rs.getInt("categoryID");
                    int quantity = rs.getInt("quantity");
                    double price = rs.getDouble("price");
                    String image = rs.getString("image");
                    String description = rs.getString("description");
                    boolean isSale = rs.getBoolean("isSale");

                    list.add(new PizzaDTO(id, name, supplierID, categoryID, price, quantity, image, description, isSale));
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

    public PizzaDTO getPizzaByID(int id) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        PizzaDTO pizza = null;
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String query = "SELECT * FROM Products WHERE productID = ?";
                stm = con.prepareStatement(query);
                stm.setInt(1, id);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("productName");
                    int supplierID = rs.getInt("supplierID");
                    int categoryID = rs.getInt("categoryID");
                    int quantity = rs.getInt("quantity");
                    double price = rs.getDouble("price");
                    String image = rs.getString("image");
                    String description = rs.getString("description");
                    boolean isSale = rs.getBoolean("isSale");
                    pizza = new PizzaDTO(id, name, supplierID, categoryID, price, quantity, image, description, isSale);
                    return pizza;
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
        return null;
    }

    public boolean update(int id, String name, int supplierID, int categoryID, int quantity, double price, String image, String description) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String query = "UPDATE Products SET productName = ?, supplierID = ?, categoryID = ?, quantity = ?, price = ?, image = ?, description = ? WHERE productID = ? ";
                stm = con.prepareStatement(query);
                stm.setString(1, name);
                stm.setInt(2, supplierID);
                stm.setInt(3, categoryID);
                stm.setInt(4, quantity);
                stm.setDouble(5, price);
                stm.setString(6, image);
                stm.setString(7, description);
                stm.setInt(8, id);
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
        return true;
    }
//

    public boolean insert(String name, int supplierID, int categoryID, int quantity, double price, String image, String description) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String query = "INSERT INTO Products(productName, supplierID, categoryID, quantity, price, image, description, isSale) VALUES (?, ?, ?, ?, ?, ?, ?, 1)";
                stm = con.prepareStatement(query);
                stm.setString(1, name);
                stm.setInt(2, supplierID);
                stm.setInt(3, categoryID);
                stm.setInt(4, quantity);
                stm.setDouble(5, price);
                stm.setString(6, image);
                stm.setString(7, description);
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
        return true;
    }

    public void remove(int id) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String query = "UPDATE Products SET isSale = 0 WHERE productID = ?";
                stm = con.prepareStatement(query);
                stm.setInt(1, id);
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
    }

    public void updateCart(int id, int quantity) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        PizzaDTO pizza = getPizzaByID(id);
        int quantity2 = pizza.getQuantity() - quantity;
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String query = "UPDATE Products SET quantity = ? WHERE productID = ?";
                stm = con.prepareStatement(query);
                stm.setInt(1, quantity2);
                stm.setInt(2, id);
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
    }

    public List<BestSellerDTO> getListBestSeller() throws ClassNotFoundException, SQLException {
        List<BestSellerDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String query = "SELECT d.productID, p.productName, d.price, sum(d.quantity) as saled "
                        + "FROM Order_Details d inner join Products p on d.productID = p.productID "
                        + "GROUP by d.productID, p.productName, d.price order by saled desc ";
                stm = con.prepareStatement(query);
                rs = stm.executeQuery();
                while(rs.next()) {
                    int id = rs.getInt("productID");
                    String productName = rs.getString("productName");
                    double price = rs.getDouble("price");
                    int saled = rs.getInt("saled");
                    list.add(new BestSellerDTO(id, productName, price, saled));
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
}
