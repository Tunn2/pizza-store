/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tungnk.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ktung
 */
public class DBUtil {
        static final String DB_NAME = "UserManagement";
    static final String DB_USER = "sa";
    static final String DB_PASSWORD = "12345";

    
    
    public static Connection makeConnection() throws ClassNotFoundException, SQLException {
        Connection con = null;
        String url = "jdbc:sqlserver://localhost:1433;databaseName=" + DB_NAME;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
        con = DriverManager.getConnection(url, DB_USER, DB_PASSWORD);
        
        return con;
    }
}
