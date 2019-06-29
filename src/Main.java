import java.util.HashMap;
import java.util.Map;

public class Main {

    /*

     Cracking the Coding Interview - Arrays and Strings

     1.4 - Palindrome Permutation:
     Given a string, write a function to check if it is a permutation of a palindrome.
     A palindrome is a word or phrase that is the same forwards and backwards.
     A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.

     */

    public static void main(String[] args) {
        System.out.println(checkPalindromePermutation("Tact Coa"));
    }

    public static boolean checkPalindromePermutation(String string) {
        Map<String, Integer> characterMap = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            if (characterMap.containsKey(Character.toString(string.charAt(i)))) {
                characterMap.put(Character.toString(string.charAt(i)), characterMap.get(Character.toString(string.charAt(i))) + 1);
            } else {
                characterMap.put(Character.toString(string.charAt(i)), 1);
            }
        }
        return checkForOddOnes(characterMap);
    }

    public static boolean checkForOddOnes(Map<String, Integer> characterMap) {
        boolean oddFound = false;
        for(Map.Entry<String, Integer> element : characterMap.entrySet()) {
            if (element.getValue()%2 != 0) {
                if (oddFound) {
                    return true;
                }
                oddFound = true;
            }
        }
        return false;
    }
}
