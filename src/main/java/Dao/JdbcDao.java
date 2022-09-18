package Dao;

import java.sql.*;

public class JdbcDao {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/mybatis?useUnicode=true&characterEncoding=utf8&useSSL=false";
        String userName = "root";
        String passWord = "xzy050711";

        Connection connection= DriverManager.getConnection(url,userName,passWord);
        Statement statement = connection.createStatement();
        String sql="SELECT * FROM jdbcstudy";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            System.out.println("课程名称"+resultSet.getObject("class_name"));
            System.out.println("课程代码"+resultSet.getObject("class_code"));
            System.out.println("开始时间"+resultSet.getObject("start_time"));
            System.out.println("结束时间"+resultSet.getObject("end_time"));
            System.out.println("参会链接"+resultSet.getObject("link_meeting"));
            System.out.println("会议密码"+resultSet.getObject("password_meeting"));System.out.println("校区"+resultSet.getObject("area_school"));
            System.out.println("教师账号"+resultSet.getObject("number_teacher"));
            System.out.println("教师姓名"+resultSet.getObject("name_teacher"));System.out.println("开课单位"+resultSet.getObject("course_unites"));
            System.out.println("会议代码"+resultSet.getObject("code_meeting"));
            System.out.println("会议创建时间"+resultSet.getObject("start_meeting"));
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
