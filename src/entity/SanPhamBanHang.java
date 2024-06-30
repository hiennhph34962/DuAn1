/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Phan Cao
 */
public class SanPhamBanHang {
    private String maSpCt;
    private String maSp;
    private String tenSp;
    private double gia;
    private int soLuong;
    private String tenSize;
    private String tenMauSac;
    private String tenChatLieu;

    public SanPhamBanHang() {
    }

    public SanPhamBanHang(String maSpCt, String maSp, String tenSp, double gia, int soLuong, String tenSize, String tenMauSac, String tenChatLieu) {
        this.maSpCt = maSpCt;
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.gia = gia;
        this.soLuong = soLuong;
        this.tenSize = tenSize;
        this.tenMauSac = tenMauSac;
        this.tenChatLieu = tenChatLieu;
    }

    public String getMaSpCt() {
        return maSpCt;
    }

    public void setMaSpCt(String maSpCt) {
        this.maSpCt = maSpCt;
    }

   

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTenSize() {
        return tenSize;
    }

    public void setTenSize(String tenSize) {
        this.tenSize = tenSize;
    }

    public String getTenMauSac() {
        return tenMauSac;
    }

    public void setTenMauSac(String tenMauSac) {
        this.tenMauSac = tenMauSac;
    }

    public String getTenChatLieu() {
        return tenChatLieu;
    }

    public void setTenChatLieu(String tenChatLieu) {
        this.tenChatLieu = tenChatLieu;
    }

}
