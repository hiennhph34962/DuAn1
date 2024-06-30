/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.ChatLieu;
import entity.DanhMuc;
import entity.HoaDon;
import entity.HoaDonChiTiet;
import entity.MauSac;
import entity.NhanVien;
import entity.SanPham;
import entity.SanPhamChiTiet;
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
public class SanPhamChiTietService {

    public SanPhamChiTiet timKiemTheoMa(String ma) {
        String sql = "SELECT spct.MaSPChiTiet, spct.MaSP,  nv.MaNhanVien AS MaNV,\n" +
"                                           nv.TenNv AS TenNV,\n" +
"                                        sp.TenSP AS TenSP, \n" +
"                                          spct.Gia, \n" +
"                                         spct.SoLuong, \n" +
"                                          sz.TenSz AS Size,\n" +
"                                           ms.TenMs AS MauSac, \n" +
"                                            cl.TenCl AS ChatLieu, \n" +
"                                          dm.TenDm AS DanhMuc, \n" +
"                                        th.TenTh AS ThuongHieu, \n" +
"                                          spct.TrangThai\n" +
"                                     FROM \n" +
"                                          dbo.SanPhamChiTiet spct\n" +
"                                      JOIN \n" +
"                                            dbo.SanPham sp ON spct.MaSP = sp.MaSP\n" +
"                                        JOIN \n" +
"                                         dbo.MauSac ms ON spct.MaMauSac = ms.MaMauSac\n" +
"                                      JOIN\n" +
"                                         dbo.Size sz ON spct.MaSize = sz.MaSize\n" +
"                                     JOIN \n" +
"                                         dbo.ChatLieu cl ON spct.MaChatLieu = cl.MaChatLieu\n" +
"                                      JOIN \n" +
"                                           dbo.DanhMuc dm ON sp.MaDanhMuc = dm.MaDanhMuc\n" +
"                                      JOIN\n" +
"                                      dbo.NhanVien nv ON sp.MaNhanVien = nv.MaNhanVien\n" +
"                                     JOIN\n" +
"                                         dbo.ThuongHieu th ON sp.MaThuongHieu = th.MaThuongHieu\n" +
"                                  WHERE spct.MaSPChiTiet = ?";
        // Tạo kết nối
        Connection cn = DBcontext.getConnection();
        SanPhamChiTiet spct = new SanPhamChiTiet();
        try {
            // Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            // Thiết lập giá trị cho tham số id
            pstm.setString(1, ma);
            // Thi hành Statement => dùng ResultSet nhận kết quả
            ResultSet rs = pstm.executeQuery();
            // Xử lý kết quả: duyệt rs => đổ dữ liệu vào lst

            while (rs.next()) {
                spct.setMaSpct(rs.getString("MaSPChiTiet"));
                spct.setGia(rs.getDouble("Gia"));
                spct.setSoLuong(rs.getInt("SoLuong"));
                spct.setMaSP(rs.getString("MaSP"));
                spct.setTrangThai(rs.getBoolean("TrangThai"));
                spct.setSanPham(
                        new SanPham(rs.getString("TenSP"),
                        new ThuongHieu(rs.getString("ThuongHieu")),
                        new DanhMuc(rs.getString("DanhMuc")),
                        new NhanVien(rs.getString("MaNV"), rs.getString("TenNV")))
                );
                spct.setSize(new Size(rs.getString("Size")));
                spct.setMauSac(new MauSac(rs.getString("MauSac")));
                spct.setChatLieu(new ChatLieu(rs.getString("ChatLieu")));
            }
            // Đóng kết nối và statement
            rs.close();
            pstm.close();
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return spct;
    }

    public static void main(String[] args) {
        SanPhamChiTietService dcv= new SanPhamChiTietService();
        SanPhamChiTiet dpct = dcv.timKiemTheoMa("SPCT03");
        System.out.println(dpct.getSoLuong());
    }
    public Integer updateSoLuongSanPham(SanPhamChiTiet spct) {
        Integer row = null;
        String sql = "UPDATE [dbo].[SanPhamChiTiet]\n"
                + "                        SET SoLuong = ?\n"
                + "                     ,[TrangThai] = ?\n"
                + "                      WHERE MaSPChiTiet = ?";
        //Tạo kết nối
        Connection cn = DBcontext.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho các dấu ?
            pstm.setInt(1, spct.getSoLuong());
            pstm.setBoolean(2, spct.isTrangThai());
             pstm.setString(3, spct.getMaSpct());
            //Thi hành Statement
            row = pstm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return row;
    }
    
    public Integer addSanPhamCt(SanPhamChiTiet spct) {
        Integer row = null;
        String sql = "INSERT INTO [dbo].[SanPhamChiTiet]\n" +
"                                ([MaSp]\n" +
"                                ,Gia\n" +
"                                ,SoLuong\n" +
"                                ,[TrangThai]\n" +
"                                ,MaSize\n" +
"                                ,MaMauSac\n" +
"                                ,MaChatLieu)\n" +
"                          VALUES (?, ?, ?, ?, ?, ?, ?)";
        //Tạo kết nối
        Connection cn = DBcontext.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho các dấu ?
            pstm.setString(1, spct.getMaSP());
            pstm.setDouble(2, spct.getGia());
            pstm.setInt(3, spct.getSoLuong());
            pstm.setBoolean(4, spct.isTrangThai());
            pstm.setInt(5, spct.getId_size());
            pstm.setInt(6, spct.getId_mauSac());
             pstm.setInt(7, spct.getId_chatLieu());
            //Thi hành Statement
            row = pstm.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return row;
    }
    
    public Integer updateSanPhamChiTiet(SanPhamChiTiet sp) {
        Integer row = null;
        String sql = "UPDATE [dbo].[SanPhamChiTiet]\n" +
"                        SET [Gia] = ?\n" +
"                           ,[SoLuong] = ?\n" +
"                           ,[TrangThai] = ?\n" +
"                           ,MaSize = ?\n" +
"                           ,MaMauSac = ?\n" +
"                           ,MaChatLieu = ?\n" +
"                      WHERE MaSP = ?";
        //Tạo kết nối
        Connection cn = DBcontext.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho các dấu ?
            pstm.setString(7, sp.getMaSP());
            pstm.setDouble(1, sp.getGia());
            pstm.setInt(2, sp.getSoLuong());
            pstm.setBoolean(3, sp.isTrangThai());
            pstm.setInt(4, sp.getId_size());
            pstm.setInt(5, sp.getId_mauSac());
            pstm.setInt(6, sp.getId_chatLieu());
            //Thi hành Statement
            row = pstm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return row;
    }
}
