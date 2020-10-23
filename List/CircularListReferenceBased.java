


// CS-102: "Computing and Algorithms II"
// Prof. Giuseppe Turini
// Kettering University
// 2020-10-23

package List;

// Reference-based implementation of a circular linked list.
public class CircularListReferenceBased implements ListInterface {

   private Node list; // Entry point to the circular linked list (reference to 1st list node).
   private int numItems; // Number of list items.

   // Desc.: Locates a specified node in this circular linked list.
   // Input: A valid input index (array-like).
   // Output: A reference to the list node at the input index.
   private Node find( int index ) {
      // Init traversal variable with reference to 1st node.
      Node curr = this.list;
      // Traverse this circular linked list until reaching target node.
      for( int skip = 0; skip < index; skip++ ) { 
         curr = curr.next;
      }
      // Return target node.
      return curr;
   }

   // Default Constructor.
   public CircularListReferenceBased() { 
      // Init internal fields.
      this.list = null; 
      this.numItems = 0;
   }
   
   // Desc.: Returns true if this circular linked list is empty, false otherwise.
   public boolean isEmpty() { 
      return ( this.numItems == 0 );
   }
   
   // Desc.: Returns the number of items in this circular linked list.
   public int size() { 
      return this.numItems;
   }
   
   // Desc.: Delete all the items in this circular linked list.
   public void removeAll() {
      this.list = null; // Set reference to 1st node to null (so 1st node is now unreferenced and marked for garbage collection, with the rest of the list).
      this.numItems = 0; // Update number of list items.
   }
   
   // Desc.: Inserts the input item at the input position in this list.
   // Input: An input index (array-like).
   //        An input item.
   // Output: Throws a ListException (non-critical) if this insertion fails because this list is full.
   //         Throws a ListIndexOutOfBoundsException (non-critical) if this insertion fails because input index is invalid.
   public void add( int index, Object item ) throws ListIndexOutOfBoundsException {
      // Check if input index is valid.
      if( ( index >= 0 ) && ( index < ( this.numItems + 1 ) ) ) {
         // Check if input index represents a special case (insertion at front).
         if( index == 0 ) {
            // Check if this circular linked list is empty.
            if( this.numItems == 0 ) {
               // This circular linked list is empty, perform insertion at front, connecting new node with itself.
               // Insertion at front in empty circular linked list: create a new node, link it to itself, and update reference to 1st node.
               Node newNode = new Node( item );
               newNode.next = newNode; // Connecting newly created node with itself.
               this.list = newNode;
            }
            else {
               // This circular linked list is not empty, perform regular insertion at front.
               // Insertion at front: create a new node, link it to former 1st node, and update reference to 1st node.
               Node newNode = new Node( item, this.list );
               // Find last node.
               Node lastNode = find( this.numItems - 1 );
               // Update reference to 1st node, and then connect last node to new 1st node.
               this.list = newNode;
               lastNode.next = this.list;
            }
         }
         else {
            // Insertion in the middle or at the end: find node before insertion point, and perform insertion.
            Node prev = find( index - 1 );
            Node newNode = new Node( item, prev.next );
            prev.next = newNode;
         }
         // Update number of list items.
         this.numItems++;
      }
      else {
         // Input index is invalid, insertion is impossible, raise the proper runtime error.
         throw new ListIndexOutOfBoundsException("Add operation failed, input index out of range!");
      }
   }
   
   // Desc.: Returns the list item at input index.
   // Input: An input index (array-like).
   // Output: Throws a ListIndexOutOfBoundsException (non-critical) if this retrieval fails because input index is invalid.
   public Object get( int index ) throws ListIndexOutOfBoundsException {
      // Check if input index is valid.
      if( ( index >= 0 ) && ( index < this.numItems ) ) {
         // Input index is valid, find target node and return its content (data).
         Node curr = find( index );
         return curr.item;
      }
      else {
         // Input index is invalid, retrieval is impossible, raise the proper runtime error.
         throw new ListIndexOutOfBoundsException("Get operation failed, input index out of range!");
      }
   }

   // Desc.: Deletes the list item at the input position from this circular linked list.
   // Input: An input index (array-like).
   // Output: Throws a ListIndexOutOfBoundsException (non-critical) if this removal fails because input index is invalid.
   public void remove( int index ) throws ListIndexOutOfBoundsException {
      // Check if input index is valid.
      if( ( index >= 0 ) && ( index < this.numItems ) ) {
         // Check if input index represents a special case (removal at front).
         if( index == 0 ) { 
            // Check if this circular linked list has only 1 node.
            if( this.numItems == 1 ) {
               // This circular linked list has only 1 node, make it empty (set reference to 1st node to null).
               this.list = null;
            }
            else {
               // This circular linked list has more than 1 node, bypass old 1st node and update last node connecting it to new 1st node.
               // Find last node.
               Node lastNode = find( this.numItems - 1 );
               // Update reference to 1st node, and then connect last node to new 1st node.
               this.list = this.list.next;
               lastNode.next = this.list;
            }
         }
         else {
            // Removal in the middle or at the end: find node before removal point, and perform removal.
            Node prev = find( index - 1 );
            Node curr = prev.next;
            prev.next = curr.next;
         }
         // Update number of list items.
         this.numItems--;
      }
      else {
         // Input index is invalid, removal is impossible, raise the proper runtime error.
         throw new ListIndexOutOfBoundsException("Remove operation failed, input index out of range!");
      }
   }
   
}


