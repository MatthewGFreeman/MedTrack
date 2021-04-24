package Medtrack;

import java.util.List;

public interface Dao<E> {
    void insert(E e);
    List<E> getall();
    List<E> getOne(String s);
    void update(E e);
    void delete(E e);
}
