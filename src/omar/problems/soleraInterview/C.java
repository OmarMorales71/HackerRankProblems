package omar.problems.soleraInterview;

public class C {
    public static void main(String[] args) {
        C ob = new C();
        System.out.println(ob.solution(new int[]{1,1,2,2,3,4,4,5, 6}, 5));
    }

    public boolean solution(int[] A, int K){
        int n = A.length;
        for(int i =0; i<n-1;i++){
            if(A[i] + 1 < A[i+1]) {
                return false;
            }
        }
        if(A[0] != 1 || A[n-1] != K){
            return false;
        }else{
            return true;
        }
    }
}
