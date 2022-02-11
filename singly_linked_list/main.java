import java.io.Console;
import com.oracle.tools.packager.Log;

class Node {

    int data;
    Node next = null;
    
    // initializer
    Node(final int data) {
        this.data = data;
    }
    // another initializer
    Node(final int data, final Node next) {
        this.data = data;
        this.next = next;
    }

    public static Node push(final Node head, final int data) {
        return new Node(data, head);
    }
    // recursive reverse
    public static Node reverse(Node head, Node prev) {
        return head ? reverse(head.next, new Node(head.data, prev)) : prev;
    }

    public static int getNth(Node n, int index) throws Exception {
        if (n == null) throw new NullPointerException("index out of range");
        return index == 0 ? n.data : getNth(n.next, index - 1);
    }

    public static Node insertNth(Node head, int index, int data) {
        if (head == null) throw new NullPointerException("index out of range");
        if (index == 0) return push(head, data);
        return head;
    }

    public static Node sortedInsert(Node head, int data) {
        if (head == null || head.data > data) return push(head, data);
        // recursivly call itself until the head is null
        head.next = sortedInsert(head.next, data);
        return head;
    }

    public static Node append(Node listA, Node listB) {
        if (listA == null) return listB;
        listA.next = append(listA.next, listB);
        return listA;
    }

    public static Node removeDuplicates(Node head) {
        if (head) head.next = removeDuplicates(head.next);
        else return head;
        return head.data == head.next.data ? head.next : head;
    }

    public static Node shuffleMerge(Node first, Node second) {

        if (first) first.next = shuffleMerge(second, first.next);
        return first ? fist : second; // find first or second operand
    }

    // DO - moveNode // create a Context class

    // DO - moveNodeInPlace - currently in beta

    // DO - alternatingSplit

    // DO - frontBackSplit

    // DO - sortedMerge
    public static Node sortedMerge(Node first, Node second) {

        if (first == null || second == null) return first ? first : second;
        if (first.data > second.data) {
            Node temp = first; first = second; second = temp; // find a one line swap, this is bs
        }
        first.next = sortedMerge(first.next, second);
        return first;
    }

    // DO - mergeSort

    // DO - sortedIntersect

    // DO - iterativeReverse - TEST THIS ! ! ! 
    public static Node iterativeReverse(Node list) {

        Node result;

        while (list) {
            result = push(result, list.data);
            list = list.next;
        }

        return result;
    }


    public static int length(final Node head) {
        // return 0 if the head is null
        // return 1 plus the result of the length function given the next node from the head
        // the result looks somthing like 1 + 1 + 1 + 0 // the last 0 being for a null head.next
        return head ? length(head.next) + 1 : 0;
    }

    public static int count(final Node head, final int data) {

    // return 0 if the head is null
    // return 1 if the node data is equal to the data, plus the result of the count function given the next node -> head.next
    // the result looks something like 0 + 1 + 1 + 0 + 1 + 0 or whatever // the last zero being for a null head.next
    return head ? count(head.next, data) + ( head.data == data ? 1 : 0 ) : 0;
    }
    
    public static Node buildOneTwoThree() {
        return push(push(push(null, 3), 2), 1);
    }

    public static void display(final Node head) {

        // if there is a head - print its data
        // if not then print END signifying the end of the list
        Log.i(head ? "current data: " + head.data : "END");
        // recursivly call itself until the head is null
        // pass in the next Node
        return head ? display(head.next) : null;
    }

    }


    // special Node
    // this was only for Java on Codewars
    public class Node {

    private String value;

    public Node next;

    public Node(String value) { this.value = value; }

    public String getValue() { return value; }

    public String toString() { return this.value; }

    public String printList() {

        if (this.next == null) return this.toString() + " ->";
        return this.toString() + " -> " + next.printList();
    }


    // this kata was only in java
    public static Node swapPairs(Node head) {

        if (head == null || head.next == null) return head;
        Node next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }


    public static void deleteNode(Node node) {

        if (node & node.next) {
        node.data = node.next.data;
        node.next = node.next.next;
        }
    }

}