


// CS-102: "Computing and Algorithms II"
// Prof. Giuseppe Turini
// Kettering University
// 2020-11-10

package Tree;

import java.lang.RuntimeException;

// Exception (non-critical) for runtime errors of BST operations.
public class BSTRuntimeException extends RuntimeException {

   // Constructor.
   public BSTRuntimeException( String s ) { 
      super(s);
   }

}


