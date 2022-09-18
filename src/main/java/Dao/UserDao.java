package Dao;


import Utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDao {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
//        获取数据库对象
            connection = JdbcUtils.getConnection();
            String sql="SELECT * FROM jdbcstudy";
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                JdbcUtils.release(connection,preparedStatement,resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
