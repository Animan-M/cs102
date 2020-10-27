


// CS-102: "Computing and Algorithms II"
// Prof. Giuseppe Turini
// Kettering University
// 2020-10-27

package List;

// Reference-based generic implementation of the ADT list.
// Note: input type parameter T (non built-in type) represents the type of the list items.
public class GenericListReferenceBased<T> {

   private GenericNode<T> head; // Entry point to the list (reference to 1st list node).
   private int numItems; // Number of list items.

   // Desc.: Locates a specified node in a linked list.
   // Input: A valid input index (array-like).
   // Output: A reference to the list node at the input index.
   private GenericNode<T> find( int index ) {
      // Init traversal variable with head reference.
      GenericNode<T> curr = this.head;
      // Traverse this list until reaching target node.
      for( int skip = 0; skip < index; skip++ ) { 
         curr = curr.next;
      }
      // Return target node.
      return curr;
   }

   // Default Constructor.
   public GenericListReferenceBased() { 
      // Init internal fields.
      this.head = null; 
      this.numItems = 0;
   }
   
   // Desc.: Returns true if this list is empty, false otherwise.
   public boolean isEmpty() { 
      return ( this.numItems == 0 );
   }
   
   // Desc.: Returns the number of items in this list.
   public int size() { 
      return this.numItems;
   }
   
   // Desc.: Delete all the items in this list.
   public void removeAll() {
      this.head = null; // Set head to null (so 1st node is now unreferenced and marked for garbage collection, with the rest of the list).
      this.numItems = 0; // Update number of list items.
   }
   
   // Desc.: Inserts the input item at the input position in this list.
   // Input: An input index (array-like).
   //        An input item.
   // Output: Throws a ListException (non-critical) if this insertion fails because this list is full.
   //         Throws a ListIndexOutOfBoundsException (non-critical) if this insertion fails because input index is invalid.
   public void add( int index, T item ) throws ListIndexOutOfBoundsException {
      // Check if input index is valid.
      if( ( index >= 0 ) && ( index < ( this.numItems + 1 ) ) ) {
         // Check if input index represents a special case (insertion at front).
         if( index == 0 ) {
            // Insertion at front: create a new node, link it to former 1st node, and update head reference.
            GenericNode<T> newNode = new GenericNode<T>( item, this.head );
            this.head = newNode;
         }
         else {
            // Insertion in the middle or at the end: find node before insertion point, and perform insertion.
            GenericNode<T> prev = find( index - 1 );
            GenericNode<T> newNode = new GenericNode<T>( item, prev.next );
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
   public T get( int index ) throws ListIndexOutOfBoundsException {
      // Check if input index is valid.
      if( ( index >= 0 ) && ( index < this.numItems ) ) {
         // Input index is valid, find target node and return its content (data).
         GenericNode<T> curr = find( index );
         return curr.item;
      }
      else {
         // Input index is invalid, retrieval is impossible, raise the proper runtime error.
         throw new ListIndexOutOfBoundsException("Get operation failed, input index out of range!");
      }
   }

   // Desc.: Deletes the list item at the input position from this list.
   // Input: An input index (array-like).
   // Output: Throws a ListIndexOutOfBoundsException (non-critical) if this removal fails because input index is invalid.
   public void remove( int index ) throws ListIndexOutOfBoundsException {
      // Check if input index is valid.
      if( ( index >= 0 ) && ( index < this.numItems ) ) {
         // Check if input index represents a special case (removal at front).
         if( index == 0 ) { 
            // Removal at front: update head reference to bypass 1st list node (now unreferenced and marker for garbage collection).
            this.head = this.head.next;
         }
         else {
            // Removal in the middle or at the end: find node before removal point, and perform removal.
            GenericNode<T> prev = find( index - 1 );
            GenericNode<T> curr = prev.next;
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


