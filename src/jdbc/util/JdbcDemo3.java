package jdbc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author hustffx
 * @Date 2020/4/16 23:11
 */
public class JdbcDemo3 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        try {
            // 获取连接
            conn = JdbcUtils.getConnection();
            // 开启事务
            conn.setAutoCommit(false);
            // 定义SQL语句
            String sql1 = "update account set balance = balance - ? where id = ?";
            String sql2 = "update account set balance = balance + ? where id = ?";
            // 获取执行SQL的对象
            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);
            // 设置SQL参数
            pstmt1.setDouble(1, 500);
            pstmt1.setInt(2, 5);
            pstmt2.setDouble(1, 500);
            pstmt2.setInt(2, 1);
            // 执行SQL
            pstmt1.executeUpdate();
            // 手动制造异常
            int i = 1 / 0;
            pstmt2.executeUpdate();
            // 所有SQL执行完毕，提交事务
            conn.commit();
        } catch (Exception e) {
            try {
                // 捕捉到异常，SQL未执行完毕，回滚事务
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JdbcUtils.close(pstmt2, null);
            JdbcUtils.close(pstmt1, conn);
        }
    }
}
