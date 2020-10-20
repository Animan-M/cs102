


// CS-102: "Computing and Algorithms II"
// Prof. Giuseppe Turini
// Kettering University
// 2020-10-20

package List;

import java.lang.RuntimeException;

// Exception (non-critical) used when the array storing the list becomes full.
public class ListException extends RuntimeException {

   // Constructor.
   public ListException( String s ) { 
      super(s);
   }

}


