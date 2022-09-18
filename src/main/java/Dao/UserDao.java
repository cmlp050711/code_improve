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
//        ��ȡ���ݿ����
            connection = JdbcUtils.getConnection();
            String sql="SELECT * FROM jdbcstudy";
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
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
