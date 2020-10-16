


// CS-102: "Computing and Algorithms II"
// Prof. Giuseppe Turini
// Kettering University
// 2020-10-16

package Recursion;

// Class including various implementations (iterative/recursive) of array-processing functions.
public final class Arrays {

   // Find the max value in input array (storing positive integers).
   // Iterative implementation (version 1).
   public static int maxIter1( int[] A ) {
      // Check if input array is valid;
      if( A != null ) {
         // Input array is valid, check its size.
         if( A.length == 1 ) { return A[0]; } // Special case.
         else {
            // Input array has more than 1 item, search for the max.
            int tmpMax = A[0]; // Temporary max value initialized with 1st array item.
            for( int i = 1; i < A.length; i++ ) {
               // Check if current array item is greater than temporary max.
               if( A[i] > tmpMax ) { tmpMax = A[i]; }
            }
            // Max value is now in local variable, return it.
            return tmpMax;
         }
      }
      // Input array not valid, return special value -1.
      return -1; // Error code.
   }
   
   // Find the max value in input array (storing positive integers).
   // Recursive implementation (version 1).
   public static int maxRec1( int[] A ) {
      // Check if input array is valid;
      if( A != null ) {
         // Input array is valid, check its size.
         if( A.length == 1 ) { return A[0]; } // Special case.
         else {
            // Input array has more than 1 item, use recursive strategy.
            // Create another array B, smaller by 1 item: B is equal to A, excluding item A[0].
            int[] B = new int[A.length-1];
            for( int i = 1; i < A.length; i++ ) {
               B[i-1] = A[i]; // For example: B[1] is A[2] etc.
            }
            // Find the max value in B.
            int maxInB = maxRec1(B); // Recursive call.
            // Determine max value in A.
            if( A[0] > maxInB ) { return A[0]; }
            else { return maxInB; }
         }
      }
      // Input array not valid, return special value -1.
      return -1; // Error code.
   }
   
   // Find the max value in input array (storing positive integers).
   // Recursive implementation (version 2).
   public static int maxRec2( int[] A ) {
      // Check if input array is valid;
      if( A != null ) {
         // Input array is valid, check its size.
         if( A.length == 1 ) { return A[0]; } // Special case.
         else {
            // Input array has more than 1 item, use recursive strategy.
            // Create other 2 arrays C and D, splitting array A in "half".
            int pivot = A.length / 2; // For example: 5 / 2 = 2.
            int[] AHalf1 = new int[pivot]; // For example: first half with 2 items.
            int[] AHalf2 = new int[A.length-pivot]; // For example: second half with 3 items.
            // Transfer/copy data from A to new arrays.
            for( int i = 0; i < pivot; i++ ) {
               AHalf1[i] = A[i];
            }
            for( int j = 0; j < A.length-pivot; j++ ) {
               AHalf2[j] = A[j+pivot]; // For example: AHalf2[0] is equal to A[pivot].
            }
            // Find the max value in AHalf1 and AHalf2.
            int maxInAHalf1 = maxRec2( AHalf1 ); // Recursive call.
            int maxInAHalf2 = maxRec2( AHalf2 ); // Recursive call.
            // Determine max value in A.
            if( maxInAHalf1 > maxInAHalf2 ) { return maxInAHalf1; }
            else { return maxInAHalf2; }
         }
      }
      // Input array not valid, return special value -1.
      return -1; // Error code.
   }
   
   // Find the max value in input array (storing positive integers).
   // Recursive implementation (version 3).
   public static int maxRec3( int[] A ) {
      // Check if input array is valid;
      if( A != null ) {
         // Input array is valid, find max.
         return maxRec3PartB( A, 0, A.length-1 );
      }
      // Input array not valid, return special value -1.
      return -1; // Error code.
   }
   
   // Internal recursive implementation for maxRec3: processing input array only inbetween indexFirst and indexLast.
   // Note: "partition" represents the part of the input array between indexFirst (inclusive) and indexLast (inclusive).
   private static int maxRec3PartB( int[] A, int indexFirst, int indexLast ) {
      // Check size of input "partition".
      if( indexLast - indexFirst == 0 ) { return A[indexFirst]; } // Special case: partition with only 1 item.
      else {
         // Input "partition has more than 1 item, use recursive strategy.
         // Find the max value in a smaller "partition" (smaller by 1 item, excluding first item of input "partition").
         int maxInRest = maxRec3PartB( A, indexFirst+1, indexLast ); // Recursive call.
         // Determine max value in input "partition".
         if( A[indexFirst] > maxInRest ) { return A[indexFirst]; }
         else { return maxInRest; }
      }
   }
   
   // Find the max value in input array (storing positive integers).
   // Recursive implementation (version 4).
   public static int maxRec4( int[] A ) {
      // Check if input array is valid;
      if( A != null ) {
         // Input array is valid, find max.
         return maxRec4PartB( A, 0, A.length-1 );
      }
      // Input array not valid, return special value -1.
      return -1; // Error code.
   }
   
   // Internal recursive implementation for maxRec4: processing input array only inbetween indexFirst and indexLast.
   // Note: "partition" represents the part of the input array between indexFirst (inclusive) and indexLast (inclusive).
   private static int maxRec4PartB( int[] A, int indexFirst, int indexLast ) {
      // Check size of input "partition".
      if( indexLast - indexFirst == 0 ) { return A[indexFirst]; } // Special case: partition with only 1 item.
      else {
         // Input "partition has more than 1 item, use recursive strategy.
         // Find the max value in the 2 halves of the input "partition".
         int pivot = ( indexFirst + indexLast + 1 ) / 2; // For example: if indexFirst = 2 and indexLast = 6 then pivot is 4.
         int maxInHalf1 = maxRec4PartB( A, indexFirst, pivot-1 ); // Recursive call.
         int maxInHalf2 = maxRec4PartB( A, pivot, indexLast ); // Recursive call.
         // Determine max value in input "partition".
         if( maxInHalf1 > maxInHalf2 ) { return maxInHalf1; }
         else { return maxInHalf2; }
      }
   }
   
   // Find the index of input value in input array (sorted and storing positive integers).
   // Recursive implementation (version 1)
   public static int binarySearch( int A[], int value ) {
      // Check if input array is valid;
      if( A != null ) {
         // Input array is valid, find max.
         return binarySearchPartB( A, 0, A.length-1, value );
      }
      // Input array not valid, return special value -1.
      return -1; // Error code.
   }
   
   // Internal recursive implementation for maxRec4: processing input array only inbetween indexFirst and indexLast.
   // Note: "partition" represents the part of the input array between indexFirst (inclusive) and indexLast (inclusive).
   private static int binarySearchPartB( int A[], int indexFirst, int indexLast, int value ) {
      // Check if input "partition" is valid.
      if( indexFirst > indexLast ) { return -1; } // -1 is an error code representing a failed search.
      else {
         // Input "partition" is valid.
         // Invariant: if value is in input array: A[indexFirst] <= value <= A[indexLast].
         int pivot = ( indexFirst + indexLast ) / 2;
         // Check if value is at A[pivot], or determine the "partition" half that could contain input value.
         if( value == A[pivot] ) { return pivot; } // Input value found at index pivot.
         else if( value < A[pivot] ) {
            return binarySearchPartB( A, indexFirst, pivot-1, value ); // Search half 1.
         }
         else {
            return binarySearchPartB( A, pivot+1, indexLast, value ); // Search half 2.
         }
      }
   }
   
}


