public class SanPham {
    public String id;
    public String name;
    public double price;
    public int soluong;
    public String idCuaHang; 
    public SanPham(String id, String name, double price, int soluong, String idCuaHang) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.soluong = soluong;
        this.idCuaHang = idCuaHang;
    }
}
