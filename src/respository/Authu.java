/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package respository;

import entity.NhanVien;

/**
 *
 * @author Phan Cao
 */
public class Authu {
     public static NhanVien user = null;

    public static void clear() {
        Authu.user = null;
    }

    public static Boolean isLogin() {
        return Authu.user != null;
    }

    public static boolean isManager() {
        return Authu.isLogin() && user.isChucVu();
    }
}
