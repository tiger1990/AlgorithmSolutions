package array.algo_company;

public class TrailingZeroString
{
    public static String trails = "0000123456789";

    public static void main(String... args)
    {
        int i =0;
        while(trails.charAt(i) == '0')
        {
            i++;
        }

        StringBuffer stringWithout0 =   new StringBuffer(trails).replace(0,i,"");
        System.out.println("Without Trail:: " +stringWithout0);
    }
}
