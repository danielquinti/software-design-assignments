/*Author 1: Daniel Quintillán (daniel.quintillan)*/
/*Author 2: Hilda Romero (h.rvelo)*/
package exercise1;

import org.junit.Test;
import static org.junit.Assert.*;

public class PalindromeTest {
    
    public PalindromeTest() {
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(Palindrome.isPalindrome("radar"));
        assertTrue(Palindrome.isPalindrome("racecar"));
        assertTrue(Palindrome.isPalindrome("a"));
        assertTrue(Palindrome.isPalindrome("aba"));        
    }
    
    @Test
    public void testIsPalindromeCase() {
        assertTrue(Palindrome.isPalindrome("Radar"));
        assertTrue(Palindrome.isPalindrome("RaceCar"));        
    }
    
    @Test
    public void testIsPalindromeSpaces() {
        assertTrue(Palindrome.isPalindrome("race car"));
    }
    
    @Test
    public void testIsPalindromeCharacters() {
        assertTrue(Palindrome.isPalindrome("Was it a cat I saw?"));
        assertTrue(Palindrome.isPalindrome("race car!"));
    }

    @Test
    public void testIsNotPalindrome() {
        assertFalse(Palindrome.isPalindrome("This is not a palindrome"));
        assertFalse(Palindrome.isPalindrome("pi"));
    }
   
//Testing underscores
    @Test
    public void testIsPalindrome_() {
        assertTrue(Palindrome.isPalindrome("Was_it_a cat I_saw?"));
        assertTrue(Palindrome.isPalindrome("race_car!"));
    }
}
