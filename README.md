<h1 align="center">👕 Ứng Dụng Quản Lý Chuỗi Quần Áo</h1>
<p align="center">
  📚 <strong>Java OOP Project</strong> – Nhóm: <code>OOP_N05_T3_2025_GROUP_DANG_VINH_HUAN</code><br>
  🎓 Môn học: Lập trình Hướng Đối Tượng
</p>

---

## 📌 Giới thiệu dự án

🌟 **Giới thiệu dự án**
- Đây là một ứng dụng mô phỏng hệ thống quản lý chuỗi cửa hàng quần áo, nơi người dùng có thể:
- Quản lý sản phẩm (tên sản phẩm, giá, số lượng, loại, size…).
- Quản lý cửa hàng (địa chỉ, tên chi nhánh, số lượng sản phẩm tồn).
- Quản lý nhân viên (mã nhân viên, họ và tên, địa chỉ)
- Quản lý khách hàng (thông tin liên hệ, lịch sử mua hàng).

📌 Dự án được phát triển bằng Java (OOP), với trọng tâm là:
- ✅ Luyện tập các khái niệm: Class, Đối tượng, Đóng gói, Kế thừa, Đa hình.
- ✅ Mô hình hóa sát thực tế với các class: SanPham, CuaHang, NhanVien, KhachHang.

---

## 🧩 Main Class

| 🧾 Class              | 🛠️ Mô tả chức năng |
|------------------------|--------------------|
| `SanPham`              | Quản lý thông tin sản phẩm: mã, tên, loại, giá, size, số lượng tồn. |
| `CuaHang`              | Quản lý chi nhánh: mã cửa hàng, địa chỉ, số lượng sản phẩm. |
| `NhanVien`             | Lưu thông tin nhân viên: mã, họ tên, tuổi, vị trí, cửa hàng đang làm việc. |
| `KhachHang`            | Thông tin khách hàng: mã, tên, số điện thoại, địa chỉ, lịch sử mua. |
| `DonHang`              | Quản lý đơn hàng: mã đơn, khách hàng, sản phẩm, ngày đặt, tổng tiền. |

---

## ⚙️ Yêu cầu hệ thống

### 📋 Môi trường phát triển
- **Java Version:** JDK 24
- **IDE:** Eclipse, IntelliJ IDEA, hoặc Visual Studio Code
- **Operating System:** Windows, macOS, Linux

### 📦 Thư viện phụ thuộc
- Java Standard Library
- Collections Framework
- Date/Time API

---

## 🚀 Hướng dẫn cài đặt và chạy

### 1️⃣ Clone dự án
```bash
git clone https://github.com/buihoangdang/OOP_N05_T3_2025_GROUP_DANG_VINH_HUAN.git
cd OOP_N05_T3_2025_GROUP_DANG_VINH_HUAN
```

### 2️⃣ Biên dịch và chạy
```bash
# Biên dịch các file Java
javac -d bin src/*.java

# Chạy ứng dụng
java -cp bin Main
```

### 3️⃣ Sử dụng IDE
1. Mở IDE (Eclipse/IntelliJ IDEA)
2. Import project từ folder đã clone
3. Build project
4. Chạy file `Main.java`

---

## 🎯 Tính năng chính

### 🏪 Quản lý cửa hàng
- ➕ Thêm chi nhánh mới
- 📝 Cập nhật thông tin cửa hàng
- 📊 Thống kê sản phẩm theo từng chi nhánh

### 👕 Quản lý sản phẩm
- ➕ Thêm/sửa/xóa sản phẩm
- 🏷️ Phân loại theo: Áo, Quần, Phụ kiện
- 📏 Quản lý size: S, M, L, XL, XXL
- 📦 Theo dõi tồn kho

### 👥 Quản lý nhân viên
- 👤 Thêm/sửa thông tin nhân viên
- 🏢 Phân công cửa hàng làm việc

### 🛒 Quản lý khách hàng & đơn hàng
- 👤 Lưu trữ thông tin khách hàng
- 🧾 Tạo và quản lý đơn hàng
- 💰 Tính toán tổng giá trị đơn hàng

---

## 🧭 Sơ đồ UML

### 📊 Class Diagram
```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│    SanPham      │    │    CuaHang      │    │    NhanVien     │
├─────────────────┤    ├─────────────────┤    ├─────────────────┤
│ - maSP: String  │    │ - maCH: String  │    │ - maNV: String  │
│ - tenSP: String │    │ - tenCH: String │    │ - hoTen: String │
│ - loai: String  │    │ - diaChi: String│    │ - tuoi: int     │
│ - gia: double   │    │ - dsSanPham: [] │    │ - viTri: String │
│ - size: String  │    └─────────────────┘    │ - cuaHang: CH   │
│ - soLuong: int  │                           └─────────────────┘
└─────────────────┘    ┌─────────────────┐    ┌─────────────────┐
                       │   KhachHang     │    │    DonHang      │
                       ├─────────────────┤    ├─────────────────┤
                       │ - maKH: String  │    │ - maDH: String  │
                       │ - hoTen: String │    │ - khachHang: KH │
                       │ - sdt: String   │    │ - dsSanPham: [] │
                       │ - diaChi: String│    │ - ngayDat: Date │
                       │ - lichSu: []    │    │ - tongTien: double│
                       └─────────────────┘    └─────────────────┘
```

### 🔁 Activity Diagrams
<details>
<summary>📊 Click để xem các sơ đồ hoạt động</summary>

**Quy trình thêm sản phẩm:**
```
[Bắt đầu] → [Nhập thông tin SP] → [Kiểm tra hợp lệ] → [Lưu vào hệ thống] → [Kết thúc]
     ↓              ↓                    ↓                     ↓
[Menu chính] → [Validation] → [Cập nhật database] → [Thông báo thành công]
```

**Quy trình tạo đơn hàng:**
```
[Chọn khách hàng] → [Chọn sản phẩm] → [Kiểm tra tồn kho] → [Tính tổng tiền] → [Tạo đơn hàng]
```

</details>

---

## 🔧 Cấu trúc thư mục

```
├── README.md
└── mavenproject1
    ├── CuaHang.xml
    ├── DonHang.xml
    ├── KhachHang.xml
    ├── NhanVien.xml
    ├── SanPham.xml
    ├── pom.xml
    ├── src
        └── main
        │   └── java
        │       └── com
        │           └── mycompany
        │               └── mavenproject1
        │                   ├── Mavenproject1.java
        │                   ├── controller
        │                       ├── LoginController.java
        │                       └── MainController.java
        │                   ├── model
        │                       ├── CuaHang.java
        │                       ├── DataXMLHandler.java
        │                       ├── DonHang.java
        │                       ├── KhachHang.java
        │                       ├── NhanVien.java
        │                       └── SanPham.java
        │                   └── view
        │                       ├── LoginView.form
        │                       ├── LoginView.java
        │                       ├── MainView.form
        │                       └── MainView.java
    └── target
        
```

---

## 🧪 Hướng dẫn test

### ✅ Test cases cơ bản
```bash
# Chạy test cho từng class
java -cp bin TestSanPham
java -cp bin TestCuaHang
java -cp bin TestNhanVien
java -cp bin TestKhachHang
java -cp bin TestDonHang
```

### 📋 Kịch bản test
1. **Test thêm sản phẩm:** Kiểm tra validation dữ liệu đầu vào
2. **Test tạo đơn hàng:** Verify tính toán tổng tiền
3. **Test quản lý tồn kho:** Kiểm tra cập nhật số lượng sau bán hàng
4. **Test tìm kiếm:** Verify các chức năng search/filter

---

## 📈 Kế hoạch phát triển

### 🎯 Version 1.0 (Hiện tại)
- ✅ CRUD operations cho tất cả entities
- ✅ Console-based interface
- ✅ File data persistence

### 🚀 Version 2.0 (Tương lai)
- 🔮 GUI interface với JavaFX/Swing
- 🔮 Database integration (MySQL/SQLite)
- 🔮 Báo cáo và thống kê nâng cao
- 🔮 Quản lý khuyến mãi và giảm giá

---

## 🤝 Đóng góp

Chúng tôi hoan nghênh mọi đóng góp! Vui lòng:

1. 🍴 Fork repository
2. 🌿 Tạo feature branch (`git checkout -b feature/AmazingFeature`)
3. 💾 Commit changes (`git commit -m 'Add some AmazingFeature'`)
4. 📤 Push to branch (`git push origin feature/AmazingFeature`)
5. 🔄 Mở Pull Request

---

## 👨‍👩‍👧‍👦 Thành viên nhóm

| Tên thành viên        | Mã SV      | GitHub                                            | Vai trò               |
|------------------------|------------|----------------------------------------------------|-----------------------|
| 🧑‍💻 Nguyễn Văn Vinh       | 24108222   | [@Vinh210](https://github.com/Vinh210)             | Team Leader, Backend  |
| 👨‍💻 Bùi Hoàng Đăng      | 24106065   | [@buihoangdang](https://github.com/buihoangdang) | Database, Testing     |
| 👨‍💻 Vũ Bá Huân         | 24100134   | [@HuanVu3003](https://github.com/HuanVu3003)     | UI/UX, Documentation  |

---

## 📄 License

📋 Dự án này được phát hành dưới [MIT License](LICENSE).

---

## 🔗 Links quan trọng

📂 **Source Code:**  
👉 https://github.com/buihoangdang/OOP_N05_T3_2025_GROUP_DANG_VINH_HUAN/

📚 **Documentation:**  
👉 [Wiki](https://github.com/buihoangdang/OOP_N05_T3_2025_GROUP_DANG_VINH_HUAN/wiki)

🐛 **Bug Reports:**  
👉 [Issues](https://github.com/buihoangdang/OOP_N05_T3_2025_GROUP_DANG_VINH_HUAN/issues)

---

## 📞 Liên hệ

📧 **Email nhóm:** oop.n05.t3.2025@gmail.com  
🏫 **Trường:** Công nghệ thông tin Phenikaa
📚 **Khoa:** Hệ thống thông tin

---

<p align="center">
  💡 <strong>Nếu bạn thấy dự án hữu ích, hãy nhấn 🌟 star để ủng hộ nhóm nhé!</strong><br>
  📝 <em>Made with ❤️ by OOP_N05_T3_2025_GROUP_DANG_VINH_HUAN</em>
</p>
