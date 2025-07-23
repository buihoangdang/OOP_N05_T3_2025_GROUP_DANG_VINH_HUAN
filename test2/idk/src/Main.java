import java.util.ArrayList;
import java.util.Scanner;
  

public class Main {
    public static void main(String[] args) {
        ArrayList<SanPham> dsSP = new ArrayList<>();
        ArrayList<KhachHang> dsKH = new ArrayList<>();
        ArrayList<CuaHang> dsCH = new ArrayList<>();

        QuanLySanPham qlsp = new QuanLySanPham(dsSP);
        QuanLyKhachHang qlkh = new QuanLyKhachHang(dsKH);
        QuanLyCuaHang qlch = new QuanLyCuaHang(dsCH);

        Scanner sc = new Scanner(System.in);

        System.out.println("===== SẢN PHẨM =====");
        qlsp.Create(new SanPham("SP1", "Áo thun", 120000, 10, "CH1"));
        qlsp.Create(new SanPham("SP2", "Quần jeans", 250000, 5, "CH2"));
        qlsp.Print();
        qlsp.Edit("SP1");
        qlsp.Print();
        qlsp.Delete("SP2");
        qlsp.Print();

        System.out.println("\n===== KHÁCH HÀNG =====");
        qlkh.Create(new KhachHang("KH1", "Nguyễn Văn A", "0901234567", "Hà Nội"));
        qlkh.Create(new KhachHang("KH2", "Trần Thị B", "0987654321", "TP.HCM"));
        qlkh.Print();
        qlkh.Edit("KH2");
        qlkh.Print();
        qlkh.Delete("KH1");
        qlkh.Print();

        System.out.println("\n===== CỬA HÀNG =====");
        qlch.Create(new CuaHang("CH1", "Cửa hàng 1", "Hà Nội"));
        qlch.Create(new CuaHang("CH2", "Cửa hàng 2", "Đà Nẵng"));
        qlch.Print();
        qlch.Edit("CH1");
        qlch.Print();
        qlch.Delete("CH2");
        qlch.Print();

   

        System.out.println("\n===== Hiển thị sản phẩm theo mã cửa hàng =====");
        System.out.print("Nhập mã cửa hàng: ");
        String maCH = sc.nextLine();
        qlsp.hienThiSanPhamTheoCuaHang(maCH);

        System.out.println("\n===== Tìm kiếm khách hàng theo tên hoặc SĐT =====");
        System.out.print("Nhập từ khóa tìm kiếm: ");
        String tuKhoa = sc.nextLine();
        qlkh.timKiemKhachHang(tuKhoa);

       
    }
}
