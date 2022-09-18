package Utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static{
        try {
            InputStream resourceAsStream = JdbcUtils.class.getClassLoader().getResourceAsStream("mysql.properties");
            Properties properties = new Properties();
            properties.load(resourceAsStream);

            driver=properties.getProperty("driver");
            url=properties.getProperty("url");
            username=properties.getProperty("username");
            password=properties.getProperty("password");

//            驱动只需要加载一次
            Class.forName(driver);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    获取链接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

//    释放链接
    public static void release(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException {
        if(resultSet!=null){
            resultSet.close();
        }
        if(preparedStatement!=null){
            preparedStatement.close();
        }if(connection!=null){
            connection.close();
        }

    }
}
