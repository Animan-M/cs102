


// CS-102: "Computing and Algorithms II"
// Prof. Giuseppe Turini
// Kettering University
// 2020-11-10

package Tree;

// Node class (internal) for the reference-based implementation of a BST (binary search tree).
class Node {
   
   String key; // Unique key.
   
   Node childLeft; // Reference to left child of this node.
   Node childRight; // Reference to right child of this node.

   // Constructor.
   public Node( String k ) {
      // Init internal data, but leave references unconfigured.
      this.key = k;
      this.childLeft = null;
      this.childRight = null;
   }
   
}


