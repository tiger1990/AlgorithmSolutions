package array.algo_company.DataStructure;

public class Rakuten {

    public static void main(String... args)
    {
        int x = 5, y = 6;
        System.out.println("XOR is "+ findProductBits(x,x,y));
    }

    static int findProductBits(int product,int M, int N)
    {
        if(M == N)
        {
            return myXOR(M,N);
        }
        else
        {
            int next = M + 1;
            int productXor =  myXOR(product, next);

            if(next < N)
            {
               return findProductBits(productXor,next,N);
            }
            else
            {
               return productXor;
            }
        }
    }

    // Returns XOR of x and y
    static int myXOR(int x, int y)
    {
        return (x | y) & (~x | ~y);
    }
}
