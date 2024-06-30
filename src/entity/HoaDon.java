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
public class HoaDon {
    private String maHd;
    private Date ngayTao;
    private Double tongTien;
    private Integer trangThai;
    private String  maNv;
    private String maKh;
    private String maVc;
    private String lyDoHuy;
    private NhanVien nv;
    private KhachHang kh;
    private Voucher vc;

    public HoaDon() {
    }

    public HoaDon(String maHd) {
        this.maHd = maHd;
    }

    public HoaDon(String maHd, Date ngayTao, Double tongTien, Integer trangThai, String maNv, String maKh, String maVc, String lyDoHuy, NhanVien nv, KhachHang kh, Voucher vc) {
        this.maHd = maHd;
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.maNv = maNv;
        this.maKh = maKh;
        this.maVc = maVc;
        this.lyDoHuy = lyDoHuy;
        this.nv = nv;
        this.kh = kh;
        this.vc = vc;
    }

    public String getLyDoHuy() {
        return lyDoHuy;
    }

    public void setLyDoHuy(String lyDoHuy) {
        this.lyDoHuy = lyDoHuy;
    }

   

    public String getMaHd() {
        return maHd;
    }

    public void setMaHd(String maHd) {
        this.maHd = maHd;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaNv() {
        return maNv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public String getMaVc() {
        return maVc;
    }

    public void setMaVc(String maVc) {
        this.maVc = maVc;
    }

    public NhanVien getNv() {
        return nv;
    }

    public void setNv(NhanVien nv) {
        this.nv = nv;
    }

    public KhachHang getKh() {
        return kh;
    }

    public void setKh(KhachHang kh) {
        this.kh = kh;
    }

    public Voucher getVc() {
        return vc;
    }

    public void setVc(Voucher vc) {
        this.vc = vc;
    }

   
   

    
    public String loadTrangThaiHD() {
        if (trangThai == 1) {
            return "Đã thanh toán";
        } else if (trangThai == 2) {
            return "Chờ thanh toán";
        } else {
            return "Đã hủy";
        }
    }
    
    public String trangThaiString() {
        if (trangThai == 1) {
            return "Đã thanh toán";
        } else if (trangThai == 3) {
            return "Đã huỷ";
        } else if (trangThai == 2){
            return "Hóa đơn chờ";
        }else{
            return null;
        }
        
    }  
}
