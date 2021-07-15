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
public class SanPham {
    public List<String> XemDSSP(){
        Connection conn = null;
        Statement statement = null;
        List<String> li = new ArrayList<>();
        try{           
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLHOADON", "root", "123456");
            String sql = "select * from SanPham";
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                li.add(rs.getString("MaSP"));
                li.add(rs.getString("TenSP"));
                li.add(rs.getString("DonViTinh"));
                li.add(rs.getString("GiaBan"));
                li.add("\n");
            }
        }
        catch(SQLException ex){
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return li;       
    }
    public boolean insert() {
        Connection conn = null;
        //get data from database
        PreparedStatement statement = null;
        try {
            System.out.println("Them san pham:");
            Scanner sc = new Scanner(System.in);
            System.out.print("Ma SP: ");
            String MaSP = sc.nextLine();
            System.out.print("Ten SP: ");
            String TenSP = sc.nextLine();
            System.out.print("Don vi tinh: ");
            String DonViTinh = sc.nextLine();
            System.out.print("Gia ban: ");
            Double GiaBan = sc.nextDouble();

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLHOADON", "root", "123456");

            String sql = "insert into SanPham(MaSP, TenSP, DonViTinh, GiaBan) values (?,?,?,?)";
            statement = conn.prepareCall(sql);
            
            statement.setString(1, MaSP);
            statement.setString(2, TenSP);
            statement.setString(3, DonViTinh);
            statement.setDouble(4, GiaBan);

            statement.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SanPham.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPham.class.getName()).log(Level.SEVERE, null, ex);
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
            System.out.println("Sua thong tin san pham:");
            //get NhanVien
            Scanner sc = new Scanner(System.in);
            System.out.print("Ma SP: ");
            String MaSP = sc.nextLine();
            System.out.print("Ten SP: ");
            String TenSP = sc.nextLine();
            System.out.print("Don vi tinh: ");
            String DonViTinh = sc.nextLine();
            System.out.print("Gia ban: ");
            Double GiaBan = sc.nextDouble();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLHOADON", "root", "123456");
            String sql = "UPDATE SanPham SET TenSP = ?, DonViTinh = ?, GiaBan = ? WHERE MaSP = ?;";           
            statement.setString(1, TenSP);
            statement.setString(2, DonViTinh);
            statement.setDouble(3, GiaBan);
            statement.setString(4, MaSP);
            statement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SanPham.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
    public boolean delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Xoa san pham:");
        System.out.print("Ma san pham can xoa: ");
        String MaSP = sc.nextLine();
        Connection connection = null;
        //get data from database
        PreparedStatement statement = null;
        try {
            //get NhanVien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLHOADON", "root", "123456");

            String sql = "DELETE FROM SanPham WHERE MaSP = ?;";
            statement = connection.prepareCall(sql);

            statement.setString(1, MaSP);

            statement.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SanPham.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
}
