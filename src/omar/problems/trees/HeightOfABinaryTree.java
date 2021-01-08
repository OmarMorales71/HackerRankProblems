package omar.problems.trees;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Scanner;

public class HeightOfABinaryTree {


    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static int height(Node root) {
        LinkedList<Node> queue = new LinkedList<Node>();

        return dfs(root, 0);
    }

    private static int dfs(Node root, int h) {

        int l = h;
        if (root.left != null) {
            l=dfs(root.left, h+1);
        }
        int r = h;
        if (root.right != null) {
            r= dfs(root.right, h+1);
        }


        return Math.max(l, r);
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}
