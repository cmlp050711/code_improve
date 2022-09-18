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
            System.out.println("�γ�����"+resultSet.getObject("class_name"));
            System.out.println("�γ̴���"+resultSet.getObject("class_code"));
            System.out.println("��ʼʱ��"+resultSet.getObject("start_time"));
            System.out.println("����ʱ��"+resultSet.getObject("end_time"));
            System.out.println("�λ�����"+resultSet.getObject("link_meeting"));
            System.out.println("��������"+resultSet.getObject("password_meeting"));System.out.println("У��"+resultSet.getObject("area_school"));
            System.out.println("��ʦ�˺�"+resultSet.getObject("number_teacher"));
            System.out.println("��ʦ����"+resultSet.getObject("name_teacher"));System.out.println("���ε�λ"+resultSet.getObject("course_unites"));
            System.out.println("�������"+resultSet.getObject("code_meeting"));
            System.out.println("���鴴��ʱ��"+resultSet.getObject("start_meeting"));
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
