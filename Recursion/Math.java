


// CS-102: "Computing and Algorithms II"
// Prof. Giuseppe Turini
// Kettering University
// 2020-10-14

package Recursion;

// Class including various implementations (iterative/recursive) of math functions.
public final class Math {

   public static int debugCounter; // Counter to perform a simple performance analysis.
   
   // Power function: returns the 1st argument raised to the power of the 2nd argument (a^b)
   // Note: assume b >= 0.
   // Iterative implementation (version 1)
   public static int powIter1( int a, int b ) {
      // Check special cases.
      if( b == 0 ) { return 1; }
      else {
         // Here b is > 0.
         int tmpRes = 1;
         // Loop to perform multiplications as needed.
         for( int i = 0; i < b; i++ ) {
            Math.debugCounter++; // DEBUG
            tmpRes = tmpRes * a;
         }
         // Return result.
         return tmpRes;
      }
   }
   
   // Power function: returns the 1st argument raised to the power of the 2nd argument (a^b)
   // Note: assume b >= 0.
   // Iterative implementation (version 2)
   public static int powIter2( int a, int b ) {
      // Check special cases.
      if( b == 0 ) { return 1; }
      else {
         // Here b is > 0.
         int tmpRes = a;
         // Loop to perform multiplications as needed.
         for( int i = 1; i < b; i++ ) {
            Math.debugCounter++; // DEBUG
            tmpRes = tmpRes * a;
         }
         // Return result.
         return tmpRes;
      }
   }
   
   // Power function: returns the 1st argument raised to the power of the 2nd argument (a^b)
   // Note: assume b >= 0.
   // Recursive implementation (version 1)
   public static int powRec1( int a, int b) {
      // Check special cases.
      if( b == 0 ) { return 1; } // Base case.
      else if( b == 1 ) { return a; } // Base case.
      else {
         // Here b > 1.
         Math.debugCounter++; // DEBUG
         return a * powRec1( a, b-1 ); // Recursive call.
      }
   }
   
   // Power function: returns the 1st argument raised to the power of the 2nd argument (a^b)
   // Note: assume b >= 0.
   // Recursive implementation (version 2)
   public static int powRec2( int a, int b) {
      // Check special cases.
      if( b == 0 ) { return 1; } // Base case.
      else if( b == 1 ) { return a; } // Base case.
      else {
         // Here b > 1.
         // Check if b is odd or even.
         if( b % 2 == 0 ) {
            // Here b > 1 AND even.
            Math.debugCounter++; // DEBUG
            return powRec2( a, b/2 ) * powRec2( a, b/2 ); // 2 recursive calls.
         }
         else {
            // Here b > 1 AND odd.
            Math.debugCounter++; // DEBUG
            Math.debugCounter++; // DEBUG
            return a * powRec2( a, (b-1)/2 ) * powRec2( a, (b-1)/2 ); // 2 recursive calls.
         }
      }
   }
   
   // Power function: returns the 1st argument raised to the power of the 2nd argument (a^b)
   // Note: assume b >= 0.
   // Recursive implementation (version 3)
   public static int powRec3( int a, int b) {
      // Check special cases.
      if( b == 0 ) { return 1; } // Base case.
      else if( b == 1 ) { return a; } // Base case.
      else {
         // Here b > 1.
         // Check if b is odd or even.
         if( b % 2 == 0 ) {
            // Here b > 1 AND even.
            int tmpRes = powRec3( a, b/2 ); // Recursive call.
            Math.debugCounter++; // DEBUG
            return tmpRes * tmpRes;
         }
         else {
            // Here b > 1 AND odd.
            int tmpRes = powRec3( a, (b-1)/2 ); // Recursive call.
            Math.debugCounter++; // DEBUG
            Math.debugCounter++; // DEBUG
            return a * ( tmpRes * tmpRes );
         }
      }
   }
   
}


