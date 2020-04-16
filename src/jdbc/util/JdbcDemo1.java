package jdbc.util;

import jdbc.jdbc.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author hustffx
 * @Date 2020/4/15 23:00
 */
public class JdbcDemo1 {
    public static void main(String[] args) {
        List<Account> list = new JdbcDemo1().findAll();
        System.out.println(list);
    }

    /**
     * 查询所有 Account 对象
     */
    public List<Account> findAll() {
        List<Account> list = null;

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from account";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            Account account;
            list = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double balance = rs.getDouble("balance");

                account = new Account(id, name, balance);
                list.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(rs, stmt, conn);
        }
        return list;
    }
}
