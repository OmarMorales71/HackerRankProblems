package omar.problems.dp;

public class MaxArraySum {

    public static void main(String[] args) {
        System.out.println(maxSubsetSum(new int []{-2,1,3,-4,5}));
    }
    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
        if(arr.length<3){
            return Math.max(arr[0], arr[1])>=0?Math.max(arr[0], arr[1]):0;
        }

        int[] dp = new int[arr.length];
        dp[0]=arr[0];
        dp[1]=Math.max(arr[0],arr[1]);

        for(int i=2; i< arr.length;i++){
            dp[i] = Math.max(Math.max(dp[i-2]+arr[i],dp[i-1]),arr[i]);
        }

        return Math.max(dp[dp.length-1],0);
    }


}
