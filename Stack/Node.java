


// CS-102: "Computing and Algorithms II"
// Prof. Giuseppe Turini
// Kettering University
// 2020-11-03

package Stack;

// Node class (internal) of the reference-based implementation of the ADT stack.
class Node {

   Object item; // Data.
   Node next; // Reference to next stack node.

   // Constructor 1.
   public Node( Object o ) {
      // Init only node data.
      item = o;
      next = null;
   } 

   // Constructor 2.
   public Node( Object o, Node n ) { 
      // Init both node data and reference to next node.
      item = o;
      next = n;
   } 

}


