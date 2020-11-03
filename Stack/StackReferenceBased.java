


// CS-102: "Computing and Algorithms II"
// Prof. Giuseppe Turini
// Kettering University
// 2020-11-03

package Stack;

// Reference-based implementation of the ADT stack.
public class StackReferenceBased implements StackInterface {

   private Node top; // Reference at top node of the stack, or null.
   
   // Default constructor.
   public StackReferenceBased() { 
      this.top = null; // Init reference to top item for an empty stack.
   }
   
   // Desc.: Determines whether this stack is empty.
   // Output: True if this stack is empty, false otherwise.
   public boolean isEmpty() { 
      return ( this.top == null );
   }
   
   // Desc.: Removes all the items from this stack.
   public void popAll() {
      this.top = null;
   }
   
   // Desc.: Adds input item to the top of this stack.
   // Input: newItem, the input item to be inserted in this stack.
   // Output: Throws a StackRuntimeException (non-critical) if this insertion fails.
   public void push( Object newItem ) { 
      // Create a new node to store input item, and connect it to rest of stack.
      this.top = new Node( newItem, this.top );
   }
   
   // Desc.: Removes the top item of this stack, and returns it. Throws StackException if the stack is empty.Inserts the input item at the input position in this list.
   // Output: The item just removed from the top of this stack.
   //         Throws a StackRuntimeException (non-critical) if this removal fails (e.g. this stack is empty).
   public Object pop() throws StackRuntimeException {
      // Check if this stack is empty.
      if( !isEmpty() ) {
         // This stack is not empty: get top node, detatch it from stack, return top item.
         Node temp = this.top;
         this.top = this.top.next;
         return temp.item;
      }
      else { 
         // This stack is empty: removal failed, throw exception.
         throw new StackRuntimeException( "StackRuntimeException on pop: stack empty!" );
      }
   }
   
   // Desc.: Returns the top item of this stack (without removing it).
   // Output: The item at the top of this stack.
   //         Throws a StackRuntimeException (non-critical) if this retrieval fails (e.g. this stack is empty).
   public Object peek() throws StackRuntimeException {
      // Check if this stack is empty.
      if( !isEmpty() ) { 
         // This stack is not empty: return top item.
         return this.top.item;
      }
      else {
         // This stack is empty: retrieval failed, throw exception.
         throw new StackRuntimeException( "StackRuntimeException on peek: stack empty!" );
      }
   }
   
}


