package omar.problems.lists;


import java.util.HashMap;

class Node {
    int data;
    Node next;
}
public class Detect_a_Cycle {

    boolean hasCycle(Node head) {
        HashMap<Node, Boolean> map = new HashMap<>();

        while(head!=null){
            if(map.containsKey(head)){
                return true;
            }
            map.put(head, true);
            head = head.next;
        }

        return false;
    }
}
