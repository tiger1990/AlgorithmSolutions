package array.algo_company;

public class DetectArrayIncreaseDecrease
{
    public static int[] elements = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,22,25,29,43,32,1,2};

    public static void main(String... args)
    {
        int index =checkRecursive(elements,0,elements.length-1);
        System.out.println("Index:" + index);
    }

    public static int checkRecursive(int[] elements,int start, int end)
    {
        int middle = (start+end) / 2;
        int arrayLength = elements.length - 1;

        if(middle == arrayLength)
            return middle;

        if((elements[middle+1] - elements[middle]) <0)
        {
            return middle;
        }
        else if((elements[middle+1] - elements[middle]) >0)
        {
            return checkRecursive(elements,middle+1,arrayLength);
        }
        else if((elements[middle] - elements[middle-1]) >0)
        {
            return checkRecursive(elements,middle-1,arrayLength);
        }
        return middle;
    }

}
