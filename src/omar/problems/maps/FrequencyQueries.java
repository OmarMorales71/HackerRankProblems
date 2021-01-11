package omar.problems.maps;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FrequencyQueries {
    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        int[] quantities = new int[queries.size() + 1];
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        int frequency;
        List<Integer> ans = new ArrayList<>();

        for (List<Integer> query : queries) {
            int x = query.get(0);
            int y = query.get(1);
            switch (x) {
                case 1:
                    frequency = frequencies.getOrDefault(y,0);
                    frequencies.put(y, frequency+1);

                    quantities[frequency]--;
                    quantities[frequency+1]++;
                    break;
                case 2:
                   frequency = frequencies.getOrDefault(y, 0);
                   if(frequency < 2){
                       frequencies.remove(y);
                   }else {
                       frequencies.put(y, frequency - 1);
                   }

                   if(frequency>0){
                       quantities[frequency]--;
                       quantities[frequency-1]++;
                   }
                    break;
                case 3:
                    if (y >= quantities.length) ans.add(0);
                    else ans.add(quantities[y]>0?1:0);
                    break;
                default:
                    break;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
