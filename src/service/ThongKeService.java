/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.ThongKe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utilty.DBcontext;

/**
 *
 * @author Phan Cao
 */
public class ThongKeService {
     public List<ThongKe> searchDataMa(String start, String end) throws SQLException {
        List<ThongKe> list = new ArrayList<>();
        Connection cn = DBcontext.getConnection();
        String sql = " SELECT SUM(TongTien) AS TongTien, COUNT(MaHD) AS SoLuongHoaDon\n" +
"               FROM HoaDon\n" +
"                 WHERE NgayTao >= ? AND NgayTao <= ?";
        PreparedStatement preSt = cn.prepareCall(sql);
        preSt.setString(1, start);
        preSt.setString(2, end);

        ResultSet rs = preSt.executeQuery();
        while (rs.next()) {
            ThongKe tk = new ThongKe();
            tk.setTongtien(rs.getInt("TongTien"));
            tk.setTonghoadon(rs.getInt("SoLuongHoaDon"));
            list.add(tk);
        }
        rs.close();
        preSt.close();
        cn.close();
        return list;
    }
}
