public class SanPham {
    String maSanPham;
    String tenSanPham;
    String kichThuoc;
    double giaBan;
    int soLuong;

    public SanPham(String maSanPham, String tenSanPham, String kichThuoc, double giaBan, int soLuong) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.kichThuoc = kichThuoc;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
    }
}

class Main {
    public static void main(String[] args) {
        SanPham sp = new SanPham("SP001", "Áo thun nam", "L", 199000, 10);

        System.out.println("Mã sản phẩm: " + sp.maSanPham);
        System.out.println("Tên sản phẩm: " + sp.tenSanPham);
        System.out.println("Kích thước: " + sp.kichThuoc);
        System.out.println("Giá bán: " + sp.giaBan);
        System.out.println("Số lượng: " + sp.soLuong);
    }
}
