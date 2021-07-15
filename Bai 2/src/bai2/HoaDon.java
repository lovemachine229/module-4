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
public class HoaDon {
    public List<String> XemDSHD(){
        Connection conn = null;
        Statement statement = null;
        List<String> li = new ArrayList<>();
        try{           
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLHOADON", "root", "123456");
            String sql = "select * from HoaDon";
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                li.add(rs.getString("MaHD"));
                li.add(rs.getString("MaNV"));
                li.add(rs.getString("LoaiHD"));
                li.add(rs.getString("NgayLap"));
                li.add(rs.getString("NgayGiaoNhan"));
                li.add(rs.getString("DienGiai"));
                li.add("\n");
            }
        }
        catch(SQLException ex){
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return li;       
    }
    public boolean insert() {
        Connection conn = null;
        //get data from database
        PreparedStatement statement = null;
        try {
            System.out.println("Them hoa don:");
            Scanner sc = new Scanner(System.in);
            System.out.print("Ma HD: ");
            String MaHD = sc.nextLine();
            System.out.print("Ma NV: ");
            String MaNV = sc.nextLine();
            System.out.print("Loai HD: ");
            String LoaiHD = sc.nextLine();
            System.out.print("Ngay lap: ");
            String NgayLap = sc.nextLine();
            System.out.print("Ngay giao nhan: ");
            String NgayGiaoNhan = sc.nextLine();
            System.out.print("Dien giai: ");
            String DienGiai = sc.nextLine();
      
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLHOADON", "root", "123456");

            String sql = "insert into HoaDon(MaHD, MaNV, LoaiHD, NgayLap, NgayGiaoNhan, DienGiai) values (?,?,?,?,?,?)";
            statement = conn.prepareCall(sql);
            
            statement.setString(1, MaHD);
            statement.setString(2, MaNV);
            statement.setString(3, LoaiHD);
            statement.setString(4, NgayLap);
            statement.setString(5, NgayGiaoNhan);
            statement.setString(6, DienGiai);

            statement.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
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
            System.out.println("Sua thong tin hoa don:");
            Scanner sc = new Scanner(System.in);
            System.out.print("Ma HD: ");
            String MaHD = sc.nextLine();
            System.out.print("Ma NV: ");
            String MaNV = sc.nextLine();
            System.out.print("Loai HD: ");
            String LoaiHD = sc.nextLine();
            System.out.print("Ngay lap: ");
            String NgayLap = sc.nextLine();
            System.out.print("Ngay giao nhan: ");
            String NgayGiaoNhan = sc.nextLine();
            System.out.print("Dien giai: ");
            String DienGiai = sc.nextLine();
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLHOADON", "root", "123456");
            String sql = "UPDATE HoaDon SET  MaNV = ?, LoaiHD = ?, NgayLap = ?, NgayGiaoNhan = ?, DienGiai = ? WHERE MaHD = ?;";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, MaHD);
            statement.setString(2, MaNV);
            statement.setString(3, LoaiHD);
            statement.setString(4, NgayLap);
            statement.setString(5, NgayGiaoNhan);
            statement.setString(6, DienGiai);
            
            statement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
    public boolean delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Xoa hoa don:");
        System.out.print("Ma hoa don can xoa: ");
        String MaHD = sc.nextLine();
        Connection connection = null;
        //get data from database
        PreparedStatement statement = null;
        try {
            //get NhanVien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLHOADON", "root", "123456");

            String sql = "DELETE FROM HoaDon WHERE MaHD = ?;";
            statement = connection.prepareCall(sql);

            statement.setString(1, MaHD);

            statement.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
}
