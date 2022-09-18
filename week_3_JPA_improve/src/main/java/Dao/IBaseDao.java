package Dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<T> {
    void save(T obj);
    void update(T obj);
//    序列化类型->long和string的基类，如果用obj会发生强转，但是用序列化不会
    void delete(Serializable serializable);
    T getOne(Serializable serializable);
    List<T> getAll();
}
