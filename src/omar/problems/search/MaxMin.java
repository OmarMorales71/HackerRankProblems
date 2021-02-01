package omar.problems.search;

import java.util.Arrays;

public class MaxMin {
    public static void main(String[] args) {

    }

    // Complete the maxMin function below.
    static int maxMin(int k, int[] arr) {

        int minUnfairness= Integer.MAX_VALUE;//O(1)
        Arrays.sort(arr);//O(n log (n))
        int l =0, r= k-1;

        while(r<arr.length){//O(n)
            minUnfairness = Math.min(minUnfairness, arr[r] - arr[l]);//O(1)
            r++;//O(1)
            l++;//O(1)
        }
        //Time complexity: O(n log (n))
        //space complexity: O(1)
        return minUnfairness;
    }

}
