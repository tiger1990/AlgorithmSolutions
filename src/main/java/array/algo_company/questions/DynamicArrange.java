package array.algo_company.questions;

/**
 * Read about langford algorithms
 */
public class DynamicArrange
{
    public static void main(String... args)
    {
        int n = 6;
        int[] number = new int[n*2];
        int length = n*2;
        int num = 1;
        for(int i=0; i<length; i+=2)
        {
            number[i] = num;
            number[i+1] = num;
            num++;
        }

        for(int j=0; j<length; j++)
        {
           System.out.println(number[j]);
        }
        shuffle(number,length);
    }

    private static void shuffle(int[] numbers, int length)
    {
       int[]shuffleArray = new int[length];
        shuffleArray[0] = numbers[0];

       for(int i=1;i<length;i++)
       {
           int number = numbers[i];
           //shuffleArray[i]
       }
    }
}
