package omar.problems.openmarketInterview;

import java.util.Scanner;

public class ArrayChallenge {
    public static String ArrayChallenge(int[] arr) {
        double sum = 0;
        int firstMax = Integer.MIN_VALUE;
        int secondMax= Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;


        for(int i = 0; i<arr.length;i++){
            sum+=arr[i];
            if(arr[i]>firstMax){
                secondMax = firstMax;
                firstMax=arr[i];
            }else if(arr[i]>secondMax){
                secondMax=arr[i];
            }else if(arr[i]<firstMin){
                secondMin=firstMin;
                firstMin = arr[i];
            }else if(arr[i]<secondMin){
                secondMin=arr[i];
            }
        }

        if((firstMax*secondMax)>(sum*2) || (firstMin*secondMin)>(sum*2)){
            return "true";
        }else{
            return "false";
        }
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(ArrayChallenge(new int[]{1,2,1}));
    }
}
