/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.ChatLieu;
import entity.HoaDon;
import entity.HoaDonChiTiet;
import entity.MauSac;
import entity.NhanVien;
import entity.SanPham;
import entity.SanPhamChiTiet;
import entity.Size;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utilty.DBcontext;

/**
 *
 * @author Phan Cao
 */
public class HoaDonChiTietService {

    public Integer addHoaDonChiTiet(HoaDonChiTiet hdct) {
        Integer row = null;
        String sql = "INSERT INTO [dbo].[HoaDonChiTiet]\n"
                + "                                ([GiaBan]\n"
                + "                                ,[SoLuongSP]\n"
                + "                                ,[TongTien]\n"
                + "                                ,[MaSPChiTiet]\n"
                + "                                ,[MaHD])\n"
                + "                          VALUES (?, ?, ?, ?, ?)";
        //Tạo kết nối
        Connection cn = DBcontext.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho các dấu ?
            pstm.setDouble(1, hdct.getGia());
            pstm.setInt(2, hdct.getSoLuong());
            pstm.setDouble(3, hdct.getTongTien());
            pstm.setString(4, hdct.getMaSpct());
            pstm.setString(5, hdct.getMaHD());
            //Thi hành Statement
            row = pstm.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return row;
    }

    public ArrayList<HoaDonChiTiet> timKiemTheoMaHD(String maHD) {
        ArrayList<HoaDonChiTiet> lst = new ArrayList<>();
        String sql = "SELECT hdct.MaHDChiTiet,hd.MaHD,sp.MaSP , sp.TenSp, size.TenSz, ms.TenMs ,  cl.TenCl ,    hdct.GiaBan,\n"
                + "                                          hdct.SoLuongSP,\n"
                + "                                         hdct.TongTien,\n"
                + "                                         hdct.MaSPChiTiet\n"
                + "                                     FROM\n"
                + "                                       dbo.HoaDonChiTiet hdct\n"
                + "                                    JOIN\n"
                + "                                          dbo.HoaDon hd ON hdct.MaHD = hd.MaHD\n"
                + "                                    JOIN\n"
                + "                                          dbo.SanPhamChiTiet spct ON hdct.MaSPChiTiet = spct.MaSPChiTiet\n"
                + "                                     JOIN\n"
                + "                                          dbo.Size size ON spct.MaSize = size.MaSize\n"
                + "                                     JOIN\n"
                + "                                         dbo.MauSac ms ON spct.MaMauSac = ms.MaMauSac\n"
                + "                                     JOIN\n"
                + "                                         dbo.ChatLieu cl ON spct.MaChatLieu = cl.MaChatLieu\n"
                + "                                  JOIN\n"
                + "                                      dbo.SanPham sp ON spct.MaSP = sp.MaSP\n"
                + "                           WHERE hd.MaHD LIKE ?";
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
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setMaHdct(rs.getString("MaHDChiTiet"));
                hdct.setGia(rs.getDouble("GiaBan"));
                hdct.setSoLuong(rs.getInt("SoLuongSP"));
                hdct.setTongTien(rs.getDouble("TongTien"));
                hdct.setMaSpct(rs.getString("MaSPChiTiet"));
                hdct.setHd(new HoaDon(rs.getString("MaHD")));
                hdct.setSpct(
                        new SanPhamChiTiet(
                                new SanPham(rs.getString("MaSP"), rs.getString("TenSP")),
                                new Size(rs.getString("tenSz")),
                                new MauSac(rs.getString("tenMs")),
                                new ChatLieu(rs.getString("tenCl"))
                        ));
                lst.add(hdct);
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

    public HoaDonChiTiet timKiemTheoMaHD1(String ma) {
        ArrayList<HoaDonChiTiet> lst = new ArrayList<>();
        String sql = " SELECT hdct.MaHDChiTiet,hd.MaHD,sp.MaSP , sp.TenSp, size.TenSz, ms.TenMs ,  cl.TenCl ,    hdct.GiaBan,\n"
                + "                                          hdct.SoLuongSP,\n"
                + "                                         hdct.TongTien,\n"
                + "                                         hdct.MaSPChiTiet\n"
                + "                                     FROM\n"
                + "                                       dbo.HoaDonChiTiet hdct\n"
                + "                                    JOIN\n"
                + "                                          dbo.HoaDon hd ON hdct.MaHD = hd.MaHD\n"
                + "                                    JOIN\n"
                + "                                          dbo.SanPhamChiTiet spct ON hdct.MaSPChiTiet = spct.MaSPChiTiet\n"
                + "                                     JOIN\n"
                + "                                          dbo.Size size ON spct.MaSize = size.MaSize\n"
                + "                                     JOIN\n"
                + "                                         dbo.MauSac ms ON spct.MaMauSac = ms.MaMauSac\n"
                + "                                     JOIN\n"
                + "                                         dbo.ChatLieu cl ON spct.MaChatLieu = cl.MaChatLieu\n"
                + "                                  JOIN\n"
                + "                                      dbo.SanPham sp ON spct.MaSP = sp.MaSP\n"
                + "                           WHERE hdct.MaHDChiTiet LIKE ? ";
        // Tạo kết nối
        Connection cn = DBcontext.getConnection();
        HoaDonChiTiet hdct = new HoaDonChiTiet();
        try {
            // Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            // Thiết lập giá trị cho tham số id
            pstm.setString(1, ma);
            // Thi hành Statement => dùng ResultSet nhận kết quả
            ResultSet rs = pstm.executeQuery();
            // Xử lý kết quả: duyệt rs => đổ dữ liệu vào lst
            while (rs.next()) {
                hdct.setMaHdct(rs.getString("MaHDChiTiet"));
                hdct.setGia(rs.getDouble("GiaBan"));
                hdct.setSoLuong(rs.getInt("SoLuongSP"));
                hdct.setTongTien(rs.getDouble("TongTien"));
                hdct.setMaSpct(rs.getString("MaSPChiTiet"));
                hdct.setHd(new HoaDon(rs.getString("MaHD")));
                hdct.setSpct(
                        new SanPhamChiTiet(
                                new SanPham(rs.getString("MaSP"), rs.getString("TenSP")),
                                new Size(rs.getString("tenSz")),
                                new MauSac(rs.getString("tenMs")),
                                new ChatLieu(rs.getString("tenCl"))
                        ));
            }
            // Đóng kết nối và statement
            rs.close();
            pstm.close();
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return hdct;
    }

    public static void main(String[] args) {
        HoaDonChiTietService hdctsv = new HoaDonChiTietService();
        HoaDonChiTiet hdct = hdctsv.timKiemTheoMaHD1("HDCT83427");
        System.out.println(hdct.getMaSpct());
    }

    public Integer deteleHDCt(String maHdCt) {
        Integer row = null;
        String sql = "Delete from HoaDonChiTiet\n"
                + "                     Where MaHDChiTiet like ?";
        //Tạo kết nối
        Connection cn = DBcontext.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho các dấu ?
            pstm.setString(1, maHdCt);

            //Thi hành Statement
            row = pstm.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return row;
    }

    public Integer updateHoaDonChiTiets(HoaDonChiTiet hdct) {
        Integer row = null;
        String sql = " UPDATE [dbo].[HoaDonChiTiet]\n"
                + "                        SET [SoLuongSP] = ?\n"
                + "                      WHERE MaHDChiTiet = ?";
        //Tạo kết nối
        Connection cn = DBcontext.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho các dấu ?
            pstm.setString(2, hdct.getMaHdct());
            pstm.setInt(1, hdct.getSoLuong());
            //Thi hành Statement
            row = pstm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return row;
    }

    public Integer updateTongGia(HoaDonChiTiet hdct, int soLuong) {
        Integer row = null;
        String sql = " UPDATE [dbo].[HoaDonChiTiet]\n"
                + "                        SET [TongTien] = ?\n"
                + "                      WHERE MaHDChiTiet = ?";
        //Tạo kết nối
        Connection cn = DBcontext.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho các dấu ?
            pstm.setString(2, hdct.getMaHdct());
            pstm.setDouble(1, (Double) (soLuong * hdct.getGia()));
            //Thi hành Statement
            row = pstm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return row;
    }

}
