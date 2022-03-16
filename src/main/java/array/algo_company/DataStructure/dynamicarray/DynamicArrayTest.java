package array.algo_company.DataStructure.dynamicarray;

public class DynamicArrayTest
{
    public static void main(String... args)
    {
        DynamicArray<String> dynamicArray = new DynamicArray<>(4);
        dynamicArray.add("Listen");
        dynamicArray.add("Silent");
        dynamicArray.add("Enlist");

        dynamicArray.add("Small");
        dynamicArray.add("Sas");
        dynamicArray.add("Ass");

        dynamicArray.insert(2,"Deepak");
        dynamicArray.set(1,"Vinay");
        dynamicArray.delete(0);
        dynamicArray.print();

    }
}
