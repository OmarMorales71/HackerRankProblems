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

public class CountTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        long triplets = 0;
        HashMap<Long, Long> before = new HashMap<Long, Long>();
        HashMap<Long, Long> after = new HashMap<Long, Long>();

        for(long value: arr){
            if(after.containsKey(value)){
                after.put(value, after.get(value)+1);
            }else{
                after.put(value, 1L);
            }
        }

        for(long value: arr){
            after.put(value, after.get(value)-1);
            if(value%r==0 && before.containsKey(value/r) && after.containsKey(value*r)){
                triplets += before.get(value/r) * after.get(value*r);
            }
            if(before.containsKey(value)) {
                before.put(value, before.get(value)+1);
            }else{
                before.put(value, 1L);
            }
        }

        return triplets;
    }

    public static void main(String[] args) {
        List<Long> arr = new ArrayList<>();
        arr.add(1l);
        arr.add(2l);
        arr.add(2l);
        arr.add(4l);

        System.out.println(countTriplets(arr, 2));
    }

//
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//        int n = Integer.parseInt(nr[0]);
//
//        long r = Long.parseLong(nr[1]);
//
//        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Long::parseLong)
//                .collect(toList());
//
//        long ans = countTriplets(arr, r);
//
//        bufferedWriter.write(String.valueOf(ans));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
}
