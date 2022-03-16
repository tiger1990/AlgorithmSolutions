package array.algo_company.DataStructure.linklist;

public interface ILinkedCollection
{
    void addToFront(String data);

    void addToBack(String data);

    String getFirst() throws Exception;

    String getLast() throws Exception;

    int size();

    void clear();

    void delete(String data);
}
