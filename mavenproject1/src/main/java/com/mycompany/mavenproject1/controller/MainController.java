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
    
    public void handleAddButton(JTabbedPane tabbedPane){        
        int selectedIndex = tabbedPane.getSelectedIndex();

        switch (selectedIndex) {
            case 0: // Tab Cửa hàng
                CuaHang cuahang = view.getShopTextField();
                
                 // Đọc danh sách hiện tại từ XML
                List<CuaHang> cuaHangs = DataXMLHandler.readCuaHangFromXML();

                // Thêm cửa hàng mới vào danh sách
                cuaHangs.add(cuahang);

                // Ghi lại vào file XML
                DataXMLHandler.writeCuaHangToXML(cuaHangs);
            break;

            case 1: // Tab Đơn hàng
                DonHang donhang = view.getOrderTextField();
                
                 // Đọc danh sách hiện tại từ XML
                List<DonHang> donHangs = DataXMLHandler.readDonHangFromXML();

                // Thêm cửa hàng mới vào danh sách
                donHangs.add(donhang);

                // Ghi lại vào file XML
                DataXMLHandler.writeDonHangToXML(donHangs);
            break;

            case 2: // Tab Khách hàng
                KhachHang khachhang = view.getCustomerTextField();
                
                 // Đọc danh sách hiện tại từ XML
                List<KhachHang> khachHangs = DataXMLHandler.readKhachHangFromXML();

                // Thêm cửa hàng mới vào danh sách
                khachHangs.add(khachhang);

                // Ghi lại vào file XML
                DataXMLHandler.writeKhachHangToXML(khachHangs);
            break;

            case 3: // Tab Nhân viên
                NhanVien nhanvien = view.getStaffTextField();
                
                 // Đọc danh sách hiện tại từ XML
                List<NhanVien> nhanViens = DataXMLHandler.readNhanViensFromXML();

                // Thêm cửa hàng mới vào danh sách
                nhanViens.add(nhanvien);

                // Ghi lại vào file XML
                DataXMLHandler.writeNhanViensToXML(nhanViens);
            break;

            case 4: // Tab Sản phẩm
                SanPham sanpham = view.getProductTextField();
                
                 // Đọc danh sách hiện tại từ XML
                List<SanPham> sanPhams = DataXMLHandler.readProductsFromXML();

                // Thêm cửa hàng mới vào danh sách
                sanPhams.add(sanpham);

                // Ghi lại vào file XML
                DataXMLHandler.writeProductsToXML(sanPhams);
            break;
        }
        handleRefreshButton(tabbedPane);
    }
    
    public void handleEditButton(JTabbedPane tabbedPane, JTable table){
        int selectedIndex = tabbedPane.getSelectedIndex();

        switch (selectedIndex) {
            case 0: // Tab Cửa hàng
                CuaHang cuahang = view.getShopTextField();
                List<CuaHang> cuaHangs = DataXMLHandler.readCuaHangFromXML();

                for (CuaHang ch : cuaHangs) {
                    if (ch.getMaCuaHang().equals(cuahang.getMaCuaHang())) {
                        ch.setDiaChi(cuahang.getDiaChi());
                        ch.setTenChiNhanh(cuahang.getTenChiNhanh());
                    }
                }
                DataXMLHandler.writeCuaHangToXML(cuaHangs);
                break;

            case 1: // Tab Đơn hàng
                DonHang donhang = view.getOrderTextField();
                List<DonHang> donHangs = DataXMLHandler.readDonHangFromXML();

                for (DonHang dh : donHangs) {
                    if (dh.getMaDonHang().equals(donhang.getMaDonHang())) {
                        dh.setMaKhachHang(donhang.getMaKhachHang());
                        dh.setNgayDat(donhang.getNgayDat());
                        dh.setTongTien(donhang.getTongTien());
                    }
                }
                DataXMLHandler.writeDonHangToXML(donHangs);
                break;

            case 2: // Tab Khách hàng
                KhachHang khachhang = view.getCustomerTextField();
                List<KhachHang> khachHangs = DataXMLHandler.readKhachHangFromXML();

                for (KhachHang kh : khachHangs) {
                    if (kh.getMaKhachHang().equals(khachhang.getMaKhachHang())) {
                        kh.setHoTen(khachhang.getHoTen());
                        kh.setDiaChi(khachhang.getDiaChi());
                        kh.setSoDienThoai(khachhang.getSoDienThoai());
                    }
                }
                DataXMLHandler.writeKhachHangToXML(khachHangs);
                break;

            case 3: // Tab Nhân viên
                NhanVien nhanvien = view.getStaffTextField();
                List<NhanVien> nhanViens = DataXMLHandler.readNhanViensFromXML();

                for (NhanVien nv : nhanViens) {
                    if (nv.getMaNhanVien().equals(nhanvien.getMaNhanVien())) {
                        nv.setHoTen(nhanvien.getHoTen());
                        nv.setViTri(nhanvien.getViTri());
                        nv.setTuoi(nhanvien.getTuoi());
                        nv.setCuaHang(nhanvien.getCuaHang());
                    }
                }
                DataXMLHandler.writeNhanViensToXML(nhanViens);
                break;

            case 4: // Tab Sản phẩm
                SanPham sanpham = view.getProductTextField();
                List<SanPham> sanPhams = DataXMLHandler.readProductsFromXML();

                for (SanPham sp : sanPhams) {
                    if (sp.getMaSanPham().equals(sanpham.getMaSanPham())) {
                        sp.setTenSanPham(sanpham.getTenSanPham());
                        sp.setLoai(sanpham.getLoai());
                        sp.setGia(sanpham.getGia());
                        sp.setSize(sanpham.getSize());
                        sp.setSoLuongTon(sanpham.getSoLuongTon());
                    }
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
