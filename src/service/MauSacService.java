/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.MauSac;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utilty.DBcontext;

/**
 *
 * @author Phan Cao
 */
public class MauSacService {
      public ArrayList<MauSac> getAllMauSac() {
        ArrayList<MauSac> lst = new ArrayList<>();
        String sql = "select * from MauSac";
        Connection cn = DBcontext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                MauSac sv = new MauSac();
                sv.setId(rs.getInt("MaMauSac"));
                sv.setTen(rs.getString("TenMs"));
                lst.add(sv);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lst;
    }
     
     public Integer addMauSac(MauSac size) {
        Integer row = null;
        String sql = "insert into MauSac(TenMs) values(?)";
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

    public Integer updateMauSac(MauSac size) {
        Integer row = null;
        String sql = "UPDATE [dbo].[MauSac]\n" +
"                          SET [TenMs] = ?\n" +
"                         WHERE MaMauSac = ?";
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
