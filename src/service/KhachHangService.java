/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.KhachHang;
import entity.NhanVien;
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
public class KhachHangService {

    public ArrayList<KhachHang> getAllKhachHang() {
        ArrayList<KhachHang> lst = new ArrayList<>();
        String sql = "select * from khachhang";
        //Tạo kết nối
        Connection cn = DBcontext.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Thi hành Statement=> dùng Resultset nhận kq
            ResultSet rs = pstm.executeQuery();
            //xử lý kq: duyệt rs => đổ dữ liệu vào lst
            while (rs.next()) {
                KhachHang sv = new KhachHang();
                sv.setMaKh(rs.getString("makh"));
                sv.setTenKh(rs.getString("tenKh"));
                sv.setNgaySinh(rs.getDate("ngaySinh"));
                sv.setSdt(rs.getString("sdt"));
                sv.setGioiTinh(rs.getBoolean("gioiTinh"));
                sv.setSdt(rs.getString("sdt"));
                lst.add(sv);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lst;
    }

    public KhachHang timKiemKHTheoMa(String ma) {
        String sql = "select * from khachhang where maKh like ?";
        //Tạo kết nối
        Connection cn = DBcontext.getConnection();
        KhachHang sv = new KhachHang();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Thi hành Statement=> dùng Resultset nhận kq
            pstm.setString(1, ma);
            ResultSet rs = pstm.executeQuery();
            //xử lý kq: duyệt rs => đổ dữ liệu vào lst
            while (rs.next()) {

                sv.setMaKh(rs.getString("makh"));
                sv.setTenKh(rs.getString("tenKh"));
                sv.setNgaySinh(rs.getDate("ngaySinh"));
                sv.setSdt(rs.getString("sdt"));
                sv.setGioiTinh(rs.getBoolean("gioiTinh"));
                sv.setSdt(rs.getString("sdt"));

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return sv;
    }

    public KhachHang timKiemKhTheoSdt(String sdt) {
        KhachHang kh = new KhachHang();
        String sql = "select * from khachhang where sdt like ?";
        // Tạo kết nối
        Connection cn = DBcontext.getConnection();
        try {
            // Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            // Thiết lập giá trị cho tham số id
            pstm.setString(1, sdt);
            // Thi hành Statement => dùng ResultSet nhận kết quả
            ResultSet rs = pstm.executeQuery();
            // Xử lý kết quả: duyệt rs => đổ dữ liệu vào lst
            while (rs.next()) {
                kh.setMaKh(rs.getString("MaKh"));
                kh.setTenKh(rs.getString("tenKh"));
                kh.setNgaySinh(rs.getDate("NgaySinh"));
                kh.setGioiTinh(rs.getBoolean("gioiTinh"));
                kh.setSdt(rs.getString("sdt"));
            }
            // Đóng kết nối và statement
            rs.close();
            pstm.close();
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return kh;
    }

    public Integer addKhachHang(KhachHang nv) {
        Integer row = null;
        String sql = "INSERT INTO [dbo].[KhachHang]\n"
                + "                                (TenKh\n"
                + "                                ,[NgaySinh]\n"
                + "                                ,[GioiTinh]\n"
                + "                                ,[SDT])\n"
                + "                          VALUES (?, ?, ?, ?)";
        //Tạo kết nối
        Connection cn = DBcontext.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho các dấu ?
            pstm.setString(1, nv.getTenKh());
            pstm.setDate(2, (Date) nv.getNgaySinh());
            pstm.setBoolean(3, nv.getGioiTinh());
            pstm.setString(4, nv.getSdt());

            row = pstm.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return row;
    }
}
