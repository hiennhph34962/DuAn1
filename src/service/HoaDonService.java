/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.ChatLieu;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.Voucher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utilty.DBcontext;

/**
 *
 * @author Phan Cao
 */
public class HoaDonService {

    public Integer addHoaDonKhNull(HoaDon hd) {
        Integer row = null;
        String sql = "insert into hoadon (Ngaytao,trangthai,MaNhanVien) values(?,?,?)";
        //Tạo kết nối
        Connection cn = DBcontext.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho các dấu ?
            pstm.setDate(1, hd.getNgayTao());
            pstm.setInt(2, hd.getTrangThai());
            pstm.setString(3, hd.getMaNv());
            //Thi hành Statement
            row = pstm.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return row;
    }

    public Integer addHoaDonKhNotNull(HoaDon hd) {
        Integer row = null;
        String sql = "insert into hoadon (Ngaytao,trangthai,MaNhanVien,MaKH) values(?,?,?,?)";
        //Tạo kết nối
        Connection cn = DBcontext.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho các dấu ?
            pstm.setDate(1, hd.getNgayTao());
            pstm.setInt(2, hd.getTrangThai());
            pstm.setString(3, hd.getMaNv());
            pstm.setString(4, hd.getMaKh());
            //Thi hành Statement
            row = pstm.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return row;
    }

    public ArrayList<HoaDon> getAllHoaDon() {
        ArrayList<HoaDon> lst = new ArrayList<>();
        String sql = "SELECT * \n"
                + "FROM dbo.HoaDon hd\n"
                + "LEFT JOIN dbo.NhanVien nv ON hd.MaNhanVien = nv.MaNhanVien\n"
                + "LEFT JOIN dbo.KhachHang kh ON kh.MaKH = hd.MaKH\n"
                + "LEFT JOIN dbo.Voucher vc ON vc.MaVoucher = hd.MaVoucher;";
        Connection cn = DBcontext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHd(rs.getString("MaHD"));
                hd.setNgayTao(rs.getDate("NgayTao"));
                hd.setTongTien(rs.getDouble("TongTien"));
                hd.setTrangThai(rs.getInt("TrangThai"));
                hd.setNv(new NhanVien(rs.getString("MaNhanVien"), rs.getString("TenNV")));
                hd.setVc(new Voucher(rs.getString("mavoucher"), rs.getString("tenVc")));
                hd.setKh(new KhachHang(rs.getString("sdt")));
                hd.setLyDoHuy(rs.getString("LyDoHuy"));
                lst.add(hd);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lst;
    }

    public HoaDon timKiemHoaDon(String ma) {
        String sql = "SELECT * \n"
                + "FROM dbo.HoaDon hd\n"
                + "LEFT JOIN dbo.NhanVien nv ON hd.MaNhanVien = nv.MaNhanVien\n"
                + "LEFT JOIN dbo.KhachHang kh ON kh.MaKH = hd.MaKH\n"
                + "LEFT JOIN dbo.Voucher vc ON vc.MaVoucher = hd.MaVoucher where hd.mahd like ?;";
        Connection cn = DBcontext.getConnection();
        HoaDon hd = new HoaDon();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, ma);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {

                hd.setMaHd(rs.getString("MaHD"));
                hd.setNgayTao(rs.getDate("NgayTao"));
                hd.setTongTien(rs.getDouble("TongTien"));
                hd.setTrangThai(rs.getInt("TrangThai"));
                hd.setNv(new NhanVien(rs.getString("MaNhanVien"), rs.getString("TenNV")));
                hd.setVc(new Voucher(rs.getString("mavoucher"), rs.getString("tenVc")));
                hd.setKh(new KhachHang(rs.getString("sdt")));
                hd.setLyDoHuy(rs.getString("LyDoHuy"));
              
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return hd;
    }

    public HoaDonService() {
    }

    public ArrayList<HoaDon> getAllTrangThaiHai() {
        ArrayList<HoaDon> lst = new ArrayList<>();
        String sql = "SELECT * FROM dbo.HoaDon hd JOIN dbo.NhanVien nv ON hd.MaNhanVien = nv.MaNhanVien WHERE hd.TrangThai = 2";
        Connection cn = DBcontext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                HoaDon sv = new HoaDon();
                sv.setMaHd(rs.getString("maHd"));
                sv.setNgayTao(rs.getDate("ngaytao"));
                sv.setTongTien(rs.getDouble("tongtien"));
                sv.setTrangThai(rs.getInt("trangthai"));
                sv.setNv(new NhanVien(rs.getString("MaNhanVien"), rs.getString("TenNV")));
                sv.setMaKh(rs.getString("maKh"));
                sv.setMaVc(rs.getString("MaVouCher"));
                lst.add(sv);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lst;
    }

    public static void main(String[] args) {
        HoaDonService hoaDonService = new HoaDonService();
        for (HoaDon arg : hoaDonService.getAllHoaDon()) {
            System.out.println(arg.getMaHd());
        }
    }

    public ArrayList<HoaDon> getAllTrangThaiHaiKh() {
        ArrayList<HoaDon> lst = new ArrayList<>();
        String sql = "SELECT \n"
                + "                   nv.MaNhanVien ,\n"
                + "                  nv.tenNv,\n"
                + "                  hd.MaHD , \n"
                + "                   hd.NgayTao, \n"
                + "              	hd.TrangThai,\n"
                + "                hd.TongTien,\n"
                + "              	hd.MaKH,\n"
                + "               	hd.MaVouCher,\n"
                + "                kh.MaKH ,\n"
                + "                   kh.tenKh\n"
                + "                 \n"
                + "               FROM \n"
                + "                 hoadon hd\n"
                + "               LEFT JOIN \n"
                + "                  khachhang kh ON hd.MaKH = kh.MaKH\n"
                + "              LEFT JOIN \n"
                + "                nhanvien nv ON hd.MaNhanVien = nv.MaNhanVien\n"
                + "            WHERE \n"
                + "                  hd.trangthai = 2;";
        Connection cn = DBcontext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                HoaDon sv = new HoaDon();
                sv.setMaHd(rs.getString("maHD"));
                sv.setNgayTao(rs.getDate("ngaytao"));
                sv.setTongTien(rs.getDouble("tongtien"));
                sv.setTrangThai(rs.getInt("trangthai"));
                sv.setNv(new NhanVien(rs.getString("MaNhanVien"), rs.getString("TenNV")));
                sv.setKh(new KhachHang(rs.getString("MaKh"), rs.getString("TenKh")));
                sv.setMaKh(rs.getString("MaKh"));
                sv.setMaVc(rs.getString("MaVouCher"));
                lst.add(sv);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lst;
    }

    public HoaDon timKiemTheoMaHd(String ma) {
        HoaDon hd = null;
        String sql = "SELECT  hd.MaHD, nv.MaNhanVien AS MaNV,nv.TenNV AS TenNV,hd.NgayTao,  hd.TongTien,   hd.TrangThai\n"
                + "FROM  dbo.HoaDon hd JOIN dbo.NhanVien nv ON hd.MaNhanVien = nv.MaNhanVien WHERE hd.MaHD = ?";
        // Tạo kết nối
        Connection cn = DBcontext.getConnection();
        try {
            // Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            // Thiết lập giá trị cho tham số id
            pstm.setString(1, ma);
            // Thi hành Statement => dùng ResultSet nhận kết quả
            ResultSet rs = pstm.executeQuery();
            // Xử lý kết quả: duyệt rs => đổ dữ liệu vào hd
            if (rs.next()) {
                hd = new HoaDon();
                hd.setMaHd(rs.getString("MaHD"));
                hd.setNgayTao(rs.getDate("NgayTao"));
                Double tongTien = rs.getDouble("TongTien");
                if (rs.wasNull()) {
                    tongTien = null;
                }
                hd.setTongTien(tongTien);
                hd.setTrangThai(rs.getInt("TrangThai"));
                hd.setNv(new NhanVien(rs.getString("MaNV"), rs.getString("TenNV")));
            }
            // Đóng kết nối và statement
            rs.close();
            pstm.close();
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return hd;
    }

    public ArrayList<HoaDon> timKiemTheoMaHD1(String maHD) {
        ArrayList<HoaDon> lst = new ArrayList<>();
        String sql = "SELECT  hd.MaHD,"
                + " nv.MaNhanVien AS MaNV,"
                + "nv.TenNV AS TenNV"
                + ",hd.NgayTao,  hd.TongTien,   hd.TrangThai\n"
                + "FROM  dbo.HoaDon hd JOIN dbo.NhanVien nv ON hd.MaNhanVien = nv.MaNhanVien "
                + "WHERE hd.MaHD = ?";
        // Tạo kết nối
        Connection cn = DBcontext.getConnection();
        try {
            // Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            // Thiết lập giá trị cho tham số id
            pstm.setString(1, maHD);
            // Thi hành Statement => dùng ResultSet nhận kết quả
            ResultSet rs = pstm.executeQuery();
            // Xử lý kết quả: duyệt rs => đổ dữ liệu vào lst
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHd(rs.getString("MaHd"));
                hd.setNgayTao(rs.getDate("NgayTao"));
                Double tongTien = rs.getDouble("TongTien");
                if (rs.wasNull()) {
                    tongTien = null;
                }
                hd.setTongTien(tongTien);
                hd.setTrangThai(rs.getInt("TrangThai"));
                hd.setNv(new NhanVien(rs.getString("MaNV"), rs.getString("TenNV")));
                lst.add(hd);
            }
            // Đóng kết nối và statement
            rs.close();
            pstm.close();
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lst;
    }

    public Integer updateHoaDonHuy(HoaDon hd) {
        Integer row = null;
        String sql = "UPDATE HoaDon SET TongTien =?, TrangThai = ?,Lydohuy = ?  WHERE MaHd = ?";
        //Tạo kết nối
        Connection cn = DBcontext.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho các dấu ?
            pstm.setDouble(1, hd.getTongTien());
            pstm.setInt(2, hd.getTrangThai());
            pstm.setString(3, hd.getLyDoHuy());
            pstm.setString(4, hd.getMaHd());
            //Thi hành Statement
            row = pstm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return row;
    }

    public Integer updateHoaDon(HoaDon hd) {
        Integer row = null;
        String sql = "UPDATE HoaDon SET TongTien = ?, TrangThai = ?,MaVoucher =?   WHERE MaHd like ?";
        //Tạo kết nối
        Connection cn = DBcontext.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho các dấu ?
            pstm.setDouble(1, hd.getTongTien());
            pstm.setInt(2, hd.getTrangThai());
            pstm.setString(3, hd.getMaVc());
            pstm.setString(4, hd.getMaHd());
            //Thi hành Statement
            row = pstm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return row;
    }
}
