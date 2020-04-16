package datasource.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @Author hustffx
 * @Date 2020/4/17 0:51
 */
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        // 加载配置文件
        Properties prop = new Properties();
        InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        prop.load(is);
        // 获取数据库连接池
        DataSource ds = DruidDataSourceFactory.createDataSource(prop);
        // 获取数据库连接
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
