/*Author 1: Daniel Quintillán (daniel.quintillan)*/
/*Author 2: Hilda Romero (h.rvelo)*/
package exercise1;


public class Palindrome {
/**
* Given a String passed as an argument , it returns a boolean indicating
* whether said String is a palindrome or not .
*
* A palindrome is a word or phrase that reads the same backwards as forwards .
*
* Our method will not be case - sensitive , and only takes into account ASCII
* characters between 'A' and 'Z' (or 'a' and 'z '). Other characters such as
* spaces , questions marks , apostrophes , etc . are ignored .
*
* Examples of palindromes :
* * " Radar " ( case is ignored )
* * " Was it a cat I saw ?" ( Question mark ignored )
*
* @param strg
* @return True if it is a palindrome . False if it is not .
*/
public static boolean isPalindrome ( String strg ) {
   strg = strg.replaceAll ("[^\\dA-Za-z]", "");     
   StringBuilder restr = new StringBuilder(strg);
   return strg.equalsIgnoreCase(restr.reverse().toString());              
}

}

