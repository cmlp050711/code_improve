package Dao;
import javax.persistence.*;
import Entity.Student;
import Utils.JPAUtil;

import java.util.List;

public class StudentDao {
    public void sava(Student s){
        EntityManager entityManager=JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(s);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void update(Student s){
        EntityManager entityManager=JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(s);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void remove(Long id){
        EntityManager entityManager=JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void delete(Student s){
        EntityManager entityManager=JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(s);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public Student findOne(Long id){
        EntityManager entityManager=JPAUtil.getEntityManager();
        Student student = entityManager.find(Student.class, id);
        entityManager.close();
        return student;
    }
    public List<Student> getAll(){
        EntityManager entityManager=JPAUtil.getEntityManager();
        String hql="select p from Entity.Student p";
        Query query = entityManager.createQuery(hql);
        List<Student> resultList = query.getResultList();
        entityManager.close();
        return resultList;
    }
}
