package utilty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBcontext {
    
    public static String USER = "phantom";
    public static String PASSWORD = "123";
    public static String URL = "jdbc:sqlserver://localhost:1433;databaseName=duan1_n2_ma1;encrypt=true;trustServerCertificate=true;";

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnection() {
        Connection cn = null;
        try {
            cn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(DBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cn;
    }

    public static void main(String[] args) {
        Connection  cn = getConnection();
        if (cn!=null) {
            System.out.println("Kết nối thành công");
        } else {
            System.out.println("Lỗi kết nối");
        }
    }

}
