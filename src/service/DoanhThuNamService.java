/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.DoanhThuNam;
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
public class DoanhThuNamService {
    public List<DoanhThuNam> showDataDoanhThuNam() throws SQLException{
        List<DoanhThuNam> list = new ArrayList<>();
        Connection cn = DBcontext.getConnection();
        String sql = "SELECT * FROM DoanhThuNam";
        Statement St = cn.createStatement();
        ResultSet rs = St.executeQuery(sql);
        while (rs.next()) {
            DoanhThuNam doanhThuNam = new DoanhThuNam();
               doanhThuNam.setDoanhthunam(rs.getInt("DoanhThuNam"));
                list.add(doanhThuNam);
        }
        rs.close();
        cn.close();
        return list;
    }
}
