import java.util.List;
import java.util.Scanner;

public class QuanLyKhachHang {

    public List<KhachHang> khachHang;

    public QuanLyKhachHang(List<KhachHang> list) {
        this.khachHang = list;
    }

    public List<KhachHang> GetList() {
        return khachHang;
    }

    public List<KhachHang> Create(KhachHang kh) {
        khachHang.add(kh);
        return khachHang;
    }

    public List<KhachHang> Delete(String id) {
        for (int i = 0; i < khachHang.size(); i++) {
            if (khachHang.get(i).id.equals(id)) {
                khachHang.remove(i);
                break;
            }
        }
        return khachHang;
    }

    public List<KhachHang> Edit(String id) {
        for (int i = 0; i < khachHang.size(); i++) {
            if (khachHang.get(i).id.equals(id)) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Tên mới: ");
                khachHang.get(i).name = sc.nextLine();
                System.out.print("SĐT mới: ");
                khachHang.get(i).phone = sc.nextLine();
                System.out.print("Địa chỉ mới: ");
                khachHang.get(i).address = sc.nextLine();
                break;
            }
        }
        return khachHang;
    }

    public void Print() {
        for (KhachHang kh : khachHang) {
            System.out.println("KH: " + kh.id + " - " + kh.name + " - " + kh.phone + " - " + kh.address);
        
        }
   
    }

}
