package omar.problems.maps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SherlockAndAnagrams {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        int ans=0;
        for(int i = 1; i < s.length();i++){
            for (int j=0; j+i<=s.length();j++){
                char[] substring = s.substring(j,j+i).toCharArray();
                Arrays.sort(substring);
                String sorted = new String(substring);
                map.put(sorted, map.getOrDefault(sorted, 0)+1);
            }
        }

        for (Integer value: map.values()){
            ans += (value*(value-1))/2;
        }
    return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
