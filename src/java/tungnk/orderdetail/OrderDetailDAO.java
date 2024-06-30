package tungnk.orderdetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tungnk.util.DBUtil;

public class OrderDetailDAO {

    public void insertOrderDetail(int orderID, int productID, double price, int quantity) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String query = "INSERT INTO Order_Details VALUES (?, ?, ?, ?)";
                stm = con.prepareStatement(query);
                stm.setInt(1, orderID);
                stm.setInt(2, productID);
                stm.setDouble(3, price);
                stm.setInt(4, quantity);
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
    
    public List<OrderDetailDTO> getData(int orderID) throws ClassNotFoundException, SQLException {
        List<OrderDetailDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String query = "SELECT p.productName, d.price, d.quantity from Order_Details d inner join Products p ON d.productID = p.productID WHERE orderID = ?";
                stm = con.prepareStatement(query);
                stm.setInt(1, orderID);
                rs = stm.executeQuery();
                while(rs.next()) {
                    list.add(new OrderDetailDTO(rs.getInt("quantity"), rs.getDouble("price"), rs.getString("productName")));
                }
            }
        } finally {
            if(rs != null) {
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
