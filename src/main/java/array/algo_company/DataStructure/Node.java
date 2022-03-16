package array.algo_company.DataStructure;

public class Node
{
    private String data;
    public Node next;

    public Node(String data)
    {
        this.data = data;
    }

    public String data(){ return data; }

    public void setData(String data)
    {
      this.data = data;
    }

    public Node next()
    {
        return next;
    }

    public void setNext(Node next)
    {
       this.next = next;
    }

    @Override
    public String toString()
    {
        return data;
    }
}
