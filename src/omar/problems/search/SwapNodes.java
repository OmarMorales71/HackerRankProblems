package omar.problems.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SwapNodes {
    public static void main(String[] args) {

    }


    static int[][] swapNodes(int[][] indexes, int[] queries) {
        int height = (int) Math.round(log(indexes.length, 2)) + 1;
        int[][] ans = new int[queries.length][indexes.length];
        TreeNode root = new TreeNode(1);
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        for (int[] index : indexes) {

            TreeNode current = nodes.pop();
            if (current != null) {

                if (index[0] != -1) {
                    current.leftChild = new TreeNode(index[0]);
                    nodes.add(current.leftChild);
                }



                if (index[1] != -1) {
                    current.rightChild = new TreeNode(index[1]);
                    nodes.add(current.rightChild);
                }


            }
        }

        int i = 0;
        for (int query: queries){
            index=0;
            swap(root, query);
            int[] array = new int[indexes.length];
            inOrder(root, array);
            ans[i] = array;
            i++;
        }

        return ans;
    }
    static int index=0;
    private static void inOrder(TreeNode root, int[] array) {
        if(root==null){
            return;
        }

        inOrder(root.leftChild,array);
        array[index]= root.index;
        index++;
        inOrder(root.rightChild, array);

    }

    private static void swap(TreeNode root, int query) {
        int level = 1;

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while(queue.isEmpty()){
            int size = queue.size();
            while(size!=0){
                TreeNode current = queue.pop();
                if(current.leftChild!=null){
                    queue.add(current.leftChild);
                }

                if(current.rightChild!=null){
                    queue.add(current.rightChild);
                }

                if(level%query==0){
                    TreeNode temp = current.leftChild;
                    temp.leftChild = current.rightChild;
                    current.rightChild=temp;

                }
                size--;
            }
            level++;
        }
    }

    private static Double log(double num, int base) {
        return (Math.log10(num) / Math.log10(base));
    }
}

class TreeNode {
    int index;
    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode(int index) {
        this.index = index;
    }
}
