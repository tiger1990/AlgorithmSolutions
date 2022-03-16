package array.algo_company.array;

public class Phonepe {

//    Cw X ch      Iw X Ih              nw X nh
//           200 X 200 :: 400 X 400 -> 1:1   >> 200 X 200
//            200 X 200 :: 200 X 400 -> 1:2   >> 100 X 200
//
//            200 X 200 :: 400 X 200 -> 2:1   >> 200 X 100
//
//    nw = 200 *
//
//
//            400 X 600 :: 600 X 400
//            400 X 600 :: 300 X 700
//            400 X 600 :: 400 X 400
//
//            600 X 400 :: 700 X 350
//            600 X 400 :: 300 X 700
//            600 X 400 :: 800 X 800

    public static void main(String... args){

//       int newParams[] =  getAspectHeightWidth(600, 400, 300, 700);
//       System.out.print("Width:"+newParams[0]+" Height:"+ newParams[1]);


       String abc = "0123456";
       System.out.println("length "+abc.length());
       String amn = abc.substring(0,6);
       if(abc.length() > 6 && abc.substring(0,6) == "012345")
        System.out.println("substring "+amn);
    }

    public static int[] getAspectHeightWidth(int containerWidth, int containerHeight, int givenWidth, int givenHeight)
    {
        int newWidthHeight[] = new int[2];

        double aspectRatio = (float)givenWidth / givenHeight;

        float newWidth =  (float) (givenWidth / aspectRatio);
        float newHeight =(float) (givenHeight / aspectRatio);

        if(givenHeight > givenWidth){
            newWidth = (float) (givenWidth * aspectRatio);
            newHeight =  (float) (givenHeight * aspectRatio);
        }

        if(aspectRatio == 1.0f)
        {
            newWidthHeight[0] = containerWidth;
            newWidthHeight[1] = containerHeight;
            return newWidthHeight;
        }

        if(newHeight > containerHeight || newWidth > containerWidth)
        {
            newWidthHeight[0] = containerWidth;
            newWidthHeight[1] = containerHeight;
        }
        else
        {
            newWidthHeight[0] = (int)newWidth;
            newWidthHeight[1] = (int)newHeight;
        }
        return newWidthHeight;
    }
}
