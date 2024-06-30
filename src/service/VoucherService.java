/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.HoaDon;
import entity.NhanVien;
import entity.Voucher;
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
public class VoucherService {

    public ArrayList<Voucher> getAllVoucher() {
        ArrayList<Voucher> lst = new ArrayList<>();
        String sql = "select * from voucher";
        Connection cn = DBcontext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Voucher vc = new Voucher();
                vc.setMaVoucher(rs.getString("MaVoucher"));
                vc.setMaNV(rs.getString("MaNhanVien"));
                vc.setTenVc(rs.getString("tenvc"));
                vc.setNgayTao(rs.getDate("ngaytao"));
                vc.setNgayBatDau(rs.getDate("NgayBatDau"));
                vc.setNgayHetHan(rs.getDate("NgayHetHan"));
                vc.setSoLuong(rs.getInt("soluong"));
                vc.setKieuGiam(rs.getBoolean("KieuGiam"));
                vc.setGiaTri(rs.getDouble("giatri"));
                vc.setTrangThai(rs.getBoolean("trangThai"));
                lst.add(vc);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lst;
    }
    
    public Voucher timKiemVoucher(String maVc) {
        ArrayList<Voucher> lst = new ArrayList<>();
        String sql = "select * from voucher where mavoucher like ?";
        Connection cn = DBcontext.getConnection();
        Voucher vc = new Voucher();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
             pstm.setString(1, maVc);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                
                vc.setMaVoucher(rs.getString("MaVoucher"));
                vc.setMaNV(rs.getString("MaNhanVien"));
                vc.setTenVc(rs.getString("tenvc"));
                vc.setNgayTao(rs.getDate("ngaytao"));
                vc.setNgayBatDau(rs.getDate("NgayBatDau"));
                vc.setNgayHetHan(rs.getDate("NgayHetHan"));
                vc.setSoLuong(rs.getInt("soluong"));
                vc.setKieuGiam(rs.getBoolean("KieuGiam"));
                vc.setGiaTri(rs.getDouble("giatri"));
                vc.setTrangThai(rs.getBoolean("trangThai"));
                lst.add(vc);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return vc;
    }

    public Integer addVoucher(Voucher vc) {
        Integer row = null;
        String sql = "INSERT INTO [dbo].[Voucher]\n"
                + "                                       (MaVouCher\n"
                + "                                       ,TenVc\n"
                + "                                       ,[NgayTao]\n"
                + "                                       ,MaNhanVien\n"
                + "                                       ,[NgayBatDau]\n"
                + "                                       ,[NgayHetHan]\n"
                + "                                       ,[SoLuong]\n"
                + "                                       ,[KieuGiam]\n"
                + "                                       ,[GiaTri]\n"
                + "                                       ,[TrangThai])\n"
                + "                                 VALUES\n"
                + "                                       (?,?,?,?,?,?,?,?,?,?)";
        //Tạo kết nối
        Connection cn = DBcontext.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho các dấu ?
           pstm.setString(1, vc.getMaVoucher());
            pstm.setString(2, vc.getTenVc());
            pstm.setDate(3, vc.getNgayTao());
            pstm.setString(4, vc.getMaNV());
            pstm.setDate(5, vc.getNgayBatDau());
            pstm.setDate(6, vc.getNgayHetHan());
            pstm.setInt(7, vc.getSoLuong());
            pstm.setBoolean(8, vc.getKieuGiam());
            pstm.setDouble(9, vc.getGiaTri());
            pstm.setBoolean(10, vc.getTrangThai());
            //Thi hành Statement
            row = pstm.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return row;
    }

    public Integer updateVoucher(Voucher vc) {
        Integer row = null;
        String sql = " UPDATE [dbo].[Voucher]\n" +
"                               SET \n" +
"                                  TenVc = ?\n" +
"                                  ,[NgayTao] = ?\n" +
"                                  ,MaNhanVien = ?\n" +
"                                  ,NgayBatDau = ?\n" +
"                                  ,[NgayHetHan] = ?\n" +
"                                  ,[SoLuong] = ?\n" +
"                                  ,[KieuGiam] = ?\n" +
"                                  ,[GiaTri] = ?\n" +
"                                  ,[TrangThai] = ?\n" +
"                             WHERE MaVouCher =?";
        //Tạo kết nối
        Connection cn = DBcontext.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho các dấu ?
            pstm.setString(10, vc.getMaVoucher());
            pstm.setString(1, vc.getTenVc());
            pstm.setDate(2, vc.getNgayTao());
            pstm.setString(3, vc.getMaNV());
            pstm.setDate(4, vc.getNgayBatDau());
            pstm.setDate(5, vc.getNgayHetHan());
            pstm.setInt(6, vc.getSoLuong());
            pstm.setBoolean(7, vc.getKieuGiam());
            pstm.setDouble(8, vc.getGiaTri());
            pstm.setBoolean(9, vc.getTrangThai());
            //Thi hành Statement
            row = pstm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return row;
    }

    public static void main(String[] args) {
        VoucherService vc = new VoucherService();
        for (Voucher arg : vc.getAllVoucher()) {
            System.out.println(arg.getMaVoucher());
        }
    }
}
