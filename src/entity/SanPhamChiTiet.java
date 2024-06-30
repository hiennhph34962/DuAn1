 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Phan Cao
 */
public class SanPhamChiTiet {
    private String maSpct;
    private double gia;
    private int soLuong;
    private String maSP;
    private boolean trangThai;
    
    private int id_sanPham;
    private int id_size;
    private int id_mauSac;
    private int id_chatLieu;
    
    private SanPham sanPham;
    private Size size;
    private MauSac mauSac;
    private ChatLieu chatLieu;

    public SanPhamChiTiet() {
    }

    public SanPhamChiTiet(SanPham sanPham, Size size, MauSac mauSac, ChatLieu chatLieu) {
        this.sanPham = sanPham;
        this.size = size;
        this.mauSac = mauSac;
        this.chatLieu = chatLieu;
    }

    public SanPhamChiTiet(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    
    
    public SanPhamChiTiet(String maSpct, double gia, int soLuong, String maSP, boolean trangThai, int id_sanPham, int id_size, int id_mauSac, int id_chatLieu, SanPham sanPham, Size size, MauSac mauSac, ChatLieu chatLieu) {
        this.maSpct = maSpct;
        this.gia = gia;
        this.soLuong = soLuong;
        this.maSP = maSP;
        this.trangThai = trangThai;
        this.id_sanPham = id_sanPham;
        this.id_size = id_size;
        this.id_mauSac = id_mauSac;
        this.id_chatLieu = id_chatLieu;
        this.sanPham = sanPham;
        this.size = size;
        this.mauSac = mauSac;
        this.chatLieu = chatLieu;
    }

    public String getMaSpct() {
        return maSpct;
    }

    public void setMaSpct(String maSpct) {
        this.maSpct = maSpct;
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

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public int getId_sanPham() {
        return id_sanPham;
    }

    public void setId_sanPham(int id_sanPham) {
        this.id_sanPham = id_sanPham;
    }

    public int getId_size() {
        return id_size;
    }

    public void setId_size(int id_size) {
        this.id_size = id_size;
    }

    public int getId_mauSac() {
        return id_mauSac;
    }

    public void setId_mauSac(int id_mauSac) {
        this.id_mauSac = id_mauSac;
    }

    public int getId_chatLieu() {
        return id_chatLieu;
    }

    public void setId_chatLieu(int id_chatLieu) {
        this.id_chatLieu = id_chatLieu;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public MauSac getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSac mauSac) {
        this.mauSac = mauSac;
    }

    public ChatLieu getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(ChatLieu chatLieu) {
        this.chatLieu = chatLieu;
    }


}
