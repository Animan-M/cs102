


// CS-102: "Computing and Algorithms II"
// Prof. Giuseppe Turini
// Kettering University
// 2020-12-02

package Heap;

// Array-based implementation of an heap (binary maxheap).
// Note: This code demonstrates that references are unnecessary to implement an heap.
public class HeapArrayBased { 

   private char[] items; // Internal array storing heap items/keys (root stored at index 0).
   private int currNumItems; // Current number of items in this heap.
   private final int maxNumItems = 20; // Maximum number of items this heap can store.

   // Desc.: Default constructor.
   public HeapArrayBased() {
      // Init internal fields to represent an empty heap.
      this.items = new char[ this.maxNumItems ];
      this.currNumItems = 0;
   }
   
   // Desc.: Check if this heap is empty.
   // Output: True if this heap is empty, false otherwise.
   public boolean isEmpty() { 
      // Check if the current number of items in this heap is 0.
      return ( this.currNumItems == 0 );
   }
   
   // Desc.: Inserts the input item in this heap.
   // Input: newItem, input item/key to be inserted in this heap.
   // Output: Throws an HeapException (critical) if insertion fails because heap is full.
   public void insert( char newItem ) throws HeapException {
      // Check if this heap is full.
      if( this.currNumItems == this.items.length ) {
         // This heap is full, insert failed, throw critical exception.
         throw new HeapException( "HeapArrayBased: insert failed, heap is full!" );
      }
      else {
         // This heap is not full, perform insertion.
         // 1. Append input item/key in internal array.
         this.items[ this.currNumItems ] = newItem;
         this.currNumItems++;
         // 2. Swap input item/key up in this heap to its proper position.
         int indexNewItem = this.currNumItems - 1; 
         int indexParent = ( indexNewItem - 1 ) / 2;
         while( ( indexParent >= 0 ) &&
                ( this.items[ indexNewItem ] > this.items[ indexParent ] ) ) {
            // Swap parent and new item.
            char temp = this.items[ indexParent ];
            this.items[ indexParent ] = this.items[ indexNewItem ];
            this.items[ indexNewItem ] = temp;
            // Update indices.
            indexNewItem = indexParent;
            indexParent = ( indexNewItem - 1 ) / 2;
         }  
      }   
   }
   
   // Desc.: Extracts (returns and deletes) topmost/root/max item/key in this heap (maxheap).
   // Output: Topmost/root/max item/key in this heap (maxheap).
   // Output: Throws an HeapException (critical) if extraction fails because heap is empty.
   public char extractMax() throws HeapException {
      // Check if this heap is empty.
      if( this.currNumItems == 0 ) {
         // This heap is empty, delete failed, throw critical exception.
         throw new HeapException( "HeapArrayBased: delete failed, heap is empty!" );
      }
      else {
         // This heap is not empty, perform delete.
         // 1. Init local variables.
         char rootItem = this.items[0];
         int indexLastItem = this.currNumItems - 1;
         // 2. Swap root with "last" item.
         this.items[0] = this.items[ indexLastItem ];
         this.items[ indexLastItem ] = '\u0000';
         this.currNumItems--;
         // 3. Swap new root item to its proper position in this heap.
         swapDownRec(0);
         // 4. Return topmost/root/max item/key (before delete).
         return rootItem;
      }
   }
   
   // Desc.: Internal recursive implementation to swap down an item of this heap.
   // Note: Assuming input index is valid.
   private void swapDownRec( int indexItem ) {
      // Compute indices of children of input item.
      int indexChildLeft = ( 2 * indexItem ) + 1; // Index of left child of input item, if any.
      int indexChildRight = indexChildLeft + 1; // Index of right child of input item, if any.
      // Check if left child exists.
      if( indexChildLeft < this.currNumItems ) {
         // Left child exists, check if right child exists.
         if( indexChildRight < this.currNumItems ) {
            // Both left and right children exist, find greatest child.
            if( this.items[ indexChildLeft ] > this.items[ indexChildRight ] ) {
               // Greatest child is left child.
               // Check if input value is less than greatest child (left).
               if( this.items[ indexItem ] < this.items[ indexChildLeft ] ) {
                  // 1. Swap input item with greatest child (left).
                  char temp = this.items[ indexChildLeft ];
                  this.items[ indexChildLeft ] = this.items[ indexItem ];
                  this.items[ indexItem ] = temp;
                  // 2. Proceed with the swapping down (recursively).
                  swapDownRec( indexChildLeft );
               }
               else {
                  // Input item is greater than both children, do nothing.
               }
            }
            else {
               // Greatest child is right child.
               // Check if input value is less than greatest child (right).
               if( this.items[ indexItem ] < this.items[ indexChildRight ] ) {
                  // 1. Swap input item with greatest child (right).
                  char temp = this.items[ indexChildRight ];
                  this.items[ indexChildRight ] = this.items[ indexItem ];
                  this.items[ indexItem ] = temp;
                  // 2. Proceed with the swapping down (recursively).
                  swapDownRec( indexChildRight );
               }
               else {
                  // Input item is greater than both children, do nothing.
               }
            }
         }
         else {
            // Left child exist, but right child does not exist, greatest child is left child.
            // Check if input value is less than greatest child (left).
            if( this.items[ indexItem ] < this.items[ indexChildLeft ] ) {
               // 1. Swap input item with greatest child (left).
               char temp = this.items[ indexChildLeft ];
               this.items[ indexChildLeft ] = this.items[ indexItem ];
               this.items[ indexItem ] = temp;
               // 2. Proceed with the swapping down (recursively).
               swapDownRec( indexChildLeft );
            }
            else {
               // Input item is greater than the only child (left), do nothing.
            }
         }
      }
      else {
         // Left child does not exist, input item has no children (leaf), do nothing (swapping down complete).
      }
   }
      
}


