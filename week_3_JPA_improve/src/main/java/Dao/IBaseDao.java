package Dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<T> {
    void save(T obj);
    void update(T obj);
//    ���л�����->long��string�Ļ��࣬�����obj�ᷢ��ǿת�����������л�����
    void delete(Serializable serializable);
    T getOne(Serializable serializable);
    List<T> getAll();
}
