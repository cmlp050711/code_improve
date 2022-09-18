package Dao.impl;

import Dao.IBaseDao;
import Utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class BaseDao<T> implements IBaseDao<T> {

    private Class<T> clz;

    public BaseDao() {
        ParameterizedType parameterizedType= (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] actualTypeArguments=parameterizedType.getActualTypeArguments();
        clz= (Class<T>) actualTypeArguments[0];

        Class c1=getClass();
        System.out.println(c1);

        Class superclass=c1.getSuperclass();
        System.out.println(superclass);

        Type type=c1.getGenericSuperclass();
        System.out.println(type);

        ParameterizedType p=(ParameterizedType) type;
        System.out.println(p);
//        拿出泛型数组
        Type[] actualTypeArguments1 = p.getActualTypeArguments();
        System.out.println(p.getActualTypeArguments()[0]);
    }

    @Override
    public void save(Object obj) {
        EntityManager entityManager= JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void update(Object obj) {
        EntityManager entityManager=JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(obj);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(Serializable serializable) {
        EntityManager entityManager=JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        T obj = entityManager.find(clz, serializable);
        entityManager.remove(obj);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public T getOne(Serializable serializable) {
        EntityManager entityManager=JPAUtil.getEntityManager();
        T obj = entityManager.find(clz, serializable);
        entityManager.close();
        return obj;
    }

    @Override
    public List<T> getAll() {
        EntityManager entityManager=JPAUtil.getEntityManager();
        String hql="select p from "+clz.getName()+"as p";
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }
}
