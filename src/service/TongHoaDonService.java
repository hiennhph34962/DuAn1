/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.TongHoaDon;
import java.sql.Connection;
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
public class TongHoaDonService {
    public List<TongHoaDon> showDataTongDonHang() throws SQLException{
        List<TongHoaDon> list = new ArrayList<>();
        Connection cn = DBcontext.getConnection();
        String sql = "SELECT * FROM TongDonHang";
        Statement St = cn.createStatement();
        ResultSet rs = St.executeQuery(sql);
        while (rs.next()) {
            TongHoaDon tongHoaDon = new TongHoaDon();
               tongHoaDon.setTonghoadon(rs.getInt("TongHoaDon"));
                list.add(tongHoaDon);
        }
        rs.close();
        cn.close();
        return list;
    }
}
