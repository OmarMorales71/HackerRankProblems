package omar.problems.greedy;

import java.util.Arrays;

public class GreedyFlorist {

    public static void main(String[] args) {

    }

    // nlogn
    static int getMinimumCost(int k, int[] c) {
        int n = c.length - 1;
        Arrays.sort(c);// nlogn
        int minSum = 0;
        int wueltas = 0;
        while (n != -1) {
            for (int i = 0; i < k && n>=0; i++) {
                minSum += (wueltas + 1) * c[n];
                n--;
            }
            wueltas++;
        }

        return minSum;
    }
}
