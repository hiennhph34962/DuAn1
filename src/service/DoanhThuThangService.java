/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.DoanhThuThang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utilty.DBcontext;

/**
 *
 * @author Phan Cao
 */
public class DoanhThuThangService {
     public List<DoanhThuThang> showDataDoanhThuThang() throws SQLException {
        List<DoanhThuThang> list = new ArrayList<>();
         Connection cn = DBcontext.getConnection();
        String sql = "SELECT * FROM DoanhThuThang";
        Statement St = cn.createStatement();

        ResultSet rs = St.executeQuery(sql);
        while (rs.next()) {
            DoanhThuThang doanhThuThang = new DoanhThuThang();
            doanhThuThang.setDoanhthuthang(rs.getInt("DoanhThuThang"));
            list.add(doanhThuThang);
        }
        rs.close();
        cn.close();
        return list;
    }

    public List<DoanhThuThang> timTheoThang(int Thang) throws SQLException {
        List<DoanhThuThang> list = new ArrayList<>();
        Connection cn = DBcontext.getConnection();
        String sql = "SELECT SUM(TongTien * 1) AS DoanhThuThang, COUNT(ID) AS TongHoaDon FROM HoaDon WHERE MONTH(NgayTao) = ?;";
        PreparedStatement preSt = cn.prepareCall(sql);
        preSt.setInt(1, Thang);
        ResultSet rs = preSt.executeQuery();
        while (rs.next()) {
            DoanhThuThang doanhThuThang = new DoanhThuThang();
            doanhThuThang.setDoanhthuthang(rs.getInt("DoanhThuThang"));
            doanhThuThang.setHoadon(rs.getInt("TongHoaDon"));
            list.add(doanhThuThang);
        }
        rs.close();
        preSt.close();
        cn.close();
        return list;
    }
}
