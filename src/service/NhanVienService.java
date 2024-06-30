/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.NhanVien;
import entity.SanPham;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utilty.DBcontext;

/**
 *
 * @author Phan Cao
 */
public class NhanVienService {

    public ArrayList<NhanVien> getAllNhanVien() {
        ArrayList<NhanVien> lst = new ArrayList<>();
        String sql = "select * from nhanvien";
        //Tạo kết nối
        Connection cn = DBcontext.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Thi hành Statement=> dùng Resultset nhận kq
            ResultSet rs = pstm.executeQuery();
            //xử lý kq: duyệt rs => đổ dữ liệu vào lst
            while (rs.next()) {
                NhanVien sv = new NhanVien();
                sv.setMaNv(rs.getString("manhanvien"));
                sv.setTen(rs.getString("tenNv"));
                sv.setPass(rs.getString("passwords"));
                sv.setSdt(rs.getString("sdt"));
                sv.setEmail(rs.getString("email"));
                sv.setLuong(rs.getDouble("luong"));
                sv.setNgaySinh(rs.getDate("ngaysinh"));
                sv.setDiaChi(rs.getString("DiaChi"));
                sv.setChucVu(rs.getBoolean("chucvu"));
                sv.setTrangThai(rs.getBoolean("trangthai"));
                lst.add(sv);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lst;
    }
    
    public NhanVien timKiemNhanVienTheoMa(String ma) {
        String sql = "select * from nhanvien where manhanvien like ?";
        //Tạo kết nối
        Connection cn = DBcontext.getConnection();
        NhanVien sv = new NhanVien();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
             pstm.setString(1, ma);
            //Thi hành Statement=> dùng Resultset nhận kq
            ResultSet rs = pstm.executeQuery();
            //xử lý kq: duyệt rs => đổ dữ liệu vào lst
            while (rs.next()) {
               sv.setMaNv(rs.getString("manhanvien"));
                sv.setTen(rs.getString("tenNv"));
                sv.setPass(rs.getString("passwords"));
                sv.setSdt(rs.getString("sdt"));
                sv.setEmail(rs.getString("email"));
                sv.setLuong(rs.getDouble("luong"));
                sv.setNgaySinh(rs.getDate("ngaysinh"));
                sv.setDiaChi(rs.getString("DiaChi"));
                sv.setChucVu(rs.getBoolean("chucvu"));
                sv.setTrangThai(rs.getBoolean("trangthai"));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return sv;
    }
    
    public NhanVien timKiemNhanVienTheoMa1(String ma) {
        String sql = "select * from nhanvien where manhanvien like ?";
        //Tạo kết nối
        Connection cn = DBcontext.getConnection();
        NhanVien sv = new NhanVien();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
             pstm.setString(1, ma);
            //Thi hành Statement=> dùng Resultset nhận kq
            ResultSet rs = pstm.executeQuery();
            //xử lý kq: duyệt rs => đổ dữ liệu vào lst
            while (rs.next()) {
                sv.setMaNv(rs.getString("manhanvien"));
                sv.setTen(rs.getString("tenNv"));
                sv.setPass(rs.getString("passwords"));
                sv.setChucVu(rs.getBoolean("chucvu"));
                sv.setTrangThai(rs.getBoolean("trangthai"));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return sv;
    }

    public static void main(String[] args) {
        NhanVienService nvsv = new NhanVienService();
        NhanVien nv = nvsv.timKiemNhanVienTheoMa("PH12345");
        System.out.println(nv.getMaNv());
    }
    public Integer addNhanVien(NhanVien nv) {
        Integer row = null;
        String sql = "INSERT INTO [dbo].[NhanVien]\n"
                + "                                   (MaNhanVien\n"
                + "                                   ,[Passwords]\n"
                + "                                   ,TenNv\n"
                + "                                   ,[SDT]\n"
                + "                                   ,[Email]\n"
                + "                                   ,[ChucVu]\n"
                + "                                   ,[TrangThai]\n"
                + "                                   ,[Luong]\n"
                + "                                   ,[NgaySinh]\n"
                + "                                   ,[DiaChi])\n"
                + "                             VALUES(?,?,?,?,?,?,?,?,?,?)	 ";
        //Tạo kết nối
        Connection cn = DBcontext.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho các dấu ?
            pstm.setString(1, nv.getMaNv());
            pstm.setString(2, nv.getPass());
            pstm.setString(3, nv.getTen());
            pstm.setString(4, nv.getSdt());
            pstm.setString(5, nv.getEmail());
            pstm.setBoolean(6, nv.isChucVu());
            pstm.setBoolean(7, nv.isTrangThai());
            pstm.setDouble(8, nv.getLuong());
            pstm.setDate(9, (Date) nv.getNgaySinh());
            pstm.setString(10, nv.getDiaChi());
            //Thi hành Statement
            row = pstm.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return row;
    }

    public Integer updateNhanVien(NhanVien nv) {
        Integer row = null;
        String sql = " UPDATE NhanVien\n"
                + "                          SET Passwords = ?\n"
                + "                             ,TenNv = ?\n"
                + "                             ,SDT = ?\n"
                + "                             ,Email = ?\n"
                + "                             ,ChucVu = ?\n"
                + "                             ,TrangThai =?\n"
                + "                             ,Luong = ?\n"
                + "                             ,NgaySinh = ?\n"
                + "                             ,DiaChi = ?\n"
                + "                        WHERE MaNhanVien like ?";
        //Tạo kết nối
        Connection cn = DBcontext.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho các dấu ?
            pstm.setString(1, nv.getPass());
            pstm.setString(2, nv.getTen());
            pstm.setString(3, nv.getSdt());
            pstm.setString(4, nv.getEmail());
            pstm.setBoolean(5, nv.isChucVu());
            pstm.setBoolean(6, nv.isTrangThai());
            pstm.setDouble(7, nv.getLuong());
            pstm.setDate(8, (Date) nv.getNgaySinh());
            pstm.setString(9, nv.getDiaChi());
            pstm.setString(10, nv.getMaNv());
            //Thi hành Statement
            row = pstm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return row;
    }
}
