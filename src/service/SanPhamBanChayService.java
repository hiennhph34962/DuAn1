/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.SanPhamBanChay;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilty.DBcontext;

/**
 *
 * @author Phan Cao
 */
public class SanPhamBanChayService {
     public List<SanPhamBanChay> showDataSanPhamBanChay() {
        List<SanPhamBanChay> list = new ArrayList<>();
        try {
            
            Connection cn = DBcontext.getConnection();
            String sql = "SELECT * FROM SanPhamBanChay";
            Statement St = cn.createStatement();
            ResultSet rs = St.executeQuery(sql);
            while (rs.next()) {
                SanPhamBanChay sanPhamBanChay = new SanPhamBanChay();
                sanPhamBanChay.setMasp(rs.getString("MASANPHAM"));
                sanPhamBanChay.setTensp(rs.getString("TENSANPHAM"));
                sanPhamBanChay.setTongtien(rs.getInt("TongDoanhThu"));
                sanPhamBanChay.setSlban(rs.getInt("SLBAN"));
                list.add(sanPhamBanChay);
            }
            rs.close();
            cn.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamBanChayService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println(new SanPhamBanChayService().showDataSanPhamBanChay());
    }
}
