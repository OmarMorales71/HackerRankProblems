package omar.problems.graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class FindTheNearestClone {

    public static void main(String[] args) {
        int graphNodes = 5;
        int[] graphFrom = new int[]{1,1,2,3};
        int[] graphTo = new int[]{2,3,4,5};
        long[] ids = new long[]{1,2,3,3,2};

        System.out.println(findShortest(graphNodes,graphFrom,graphTo,ids,2));
    }

    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {

        Node[] nodeList = new Node[graphNodes];
        for(int i = 0 ; i<graphNodes ;i++){
            nodeList[i] = new Node(i, ids[i]);
        }

        for(int i=0; i<graphFrom.length; i++){
            nodeList[graphFrom[i]-1].neighbours.add(nodeList[graphTo[i]-1]);

            nodeList[graphTo[i]-1].neighbours.add(nodeList[graphFrom[i]-1]);
        }

        int shortestPath = -1;

        for(int i=0; i<graphNodes; i++){
            if(nodeList[i].color==val){
                if(shortestPath==-1){
                    shortestPath=bfs(nodeList[i], val);
                }else {
                    shortestPath=Math.min(bfs(nodeList[i], val), shortestPath);

                }
                for(Node node:nodeList){
                    node.visitado=false;
                }
                if(shortestPath==1)
                    return 1;
            }
        }
    return shortestPath;
    }

    private static int bfs(Node node, int color) {
        LinkedList<Node> queue = new LinkedList<>();

        queue.add(node);

        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();

            while(size!=0){
                size--;
                Node currentNode = queue.pop();
                currentNode.visitado=true;
                for (Node neighbour: currentNode.neighbours){
                    if(!neighbour.visitado){
                        if (neighbour.color==color)
                            return level+1;

                        queue.add(neighbour);
                    }

                }
            }
            level++;
        }
        return -1;
    }

}

class Node{
    int index;
    long color;
    boolean visitado=false;
    ArrayList<Node> neighbours;
    public Node(int index, long color){
        this.index = index;
        this.color=color;
        neighbours = new ArrayList<>();
    }
}
