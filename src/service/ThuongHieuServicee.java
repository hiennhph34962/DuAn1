/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

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
public class ThuongHieuServicee {
      public ArrayList<ThuongHieu> getAllThuongHieu() {
        ArrayList<ThuongHieu> lst = new ArrayList<>();
        String sql = "select * from ThuongHieu";
        Connection cn = DBcontext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                ThuongHieu sv = new ThuongHieu();
                sv.setId(rs.getInt("MaThuongHieu"));
                sv.setTen(rs.getString("TenTh"));
                lst.add(sv);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lst;
    }
     
     public Integer addThuongHieu(ThuongHieu size) {
        Integer row = null;
        String sql = "insert into ThuongHieu(TenTh) values(?)";
        //Tạo kết nối
        Connection cn = DBcontext.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho các dấu ?
            pstm.setString(1, size.getTen());

            //Thi hành Statement
            row = pstm.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return row;
    }

    public Integer updateThuongHieu(ThuongHieu size) {
        Integer row = null;
        String sql = "UPDATE [dbo].[ThuongHieu]\n" +
"                          SET [TenTh] = ?\n" +
"                         WHERE MaThuongHieu = ?";
        //Tạo kết nối
        Connection cn = DBcontext.getConnection();
        try {
            //Tạo statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            //Gán giá trị cho các dấu ?
            pstm.setInt(2, size.getId());
            pstm.setString(1, size.getTen());
            //Thi hành Statement
            row = pstm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return row;
    }
}
