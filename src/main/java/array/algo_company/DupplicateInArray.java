package array.algo_company;

public class DupplicateInArray
{
    public static int[] duplicateArray = {1,5,3,4,4,5,2,1,6};

    public static void main(String... args)
    {

        //findDuplicateElement();

        //More better way

        //elements should be in range 0 to n-1
        findDuplicateElementBest();
    }


    private static void findDuplicateElementBest()
    {
        int length = duplicateArray.length;

        for(int i=0; i<length; i++)
        {
            int index =duplicateArray[i] % length;
            duplicateArray[index] = duplicateArray[index] + length;
        }

        for(int i=0; i<length; i++)
        {
            if(duplicateArray[i]/length > 1)
            {
                System.out.println(i);
            }
        }
    }


    private static void findDuplicateElement()
    {
        int arrayLength = duplicateArray.length;

        for(int i=0; i<arrayLength; i++)
        {

            int absValue = Math.abs(duplicateArray[i]);
            if(absValue > arrayLength)continue;

            if (duplicateArray[absValue] >= 0)
                duplicateArray[absValue] = -duplicateArray[absValue];
            else
                System.out.print(Math.abs(duplicateArray[i]) + " ");
        }
    }
}
