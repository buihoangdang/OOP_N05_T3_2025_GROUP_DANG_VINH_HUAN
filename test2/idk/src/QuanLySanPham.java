import java.util.List;
import java.util.Scanner;

public class QuanLySanPham {

    public List<SanPham> sanPham;

    public QuanLySanPham(List<SanPham> list) {
        this.sanPham = list;
    }

    public List<SanPham> GetList() {
        return sanPham;
    }

    public List<SanPham> Create(SanPham sp) {
        sanPham.add(sp);
        return sanPham;
    }

    public List<SanPham> Delete(String id) {
        for (int i = 0; i < sanPham.size(); i++) {
            if (sanPham.get(i).id.equals(id)) {
                sanPham.remove(i);
                break;
            }
        }
        return sanPham;
    }

    public List<SanPham> Edit(String id) {
        for (int i = 0; i < sanPham.size(); i++) {
            if (sanPham.get(i).id.equals(id)) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Tên mới: ");
                sanPham.get(i).name = sc.nextLine();
                System.out.print("Giá mới: ");
                sanPham.get(i).price = sc.nextDouble();
                System.out.print("Số lượng mới: ");
                sanPham.get(i).soluong = sc.nextInt(); sc.nextLine();
                break;
            }
        }
        return sanPham;
    }

    public void Print() {
        for (SanPham sp : sanPham) {
            System.out.println("SP: " + sp.id + " - " + sp.name + " - " + sp.price + "đ - SL: " + sp.soluong);
        }
    }
}
