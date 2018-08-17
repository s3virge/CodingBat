package CodingBat;

import java.util.ArrayList;



public class Main {
    public static void main(String[] args) {
       testAltPairs();
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

    public static void testAltPairs() {
        ArrayList<String> arr = new ArrayList<String>();

        arr.add("kitten");
        arr.add("Chocolate");
        arr.add("CodingHorror");
        arr.add("yak");
        arr.add("ya");
        arr.add("y");
        arr.add("");

        for (String str : arr) {
            System.out.print(str + " -> ");
            System.out.println(altPairs(str));
        }
    }
}
