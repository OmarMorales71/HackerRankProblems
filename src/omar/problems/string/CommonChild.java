package omar.problems.string;

public class CommonChild {

    public static void main(String[] args) {
        System.out.println(commonChild("AA","BB"));
    }

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {

        char [] array1 = s1.toCharArray();
        char [] array2 = s2.toCharArray();

        int [][] lcs = new int[array1.length+1][array2.length+1];

        for(int i = 1; i <= array1.length; i++){
            for(int j = 1 ; j<= array2.length; j++){
                if(array1[i-1]==array2[j-1]){
                    lcs[i][j] = lcs[i-1][j-1]+1;
                }else{
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }

        return lcs[s1.length()][s2.length()];
    }

}
