public class CuaHang {
    public String id;
    public String name;
    public String location;


    public CuaHang(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    
    public void hienThiThongTin() {
        System.out.println("Cửa hàng: " + name);
        System.out.println("Địa điểm: " + location);
    }
}
