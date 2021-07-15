/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Bai2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NhanVien c = new NhanVien();
        SanPham s = new SanPham();
        HoaDon h = new HoaDon();
        ChiTietHD ct = new ChiTietHD();
        Scanner sc = new Scanner(System.in);
        int choose;
        do {
            System.out.println("1.Hien thi ds nhan vien");
            System.out.println("2.Thêm NV");
            System.out.println("3.Sửa NV");
            System.out.println("4.Xóa NV");
            System.out.println("-------------------------");
            System.out.println("5.Xem DSSP");
            System.out.println("6.Thêm SP");
            System.out.println("7.Sửa SP");
            System.out.println("8.Xóa SP");
            System.out.println("-------------------------");
            System.out.println("9.Xem DSHD");
            System.out.println("10.Thêm HD");
            System.out.println("11.Sửa HD");
            System.out.println("12.Xóa HD");
            System.out.println("-------------------------");
            System.out.println("13.Xem DS CTHD");
            System.out.println("14.Thêm CTHD");
            System.out.println("15.Sửa CTHD");
            System.out.println("16.Xóa CTHD");
            System.out.println("-------------------------");
            System.out.println("17.Thoát");
            System.out.println("-------------------------");
            System.out.println("Lua Chon: ");
            choose = sc.nextInt();
            switch (choose) {
                case 1 ->
                    System.out.println(c.XemDSNV().toString());
                case 2 -> {
                    c.insert();
                    if (c.insert()) {
                        System.out.println("Them thanh cong");
                    } else {
                        System.out.println("Co loi xay ra");
                    }
                }
                case 3 -> {
                    c.update();
                    if (c.update()) {
                        System.out.println("Sua thanh cong");
                    } else {
                        System.out.println("Co loi xay ra");
                    }
                }
                case 4 -> {
                    c.delete();
                    if (c.update()) {
                        System.out.println("Xoa thanh cong");
                    } else {
                        System.out.println("Co loi xay ra");
                    }
                }
                case 5 ->
                    System.out.println(s.XemDSSP().toString());
                case 6 ->
                    s.insert();
                case 7 -> {
                    s.update();
                    if (s.update()) {
                        System.out.println("Sua thanh cong");
                    } else {
                        System.out.println("Co loi xay ra");
                    }
                }
                case 8 -> {
                    s.delete();
                    if (c.update()) {
                        System.out.println("Xoa thanh cong");
                    } else {
                        System.out.println("Co loi xay ra");
                    }
                }
                case 9 ->
                    System.out.println(h.XemDSHD().toString());
                case 10 -> {
                    h.insert();
                    if (s.insert()) {
                        System.out.println("Them thanh cong");
                    } else {
                        System.out.println("Co loi xay ra");
                    }
                }
                case 11 -> {
                    h.update();
                    if (c.update()) {
                        System.out.println("Sua thanh cong");
                    } else {
                        System.out.println("Co loi xay ra");
                    }
                }
                case 12 -> {
                    h.delete();
                    if (c.update()) {
                        System.out.println("Xoa thanh cong");
                    } else {
                        System.out.println("Co loi xay ra");
                    }
                }
                case 13 ->
                    System.out.println(ct.XemDSCTHD().toString());
                case 14 -> {
                    ct.insert();
                    if (c.insert()) {
                        System.out.println("Them thanh cong");
                    } else {
                        System.out.println("Co loi xay ra");
                    }
                }
                case 15 -> {
                    ct.update();
                    if (c.update()) {
                        System.out.println("Sua thanh cong");
                    } else {
                        System.out.println("Co loi xay ra");
                    }
                }
                case 16 -> {
                    ct.delete();
                    if (c.update()) {
                        System.out.println("Xoa thanh cong");
                    } else {
                        System.out.println("Co loi xay ra");
                    }
                }
                case 17 -> {
                    System.out.println("Ðã thoát!");
                    System.exit(0);
                }
            }
        } while (choose != 0);
    }

}
