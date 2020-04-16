package jdbc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @Author hustffx
 * @Date 2020/4/16 17:49
 */
public class JdbcDemo2 {
    public static void main(String[] args) {
        // 键盘录入用户名和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();

        // 调用登录方法
        boolean flag = new JdbcDemo2().login(username, password);
        if (flag) {
            System.out.println("登录成功");
        } else {
            System.out.println("用户名或密码不正确");
        }
    }

    /**
     * 登录方法
     *
     * @param username
     * @param password
     * @return
     */
    public boolean login(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        // 连接数据库判断是否登录成功
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            // 定义 sql
            String sql = "select * from user where username = ? and password = ?";
            // 获取执行 sql 的对象
            pstmt = conn.prepareStatement(sql);
            // 给 ? 赋值
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            // 执行 sql，不需要传递 sql
            rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(rs, pstmt, conn);
        }
        return false;
    }
}
