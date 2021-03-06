package omar.problems.string;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AlternatingCharacters {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        if (s == null || s.length() == 0) return 0;

        boolean isA = false;
        int deletions = 0;

        if (s.charAt(0) == 'A'){
            isA = true;
        }

        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == 'A'){
                if(isA){
                    deletions++;
                }else {
                    isA=true;
                }
            }else{
                if(isA){
                    isA=false;
                }else{
                    deletions++;
                }
            }
        }
        return deletions;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }

}
