/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class ChiTietHD {
    public List<String> XemDSCTHD(){
        Connection conn = null;
        Statement statement = null;
        List<String> li = new ArrayList<>();
        try{           
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLHOADON", "root", "123456");
            String sql = "select * from ChiTietHD";
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                li.add(rs.getString("MaHD"));
                li.add(rs.getString("MaSP"));
                li.add(rs.getString("SoLuong"));
                li.add(rs.getString("GiaBan"));
                li.add("\n");
            }
        }
        catch(SQLException ex){
            Logger.getLogger(ChiTietHD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return li;       
    }
    public boolean insert() {
        Connection conn = null;
        //get data from database
        PreparedStatement statement = null;
        try {
            System.out.println("Them Chi tiet hoa don:");
            Scanner sc = new Scanner(System.in);
            System.out.print("Ma hoa don: ");
            String MaHD = sc.nextLine();
            System.out.print("Ma san pham: ");
            String MaSP = sc.nextLine();
            System.out.print("So luong: ");
            String SoLuong = sc.nextLine();
            System.out.print("Gia ban: ");
            Double GiaBan = sc.nextDouble();

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLHOADON", "root", "123456");

            String sql = "insert into ChiTietHD(MaSP, TenSP, DonViTinh, GiaBan) values (?,?,?,?)";
            statement = conn.prepareCall(sql);
            
            statement.setString(1, MaHD);
            statement.setString(2, MaSP);
            statement.setString(3, SoLuong);
            statement.setDouble(4, GiaBan);

            statement.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChiTietHD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChiTietHD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public boolean update() {
        Connection connection = null;
        //get data from database
        PreparedStatement statement = null;
        try {
            System.out.println("Sua thong tin Chi tiet hoa don:");
            Scanner sc = new Scanner(System.in);
            System.out.print("Ma hoa don: ");
            String MaHD = sc.nextLine();
            System.out.print("Ma san pham: ");
            String MaSP = sc.nextLine();
            System.out.print("So luong: ");
            String SoLuong = sc.nextLine();
            System.out.print("Gia ban: ");
            Double GiaBan = sc.nextDouble();
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLHOADON", "root", "123456");
            String sql = "UPDATE ChiTietHD SET SoLuong = ?, GiaBan = ? WHERE MaHD = ? AND MaSP = ?;";   
            statement = connection.prepareCall(sql);
            
            statement.setString(1, SoLuong);            
            statement.setDouble(2, GiaBan);
            statement.setString(3, MaHD); 
            statement.setString(4, MaSP);
            
            statement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChiTietHD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChiTietHD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
    public boolean delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Xoa Chi tiet HD:");
        System.out.print("Ma san hoa don kem ma san pham can xoa: ");
        String MaHD = sc.nextLine();
        String MaSP = sc.nextLine();
        Connection connection = null;
        //get data from database
        PreparedStatement statement = null;
        try {
            //get NhanVien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLHOADON", "root", "123456");

            String sql = "DELETE FROM ChiTietHD WHERE MaHD = ? AND MaSP = ?;";
            statement = connection.prepareCall(sql);

            statement.setString(1, MaHD);
            statement.setString(2, MaSP);

            statement.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SanPham.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChiTietHD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChiTietHD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
}
