public class SanPham {
    public String id;
    public String name;
    public double price;
    public int soluong;

    public SanPham(String id, String name, double price, int soluong) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.soluong = soluong;
    }

    public void hienThiThongTin() {
        System.out.println("Sản phẩm: " + name);
        System.out.println("Giá: " + price + " VND");
        System.out.println("Số lượng còn: " + soluong);
    }
}
