package bai1_498 ;
import Connect.ConnectWithDriver;
import java.util.Scanner;

    /**
     *
     * @author ADMIN
     */

    public class Bai1_498 {

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            ConnectWithDriver c = new ConnectWithDriver();
            System.out.println(c.ConnectWithDriver().toString());
            System.out.println("Nhập thông tin:");
            System.out.println("Mã loại sản phẩm:");  
            String MaLoaiSP = sc.nextLine();
            System.out.println("Tên loại sản phẩm:");
            String TenLoaiSP = sc.nextLine();
            c.insert(MaLoaiSP,TenLoaiSP);
        }
        
    }
