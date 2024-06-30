/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Phan Cao
 */
public class Voucher {
    private String maVoucher;
    private String tenVc;
    private Date ngayTao;
     private String maNV;
     private Date ngayBatDau;
    private Date ngayHetHan;
    private Integer soLuong;
    private Boolean kieuGiam;
    private Double giaTri;
    private Boolean trangThai;
    private NhanVien nv;
    

    public Voucher() {
    }

    public Voucher(String maVoucher, String tenVc) {
        this.maVoucher = maVoucher;
        this.tenVc = tenVc;
    }

    public Voucher(String maVoucher, String tenVc, Date ngayTao, String maNV, Date ngayBatDau, Date ngayHetHan, Integer soLuong, Boolean kieuGiam, Double giaTri, Boolean trangThai, NhanVien nv) {
        this.maVoucher = maVoucher;
        this.tenVc = tenVc;
        this.ngayTao = ngayTao;
        this.maNV = maNV;
        this.ngayBatDau = ngayBatDau;
        this.ngayHetHan = ngayHetHan;
        this.soLuong = soLuong;
        this.kieuGiam = kieuGiam;
        this.giaTri = giaTri;
        this.trangThai = trangThai;
        this.nv = nv;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

   

   


    public String getMaVoucher() {
        return maVoucher;
    }

    public void setMaVoucher(String maVoucher) {
        this.maVoucher = maVoucher;
    }

    public String getTenVc() {
        return tenVc;
    }

    public void setTenVc(String tenVc) {
        this.tenVc = tenVc;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    
   

   
    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Boolean getKieuGiam() {
        return kieuGiam;
    }

    public void setKieuGiam(Boolean kieuGiam) {
        this.kieuGiam = kieuGiam;
    }

    public Double getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(Double giaTri) {
        this.giaTri = giaTri;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public NhanVien getNv() {
        return nv;
    }

    public void setNv(NhanVien nv) {
        this.nv = nv;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }
    
    
}
