/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import entity.ChatLieu;
import entity.DanhMuc;
import entity.MauSac;
import entity.Size;
import entity.ThuongHieu;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.ChatLieuService;
import service.DanhMucService;
import service.MauSacService;
import service.SizeService;
import service.ThuongHieuServicee;

/**
 *
 * @author Phan Cao
 */
public class Form_ThuocTinh extends javax.swing.JPanel {

    /**
     * Creates new form Form_ThuocTinh
     */
    DefaultTableModel model = new DefaultTableModel();
    SizeService sizeSv = new SizeService();
    ThuongHieuServicee ttSv = new ThuongHieuServicee();
    MauSacService msSv = new MauSacService();
    ChatLieuService clSv = new ChatLieuService();
    DanhMucService dmSv = new DanhMucService();

    public Form_ThuocTinh() {
        initComponents();
        model = (DefaultTableModel) tblDanhMuc.getModel();
        danhSachTrang();
    }

    public void danhSachTrang() {
        if (rdoSize.isSelected()) {
            LoadDataSize();
        }
        if (rdoMauSac.isSelected()) {
            LoadDataMauSac();
        }
        if (rdoChatLieu.isSelected()) {
            LoadDataChatLieu();
        }
        if (rdoDanhMuc.isSelected()) {
            LoadDataDanhMuc();
        }
        if (rdoThuongHieu.isSelected()) {
            LoadDataThuongHieu();
        }
    }

    public void LoadDataSize() {
        model.setRowCount(0);
        ArrayList<Size> lst = sizeSv.getAllSize();

        for (Size d : lst) {
            model.addRow(new Object[]{
                d.getId(),
                d.getTen()
            });
        }
    }

    public void LoadDataMauSac() {
        model.setRowCount(0);
        ArrayList<MauSac> lst = msSv.getAllMauSac();

        for (MauSac d : lst) {
            model.addRow(new Object[]{
                d.getId(),
                d.getTen()
            });
        }
    }

    public void LoadDataThuongHieu() {
        model.setRowCount(0);
        ArrayList<ThuongHieu> lst = ttSv.getAllThuongHieu();

        for (ThuongHieu d : lst) {
            model.addRow(new Object[]{
                d.getId(),
                d.getTen()
            });
        }
    }

    public void LoadDataChatLieu() {
        model.setRowCount(0);
        ArrayList<ChatLieu> lst = clSv.getAllChatLieu();

        for (ChatLieu d : lst) {
            model.addRow(new Object[]{
                d.getId(),
                d.getTen()
            });
        }
    }

    public void LoadDataDanhMuc() {
        model.setRowCount(0);
        ArrayList<DanhMuc> lst = dmSv.getAllDanhMuc();

        for (DanhMuc d : lst) {
            model.addRow(new Object[]{
                d.getId(),
                d.getTen()
            });
        }
    }

    private Size getFormSizeAdd() {
        Size newSize = new Size();
        newSize.setTen(txtTen.getText());
        return newSize;
    }

    private Size getFormSizeUpdate() {
        Size newSize = new Size();
        int index = tblDanhMuc.getSelectedRow();
        newSize.setId(Integer.parseInt(tblDanhMuc.getValueAt(index, 0).toString()));
        newSize.setTen(txtTen.getText());
        return newSize;
    }

    //Thuong hieu
    private ThuongHieu getFormThuongHieuAdd() {
        ThuongHieu newTT = new ThuongHieu();
        newTT.setTen(txtTen.getText());
        return newTT;
    }

    private ThuongHieu getFormThuongHieuUpdate() {
        ThuongHieu newTT = new ThuongHieu();
        int index = tblDanhMuc.getSelectedRow();
        newTT.setId(Integer.parseInt(tblDanhMuc.getValueAt(index, 0).toString()));
        newTT.setTen(txtTen.getText());
        return newTT;
    }

    //Mau sac
    private MauSac getFormMauSacAdd() {
        MauSac newTT = new MauSac();
        newTT.setTen(txtTen.getText());
        return newTT;
    }

    private MauSac getFormMauSacUpdate() {
        MauSac newTT = new MauSac();
        int index = tblDanhMuc.getSelectedRow();
        newTT.setId(Integer.parseInt(tblDanhMuc.getValueAt(index, 0).toString()));
        newTT.setTen(txtTen.getText());
        return newTT;
    }

    //Chat lieu
    private ChatLieu getFormChatLieuAdd() {
        ChatLieu newMs = new ChatLieu();
        newMs.setTen(txtTen.getText());
        return newMs;
    }

    private ChatLieu getFormChatLieuUpdate() {
        ChatLieu newMs = new ChatLieu();
        int index = tblDanhMuc.getSelectedRow();
        newMs.setId(Integer.parseInt(tblDanhMuc.getValueAt(index, 0).toString()));
        newMs.setTen(txtTen.getText());
        return newMs;
    }

    //Danh muc
    private DanhMuc getFormDanhMucAdd() {
        DanhMuc newMs = new DanhMuc();
        newMs.setTen(txtTen.getText());
        return newMs;
    }

    private DanhMuc getFormDanhMucUpdate() {
        DanhMuc newMs = new DanhMuc();
        int index = tblDanhMuc.getSelectedRow();
        newMs.setId(Integer.parseInt(tblDanhMuc.getValueAt(index, 0).toString()));
        newMs.setTen(txtTen.getText());
        return newMs;
    }

    public Integer chonNoiQuanLy() {
        if (rdoSize.isSelected()) {
            return 1;
        } else if (rdoMauSac.isSelected()) {
            return 2;
        } else if (rdoChatLieu.isSelected()) {
            return 3;
        } else if (rdoDanhMuc.isSelected()) {
            return 4;
        } else if (rdoThuongHieu.isSelected()) {
            return 5;
        } else {
            return null;
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        rdoChatLieu = new javax.swing.JRadioButton();
        rdoDanhMuc = new javax.swing.JRadioButton();
        rdoThuongHieu = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhMuc = new javax.swing.JTable();
        rdoSize = new javax.swing.JRadioButton();
        rdoMauSac = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(255, 255, 255));

        buttonGroup1.add(rdoChatLieu);
        rdoChatLieu.setText("Chất liệu");
        rdoChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoChatLieuActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoDanhMuc);
        rdoDanhMuc.setText("Danh mục");
        rdoDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDanhMucActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoThuongHieu);
        rdoThuongHieu.setText("Thương hiệu");
        rdoThuongHieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoThuongHieuMouseClicked(evt);
            }
        });

        jLabel2.setText("Tên :");

        btnThem.setText("Thêm");
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaMouseClicked(evt);
            }
        });

        btnXoa.setText("Xóa");

        jLabel1.setText("Thuộc tính :");

        tblDanhMuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ));
        tblDanhMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhMucMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhMuc);

        jScrollPane2.setViewportView(jScrollPane1);

        buttonGroup1.add(rdoSize);
        rdoSize.setSelected(true);
        rdoSize.setText("Size");
        rdoSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoSizeActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoMauSac);
        rdoMauSac.setText("Màu sắc");
        rdoMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoMauSacActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(rdoSize, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdoMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdoThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addGap(40, 40, 40)
                                .addComponent(btnSua)
                                .addGap(41, 41, 41)
                                .addComponent(btnXoa))
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1017, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rdoSize)
                    .addComponent(rdoMauSac)
                    .addComponent(rdoChatLieu)
                    .addComponent(rdoDanhMuc)
                    .addComponent(rdoThuongHieu))
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rdoChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoChatLieuActionPerformed
        // TODO add your handling code here:
        LoadDataChatLieu();
    }//GEN-LAST:event_rdoChatLieuActionPerformed

    private void rdoDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDanhMucActionPerformed
        // TODO add your handling code here:
        LoadDataDanhMuc();
    }//GEN-LAST:event_rdoDanhMucActionPerformed

    private void rdoThuongHieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoThuongHieuMouseClicked
        // TODO add your handling code here:
        LoadDataThuongHieu();
    }//GEN-LAST:event_rdoThuongHieuMouseClicked

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        // TODO add your handling code here:
        if (chonNoiQuanLy() == 1) {
            try {

                Size size = getFormSizeAdd();
                if (sizeSv.addSize(size) != null) {
                    JOptionPane.showMessageDialog(this, "Them Thanh Cong");
                    LoadDataSize();
                    return;
                } else {
                    JOptionPane.showMessageDialog(this, "Ko thanh cong");
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showConfirmDialog(this, "Loi nut them");
            }
        } else if (chonNoiQuanLy() == 2) {
            try {
                MauSac size = getFormMauSacAdd();
                if (msSv.addMauSac(size) != null) {
                    JOptionPane.showMessageDialog(this, "Them Thanh Cong");
                    LoadDataMauSac();
                    return;
                } else {
                    JOptionPane.showMessageDialog(this, "Ko thanh cong");
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showConfirmDialog(this, "Loi nut them");
            }

        } else if (chonNoiQuanLy() == 3) {
            try {
                ChatLieu size = getFormChatLieuAdd();
                if (clSv.addChatLieu(size) != null) {
                    JOptionPane.showMessageDialog(this, "Them Thanh Cong");
                    LoadDataChatLieu();
                    return;
                } else {
                    JOptionPane.showMessageDialog(this, "Ko thanh cong");
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showConfirmDialog(this, "Loi nut them");
            }
        } else if (chonNoiQuanLy() == 4) {
            try {
                DanhMuc size = getFormDanhMucAdd();
                if (dmSv.addDanhMuc(size) != null) {
                    JOptionPane.showMessageDialog(this, "Them Thanh Cong");
                    LoadDataDanhMuc();
                    return;
                } else {
                    JOptionPane.showMessageDialog(this, "Ko thanh cong");
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showConfirmDialog(this, "Loi nut them");
            }
        } else {
            try {
                ThuongHieu tt = getFormThuongHieuAdd();
                if (ttSv.addThuongHieu(tt) != null) {
                    JOptionPane.showMessageDialog(this, "Them Thanh Cong");
                    LoadDataThuongHieu();
                    return;
                } else {
                    JOptionPane.showMessageDialog(this, "Ko thanh cong");
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showConfirmDialog(this, "Loi nut them");
            }
        }

    }//GEN-LAST:event_btnThemMouseClicked

    private void btnSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMouseClicked
        // TODO add your handling code here:
        if (chonNoiQuanLy() == 1) {
            try {
                Size s = getFormSizeUpdate();
                if (sizeSv.updateSize(s) != null) {
                    JOptionPane.showMessageDialog(this, "Sua Thanh Cong");
                    LoadDataSize();
                    return;
                } else {
                    JOptionPane.showMessageDialog(this, "Sua ko thanh cong");
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        } else if (chonNoiQuanLy() == 2) {
            try {
                MauSac s = getFormMauSacUpdate();
                if (msSv.updateMauSac(s) != null) {
                    JOptionPane.showMessageDialog(this, "Sua Thanh Cong");
                    LoadDataMauSac();
                    return;
                } else {
                    JOptionPane.showMessageDialog(this, "Sua ko thanh cong");
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        } else if (chonNoiQuanLy() == 3) {
            try {
                ChatLieu s = getFormChatLieuUpdate();
                if (clSv.updateChatLieu(s) != null) {
                    JOptionPane.showMessageDialog(this, "Sua Thanh Cong");
                    LoadDataChatLieu();
                    return;
                } else {
                    JOptionPane.showMessageDialog(this, "Sua ko thanh cong");
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        } else if (chonNoiQuanLy() == 4) {
            try {
                DanhMuc s = getFormDanhMucUpdate();
                if (dmSv.updateDanhMuc(s) != null) {
                    JOptionPane.showMessageDialog(this, "Sua Thanh Cong");
                    LoadDataDanhMuc();
                    return;
                } else {
                    JOptionPane.showMessageDialog(this, "Sua ko thanh cong");
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        } else {
            try {
                ThuongHieu th = getFormThuongHieuUpdate();
                if (ttSv.updateThuongHieu(th) != null) {
                    JOptionPane.showMessageDialog(this, "Sua Thanh Cong");
                    LoadDataThuongHieu();
                    return;
                } else {
                    JOptionPane.showMessageDialog(this, "Sua ko thanh cong");
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }

    }//GEN-LAST:event_btnSuaMouseClicked

    private void tblDanhMucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhMucMouseClicked
        // TODO add your handling code here:
        showDetails();
    }//GEN-LAST:event_tblDanhMucMouseClicked

    private void rdoSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoSizeActionPerformed
        // TODO add your handling code here:
        LoadDataSize();
    }//GEN-LAST:event_rdoSizeActionPerformed

    private void rdoMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoMauSacActionPerformed
        // TODO add your handling code here:
        LoadDataMauSac();
    }//GEN-LAST:event_rdoMauSacActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdoChatLieu;
    private javax.swing.JRadioButton rdoDanhMuc;
    private javax.swing.JRadioButton rdoMauSac;
    private javax.swing.JRadioButton rdoSize;
    private javax.swing.JRadioButton rdoThuongHieu;
    private javax.swing.JTable tblDanhMuc;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables

    private void showDetails() {
        int index = tblDanhMuc.getSelectedRow();
        txtTen.setText(tblDanhMuc.getValueAt(index, 1).toString());
    }

}
