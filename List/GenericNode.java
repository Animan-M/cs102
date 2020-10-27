


// CS-102: "Computing and Algorithms II"
// Prof. Giuseppe Turini
// Kettering University
// 2020-10-27

package List;

// Generic node class (internal) of the reference-based generic implementation of the ADT list.
// Note: input type parameter T (non built-in type) represents the type of the list items.
class GenericNode<T> {

   T item; // Data (custom type determined by input type parameter.
   GenericNode<T> next; // Reference to next list node.

   // Constructor 1.
   public GenericNode( T o ) {
      // Init only node data.
      this.item = o;
      this.next = null;
   } 

   // Constructor 2.
   public GenericNode( T o, GenericNode<T> n ) { 
      // Init both node data and reference to next node.
      this.item = o;
      this.next = n;
   } 

}


