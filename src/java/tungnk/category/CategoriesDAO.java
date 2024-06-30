/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tungnk.category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import tungnk.util.DBUtil;

/**
 *
 * @author ADMIN
 */
public class CategoriesDAO {

    public List<CategoriesDTO> getData() throws ClassNotFoundException, SQLException {
        List<CategoriesDTO> list = new ArrayList<>();
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtil.makeConnection();
            String query = "SELECT * FROM Categories";
            stm = con.prepareStatement(query);
            rs = stm.executeQuery();
            while (rs.next()) {
                String cid = rs.getString("categoryID");
                String cname = rs.getString("categoryName");
                list.add(new CategoriesDTO(cid, cname));
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
    
    public boolean checkExistedCategory(int id) throws SQLException, ClassNotFoundException {
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtil.makeConnection();
            String query = "SELECT * FROM Categories WHERE categoryID = ?";
            stm = con.prepareStatement(query);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                return true;
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
}
