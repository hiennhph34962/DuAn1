/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author Phan Cao
 */
public class KhachHang {
     private String maKh;
    private String tenKh;
    private Date ngaySinh;
    private Boolean gioiTinh;
    private String sdt;

    public KhachHang() {
    }

    public KhachHang(String maKh, String tenKh) {
        this.maKh = maKh;
        this.tenKh = tenKh;
    }

    public KhachHang(String sdt) {
        this.sdt = sdt;
    }

    public KhachHang(String maKh, String tenKh, Date ngaySinh, Boolean gioiTinh, String sdt) {
        this.maKh = maKh;
        this.tenKh = tenKh;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
    }

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    
 
   

    @Override
    public String toString() {
        return this.tenKh;
    }
}
