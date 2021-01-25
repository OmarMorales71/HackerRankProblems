package omar.problems.search;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TripleSum {
    public static void main(String[] args) {
        System.out.println(triplets(new int[]{1,3,5}, new int[]{2,3}, new int[]{1,2,3}));
    }
    static long triplets(int[] a, int[] b, int[] c) {
        a = removeDuplicates(a);
        b = removeDuplicates(b);
        c = removeDuplicates(c);
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        long t = 0;
        for (int i = 0; i < b.length; i++) {
            long left = counting(a, b[i]) + 1;
            long right = counting(c, b[i]) + 1;

            long ans = left * right;

            t += ans;

        }

        return t;
    }

    private static int counting(int[] c, int x) {
        int lo=0;
        int hi=c.length-1;

        int counter=-1;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(c[mid]<x){
                counter=mid;
                lo=mid+1;
            }else if(c[mid]>x){
                hi=mid-1;
            }else{
                return mid;
            }
        }
        return counter;
    }

    private static int[] removeDuplicates(int [] array){
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<array.length; i++){
            set.add(array[i]);
        }

        int[] ans =set.stream().mapToInt(i->i).toArray();

        return ans;
    }
}
