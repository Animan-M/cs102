


// CS-102: "Computing and Algorithms II"
// Prof. Giuseppe Turini
// Kettering University
// 2020-10-20

package List;

import java.lang.IndexOutOfBoundsException;

// Exception (non-critical) used for an out-of-bounds list index.
public class ListIndexOutOfBoundsException extends IndexOutOfBoundsException {
   
   // Constructor.
   public ListIndexOutOfBoundsException( String s ) { 
      super(s);
   }
   
}


