package array.algo_company.DataStructure;

public class Rakuten2 {

    public static void main(String... args)
    {
        System.out.println(solution("John","Firelord",8));
    }

    public static String solution(String name, String surname, int age) {
        // write your code in Java SE 8
        StringBuilder strb = new StringBuilder();

        String part1 = name.length()>2? name.substring(0,2):name;

        String part2 = surname.length()>2?surname.substring(0,2):surname;

        strb.append(part1).append(part2).append(age);

        return strb.toString();
    }
}
