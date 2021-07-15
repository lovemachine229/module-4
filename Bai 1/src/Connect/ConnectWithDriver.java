package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.Scanner;


/**
 *
 * @author ADMIN
 */
public class ConnectWithDriver {
    
    public List<String> ConnectWithDriver(){
        Connection conn = null;
        Statement statement = null;
        List<String> li = new ArrayList<String>();
        try{
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLSanPham", "root", "123456");
            String sql = "select MaSP,TenSp,TenLoaiSP from SanPham s inner join LoaiSanPham l where s.MaLoaiSP=l.MaLoaiSP";
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                li.add(rs.getString("MaSP"));
                li.add(rs.getString("TenSP"));
                li.add(rs.getString("TenLoaiSP"));
                li.add("\n");
            }
        }
        catch(Exception ex){
            Logger.getLogger(ConnectWithDriver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return li;       
    }
    public boolean insert(String ma, String ten){
        Connection conn = null;
        PreparedStatement statement = null;
        Scanner sc = new Scanner(System.in);
        try{            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLSanPham", "root", "123456");
            String sql = "insert into LoaiSanPham(MaLoaiSP,TenLoaiSP) values (?,?)";
            statement = conn.prepareCall(sql);
            
            statement.setString(1, ma);
            statement.setString(2, ten);
            statement.execute();
            return true;
        }
        catch(Exception ex){
            Logger.getLogger(ConnectWithDriver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
