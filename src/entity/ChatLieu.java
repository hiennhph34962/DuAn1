/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Phan Cao
 */
public class ChatLieu {
     private int id;
    private String ten;

    public ChatLieu() {
    }

    public ChatLieu(String ten) {
        this.ten = ten;
    }

    public ChatLieu(int id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public String toString() {
        return ten;
    }

}
