public class Main {
    public static void main(String[] args) {
        Sanpham p = new Sanpham();
        p.id = "P01";
        p.name = "Laptop";
        p.price = 1500;
        p.stockQuantity = 10;

        Khachhang c = new Khanhhang();
        c.id = "C01";
        c.name = "Trần Thị B";
        c.email = "b@example.com";

        Cuahang s = new Cuahang();
        s.id = "S01";
        s.name = "Cửa hàng ABC";

        

        System.out.println("Đã gọi các class thành công.");
    }
}
