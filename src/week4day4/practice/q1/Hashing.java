package week4day4.practice.q1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Hashing and chaining using hashmap in java
 */
class Hashing {
    public static void main(String[] args) throws IOException {
        FileWriter output = new FileWriter("src/week4day4/practice/q1/output.txt");

        HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();

        // Adding integer keys and values to same respective keys as list of values in the form of arraylist
        mp.put(0, new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
        }});
        mp.put(1, new ArrayList<>() {{
            add(11);
            add(12);
            add(13);
            add(14);
        }});
        mp.put(2, new ArrayList<>() {{
            add(21);
            add(22);
        }});
        mp.put(3, new ArrayList<>() {{
            add(31);
            add(32);
            add(33);
            add(34);
            add(35);
        }});

        // Retrieving each of the key,value pairs
        // And writing the out in the file
        for (HashMap.Entry<Integer, ArrayList<Integer>> map : mp.entrySet()) {
            output.write(map.getKey() + " => " + map.getValue() + "\n");
        }

        output.close();
    }
}
