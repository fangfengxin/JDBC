package jdbctemplate;

import datasource.util.JdbcUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

/**
 * @Author hustffx
 * @Date 2020/4/17 1:55
 */
public class JdbcTemplateDemo2 {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());
        String sql = "select * from account where id = ?";
        // 将列名作为 key，将值作为 value，将这条记录封装为一个 Map 集合
        // 注意：这个方法查询的结果集长度只能是 1
        Map<String, Object> map = template.queryForMap(sql, 1);
        System.out.println(map);
    }
}
