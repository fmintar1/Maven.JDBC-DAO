package daos;

import java.util.List;

public interface DAO<T> {
    public T findById(int id);
    public List<T> findAll();
    public boolean update(T dto);
    public boolean create(T dto);
    public boolean delete(int id);

}
