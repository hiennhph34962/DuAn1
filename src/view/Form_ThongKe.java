/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import entity.DoanhThuNam;
import entity.DoanhThuNgay;
import entity.DoanhThuThang;
import entity.SanPhamBanChay;
import entity.ThongKe;
import entity.TongHoaDon;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.DoanhThuNamService;
import service.DoanhThuNgayService;
import service.DoanhThuThangService;
import service.SanPhamBanChayService;
import service.ThongKeService;
import service.TongHoaDonService;

/**
 *
 * @author Phan Cao
 */
public class Form_ThongKe extends javax.swing.JPanel {
DoanhThuNgayService doanhThuNgayService = new DoanhThuNgayService();
    DoanhThuThangService doanhThuThangService = new DoanhThuThangService();
    DoanhThuNamService doanhThuNamService = new DoanhThuNamService();
    TongHoaDonService tongHoaDonService = new TongHoaDonService();
    SanPhamBanChayService sanPhamBanChayService = new SanPhamBanChayService();
    ThongKeService thongKeService = new ThongKeService();
    DoanhThuNgay doanhThuNgay = new DoanhThuNgay();
    DoanhThuThang doanhThuThang = new DoanhThuThang();
    DoanhThuNam doanhThuNam = new DoanhThuNam();
    TongHoaDon tongHoaDon = new TongHoaDon();
    SanPhamBanChay sanPhamBanChay = new SanPhamBanChay();
    DefaultTableModel dtm = new DefaultTableModel();
    /**
     * Creates new form Form_ThonKe
     */
    public Form_ThongKe() {
        initComponents();
        dtm = (DefaultTableModel) tblSanPham.getModel();
        List<DoanhThuThang> dataListThang = null;
        List<DoanhThuNgay> dataListNgay = null;
        List<DoanhThuNam> dataListNam = null;
        List<TongHoaDon> dataListDonHang = null;

        List<DoanhThuNam> timNam = null;
        List<TongHoaDon> timHD = null;
        try {
            dataListThang = doanhThuThangService.showDataDoanhThuThang();
            dataListNgay = doanhThuNgayService.showDataDoanhThuNgay();
            dataListNam = doanhThuNamService.showDataDoanhThuNam();
            dataListDonHang = tongHoaDonService.showDataTongDonHang();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            showData(sanPhamBanChayService.showDataSanPhamBanChay());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        tongDonHang(dataListDonHang);
        doanhThuNgay(dataListNgay);
        doanhThuThang(dataListThang);
        doanhThuNam(dataListNam);
    }

     public void doanhThuNgay(List<DoanhThuNgay> listData) {
        for (DoanhThuNgay doanhThuNgay1 : listData) {
            double tien = doanhThuNgay1.getDoanhthungay();
            NumberFormat numberFormat = NumberFormat.getInstance();
            String soDaDinhDang = numberFormat.format(tien);
            txtDoanhThuNgay.setText(soDaDinhDang + " VND");
        }
    }

    public void timDoanhThuNgay(List<DoanhThuNgay> listData) {
        for (DoanhThuNgay doanhThuNgay1 : listData) {
            double tien = doanhThuNgay1.getDoanhthungay();
            doanhThuNgay1.getHoadon();
            NumberFormat numberFormat = NumberFormat.getInstance();
            String soDaDinhDang = numberFormat.format(tien);
            JOptionPane.showMessageDialog(this, "Tổng Doanh Thu Ngày: " + soDaDinhDang + " VND" + "\n" + "Số hoá đơn: " + doanhThuNgay1.getHoadon() + " hoá đơn");
        }
    }

    public void doanhThuThang(List<DoanhThuThang> doanhThuThangs) {
        for (DoanhThuThang doanhThuThang1 : doanhThuThangs) {
            double tien = doanhThuThang1.getDoanhthuthang();
            NumberFormat numberFormat = NumberFormat.getInstance();
            String soDaDinhDang = numberFormat.format(tien);
            txtDoanhThuThang.setText(soDaDinhDang + " VND");
        }
    }

    public void timDoanhThuThang(List<ThongKe> thongKes) {
        for (ThongKe thongKe : thongKes) {
            double tien = thongKe.getTongtien();
            NumberFormat numberFormat = NumberFormat.getInstance();
            String soDaDinhDang = numberFormat.format(tien);
            JOptionPane.showMessageDialog(this, "Tổng Doanh Thu Là: " + soDaDinhDang + " VND" + " Và Có " + thongKe.getTonghoadon() + " Hóa Ðon");

        }
    }

    public void doanhThuNam(List<DoanhThuNam> doanhThuNams) {
        for (DoanhThuNam doanhThuNam1 : doanhThuNams) {
            double tien = doanhThuNam1.getDoanhthunam();
            NumberFormat numberFormat = NumberFormat.getInstance();
            String soDaDinhDang = numberFormat.format(tien);
            txtDoanhThuNam.setText(soDaDinhDang + " VND");
        }
    }

    public void tongDonHang(List<TongHoaDon> tongHoaDons) {
        for (TongHoaDon tongHoaDon1 : tongHoaDons) {
            txtTongDon.setText(tongHoaDon1.getTonghoadon() + " Đơn Hàng");
        }

    }

    public void showData(List<SanPhamBanChay> list) {
        dtm.setRowCount(0);
        int stt = 1;
        for (SanPhamBanChay sanPhamBanChay1 : list) {
            Object data[] = {
                stt++,
                sanPhamBanChay1.getMasp(),
                sanPhamBanChay1.getTensp(),
                sanPhamBanChay1.getSlban(),
                sanPhamBanChay1.getTongtien()
            };
            dtm.addRow(data);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTongDon = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtDoanhThuThang = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtDoanhThuNam = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtDoanhThuNgay = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtDateTu = new javax.swing.JTextField();
        txtDateDen = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SP", "Tên sản phẩm", "Số lượng bán", "Tổng  Tiền"
            }
        ));
        jScrollPane1.setViewportView(tblSanPham);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tổng hóa đơn");

        txtTongDon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTongDon.setForeground(new java.awt.Color(255, 255, 255));
        txtTongDon.setText("50 Đơn hàng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtTongDon))
                    .addComponent(jLabel1))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTongDon)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 204, 0));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tổng doanh thu tháng");

        txtDoanhThuThang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDoanhThuThang.setForeground(new java.awt.Color(255, 255, 255));
        txtDoanhThuThang.setText("0 VND");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtDoanhThuThang))
                    .addComponent(jLabel3))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDoanhThuThang)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(51, 206, 229));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tổng doanh thu năm");

        txtDoanhThuNam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDoanhThuNam.setForeground(new java.awt.Color(255, 255, 255));
        txtDoanhThuNam.setText("0 VND");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtDoanhThuNam))
                    .addComponent(jLabel5))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDoanhThuNam)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(74, 150, 226));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tổng doanh thu ngày");

        txtDoanhThuNgay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDoanhThuNgay.setForeground(new java.awt.Color(255, 255, 255));
        txtDoanhThuNgay.setText("0 VND");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(txtDoanhThuNgay)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDoanhThuNgay)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Đến ngày");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Từ ngày");

        jButton1.setText("Search");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(txtDateTu, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDateDen, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(jLabel6)
                    .addContainerGap(1019, Short.MAX_VALUE)))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel1, jPanel3, jPanel4, jPanel5});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtDateTu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDateDen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(195, 195, 195)
                    .addComponent(jLabel6)
                    .addContainerGap(386, Short.MAX_VALUE)))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel1, jPanel3, jPanel4, jPanel5});

    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    try {
        // Chuyển đổi chuỗi thành Date
        Date startDate = sdf.parse(txtDateTu.getText());
        Date endDate = sdf.parse(txtDateDen.getText());

        // Định dạng lại ngày nếu cần (ở đây tôi giữ nguyên định dạng gốc)
        String start = sdf.format(startDate);
        String end = sdf.format(endDate);

        List<ThongKe> ListThongKe;
        ListThongKe = null;
        try {
            System.out.println(start);
            System.out.println(end);
            ListThongKe = thongKeService.searchDataMa(start, end);

            timDoanhThuThang(ListThongKe);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    } catch (ParseException e) {
        // Xử lý lỗi nếu định dạng chuỗi không đúng
        JOptionPane.showMessageDialog(this, "Định dạng ngày không hợp lệ. Vui lòng nhập lại theo định dạng yyyy-MM-dd.");
        e.printStackTrace();
    }
    }//GEN-LAST:event_jButton1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtDateDen;
    private javax.swing.JTextField txtDateTu;
    private javax.swing.JLabel txtDoanhThuNam;
    private javax.swing.JLabel txtDoanhThuNgay;
    private javax.swing.JLabel txtDoanhThuThang;
    private javax.swing.JLabel txtTongDon;
    // End of variables declaration//GEN-END:variables
}
