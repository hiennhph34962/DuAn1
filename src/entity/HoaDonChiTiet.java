/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Phan Cao
 */
public class HoaDonChiTiet {
      private String  maHdct;
    private Double gia;
    private Integer soLuong;
    private Double tongTien;
    private String maSpct;
    private String maHD;
    private String maVc;
    private SanPhamChiTiet spct;
    private HoaDon hd;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String maHD) {
        this.maHD = maHD;
    }

    public HoaDonChiTiet(HoaDon hd) {
        this.hd = hd;
    }

    public HoaDonChiTiet(String maHdct, Double gia, Integer soLuong, Double tongTien, String maSpct, String maHD, String maVc, SanPhamChiTiet spct, HoaDon hd) {
        this.maHdct = maHdct;
        this.gia = gia;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.maSpct = maSpct;
        this.maHD = maHD;
        this.maVc = maVc;
        this.spct = spct;
        this.hd = hd;
    }

    public String getMaHdct() {
        return maHdct;
    }

    public void setMaHdct(String maHdct) {
        this.maHdct = maHdct;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public String getMaSpct() {
        return maSpct;
    }

    public void setMaSpct(String maSpct) {
        this.maSpct = maSpct;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaVc() {
        return maVc;
    }

    public void setMaVc(String maVc) {
        this.maVc = maVc;
    }

    public SanPhamChiTiet getSpct() {
        return spct;
    }

    public void setSpct(SanPhamChiTiet spct) {
        this.spct = spct;
    }

    public HoaDon getHd() {
        return hd;
    }

    public void setHd(HoaDon hd) {
        this.hd = hd;
    }

  
}
