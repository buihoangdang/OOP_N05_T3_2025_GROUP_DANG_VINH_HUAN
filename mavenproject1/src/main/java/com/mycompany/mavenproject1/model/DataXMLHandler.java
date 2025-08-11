package com.mycompany.mavenproject1.model;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class DataXMLHandler {
    // Hàm ghi danh sách cửa hàng vào file XML
    public static void writeCuaHangToXML(List<CuaHang> cuaHangs) {
        String filePath = "CuaHang.xml";
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            // Tạo phần tử gốc
            Element rootElement = doc.createElement("cuahangs");
            doc.appendChild(rootElement);

            // Thêm từng cửa hàng
            for (CuaHang ch : cuaHangs) {
                Element chElement = doc.createElement("cuahang");

                addElement(doc, chElement, "maCuaHang", ch.getMaCuaHang());
                addElement(doc, chElement, "tenChiNhanh", ch.getTenChiNhanh());
                addElement(doc, chElement, "diaChi", ch.getDiaChi());

                rootElement.appendChild(chElement);
            }

            // Ghi vào file XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    // Hàm đọc danh sách cửa hàng từ file XML
    public static List<CuaHang> readCuaHangFromXML() {
        String filePath = "CuaHang.xml";
        List<CuaHang> cuaHangs = new ArrayList<>();
        try {
            File xmlFile = new File(filePath);
            if (!xmlFile.exists()) {
                return cuaHangs;
            }

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList chNodes = doc.getElementsByTagName("cuahang");

            for (int i = 0; i < chNodes.getLength(); i++) {
                Node chNode = chNodes.item(i);
                if (chNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element chElement = (Element) chNode;

                    String maCuaHang = getElementValue(chElement, "maCuaHang");
                    String tenChiNhanh = getElementValue(chElement, "tenChiNhanh");
                    String diaChi = getElementValue(chElement, "diaChi");

                    CuaHang ch = new CuaHang(maCuaHang, tenChiNhanh, diaChi);
                    cuaHangs.add(ch);
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return cuaHangs;
    }
    
    // Hàm ghi danh sách đơn hàng vào file XML
    public static void writeDonHangToXML(List<DonHang> donHangs) {
        String filePath = "DonHang.xml";
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            // Tạo phần tử gốc
            Element rootElement = doc.createElement("donHangs");
            doc.appendChild(rootElement);

            // Thêm từng đơn hàng
            for (DonHang dh : donHangs) {
                Element donHangElement = doc.createElement("donHang");

                addElement(doc, donHangElement, "maDonHang", dh.getMaDonHang());
                addElement(doc, donHangElement, "maKhachHang", dh.getMaKhachHang());
                addElement(doc, donHangElement, "ngayDat", dh.getNgayDat()); // String trực tiếp
                addElement(doc, donHangElement, "tongTien", String.valueOf(dh.getTongTien()));

                rootElement.appendChild(donHangElement);
            }

            // Ghi vào file XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    // Hàm đọc danh sách đơn hàng từ file XML
    public static List<DonHang> readDonHangFromXML() {
        String filePath = "DonHang.xml";
        List<DonHang> donHangs = new ArrayList<>();

        try {
            File xmlFile = new File(filePath);
            if (!xmlFile.exists()) {
                return donHangs; // File chưa tồn tại -> trả về danh sách rỗng
            }

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("donHang");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    String maDonHang = getElementValue(element, "maDonHang");
                    String maKhachHang = getElementValue(element, "maKhachHang");
                    String ngayDat = getElementValue(element, "ngayDat"); // Giữ nguyên String

                    double tongTien;
                    try {
                        tongTien = Double.parseDouble(getElementValue(element, "tongTien"));
                    } catch (NumberFormatException e) {
                        tongTien = 0.0;
                    }

                    donHangs.add(new DonHang(maDonHang, maKhachHang, ngayDat, tongTien));
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return donHangs;
    }

    // Hàm ghi danh sách sản phẩm vào file XML
    public static void writeProductsToXML(List<SanPham> products) {
        String filePath = "SanPham.xml";
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            // Tạo phần tử gốc
            Element rootElement = doc.createElement("products");
            doc.appendChild(rootElement);

            // Thêm từng sản phẩm
            for (SanPham sp : products) {
                Element productElement = doc.createElement("product");

                addElement(doc, productElement, "maSanPham", sp.getMaSanPham());
                addElement(doc, productElement, "tenSanPham", sp.getTenSanPham());
                addElement(doc, productElement, "loai", sp.getLoai());
                addElement(doc, productElement, "gia", String.valueOf(sp.getGia()));
                addElement(doc, productElement, "size", sp.getSize());
                addElement(doc, productElement, "soLuongTon", String.valueOf(sp.getSoLuongTon()));

                rootElement.appendChild(productElement);
            }

            // Ghi ra file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    // Hàm đọc danh sách sản phẩm từ file XML
    public static List<SanPham> readProductsFromXML() {
        String filePath = "SanPham.xml";
        List<SanPham> products = new ArrayList<>();
        try {
            File xmlFile = new File(filePath);
            if (!xmlFile.exists()) {
                return products; // File chưa tồn tại
            }

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList productNodes = doc.getElementsByTagName("product");

            for (int i = 0; i < productNodes.getLength(); i++) {
                Node productNode = productNodes.item(i);
                if (productNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element productElement = (Element) productNode;

                    String maSanPham = getElementValue(productElement, "maSanPham");
                    String tenSanPham = getElementValue(productElement, "tenSanPham");
                    String loai = getElementValue(productElement, "loai");

                    double gia;
                    try {
                        gia = Double.parseDouble(getElementValue(productElement, "gia"));
                    } catch (NumberFormatException e) {
                        gia = 0;
                    }

                    String size = getElementValue(productElement, "size");

                    int soLuongTon;
                    try {
                        soLuongTon = Integer.parseInt(getElementValue(productElement, "soLuongTon"));
                    } catch (NumberFormatException e) {
                        soLuongTon = 0;
                    }

                    SanPham sp = new SanPham(maSanPham, tenSanPham, loai, gia, size, soLuongTon);
                    products.add(sp);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return products;
    }
    
    // Hàm ghi danh sách nhân viên vào file XML (cuaHang là String)
    public static void writeNhanViensToXML(List<NhanVien> nhanViens) {
        String filePath = "NhanVien.xml";
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            // Root element
            Element rootElement = doc.createElement("nhanViens");
            doc.appendChild(rootElement);

            for (NhanVien nv : nhanViens) {
                Element nvElement = doc.createElement("nhanVien");

                addElement(doc, nvElement, "maNhanVien", nv.getMaNhanVien());
                addElement(doc, nvElement, "hoTen", nv.getHoTen());
                addElement(doc, nvElement, "tuoi", String.valueOf(nv.getTuoi()));
                addElement(doc, nvElement, "viTri", nv.getViTri());
                addElement(doc, nvElement, "cuaHang", nv.getCuaHang()); // chỉ là String

                rootElement.appendChild(nvElement);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    // Hàm đọc danh sách nhân viên từ file XML (cuaHang là String)
    public static List<NhanVien> readNhanViensFromXML() {
        String filePath = "NhanVien.xml";
        List<NhanVien> nhanViens = new ArrayList<>();

        try {
            File xmlFile = new File(filePath);
            if (!xmlFile.exists()) {
                return nhanViens;
            }

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nvNodes = doc.getElementsByTagName("nhanVien");

            for (int i = 0; i < nvNodes.getLength(); i++) {
                Node nvNode = nvNodes.item(i);
                if (nvNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element nvElement = (Element) nvNode;

                    String maNhanVien = getElementValue(nvElement, "maNhanVien");
                    String hoTen = getElementValue(nvElement, "hoTen");
                    int tuoi;
                    try {
                        tuoi = Integer.parseInt(getElementValue(nvElement, "tuoi"));
                    } catch (NumberFormatException e) {
                        tuoi = 0;
                    }
                    String viTri = getElementValue(nvElement, "viTri");
                    String cuaHang = getElementValue(nvElement, "cuaHang"); // chỉ là String

                    NhanVien nv = new NhanVien(maNhanVien, hoTen, tuoi, viTri, cuaHang);
                    nhanViens.add(nv);
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return nhanViens;
    }

    // Hàm ghi danh sách khách hàng vào file XML
    public static void writeKhachHangToXML(List<KhachHang> danhSachKhachHang) {
        String filePath = "KhachHang.xml";
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            // Tạo phần tử gốc
            Element rootElement = doc.createElement("khachHangs");
            doc.appendChild(rootElement);

            // Thêm từng khách hàng vào file XML
            for (KhachHang kh : danhSachKhachHang) {
                Element khElement = doc.createElement("khachHang");

                addElement(doc, khElement, "maKhachHang", kh.getMaKhachHang());
                addElement(doc, khElement, "hoTen", kh.getHoTen());
                addElement(doc, khElement, "soDienThoai", kh.getSoDienThoai());
                addElement(doc, khElement, "diaChi", kh.getDiaChi());

                rootElement.appendChild(khElement);
            }

            // Ghi vào file XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    // Hàm đọc danh sách khách hàng từ file XML
    public static List<KhachHang> readKhachHangFromXML() {
        String filePath = "KhachHang.xml";
        List<KhachHang> danhSachKhachHang = new ArrayList<>();
        try {
            File xmlFile = new File(filePath);
            if (!xmlFile.exists()) {
                return danhSachKhachHang; // Trả về danh sách rỗng nếu file không tồn tại
            }

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList khNodes = doc.getElementsByTagName("khachHang");

            for (int i = 0; i < khNodes.getLength(); i++) {
                Node khNode = khNodes.item(i);
                if (khNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element khElement = (Element) khNode;

                    String maKhachHang = getElementValue(khElement, "maKhachHang");
                    String hoTen = getElementValue(khElement, "hoTen");
                    String soDienThoai = getElementValue(khElement, "soDienThoai");
                    String diaChi = getElementValue(khElement, "diaChi");

                    KhachHang kh = new KhachHang(maKhachHang, hoTen, soDienThoai, diaChi);
                    danhSachKhachHang.add(kh);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return danhSachKhachHang;
    }

    // Hàm tiện ích để thêm phần tử vào XML
    private static void addElement(Document doc, Element parent, String name, String value) {
        Element element = doc.createElement(name);
        element.setTextContent(value != null ? value : "");
        parent.appendChild(element);
    }

    // Hàm tiện ích để lấy giá trị của phần tử
    private static String getElementValue(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0 && nodeList.item(0).getTextContent() != null) {
            return nodeList.item(0).getTextContent();
        }
        return "";
    }
}