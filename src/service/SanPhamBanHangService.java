/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.ChatLieu;
import entity.MauSac;
import entity.SanPhamBanHang;
import entity.Size;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utilty.DBcontext;

/**
 *
 * @author Phan Cao
 */
public class SanPhamBanHangService {

    public ArrayList<SanPhamBanHang> getAllSanPham() {
        ArrayList<SanPhamBanHang> lst = new ArrayList<>();
        String sql = "select * from sanpham \n" +
"                join sanphamchitiet on sanpham.MaSP = sanphamchitiet.MaSP\n" +
"                join Size on sanphamchitiet.MaSize = size.MaSize\n" +
"                join chatlieu on sanphamchitiet.MaChatLieu = chatlieu.MaChatLieu\n" +
"                join mausac on sanphamchitiet.MaMauSac = mausac.MaMauSac";
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
                clbh.setTen(rs .getString("tenCl"));
                
                Size sizebh = new Size();
                sizebh.setTen(rs.getString("tenSz"));
                
                MauSac msbh = new MauSac();
                msbh.setTen(rs.getString("tenMs"));
                
                SanPhamBanHang spbh = new SanPhamBanHang();
                spbh.setMaSpCt(rs.getString("maSPChiTiet"));
                spbh.setMaSp(rs.getString("maSp"));
                spbh.setTenSp(rs.getString("tenSp"));
                spbh.setGia(rs.getDouble("gia"));
                spbh.setSoLuong(rs.getInt("soluong"));
                spbh.setTenChatLieu(clbh.getTen());
                spbh.setTenSize(sizebh.getTen());
                spbh.setTenMauSac(msbh.getTen());
                
                lst.add(spbh);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lst;
    }
}
