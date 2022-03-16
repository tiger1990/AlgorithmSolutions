package array;

public interface ICollectionCrud<T>
{
     T get(int index);

     void set(int index, T data);

     void insert(int index, T data);

     void delete(int index);

     boolean isEmpty();

     boolean contains(T data);

     int size();
}
