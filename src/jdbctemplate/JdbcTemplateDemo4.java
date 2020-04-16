package jdbctemplate;

import datasource.util.JdbcUtils;
import jdbc.jdbc.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author hustffx
 * @Date 2020/4/17 2:07
 */
public class JdbcTemplateDemo4 {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());
        String sql = "select * from account";
        /*List<Account> list = template.query(sql, new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet resultSet, int i) throws SQLException {
                Account account = new Account();
                account.setId(resultSet.getInt("id"));
                account.setName(resultSet.getString("name"));
                account.setBalance(resultSet.getDouble("balance"));
                return account;
            }
        });*/
        // 不需要上述复杂操作
        List<Account> list = template.query(sql, new BeanPropertyRowMapper<>(Account.class));
        System.out.println(list);
    }
}
