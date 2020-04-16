package jdbc.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 定义一个方法，查询 account 表的数据将其封装为对象，然后装载集合，返回。
 */
public class JdbcDemo4 {
    public static void main(String[] args) {
        List<Account> list = new JdbcDemo4().findAll();
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
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///dbdemo", "root", "root");
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
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}
