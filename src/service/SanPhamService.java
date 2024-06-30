/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.ChatLieu;
import entity.DanhMuc;
import entity.MauSac;
import entity.NhanVien;
import entity.SanPham;
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
public class SanPhamService {

    public ArrayList<SanPham> getAllSanPham() {
        ArrayList<SanPham> lst = new ArrayList<>();
        String sql = "SELECT sp.MaSP,\n"
                + "nv.MaNhanVien AS MaNV,\n"
                + " nv.TenNv AS TenNV,\n"
                + "sp.TenSp, \n"
                + " sp.NgayThem,\n"
                + " th.TenTh AS ThuongHieu,\n"
                + " dm.TenDm AS DanhMuc\n"
                + " FROM    \n"
                + " dbo.SanPham sp\n"
                + " INNER JOIN dbo.NhanVien nv ON sp.MaNhanVien = nv.MaNhanVien\n"
                + " INNER JOIN dbo.ThuongHieu th ON sp.MaThuongHieu = th.MaThuongHieu\n"
                + "INNER JOIN dbo.DanhMuc dm ON sp.MaDanhMuc = dm.MaDanhMuc";
        //Tạo kết nối
        Connection cn = DBcontext.getConnection();
        try {
            //Tạo statement

            PreparedStatement pstm = cn.prepareStatement(sql);
            //Thi hành Statement=> dùng Resultset nhận kq
            ResultSet rs = pstm.executeQuery();
            //xử lý kq: duyệt rs => đổ dữ liệu vào lst
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSp(rs.getString("MaSp"));
                sp.setTen(rs.getString("TenSp"));
                sp.setNgayThem(rs.getDate("NgayThem"));
                sp.setNhanVien(new NhanVien(rs.getString("MaNV"), rs.getString("TenNV")));
                sp.setThuongHieu(new ThuongHieu(rs.getString("ThuongHieu")));
                sp.setDanhMuc(new DanhMuc(rs.getString("DanhMuc")));
                lst.add(sp);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lst;
    }

    public Integer addSanPham(SanPham sp) {
        Integer row = null;
        String sql = "  INSERT INTO [dbo].[SanPham]\n" +
"                                   (MaSP\n" +
"                                   ,TenSp\n" +
"                                   ,[NgayThem]\n" +
"                                   ,MaThuongHieu\n" +
"                                   ,MaDanhMuc\n" +
"                                   ,MaNhanVien)\n" +
"                             VALUES (?, ?, ?, ?, ?, ?)";
        //Tạo kết nối
        Connection cn = DBcontext.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho các dấu ?
            pstm.setString(1, sp.getMaSp());
            pstm.setString(2, sp.getTen());
            pstm.setDate(3, sp.getNgayThem());
            pstm.setInt(4, sp.getId_th());
            pstm.setInt(5, sp.getId_dm());
            pstm.setString(6, sp.getMaNV());
            //Thi hành Statement
            row = pstm.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return row;
    }
    
    
    public Integer updateSanPham(SanPham sp) {
        Integer row = null;
        String sql = "UPDATE [dbo].[SanPham]\n" +
"                                 SET TenSp = ?\n" +
"                                    ,MaThuongHieu = ?\n" +
"                                    ,MaDanhMuc = ?\n" +
"                         WHERE MaSP = ?";
        //Tạo kết nối
        Connection cn = DBcontext.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho các dấu ?
            pstm.setString(4, sp.getMaSp());
            pstm.setString(1, sp.getTen());
            pstm.setInt(2, sp.getId_th());
            pstm.setInt(3, sp.getId_dm());
            //Thi hành Statement
            row = pstm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return row;
    }
    
    public static void main(String[] args) {
        SanPhamService spsv = new SanPhamService();
        for (SanPham sanPham : spsv.getAllSanPham()) {
            System.out.println(sanPham.getNhanVien().getTen());
        }
    }
}
