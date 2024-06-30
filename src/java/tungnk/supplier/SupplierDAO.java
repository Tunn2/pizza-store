
package tungnk.supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tungnk.util.DBUtil;

public class SupplierDAO {
    public boolean checkExistedSupplier(int id) throws SQLException, ClassNotFoundException {
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtil.makeConnection();
            String query = "SELECT * FROM Suppliers WHERE supplierID = ?";
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
