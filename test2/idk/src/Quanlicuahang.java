import java.util.List;
import java.util.Scanner;

public class QuanLyCuaHang {

    public List<CuaHang> cuaHang;

    public QuanLyCuaHang(List<CuaHang> list) {
        this.cuaHang = list;
    }

    public List<CuaHang> GetList() {
        return cuaHang;
    }

    public List<CuaHang> Create(CuaHang ch) {
        cuaHang.add(ch);
        return cuaHang;
    }

    public List<CuaHang> Delete(String id) {
        for (int i = 0; i < cuaHang.size(); i++) {
            if (cuaHang.get(i).id.equals(id)) {
                cuaHang.remove(i);
                break;
            }
        }
        return cuaHang;
    }

    public List<CuaHang> Edit(String id) {
        for (int i = 0; i < cuaHang.size(); i++) {
            if (cuaHang.get(i).id.equals(id)) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Tên mới: ");
                cuaHang.get(i).name = sc.nextLine();
                System.out.print("Địa điểm mới: ");
                cuaHang.get(i).location = sc.nextLine();
                break;
            }
        }
        return cuaHang;
    }

    public void Print() {
        for (CuaHang ch : cuaHang) {
            System.out.println("CH: " + ch.id + " - " + ch.name + " - " + ch.location);
        }
    }
}
