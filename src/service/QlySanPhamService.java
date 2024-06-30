/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.ChatLieu;
import entity.DanhMuc;
import entity.MauSac;
import entity.NhanVien;
import entity.SanPhamBanHang;
import entity.SanPhamChiTiet;
import entity.SanPhamQuanLy;
import entity.Size;
import entity.ThuongHieu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utilty.DBcontext;

/**
 *
 * @author Phan Cao
 */
public class QlySanPhamService {

    public ArrayList<SanPhamQuanLy> getAllSanPham() {
        ArrayList<SanPhamQuanLy> lst = new ArrayList<>();
        String sql = "select spct.maSpChiTiet,  sp.MaSP, nv.MaNhanVien as maNV , sp.tenSp,spct.Gia,spct.SoLuong\n"
                + "          ,sz.TenSz, ms.TenMs, cl.TenCl ,dm.TenDm,th.TenTh,spct.TrangThai  from sanpham sp\n"
                + "     join sanphamchitiet spct on sp.MaSP = spct.MaSP\n"
                + "             join Size sz on spct.MaSize = sz.MaSize\n"
                + "               join chatlieu cl on spct.MaChatLieu = cl.MaChatLieu\n"
                + "               join mausac  ms on spct.MaMauSac = ms.MaMauSac\n"
                + "               join nhanvien nv on nv.MaNhanVien = sp.MaNhanVien\n"
                + "              join danhmuc dm on sp.MaDanhMuc = dm.MaDanhMuc\n"
                + "                	join ThuongHieu th on th.MaThuongHieu = sp.MaThuongHieu";
        //Tạo kết nối
        Connection cn = DBcontext.getConnection();
        try {
            //Tạo statement

            PreparedStatement pstm = cn.prepareStatement(sql);
            //Thi hành Statement=> dùng Resultset nhận kq
            ResultSet rs = pstm.executeQuery();
            //xử lý kq: duyệt rs => đổ dữ liệu vào lst
            while (rs.next()) {
                ChatLieu clbh = new ChatLieu();
                clbh.setTen(rs.getString("tenCl"));

                Size sizebh = new Size();
                sizebh.setTen(rs.getString("tenSz"));

                MauSac msbh = new MauSac();
                msbh.setTen(rs.getString("tenMs"));

                DanhMuc dm = new DanhMuc();
                dm.setTen(rs.getString("tenDm"));

                ThuongHieu th = new ThuongHieu();
                th.setTen(rs.getString("tenTh"));

                NhanVien nv = new NhanVien();
                nv.setMaNv(rs.getString("maNV"));

                SanPhamChiTiet spct = new SanPhamChiTiet();
                spct.setMaSpct(rs.getString("maSpChiTiet"));
                spct.setGia(rs.getDouble("gia"));
                spct.setSoLuong(rs.getInt("soluong"));
                spct.setTrangThai(rs.getBoolean("trangThai"));

                SanPhamQuanLy spql = new SanPhamQuanLy();
                spql.setMaSp(rs.getString("maSp"));
                spql.setTenSp(rs.getString("tenSp"));
                spql.setMaSpCt(spct.getMaSpct());
                spql.setGia(spct.getGia());
                spql.setSoLuong(spct.getSoLuong());
                spql.setTenCl(clbh.getTen());
                spql.setTenDm(dm.getTen());
                spql.setTenMs(msbh.getTen());
                spql.setTenSz(sizebh.getTen());
                spql.setTenTh(th.getTen());
                spql.setTrangThai(spct.isTrangThai());
                spql.setMaNv(nv.getMaNv());
                lst.add(spql);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lst;
    }

    public SanPhamQuanLy timKiemSanPhamTheoMa(String ma) {
        String sql = "select spct.maSpChiTiet,  sp.MaSP, nv.MaNhanVien as maNV , sp.tenSp,spct.Gia,spct.SoLuong\n"
                + "          ,sz.TenSz, ms.TenMs, cl.TenCl ,dm.TenDm,th.TenTh,spct.TrangThai  from sanpham sp\n"
                + "     join sanphamchitiet spct on sp.MaSP = spct.MaSP\n"
                + "             join Size sz on spct.MaSize = sz.MaSize\n"
                + "               join chatlieu cl on spct.MaChatLieu = cl.MaChatLieu\n"
                + "               join mausac  ms on spct.MaMauSac = ms.MaMauSac\n"
                + "               join nhanvien nv on nv.MaNhanVien = sp.MaNhanVien\n"
                + "              join danhmuc dm on sp.MaDanhMuc = dm.MaDanhMuc\n"
                + "                	join ThuongHieu th on th.MaThuongHieu = sp.MaThuongHieu where sp.masp like ?";
        //Tạo kết nối
        Connection cn = DBcontext.getConnection();
        SanPhamQuanLy spql = new SanPhamQuanLy();
        try {
            //Tạo statement

            PreparedStatement pstm = cn.prepareStatement(sql);
            //Thi hành Statement=> dùng Resultset nhận kq
            pstm.setString(1, ma);
            ResultSet rs = pstm.executeQuery();
            
            //xử lý kq: duyệt rs => đổ dữ liệu vào lst
            while (rs.next()) {
                ChatLieu clbh = new ChatLieu();
                clbh.setTen(rs.getString("tenCl"));

                Size sizebh = new Size();
                sizebh.setTen(rs.getString("tenSz"));

                MauSac msbh = new MauSac();
                msbh.setTen(rs.getString("tenMs"));

                DanhMuc dm = new DanhMuc();
                dm.setTen(rs.getString("tenDm"));

                ThuongHieu th = new ThuongHieu();
                th.setTen(rs.getString("tenTh"));

                NhanVien nv = new NhanVien();
                nv.setMaNv(rs.getString("maNV"));

                SanPhamChiTiet spct = new SanPhamChiTiet();
                spct.setMaSpct(rs.getString("maSpChiTiet"));
                spct.setGia(rs.getDouble("gia"));
                spct.setSoLuong(rs.getInt("soluong"));
                spct.setTrangThai(rs.getBoolean("trangThai"));

                spql.setMaSp(rs.getString("maSp"));
                spql.setTenSp(rs.getString("tenSp"));
                spql.setMaSpCt(spct.getMaSpct());
                spql.setGia(spct.getGia());
                spql.setSoLuong(spct.getSoLuong());
                spql.setTenCl(clbh.getTen());
                spql.setTenDm(dm.getTen());
                spql.setTenMs(msbh.getTen());
                spql.setTenSz(sizebh.getTen());
                spql.setTenTh(th.getTen());
                spql.setTrangThai(spct.isTrangThai());
                spql.setMaNv(nv.getMaNv());

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return spql;
    }

}
