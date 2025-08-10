package com.mycompany.mavenproject1.controller;

import com.mycompany.mavenproject1.model.CuaHang;
import com.mycompany.mavenproject1.model.DataXMLHandler;
import com.mycompany.mavenproject1.model.DonHang;
import com.mycompany.mavenproject1.model.KhachHang;
import com.mycompany.mavenproject1.model.NhanVien;
import com.mycompany.mavenproject1.model.SanPham;
import com.mycompany.mavenproject1.view.MainView;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class MainController {
    private MainView view;

    public MainController(MainView view) {
        this.view = view;
    }    
    
    public void addTableSelectionListener(JTabbedPane tabbedPane, JTable table) {
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                
                // Tránh xử lý 2 lần khi đang thay đổi
                if (!e.getValueIsAdjusting()) {
                    int selectedIndex = tabbedPane.getSelectedIndex();
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) { 
                        DefaultTableModel model = (DefaultTableModel) table.getModel();

                        // Lấy dữ liệu từng cột
                        Object[] rowData = new Object[model.getColumnCount()];
                        for (int i = 0; i < model.getColumnCount(); i++) {
                            rowData[i] = model.getValueAt(selectedRow, i);
                        }
                        
                        switch (selectedIndex) {
                            case 0: // Cửa hàng
                                view.setShopTextField(rowData[0].toString(), rowData[1].toString(), rowData[2].toString());
                                break;
                            case 1: // Đơn hàng
                                view.setOrderTextField(rowData[0].toString(), rowData[1].toString(), rowData[2].toString(), rowData[3].toString());
                                break;
                            case 2: // Khách hàng
                                view.setCustomerTextField(rowData[0].toString(), rowData[1].toString(), rowData[2].toString(), rowData[3].toString());
                                break;
                            case 3: // Nhân viên
                                view.setStaffTextField(rowData[0].toString(), rowData[1].toString(), rowData[2].toString(), rowData[3].toString(), rowData[4].toString());
                                break;
                            case 4: // Sản phẩm
                                view.setProductTextField(rowData[0].toString(), rowData[1].toString(), rowData[2].toString(), rowData[3].toString(), rowData[4].toString(), rowData[5].toString());
                                break;
                        }
                    }
                }
            }
        });
    }
    
    public void showTableContent(JTabbedPane tabbedPane, JTable table){
        int selectedIndex = tabbedPane.getSelectedIndex();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ

        switch (selectedIndex) {
            case 0: // Cửa hàng
                List<CuaHang> shopData = DataXMLHandler.readCuaHangFromXML();
                for (CuaHang row : shopData) {
                    model.addRow(new Object[]{
                        row.getMaCuaHang(),
                        row.getTenChiNhanh(),
                        row.getDiaChi()
                    });
                }
                break;
            case 1: // Đơn hàng
                List<DonHang> orderData = DataXMLHandler.readDonHangFromXML();
                for (DonHang row : orderData) {
                    model.addRow(new Object[]{
                        row.getMaDonHang(),
                        row.getMaKhachHang(),
                        row.getNgayDat(),
                        row.getTongTien()
                    });
                }
                break;
            case 2: // Khách hàng
                List<KhachHang> customerData = DataXMLHandler.readKhachHangFromXML();
                for (KhachHang row : customerData) {
                    model.addRow(new Object[]{
                        row.getMaKhachHang(),
                        row.getHoTen(),
                        row.getSoDienThoai(),
                        row.getDiaChi()
                    });
                }
                break;
            case 3: // Nhân viên
                List<NhanVien> employeeData = DataXMLHandler.readNhanViensFromXML();
                for (NhanVien row : employeeData) {
                    model.addRow(new Object[]{
                        row.getMaNhanVien(),
                        row.getHoTen(),
                        row.getTuoi(),
                        row.getViTri(),
                        row.getCuaHang()
                    });
                }
                break;
            case 4: // Sản phẩm
                List<SanPham> productData = DataXMLHandler.readProductsFromXML();
                for (SanPham row : productData) {
                    model.addRow(new Object[]{
                        row.getMaSanPham(),
                        row.getTenSanPham(),
                        row.getLoai(),
                        row.getSize(),
                        row.getGia(),
                        row.getSoLuongTon()
                    });
                }
                break;
        }
    }
    
    public void handleAddButton(JTabbedPane tabbedPane) {        
        int selectedIndex = tabbedPane.getSelectedIndex();

        switch (selectedIndex) {
            case 0: // Tab Cửa hàng
                CuaHang cuahang = view.getShopTextField();
                if (cuahang == null) return;

                List<CuaHang> cuaHangs = DataXMLHandler.readCuaHangFromXML();

                for (CuaHang ch : cuaHangs) {
                    if (ch.getMaCuaHang().equals(cuahang.getMaCuaHang())) {
                        JOptionPane.showMessageDialog(null, "Mã cửa hàng đã tồn tại, không thể thêm.");
                        return;
                    }
                }

                cuaHangs.add(cuahang);
                DataXMLHandler.writeCuaHangToXML(cuaHangs);
                break;

            case 1: // Tab Đơn hàng
                DonHang donhang = view.getOrderTextField();
                if (donhang == null) return;

                List<DonHang> donHangs = DataXMLHandler.readDonHangFromXML();

                for (DonHang dh : donHangs) {
                    if (dh.getMaDonHang().equals(donhang.getMaDonHang())) {
                        JOptionPane.showMessageDialog(null, "Mã đơn hàng đã tồn tại, không thể thêm.");
                        return;
                    }
                }

                donHangs.add(donhang);
                DataXMLHandler.writeDonHangToXML(donHangs);
                break;

            case 2: // Tab Khách hàng
                KhachHang khachhang = view.getCustomerTextField();
                if (khachhang == null) return;

                List<KhachHang> khachHangs = DataXMLHandler.readKhachHangFromXML();

                for (KhachHang kh : khachHangs) {
                    if (kh.getMaKhachHang().equals(khachhang.getMaKhachHang())) {
                        JOptionPane.showMessageDialog(null, "Mã khách hàng đã tồn tại, không thể thêm.");
                        return;
                    }
                }

                khachHangs.add(khachhang);
                DataXMLHandler.writeKhachHangToXML(khachHangs);
                break;

            case 3: // Tab Nhân viên
                NhanVien nhanvien = view.getStaffTextField();
                if (nhanvien == null) return;

                List<NhanVien> nhanViens = DataXMLHandler.readNhanViensFromXML();

                for (NhanVien nv : nhanViens) {
                    if (nv.getMaNhanVien().equals(nhanvien.getMaNhanVien())) {
                        JOptionPane.showMessageDialog(null, "Mã nhân viên đã tồn tại, không thể thêm.");
                        return;
                    }
                }

                nhanViens.add(nhanvien);
                DataXMLHandler.writeNhanViensToXML(nhanViens);
                break;

            case 4: // Tab Sản phẩm
                SanPham sanpham = view.getProductTextField();
                if (sanpham == null) return;

                List<SanPham> sanPhams = DataXMLHandler.readProductsFromXML();

                for (SanPham sp : sanPhams) {
                    if (sp.getMaSanPham().equals(sanpham.getMaSanPham())) {
                        JOptionPane.showMessageDialog(null, "Mã sản phẩm đã tồn tại, không thể thêm.");
                        return;
                    }
                }

                sanPhams.add(sanpham);
                DataXMLHandler.writeProductsToXML(sanPhams);
                break;
        }
        handleRefreshButton(tabbedPane);
    }

    public void handleEditButton(JTabbedPane tabbedPane, JTable table) {
        int selectedIndex = tabbedPane.getSelectedIndex();

        switch (selectedIndex) {
            case 0: // Tab Cửa hàng
                CuaHang cuahang = view.getShopTextField();
                if (cuahang == null) return;

                int selectedRow0 = table.getSelectedRow();
                if (selectedRow0 < 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn một cửa hàng để sửa.");
                    return;
                }
                String originalID0 = (String) table.getValueAt(selectedRow0, 0);
                if (!originalID0.equals(cuahang.getMaCuaHang())) {
                    JOptionPane.showMessageDialog(null, "Không được chỉnh sửa mã cửa hàng.");
                    return;
                }

                List<CuaHang> cuaHangs = DataXMLHandler.readCuaHangFromXML();
                boolean found0 = false;
                for (CuaHang ch : cuaHangs) {
                    if (ch.getMaCuaHang().equals(cuahang.getMaCuaHang())) {
                        ch.setTenChiNhanh(cuahang.getTenChiNhanh());
                        ch.setDiaChi(cuahang.getDiaChi());
                        found0 = true;
                        break;
                    }
                }
                if (!found0) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy cửa hàng để sửa.");
                    return;
                }
                DataXMLHandler.writeCuaHangToXML(cuaHangs);
                break;

            case 1: // Tab Đơn hàng
                DonHang donhang = view.getOrderTextField();
                if (donhang == null) return;

                int selectedRow1 = table.getSelectedRow();
                if (selectedRow1 < 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn một đơn hàng để sửa.");
                    return;
                }
                String originalID1 = (String) table.getValueAt(selectedRow1, 0);
                if (!originalID1.equals(donhang.getMaDonHang())) {
                    JOptionPane.showMessageDialog(null, "Không được chỉnh sửa mã đơn hàng.");
                    return;
                }

                List<DonHang> donHangs = DataXMLHandler.readDonHangFromXML();
                boolean found1 = false;
                for (DonHang dh : donHangs) {
                    if (dh.getMaDonHang().equals(donhang.getMaDonHang())) {
                        dh.setMaKhachHang(donhang.getMaKhachHang());
                        dh.setNgayDat(donhang.getNgayDat());
                        dh.setTongTien(donhang.getTongTien());
                        found1 = true;
                        break;
                    }
                }
                if (!found1) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy đơn hàng để sửa.");
                    return;
                }
                DataXMLHandler.writeDonHangToXML(donHangs);
                break;

            case 2: // Tab Khách hàng
                KhachHang khachhang = view.getCustomerTextField();
                if (khachhang == null) return;

                int selectedRow2 = table.getSelectedRow();
                if (selectedRow2 < 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn một khách hàng để sửa.");
                    return;
                }
                String originalID2 = (String) table.getValueAt(selectedRow2, 0);
                if (!originalID2.equals(khachhang.getMaKhachHang())) {
                    JOptionPane.showMessageDialog(null, "Không được chỉnh sửa mã khách hàng.");
                    return;
                }

                List<KhachHang> khachHangs = DataXMLHandler.readKhachHangFromXML();
                boolean found2 = false;
                for (KhachHang kh : khachHangs) {
                    if (kh.getMaKhachHang().equals(khachhang.getMaKhachHang())) {
                        kh.setHoTen(khachhang.getHoTen());
                        kh.setDiaChi(khachhang.getDiaChi());
                        kh.setSoDienThoai(khachhang.getSoDienThoai());
                        found2 = true;
                        break;
                    }
                }
                if (!found2) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng để sửa.");
                    return;
                }
                DataXMLHandler.writeKhachHangToXML(khachHangs);
                break;

            case 3: // Tab Nhân viên
                NhanVien nhanvien = view.getStaffTextField();
                if (nhanvien == null) return;

                int selectedRow3 = table.getSelectedRow();
                if (selectedRow3 < 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn một nhân viên để sửa.");
                    return;
                }
                String originalID3 = (String) table.getValueAt(selectedRow3, 0);
                if (!originalID3.equals(nhanvien.getMaNhanVien())) {
                    JOptionPane.showMessageDialog(null, "Không được chỉnh sửa mã nhân viên.");
                    return;
                }

                List<NhanVien> nhanViens = DataXMLHandler.readNhanViensFromXML();
                boolean found3 = false;
                for (NhanVien nv : nhanViens) {
                    if (nv.getMaNhanVien().equals(nhanvien.getMaNhanVien())) {
                        nv.setHoTen(nhanvien.getHoTen());
                        nv.setViTri(nhanvien.getViTri());
                        nv.setTuoi(nhanvien.getTuoi());
                        nv.setCuaHang(nhanvien.getCuaHang());
                        found3 = true;
                        break;
                    }
                }
                if (!found3) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy nhân viên để sửa.");
                    return;
                }
                DataXMLHandler.writeNhanViensToXML(nhanViens);
                break;

            case 4: // Tab Sản phẩm
                SanPham sanpham = view.getProductTextField();
                if (sanpham == null) return;

                int selectedRow4 = table.getSelectedRow();
                if (selectedRow4 < 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn một sản phẩm để sửa.");
                    return;
                }
                String originalID4 = (String) table.getValueAt(selectedRow4, 0);
                if (!originalID4.equals(sanpham.getMaSanPham())) {
                    JOptionPane.showMessageDialog(null, "Không được chỉnh sửa mã sản phẩm.");
                    return;
                }

                List<SanPham> sanPhams = DataXMLHandler.readProductsFromXML();
                boolean found4 = false;
                for (SanPham sp : sanPhams) {
                    if (sp.getMaSanPham().equals(sanpham.getMaSanPham())) {
                        sp.setTenSanPham(sanpham.getTenSanPham());
                        sp.setLoai(sanpham.getLoai());
                        sp.setGia(sanpham.getGia());
                        sp.setSize(sanpham.getSize());
                        sp.setSoLuongTon(sanpham.getSoLuongTon());
                        found4 = true;
                        break;
                    }
                }
                if (!found4) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm để sửa.");
                    return;
                }
                DataXMLHandler.writeProductsToXML(sanPhams);
                break;
        }
        handleRefreshButton(tabbedPane);
    }

    public void handleDeleteButton(JTabbedPane tabbedPane, JTable table){
        int selectedIndex = tabbedPane.getSelectedIndex();
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng cần xóa!");
            return;
        }

        switch (selectedIndex) {
            case 0: // Tab Cửa hàng
                String maCuaHang = table.getValueAt(selectedRow, 0).toString();
                List<CuaHang> cuaHangs = DataXMLHandler.readCuaHangFromXML();
                cuaHangs.removeIf(ch -> ch.getMaCuaHang().equals(maCuaHang));
                DataXMLHandler.writeCuaHangToXML(cuaHangs);
                break;

            case 1: // Tab Đơn hàng
                String maDonHang = table.getValueAt(selectedRow, 0).toString();
                List<DonHang> donHangs = DataXMLHandler.readDonHangFromXML();
                donHangs.removeIf(dh -> dh.getMaDonHang().equals(maDonHang));
                DataXMLHandler.writeDonHangToXML(donHangs);
                break;

            case 2: // Tab Khách hàng
                String maKhachHang = table.getValueAt(selectedRow, 0).toString();
                List<KhachHang> khachHangs = DataXMLHandler.readKhachHangFromXML();
                khachHangs.removeIf(kh -> kh.getMaKhachHang().equals(maKhachHang));
                DataXMLHandler.writeKhachHangToXML(khachHangs);
                break;

            case 3: // Tab Nhân viên
                String maNhanVien = table.getValueAt(selectedRow, 0).toString();
                List<NhanVien> nhanViens = DataXMLHandler.readNhanViensFromXML();
                nhanViens.removeIf(nv -> nv.getMaNhanVien().equals(maNhanVien));
                DataXMLHandler.writeNhanViensToXML(nhanViens);
                break;

            case 4: // Tab Sản phẩm
                String maSanPham = table.getValueAt(selectedRow, 0).toString();
                List<SanPham> sanPhams = DataXMLHandler.readProductsFromXML();
                sanPhams.removeIf(sp -> sp.getMaSanPham().equals(maSanPham));
                DataXMLHandler.writeProductsToXML(sanPhams);
                break;
        }

        handleRefreshButton(tabbedPane);
    }
    
    public void handleRefreshButton(JTabbedPane tabbedPane) {
        int selectedIndex = tabbedPane.getSelectedIndex();

        switch (selectedIndex) {
            case 0:
                view.setShopTextField("", "", "");
            break;            
            case 1:
                view.setOrderTextField("", "", "", "");
            break;            
            case 2:
                view.setCustomerTextField("", "", "", "");
            break;            
            case 3:
                view.setStaffTextField("", "", "", "", "");
            break;            
            case 4:
                view.setProductTextField("", "", "", "", "", "");
            break;
        }
    }
}
