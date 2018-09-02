package CodingBat;

import java.util.ArrayList;



public class Main {
    public static void main(String[] args) {
//       testAltPairs();

        testwithoutX2();
    }

    /*
Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9 ... so "kittens" yields "kien".

altPairs("kitten") → "kien"
altPairs("Chocolate") → "Chole"
altPairs("CodingHorror") → "Congrr"
altPairs("yak") → "ya"
altPairs("ya") → "ya"
altPairs("y") → "y"
altPairs("") → ""
altPairs("ThisThatTheOther") → "ThThThth"	"ThThThth"	OK
*/
    public static String altPairs(String str) {
        String sRes = new String();

        int sLength = str.length();

        if (sLength == 0) {
            return str;
        }

        int n = 0;

        for (int c = 0; c < sLength; c++) {

            if (n > 1) {
                n = 0;
                c += 2;
            }

            if (c > sLength - 1) {
                break;
            }

            sRes += str.charAt(c);

            n++;
        }

        return sRes;
    }

    public static String altPairs2(String str) {
        String sRes = new String();

        for (int c = 0; c < str.length(); c += 4) {
            int end = c + 2;

            if (end > str.length()) {
                end = str.length();
            }

            sRes += str.substring(c, end);
        }

        return sRes;
    }

    public static String altPairsAnswer(String str) {
        String result = "";

        // Run i by 4 to hit 0, 4, 8, ...
        for (int i=0; i<str.length(); i += 4) {
            // Append the chars between i and i+2
            int end = i + 2;

            if (end > str.length()) {
                end = str.length();
            }

            result = result + str.substring(i, end);
        }

        return result;
    }

    public static String withoutX2(String str) {

        int counter = 0;
        //если в строке два символа и больше, то проверяем вторую букву на 'x'
        if (str.length() > 1 && str.charAt(1) == 'x') {
            //вторая буква 'x' избавляемся от нее
            str = str.charAt(0) + str.substring(2);
            counter++;
        }

        //если строка не пустая и первая буква х
        if (str.length() > 0 && str.charAt(0) == 'x') {
            str = str.substring(1); //то избавляемя от х
            counter++;
        }

        //str стала на один символ короче. //если строка не пустая и первая буква х
        //и еще не удалялись две буквы х
        if (str.length() > 0 && counter !=2 && str.charAt(0) == 'x') {
            str = str.substring(1);
        }


        return str;
    }

    public static void testAltPairs() {
        ArrayList<String> arr = new ArrayList<String>();

        arr.add("kitten");
        arr.add("Chocolate");
        arr.add("CodingHorror");
        arr.add("yak");
        arr.add("ya");
        arr.add("y");
        arr.add("");
        arr.add("");

        for (String str : arr) {
            System.out.print(str + " -> ");
            System.out.println(altPairs(str));
        }
    }

    public static void testwithoutX2() {
        ArrayList<String> arr = new ArrayList<String>();

        arr.add("xHi");
        arr.add("Hxi");
        arr.add("Hi");
        arr.add("");
        arr.add("q");
        arr.add("x");
        arr.add("qq");
        arr.add("xq");
        arr.add("qx");
        arr.add("xx");
        arr.add("xxx");
        arr.add("xaxb");
        arr.add("xHxllo");

        for (String str : arr) {
            System.out.print(str + " -> ");
            System.out.println(withoutX2(str));
        }
    }

}
