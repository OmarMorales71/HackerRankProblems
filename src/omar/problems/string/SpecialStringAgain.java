package omar.problems.string;

public class SpecialStringAgain {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
    long ans = 0;

    for(int i = 0 ; i<s.length(); i++){
        char base = s.charAt(i);
        for(int j=i+1; j<s.length();j++){
            char pointer = s.charAt(j);
            if(base!=pointer){
                if(((j*2)-i)<s.length() && s.substring(i,j).equals(s.substring(j+1, (j*2)-i+1))){
                    ans++;
                }
                break;
            }else{
                ans++;
            }
        }
    }
    return ans+n;
    }
    public static void main(String[] args) {
        String s = "acaa";
        System.out.println(substrCount(s.length(), s));
    }
}
