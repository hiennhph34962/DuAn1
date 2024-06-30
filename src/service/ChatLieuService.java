/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.ChatLieu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utilty.DBcontext;

/**
 *
 * @author Phan Cao
 */
public class ChatLieuService {
     public ArrayList<ChatLieu> getAllChatLieu() {
        ArrayList<ChatLieu> lst = new ArrayList<>();
        String sql = "select * from ChatLieu";
        Connection cn = DBcontext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                ChatLieu sv = new ChatLieu();
                sv.setId(rs.getInt("MaChatLieu"));
                sv.setTen(rs.getString("TenCl"));
                lst.add(sv);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lst;
    }
     
     public Integer addChatLieu(ChatLieu size) {
        Integer row = null;
        String sql = "insert into ChatLieu(TenCl) values(?)";
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

    public Integer updateChatLieu(ChatLieu size) {
        Integer row = null;
        String sql = "UPDATE [dbo].[ChatLieu]\n" +
"                          SET [TenCl] = ?\n" +
"                         WHERE MaChatLieu = ?";
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
