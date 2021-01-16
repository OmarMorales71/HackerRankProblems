package omar.problems.openmarketInterview;

import java.util.Scanner;

public class StringChallenge {
    public static String StringChallenge(String str) {
        StringBuilder s = new StringBuilder();
        boolean mustBeUpperCase = false;
        for(int i = 0;i<str.length();i++){
            char le = str.charAt(i);
            if((le<65 || le>90) && (le<97 || le>122)){
                mustBeUpperCase=true;
                continue;
            }


            if(mustBeUpperCase){
                le = Character.toUpperCase(le);
                mustBeUpperCase=false;
            }else{
                le = Character.toLowerCase(le);
            }
            s.append(le);
        }
        str = String.valueOf(s);
        return str;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(StringChallenge(s.nextLine()));
    }
}
