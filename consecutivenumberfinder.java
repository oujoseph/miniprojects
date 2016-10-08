/*************************************************************************

Author: Joseph Ou, Shivam Dave
10/7/16


Binary Consecutive Number Finder:

Finds whether or not two binary numbers are consecutive, e.g. 1101 and 1100.

In implementation, we first start by taking a number, and adding one to it.
For example,
11001100 + 00000001.

We notice that when we do this, only the rightmost bit changes.

We notice that if there is a carry, such as in
11001111 + 00000001,

The bits change in a cascading manner from left to right, stopping when
one of two cases occurs:

Case 1: when the carry reaches a 0, cascading stops.
example: 
11001111 + 00000001 stops carrying when it reaches 1101XXXX

Case 2: when the number ceases to change, cascading is not occurring.
example:
11001111 compared to
11010000 stops carrying when it reaches 110XXXXX


Following this logical flow is our algorithm:

Step 1: equalizes the number of digits in both numbers by prepending zeroes to
the smaller number

Step 2: begin iterating from the leftmost (most significant) bit, rightwards,
comparing the digit at that element of the index of both numbers, until we 
find two DIFFERENT digits.

If the digit is different, we assume that is where the carry begins, and 
we mark the number with the digit "1" as the larger number, and the number
with the digit "0" at that location is the smaller number. We then mark
the index where this dissimilarity occurs.

Step 3: Begin iterating from the rightmost bit, leftwards, comparing the digit
at that element of the index of both numbers, until we find two SIMILAR digits,
or until we find a 0; either of these two cases signify the end of the carry.

We mark where the carry ends, and compare that to where step 2 ended. If the
index does not match up, we know that there are digits in the two numbers which
are different, but do not fall under the carry, implying the numbers are not
consecutive.

If the index matches up, we will have iterated through and compared each digit
in both numbers in order to verify that the two numbers are consecutive.


**************************************************************************/

    
    
import java.io.*;

class binNumConsecutive
{
    public static void main (String[] args) throws java.lang.Exception
    {
        String aa = "111111";
        String bb = "1000000";
        String a = "0011010101011";
        String z = "0011010101100";
        String b = "11";
        String c = "100101000";
        String d = "100101001";
        String e = "00100101001";
        String num_296 = "0000000100101000";
        String num_297 = "00100101001";
        String num_299 = "00100101011";
        String num_300 = "000100101100";
        String num_5937162 = "10110101001100000001010";
        String num_5937161 = "10110101001100000001001";
        String num_5931162 = "10110101000000010011010";
        
        
        
        String active1 = aa;
        String active2 = bb;
        
        //First, get length of both strings, if one is shorter, prepend zeroes until it is not
        String tempString1 = active1;
        String tempString2 = active2;
        
        // Used to add zeroes based on: (length of longer number) - (length of shorter number)
        // This resulting difference is the number of zeroes prepended to the shorter number
        int addZero = 0;
        if (tempString1.length() > tempString2.length()) {
            addZero = tempString1.length() - tempString2.length();
            
            for(int i = 0; i < addZero; i++){
                tempString2 = "0" + tempString2;
            }
            
        } else {
            addZero = tempString2.length() - tempString1.length();
            
            for(int i = 0; i < addZero; i++) {
                tempString1 = "0" + tempString1;
            }
        }
        
        
        //VARIABLES FOR USAGE WITHIN LOOPS
        char currChar1;
        char currChar2;
        //VARIABLES FOR USAGE WITHIN LOOPS
        
        //if leftResult and rightResult match, it is consecutive
        //initialize them to start from opposite ends
        int leftResult = 0;
        int rightResult = tempString1.length();

        //mark the bigger string and smaller string for a check in the second loop
        String smallerString = "";
        String biggerString = "";
        
        // Goes through the numbers from the leftmost bit
        // until both digits are equal. When they are equal,
        // the larger number is found based on which digit is
        // '1'. The bigger and smaller numbers are stored, and
        // The left position is marked where these digits differ.
        for(int i = 0; i < tempString1.length(); i++){
            currChar1 = tempString1.charAt(i);
            currChar2 = tempString2.charAt(i);
            
            
            if (currChar1 == currChar2){
            } else {
                
                if (currChar1 == '1'){
                    smallerString = tempString2;
                    biggerString = tempString1;
                    
                } else {
                    smallerString = tempString1;
                    biggerString = tempString2;
                }
                leftResult = i;
                break;
            }
        }
        
        // First check if both are equal and one is empty, then returns
        // that both are identical, empty strings.
        // Otherwise, from the right, the numbers are iterated through
        // where in each iteration the current position is stored.
        // Iteration is done until 1 of 2 conditions are met:
        //     1. The digits are equal
        //     2. The smaller number's digit is 0
        // On one of these conditions, the loop is broken out of.
        if ((biggerString == smallerString) && (smallerString == "")) {
            System.out.println("IDENTICAL NUMBERS");
        } else {
            for(int i = tempString1.length() - 1; i >= leftResult; i--){
                currChar1 = smallerString.charAt(i);
                currChar2 = biggerString.charAt(i);
                rightResult = i;
                if (currChar1 == currChar2){
                    break;
                }
                if (currChar1 == '0') {
                    break;
                }
            }
        }  
        
        // If the right position iterated to is equal to the left position
        // that was marked (where the 2 digits first differed from the left)
        // then we know the numbers are consecutive. Otherwise, the numbers
        // are not consecutive
        if (rightResult == leftResult)System.out.println("CONSECUTIVE");
        else System.out.println("NOT CONSECUTIVE");
    }
}
