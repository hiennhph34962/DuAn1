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
public class SanPham {
    private String maSp;
    private String ten;
    private Date ngayThem;
    private String maNV;
    private Integer id_th;
    private Integer id_dm;
    private ThuongHieu thuongHieu;
    private DanhMuc danhMuc;
    private NhanVien nhanVien;

    public SanPham() {
    }

    public SanPham(String ma, String ten) {
        this.maSp = ma;
        this.ten = ten;
    }

    public SanPham( String ten) {
        this.ten = ten;
    }
    
     public SanPham(ThuongHieu thuongHieu, DanhMuc danhMuc, NhanVien nhanVien) {
        this.thuongHieu = thuongHieu;
        this.danhMuc = danhMuc;
        this.nhanVien = nhanVien;
    }

    public SanPham(String ten, ThuongHieu thuongHieu, DanhMuc danhMuc, NhanVien nhanVien) {
        this.ten = ten;
        this.thuongHieu = thuongHieu;
        this.danhMuc = danhMuc;
        this.nhanVien = nhanVien;
    }

    public SanPham(String maSp, String ten, Date ngayThem, String maNV, Integer id_th, Integer id_dm, ThuongHieu thuongHieu, DanhMuc danhMuc, NhanVien nhanVien) {
        this.maSp = maSp;
        this.ten = ten;
        this.ngayThem = ngayThem;
        this.maNV = maNV;
        this.id_th = id_th;
        this.id_dm = id_dm;
        this.thuongHieu = thuongHieu;
        this.danhMuc = danhMuc;
        this.nhanVien = nhanVien;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgayThem() {
        return ngayThem;
    }

    public void setNgayThem(Date ngayThem) {
        this.ngayThem = ngayThem;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public Integer getId_th() {
        return id_th;
    }

    public void setId_th(Integer id_th) {
        this.id_th = id_th;
    }

    public Integer getId_dm() {
        return id_dm;
    }

    public void setId_dm(Integer id_dm) {
        this.id_dm = id_dm;
    }

    public ThuongHieu getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(ThuongHieu thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

   

   
   
}
