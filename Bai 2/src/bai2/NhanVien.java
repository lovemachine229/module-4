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
public class NhanVien {
    public List<String> XemDSNV(){
        Connection conn = null;
        Statement statement = null;
        List<String> li = new ArrayList<String>();
        try{           
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLHOADON", "root", "123456");
            String sql = "select * from NhanVien";
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                li.add(rs.getString("MaNV"));
                li.add(rs.getString("HoTen"));
                li.add(rs.getString("NgaySinh"));
                li.add(rs.getString("DiaChi"));
                li.add(rs.getString("SDT"));
                li.add(rs.getString("GioiTinh"));
                li.add("\n");
            }
        }
        catch(Exception ex){
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return li;       
    }
    public boolean insert() {
        Connection conn = null;
        //get data from database
        PreparedStatement statement = null;
        try {
            System.out.println("Them Nhan Vien:");
            Scanner sc = new Scanner(System.in);
            System.out.print("Ma NV: ");
            String MaNV = sc.nextLine();
            System.out.print("HoTen: ");
            String HoTen = sc.nextLine();
            System.out.print("Ngay thang nam sinh: ");
            String NgaySinh = sc.nextLine();
            System.out.print("Dia chi: ");
            String DiaChi = sc.nextLine();
            System.out.print("So dien thoai: ");
            String SDT = sc.nextLine();
            System.out.print("GioiTinh: ");
            String GioiTinh = sc.nextLine();
            //get NhanVien
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLHOADON", "root", "123456");

            String sql = "insert into NhanVien(MaNV, HoTen, NgaySinh, DiaChi, SDT, GioiTinh) values (?,?,?,?,?,?)";
            statement = conn.prepareCall(sql);
            
            statement.setString(1, MaNV);
            statement.setString(2, HoTen);
            statement.setString(3, NgaySinh);
            statement.setString(4, DiaChi);
            statement.setString(5, SDT);
            statement.setString(6, GioiTinh);

            statement.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
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
            System.out.println("Sua thong tin Nhan Vien:");
            //get NhanVien
            Scanner sc = new Scanner(System.in);
            System.out.print("Ma nhan vien can sua: ");
            String MaNV = sc.nextLine();
            System.out.print("HoTen: ");
            String HoTen = sc.nextLine();
            System.out.print("Ngay thang nam sinh: ");
            String NgaySinh = sc.nextLine();
            System.out.print("Dia chi: ");
            String DiaChi = sc.nextLine();
            System.out.print("So dien thoai: ");
            String SDT = sc.nextLine();
            System.out.print("GioiTinh: ");
            String GioiTinh = sc.nextLine();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLHOADON", "root", "123456");
            String sql = "UPDATE NhanVien SET HoTen = ?, NgaySinh = ?, DiaChi= ?, SDT= ?, GioiTinh = ? WHERE MaNV = ?;";
            statement = connection.prepareCall(sql);
            statement.setString(1, HoTen);
            statement.setString(2, NgaySinh);
            statement.setString(3, DiaChi);
            statement.setString(4, SDT);
            statement.setString(5, GioiTinh);
            statement.setString(6, MaNV);
            statement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
    public boolean delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Xoa Nhan Vien:");
        System.out.print("Ma nhan vien can xoa: ");
        String MaNV = sc.nextLine();
        Connection connection = null;
        //get data from database
        PreparedStatement statement = null;
        try {
            //get NhanVien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLHOADON", "root", "123456");

            String sql = "DELETE FROM NhanVien WHERE MaNV = ?;";
            statement = connection.prepareCall(sql);

            statement.setString(1, MaNV);

            statement.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
}
