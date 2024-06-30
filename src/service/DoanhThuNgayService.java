/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.DoanhThuNgay;
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
public class DoanhThuNgayService {

    public List<DoanhThuNgay> showDataDoanhThuNgay() throws SQLException {
        List<DoanhThuNgay> list = new ArrayList<>();
        Connection cn = DBcontext.getConnection();
        String sql = "SELECT * FROM DoanhThuNgay";
        Statement St = cn.createStatement();

        ResultSet rs = St.executeQuery(sql);
        while (rs.next()) {
            DoanhThuNgay doanhThuNgay = new DoanhThuNgay();
            doanhThuNgay.setDoanhthungay(rs.getInt("DoanhThuNgay"));
            list.add(doanhThuNgay);
        }
        rs.close();
        cn.close();
        return list;
    }
    
    public List<DoanhThuNgay> timTheoNgay(int ngay) throws SQLException{
        List<DoanhThuNgay> list = new ArrayList<>();
        Connection cn = DBcontext.getConnection();
        String sql = "SELECT SUM(TongTien * 1) AS DoanhThuNgay, COUNT(ID) AS TongHoaDon FROM HoaDon WHERE DAY(NgayTao) = ?;";
        PreparedStatement preSt = cn.prepareCall(sql);
        preSt.setInt(1,ngay);
        ResultSet rs = preSt.executeQuery();
        while (rs.next()) {
            DoanhThuNgay doanhThuNgay = new DoanhThuNgay();
            doanhThuNgay.setDoanhthungay(rs.getInt("DoanhThuNgay"));
            doanhThuNgay.setHoadon(rs.getInt("TongHoaDon"));
                list.add(doanhThuNgay);
        }
        rs.close();
        preSt.close();
        cn.close();
        return list;
    }
}
