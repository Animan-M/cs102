


// CS-102: "Computing and Algorithms II"
// Prof. Giuseppe Turini
// Kettering University
// 2020-10-21

package List;

// Reference-based implementation of the ADT list.
public class ListReferenceBased implements ListInterface {

   private Node head; // Entry point to the list (reference to 1st list node).
   private int numItems; // Number of list items.

   // Desc.: Locates a specified node in a linked list.
   // Input: A valid input index (array-like).
   // Output: A reference to the list node at the input index.
   private Node find( int index ) {
      // Init traversal variable with head reference.
      Node curr = this.head;
      // Traverse this list until reaching target node.
      for( int skip = 0; skip < index; skip++ ) { 
         curr = curr.next;
      }
      // Return target node.
      return curr;
   }

   // Default Constructor.
   public ListReferenceBased() { 
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
   public void add( int index, Object item ) throws ListIndexOutOfBoundsException {
      // Check if input index is valid.
      if( ( index >= 0 ) && ( index < ( this.numItems + 1 ) ) ) {
         // Check if input index represents a special case (insertion at front).
         if( index == 0 ) {
            // Insertion at front: create a new node, link it to former 1st node, and update head reference.
            Node newNode = new Node( item, this.head );
            this.head = newNode;
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
   
   // Desc.: Removes duplicates items (items with same reference) from the list, but keeping the 1st item occurrence in the list.
   // Note: In-place implementation.
   public void removeDuplicates() {
      // Check if the list is long enough to have duplicate items.
      if( this.numItems > 1 ) {
         // List is long enough to have duplicate items, search and remove all of them.
         // Iterate through all list items from 1st node to node before last.
         Node currNode = this.head; // Set current node to 1st list node.
         while( currNode.next != null ) {
            // Scan rest of list (from currNode forward).
            Node currDuplicate = currNode.next; // Set current duplicate to node right after current node.
            Node prevDuplicate = currNode; // Set previous duplicate to node right before current duplicate.
            while( currDuplicate != null ) {
               // Check if currDuplicate stores an item that is a duplicate (reference) of item stored in currNode.
               if( currNode.item.equals( currDuplicate.item ) ) {
                  // Duplicate found, delete node pointed by currDuplicate (modify prevDuplicate so that it bypasses currDuplicate).
                  prevDuplicate.next = currDuplicate.next; // Bypassing currDuplicate.
                  this.numItems--;
                  // Update previous duplicate and current duplicate, switching both of them to next list node.
                  // WARNING: do not update/change prevDuplicate!.
                  currDuplicate = currDuplicate.next;
               }
               else {
                  // Duplicate not found, do nothing.
                  // Update previous duplicate and current duplicate, switching both of them to next list node.
                  prevDuplicate = currDuplicate;
                  currDuplicate = currDuplicate.next;
               }
            }
            // Update current node switching it to next list node.
            currNode = currNode.next;
            // Special case: last removal has made currNode the last node, quit immediately to avoid executing loop header.
            if( currNode == null ) {
               return;
            }
         }
      }
      else {
         // List is not long enough to have duplicate items, do nothing and return.
         return;
      }
   }

}


