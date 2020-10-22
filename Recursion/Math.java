


// CS-102: "Computing and Algorithms II"
// Prof. Giuseppe Turini
// Kettering University
// 2020-10-14

package Recursion;

// Class including various implementations (iterative/recursive) of math functions.
public final class Math {

   public static int debugCounter; // Counter to perform a simple performance analysis.
   
   // Desc.: Computes a^b (a at the power of b).
   // Input: The base a and the exponent b (assuming b >= 0).
   // Note: Iterative implementation (version 1).
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
   
   // Desc.: Computes a^b (a at the power of b).
   // Input: The base a and the exponent b (assuming b >= 0).
   // Note: Iterative implementation (version 2).
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
   
   // Desc.: Computes a^b (a at the power of b).
   // Input: The base a and the exponent b (assuming b >= 0).
   // Note: Recursive implementation (version 1).
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
   
   // Desc.: Computes a^b (a at the power of b).
   // Input: The base a and the exponent b (assuming b >= 0).
   // Note: Recursive implementation (version 2).
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
   
   // Desc.: Computes a^b (a at the power of b).
   // Input: The base a and the exponent b (assuming b >= 0).
   // Note: Recursive implementation (version 3).
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
   
   // Desc.: Computes the sum of powers of 2, considering the first n+1 powers of 2, from 2^0 to 2^n.
   // Input: "n" (assuming n >= 0) as the value of the last exponent used in the sum, or as the exponent of the last term in the sum.
   // Node: If input value is negative (n < 0), this function returns a special value (-1).
   // Note: See https://en.wikipedia.org/wiki/1_%2B_2_%2B_4_%2B_8_%2B_%E2%8B%AF
   // Note: Iterative implementation (version 1).
   public static int sumPowersOfTwoIter1( int n ) {
      // Check if input value is valid (n >= 0 ).
      if( n < 0 ) {
         // Input value is invalid, return special value -1.
         return -1;
      }
      // Input value is valid, check if the sum is trivial (only 1 term).
      else if( n == 0 ) { 
         // Sum includes only 1 term, result is 2^0.
         return 1;
      }
      else {
         // Here the sum includes at least 2 terms.
         // Init temporary sum.
         int tmpSum = 0;
         // Iteration to generate each term of the sum.
         for( int exp = 0; exp <= n; exp++ ) {
            // Init current term of the sum.
            int currTerm = 1;
            // Iteration to perform the multiplications to compute current term of the sum (2^exp).
            for( int mult = 1; mult <= exp; mult++ ) {
               // Multiply current term by the base.
               currTerm = currTerm * 2;
            }
            // Update temp sum adding current term.
            tmpSum = tmpSum + currTerm;
         }
         // Return the sum.
         return tmpSum;
      }
   }
   
   // Desc.: Computes the sum of powers of 2, considering the first n+1 powers of 2, from 2^0 to 2^n.
   // Input: "n" (assuming n >= 0) as the value of the last exponent used in the sum, or as the exponent of the last term in the sum.
   // Node: If input value is negative (n < 0), this function returns a special value (-1).
   // Note: See https://en.wikipedia.org/wiki/1_%2B_2_%2B_4_%2B_8_%2B_%E2%8B%AF
   // Note: Recursive implementation (version 1).
   public static int sumPowersOfTwoRec1( int n ) {
      // Check if input value is valid (n >= 0 ).
      if( n < 0 ) {
         // Input value is invalid, return special value -1.
         return -1;
      }
      // Input value is valid, check if the sum is trivial (only 1 term).
      else if( n == 0 ) { 
         // Sum includes only 1 term, result is 2^0.
         return 1;
      }
      else {
         // Here the sum includes at least 2 terms.
         // 1. Compute last term, 2^n.
         int lastTerm = 1; // Init current term of the sum.
         // Iteration to perform the multiplications to compute last term of the sum (2^n).
         for( int mult = 1; mult <= n; mult++ ) {
            // Multiply last term by 2.
            lastTerm = lastTerm * 2;
         }
         // 2. Compute rest of sum recursively.
         int restOfSum = sumPowersOfTwoRec1( n-1 );
         // 3. Add last term to rest of sum, and return final result.
         return restOfSum + lastTerm;
      }
   }

}


