package array.algo_company.DataStructure.dynamicarray;

import array.ICollectionCrud;

public class DynamicArray<T> implements ICollectionCrud<T>
{
    private T[] data;
    private int size;
    private int initialCapacity;

    public DynamicArray(int initialCapacity)
    {
        this.initialCapacity = initialCapacity;
        Object[] a = new Object[initialCapacity];
        this.data = (T[]) a;
    }

    @Override
    public T get(int index)
    {
        return (T)data[index];
    }

    @Override
    public void set(int index, T element)
    {
        this.data[index] = element;
    }

    @Override
    public void insert(int index, T element)
    {
        //check size
        if(size == initialCapacity)
        {
           resize();
        }

        //copy up
        for(int j=size; j>index; j--)
        {
           data[j] = data[j-1];
        }

        //insert
        data[index] = element;
        size++;
    }

    @Override
    public void delete(int index)
    {
       for(int i= index;i<size-1;i++)
       {
           data[i] = data[i+1];
       }
       size--;
    }

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public boolean contains(T element)
    {
        for(int i=0; i<size; i++)
        {
            if(data[i].equals(element))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    private void resize()
    {
        Object[] newData = new Object[initialCapacity * 2];
        for(int i=0; i<initialCapacity; i++)
        {
            newData[i] = data[i];
        }
        this.data = (T[]) newData;
        initialCapacity = initialCapacity * 2;
    }

    public void add(T element)
    {
        if(size == initialCapacity)
        {
            resize();
        }
        this.data[size] = element;
        size++;
    }

    public void print()
    {
        for(int i=0; i<size; i++)
        {
            System.out.println("data["+i+"] ::  "+ data[i]);
        }
    }
}
