package omar.problems.dp;

public class MaxArraySum {

    public static void main(String[] args) {
        System.out.println(maxSubsetSum(new int []{-2,1,3,-4,5}));
    }
    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {

        return findingMaxSum(arr, arr.length-1);
    }

    private static int findingMaxSum(int[] arr, int i) {


        if(i<0)
            return 0;


        int actual = Math.max(findingMaxSum(arr,i-2),0);
        int max = Math.max(findingMaxSum(arr, i-1),0);

        return Math.max(actual+arr[i],max);
    }
}
