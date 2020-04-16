package jdbctemplate;

import datasource.util.JdbcUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author hustffx
 * @Date 2020/4/17 1:33
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        // 创建JdbcTemplate对象
        JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());
        // 调用方法，只关心如何定义SQL、如何执行以及如何处理结果
        String sql = "update account set balance = 0 where id = ?";
        int count = template.update(sql, 3);
        System.out.println(count);
    }
}
