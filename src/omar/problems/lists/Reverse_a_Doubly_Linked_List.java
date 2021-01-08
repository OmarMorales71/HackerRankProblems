package omar.problems.lists;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Reverse_a_Doubly_Linked_List {
    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the reverse function below.

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */
    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {

        if(head == null || head.next==null){
            return head;
        }
        DoublyLinkedListNode currentNode = head;
        DoublyLinkedListNode previousNode = null;
        DoublyLinkedListNode nextNode = null;
        do{
            nextNode = currentNode.next;
            currentNode.prev = currentNode.next;
            currentNode.next=previousNode;
            previousNode=currentNode;
            currentNode = nextNode;

        }while (nextNode!=null);

        return previousNode;
    }

    public static void main(String[] args) {
        DoublyLinkedListNode obj = new DoublyLinkedListNode(4);
        DoublyLinkedListNode obj2 = new DoublyLinkedListNode(3);
        DoublyLinkedListNode obj3 = new DoublyLinkedListNode(2);
        DoublyLinkedListNode obj4 = new DoublyLinkedListNode(1);
        obj.next=obj2;
        obj2.prev=obj;
        obj2.next=obj3;
        obj3.prev=obj2;
        obj3.next=obj4;

        reverse(obj);
    }
    private static final Scanner scanner = new Scanner(System.in);

   /* public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            DoublyLinkedList llist = new DoublyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            DoublyLinkedListNode llist1 = reverse(llist.head);

            printDoublyLinkedList(llist1, " ", bufferedWriter);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }*/

}
