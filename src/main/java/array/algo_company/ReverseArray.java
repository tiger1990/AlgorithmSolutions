package array.algo_company;

public class ReverseArray
{
    public static int[] elements = {1,2,3,4,5,6};

    public static void main(String... args)
    {
        int length = elements.length;
        int temp;

        for(int i=0;i<length/2;i++)
        {
            temp = elements[i];
            elements[i] = elements[length - i -1];
            elements[length - i -1] = temp;
        }

        for(int i=0; i<elements.length;i++)
        {
            System.out.println(" Elements:: =>  "+elements[i]);
        }
    }
}
