package week4day1.practice.q1;

import inputreader.InputReader;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Count non-repeated characters in a string
 */

class RepeatedCharacters {
    public static void main(String[] args) throws IOException {
        File input = new File("src/week4day1/practice/q1/input.txt");
        FileWriter output = new FileWriter("src/week4day1/practice/q1/output.txt", false);

        InputReader ir = new InputReader(new BufferedReader(new FileReader(input)));

        int T = ir.nextInt();
        for (int t = 0; t < T; t++) {
            output.write("Testcase " + (t + 1) + ": ");

            String str = ir.next();
            output.write(countNonRepeatingChars(str) + "\n");

        }

        output.close();
    }

    private static int countNonRepeatingChars(String str) {
        int strLen = str.length();
        if (strLen == 1) { return 1; }

        Map<Character, Integer> map = new HashMap<>();
        int countOfNonRepeatingChars = 0;

        // Using a hashmap that will have
        // Keys as unique characters
        // Values will be count of that corresponding characters
        for (int i = 0; i < strLen; i++) {
            char ch = str.charAt(i);

            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch)+ 1);
            } else {
                map.put(ch,1);
            }
        }

        // Iterating the map over all the values
        // Increment the count whenever value found = 1
        // value = 1 means that particular character occurs only once
        for (Integer x : map.values()) {
            if (x == 1) {
                countOfNonRepeatingChars++;
            }
        }

        return countOfNonRepeatingChars;
    }
}
