package jdbctemplate;

import datasource.util.JdbcUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author hustffx
 * @Date 2020/4/17 2:18
 */
public class JdbcTemplateDemo5 {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());
        String sql = "select count(*) from account";
        Long count = template.queryForObject(sql, Long.class);
        System.out.println(count);
    }
}
