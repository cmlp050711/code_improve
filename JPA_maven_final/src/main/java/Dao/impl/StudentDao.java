package Dao.impl;

import Dao.IStudentDao;
import Entity.Student;
import Utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class StudentDao extends BaseDao<Student> implements IStudentDao {

    @Override
    public boolean Login(String name, String password) {
        EntityManager entityManager= JPAUtil.getEntityManager();
        String hql="select s from Student s where s.name=:username and s.Password=:password ";
        Query query=entityManager.createQuery(hql);
        query.setParameter("username",name);
        query.setParameter("password",password);
        List list=query.getResultList();
        return list.size()>=1;
    }
}
