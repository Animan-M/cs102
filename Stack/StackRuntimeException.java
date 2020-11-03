


// CS-102: "Computing and Algorithms II"
// Prof. Giuseppe Turini
// Kettering University
// 2020-11-03

package Stack;

import java.lang.RuntimeException;
import java.lang.String;

// Exception (non-critical) used for a runtime failure performing a stack operation.
public class StackRuntimeException extends java.lang.RuntimeException {

   // Constructor.
   public StackRuntimeException( String s ) { 
      super(s);
   }
   
}


