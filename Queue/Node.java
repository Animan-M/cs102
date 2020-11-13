


// CS-102: "Computing and Algorithms II"
// Prof. Giuseppe Turini
// Kettering University
// 2020-11-13

package Queue;

// Node class for the reference-based implementation of the ADT queue.
class Node {

   Object item; // Queue item.
   Node next; // Link to next node in queue.
   
   // Constructor.
   public Node( Object newItem ) {
      this.item = newItem;
      this.next = null;
   }
   
}


