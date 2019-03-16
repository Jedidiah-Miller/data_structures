import java.io.Console;

import com.oracle.tools.packager.Log;

// singly linked list
// all the comment marked 'DO' weren't on codewars

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

  public static void display(final Node head) {

    // if there is a head - print its data
    // if not then print END signifying the end of the list
    Log.i(head ? "current data: " + head.data : "END");
    // recursivly call itself until the head is null
    // pass in the next Node
    return head ? display(head.next) : null ;
  }

  public static Node push(final Node head, final int data) {
    return new Node(data, head);
  }
  
  public static Node buildOneTwoThree() {
    return push(push(push(null, 3), 2), 1);
  }

  function length(final Node head) {
    // return 0 if the head is nil
    // return 1 plus the result of the length function given the next node from the head
    // the result looks somthing like 1 + 1 + 1 + 0 // the last 0 being for a nil head.next
    return head ? length(head.next) + 1 : 0;
  }

  public static int count(final Node head, final int data) {

  // return 0 if the head is nil
  // return 1 if the node data is equal to the data, plus the result of the count function given the next node -> head.next
  // the result looks something like 0 + 1 + 1 + 0 + 1 + 0 or whatever // the last zero being for a nil head.next
  return head ? count(head.next, data) + ( head.data == data ? 1 : 0 ) : 0;
  }


  public static int getNth(Node n, int index) throws Exception {
    // if the head is nil then the index is greater than the length of the list
    // return an out of range error
    if (n == null) throw new NullPointerException("index out of range");
    // if the index is 0 then the function has counted down from the original index to 0
    // if the index isn't 0 then try the next node with an index of 1 less than the current index
    return index == 0 ? n.data : getNth(n.next, index - 1);
  }

  
  public static Node insertNth(Node head, int index, int data) {

    // if the index hasn't reached 0 and the head is null then the end of the list has been reached
    // - throw an error yo
    if (head == null) throw new NullPointerException("index out of range");
    // if the index is = to 0 then the correct position has been found
    // return the new node with a next value of the current node - head
    if (index == 0) return push(head, data);
    return head;
  }


  public static Node sortedInsert(Node head, int data) {

    // if the head is null or the nodes data is greater than the param data
    // push the new node, head, use the data obvi
    if (head == null || head.data > data) return push(head, data);
    // recursivly call itself until the head is null
    head.next = sortedInsert(head.next, data);
    return head;
  }

  // DO - insertSort

  public static Node append(Node listA, Node listB) {
    // if there is no listA - return listB - nobody cares if listB is null
    if (listA == null) return listB;
    // recursivly call itself until listA is Null - the end of the list
    listA.next = append(listA.next, listB);
    return listA;
  }

  // DO - removeDuplicates

  // DO - moveNode

  // DO - moveNodeInPlace - currently in beta

  // DO - alternatingSplit

  // DO - frontBackSplit

  // DO - shuffleMerge

  // DO - sortedMerge

  // DO - mergeSort

  // DO - sortedIntersect

  // DO - iterativeReverse

  // DO - recursiveReverse


  public static void temp() {

    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
    Log.info("tomato");
  }
}