package omar.problems.trees;

import java.util.ArrayList;

public class ThisIsABinarySearchTree {
    boolean checkBST(TreeNode root) {
    return inOrder(root);
    }

    ArrayList<Integer> nums = new ArrayList<>();
    private boolean inOrder(TreeNode root){
        if(root==null){
            return true;
        }

        if(root.left!=null){
            if(!inOrder(root.left))
                return false;
        }

        if(nums.isEmpty() || root.val>nums.get(nums.size()-1)){
            nums.add(root.val);
        }else{
            return false;
        }

        if(root.right!=null){
            if(!inOrder(root.right))
                return false;
        }

        return true;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}
