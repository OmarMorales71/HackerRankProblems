package omar.problems.soleraInterview;

import javax.swing.*;

public class B {

    public static void main(String[] args) {
        B obj = new B();
        System.out.println(obj.solution(new int []{1,2,4,8}));
    }
    static int max=1;
    public int solution(int[] A){

        Integer [] subset = new Integer[A.length];
        findingPermutations(A, subset,0);
        return max;
    }

    private void findingPermutations(int[] a, Integer[] subset, int i) {
        if(i==a.length){
            int AND=Integer.MAX_VALUE;
            boolean isNotEmpty=false;
            int size=0;
            for(Integer val:subset){
                if(val!=null){
                    isNotEmpty=true;
                    size++;
                    AND = val&AND;
                }
            }
            if(AND>0 &&isNotEmpty){
                max = Math.max(max, size);
            }
        }else{
            subset[i]=null;
            findingPermutations(a, subset,i+1);

            subset[i]=a[i];
            findingPermutations(a, subset,i+1);

        }
    }
}
