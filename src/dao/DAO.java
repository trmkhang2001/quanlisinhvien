
package dao;

import java.io.Serializable;
import java.util.List;


public interface DAO<T> {
    List<T> findAll();
    T findById(Serializable id);
    boolean insert(T t);
    boolean delete(Serializable id);
    boolean update(T t);
}
