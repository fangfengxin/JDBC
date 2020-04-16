package datasource.druid;

import datasource.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author hustffx
 * @Date 2020/4/17 1:13
 */
public class DruidDemo2 {
    /**
     * 完成添加操作，给account表增加一条记录
     */
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into account values(null, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "fangba");
            pstmt.setDouble(2, 8000);
            int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(pstmt, conn);
        }
    }
}
