package zhu.common;

import java.util.List;

public interface BaseDao<T> {
	 List<T> findAll();
    boolean save(T t);
    T findDataById(int id);
    boolean delete(int id);
    boolean update(T t); 
   
}
