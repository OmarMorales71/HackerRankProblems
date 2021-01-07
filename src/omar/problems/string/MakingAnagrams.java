package omar.problems.string;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MakingAnagrams {


    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int match = 0;
        for(int i = 0; i<a.length(); i++){
            if(b.contains(String.valueOf(a.charAt(i)))){
                b = b.replaceFirst(String.valueOf(a.charAt(i)), "-");
                match++;
            }
        }

    return (a.length() - match) + (b.length() - match);
    }

    public static void main(String[] args) {
        System.out.println(makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));
    }
    private static final Scanner scanner = new Scanner(System.in);

    /*public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }*/

}
