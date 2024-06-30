/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.DanhMuc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utilty.DBcontext;

/**
 *
 * @author Phan Cao
 */
public class DanhMucService {
     public ArrayList<DanhMuc> getAllDanhMuc() {
        ArrayList<DanhMuc> lst = new ArrayList<>();
        String sql = "select * from DanhMuc";
        Connection cn = DBcontext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                DanhMuc sv = new DanhMuc();
                sv.setId(rs.getInt("MaDanhMuc"));
                sv.setTen(rs.getString("TenDm"));
                lst.add(sv);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lst;
    }
     
     public Integer addDanhMuc(DanhMuc size) {
        Integer row = null;
        String sql = "insert into DanhMuc(TenDm) values(?)";
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

    public Integer updateDanhMuc(DanhMuc size) {
        Integer row = null;
        String sql = "UPDATE [dbo].[DanhMuc]\n" +
"                          SET [TenDm] = ?\n" +
"                         WHERE MaDanhMuc = ?";
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
