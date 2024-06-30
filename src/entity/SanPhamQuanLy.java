/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Phan Cao
 */
public class SanPhamQuanLy {
    private String maSpCt;
    private String maSp;
    private String tenSp;
    private double gia;
    private int soLuong;
    private boolean trangThai;
    private String tenSz;
    private String tenCl;
    private String tenMs;
    private String tenDm;
    private String tenTh;
    private String maNv;

    public SanPhamQuanLy() {
    }

    public SanPhamQuanLy(String maSpCt, String maSp, String tenSp, double gia, int soLuong, boolean trangThai, String tenSz, String tenCl, String tenMs, String tenDm, String tenTh, String maNv) {
        this.maSpCt = maSpCt;
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.gia = gia;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
        this.tenSz = tenSz;
        this.tenCl = tenCl;
        this.tenMs = tenMs;
        this.tenDm = tenDm;
        this.tenTh = tenTh;
        this.maNv = maNv;
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

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getTenSz() {
        return tenSz;
    }

    public void setTenSz(String tenSz) {
        this.tenSz = tenSz;
    }

    public String getTenCl() {
        return tenCl;
    }

    public void setTenCl(String tenCl) {
        this.tenCl = tenCl;
    }

    public String getTenMs() {
        return tenMs;
    }

    public void setTenMs(String tenMs) {
        this.tenMs = tenMs;
    }

    public String getTenDm() {
        return tenDm;
    }

    public void setTenDm(String tenDm) {
        this.tenDm = tenDm;
    }

    public String getTenTh() {
        return tenTh;
    }

    public void setTenTh(String tenTh) {
        this.tenTh = tenTh;
    }

    public String getMaNv() {
        return maNv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

}
