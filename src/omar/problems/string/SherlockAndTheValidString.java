package omar.problems.string;

import javax.xml.stream.events.Characters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SherlockAndTheValidString {

    // Complete the isValid function below.
    static String isValid(String s) {
        HashMap<Character, Integer> letters = new HashMap<>();
        HashMap<Integer, Integer> frequency = new HashMap<>();

        boolean isValid = false;

        for (int i = 0; i < s.length(); i++) {
            char l = s.charAt(i);
            letters.put(l, letters.getOrDefault(l, 0) + 1);
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;


        HashSet<Integer> values = new HashSet<>(letters.values());

        if (values.size()==1) {
            return "YES";
        }
        else if (values.size()>2){
            return "NO";
        }

        for(int value: values){
            max = Math.max(max, value);
            min = Math.min(min, value);

        }

        int minFre=0, maxFre=0;
        for (int value : letters.values()) {
            if (value == min)
                minFre++;
            if (value == max)
                maxFre++;
        }

        if (min == 1 && minFre == 1)
            return "YES";
        if ((max - min) == 1 && maxFre == 1)
            return "YES";

            return "NO";
    }

    public static void main(String[] args) {
        System.out.println(isValid("abbbb"));

        //System.out.println("aabcddeff".repeat(1));
    }

}
