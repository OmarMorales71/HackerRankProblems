package omar.problems.search;

import java.util.ArrayList;
import java.util.HashMap;

public class IceCreamParlor {

    public static void main(String[] args) {

    }

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        HashMap<Integer, ArrayList<Integer>> mapOfIceCream = new HashMap<>();

        for(int i=0;i<cost.length;i++){
            if(mapOfIceCream.containsKey(cost[i])){
                mapOfIceCream.get(cost[i]).add(i+1);
            }else{
                ArrayList<Integer> ids = new ArrayList<Integer>();
                ids.add(i+1);
                mapOfIceCream.put(cost[i],ids);
            }
        }

        int iceCream1=0, iceCream2=0;
        for(int c: cost){
            int lookingFor = money-c;
            if(mapOfIceCream.containsKey(lookingFor)){
                if(lookingFor!=c){
                    iceCream1 = mapOfIceCream.get(c).get(0);
                    iceCream2 = mapOfIceCream.get(lookingFor).get(0);
                    break;
                }else{
                    if(mapOfIceCream.get(c).size()>1){
                        iceCream1 = mapOfIceCream.get(c).get(0);
                        iceCream2 = mapOfIceCream.get(c).get(1);
                        break;
                    }
                }
            }
        }

        if(iceCream1<iceCream2){
            System.out.println(iceCream1+" "+iceCream2);
        }else{
            System.out.println(iceCream2+" "+iceCream1);
        }

    }
}
