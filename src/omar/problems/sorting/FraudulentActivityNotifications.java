package omar.problems.sorting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FraudulentActivityNotifications {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int [] trailingDays = new int[201];
        double median;
        int indexMedian;
        int notifications=0;
        for (int i = 0; i<d; i++){
            trailingDays[expenditure[i]]++;
        }

        boolean isOdd = d%2==1;

        for(int i = d; i < expenditure.length; i++){
                indexMedian = d/2;

                median = getMedian(trailingDays, indexMedian, isOdd);
                if(2*median<=expenditure[i])
                    notifications++;

                trailingDays[expenditure[i]]++;
                trailingDays[expenditure[i-d]]--;
        }
        return notifications;
    }

    private static double getMedian(int[] trailingDays, int indexMedian, boolean isOdd) {
        int accumulated=0;

        double left=-1, right=-1;
        for(int i = 0 ; i< trailingDays.length; i++){
            accumulated += trailingDays[i];
            if(accumulated>indexMedian-1 && left==-1){
                left=i;
            }
            if(accumulated>indexMedian){
                right=i;
                break;
            }
        }
        if(isOdd)
            left=right;

        return (left+right)/2;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(activityNotifications(new int[]{1,2,3,4,4}, 4));
    }
   /* public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }*/

}
