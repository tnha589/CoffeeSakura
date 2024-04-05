package com.untils;

import com.model.NhanVien;

/**
 *
 * @author HP
 */
public class XAuth {

    /*
     * Đối tượng này chứa thông tin người sử dụng sau khi đăng nhập
     */
    public static NhanVien user = null;

    /*
     * Xóa thông tin của người sử dụng khi có yêu cầu đăng xuất
     */
    public static void clear() {
        XAuth.user = null;
    }

    /*
     * Kiểm tra xem đã đăng nhập hay chưa
     */
    public static boolean isLogin() {
        return XAuth.user != null;
    }

    /*
     * Kiểm tra xem có phải là trưởng phòng hay không
     */
    public static boolean isManager() {
        return XAuth.isLogin() && user.getChuVu().equalsIgnoreCase("Quản Lý") == true;
    }

    public static boolean isNhanVien() {
        return XAuth.isLogin() && user.getChuVu().equalsIgnoreCase("Nhân Viên") == true;
    }
}
