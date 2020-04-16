package jdbctemplate;

import datasource.util.JdbcUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @Author hustffx
 * @Date 2020/4/17 2:04
 */
public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());
        String sql = "select * from account";
        // 将每一条记录封装为一个 Map 集合，再将 Map 集合装载到 List 集合中
        List<Map<String, Object>> list = template.queryForList(sql);
        System.out.println(list);
    }
}
