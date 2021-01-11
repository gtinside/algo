import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * The FirstNonRepeatingCharacter program implements an algorithm to find the first non repeating character in a given
 * string and simply displays the value to the standard output.
 *
 * @author Gaurav Tiwari
 * @version 1.0
 * @since 2021-01-11
 */
public class FirstNonRepeatingCharacter {

    /**
     * Implements an algorithm using LinkedHashMap to find the first non repeating character in a given string.
     * This method throws an IllegalArgumentException if no unique character exists in the string
     * Time Complexity: O(n)
     * Space Complexity: O(n) because of LinkedHashMap
     *
     * @param input a given string
     * @return Unique character in the input in lowercase
     * @throws IllegalArgumentException
     */
    public Character findFirstNonRepeatingCharacterUsingMap(final String input) throws IllegalArgumentException {
        //corner conditions, edge cases
        if (input == null || input.trim().length() == 0) throw new IllegalArgumentException("Invalid Input");

        //input might have characters both in upper and lower case
        final String lower_case_input = input.toLowerCase();

        //LinkedHashMap to maintain the order
        final Map<Character, Integer> map = new LinkedHashMap<>();
        for (Character character : lower_case_input.toCharArray()) {
            map.put(character, map.getOrDefault(character, 0) + 1);
        }

        for (Character character : map.keySet()) {
            if (map.get(character) == 1) return character;
        }

        throw new IllegalArgumentException("No unique character found");
    }

    /**
     * Implements an algorithm using Queue to find the first non repeating character in a given string.
     * This method throws an IllegalArgumentException if no unique character exists in the string
     * Time Complexity: O(n)
     * Space Complexity: O(n) because of Queue
     *
     * @param input a given string
     * @return Unique character in the input in lowercase
     * @throws IllegalArgumentException
     */
    public Character findFirstNonRepeatingCharacterUsingQueue(final String input) throws IllegalArgumentException {
        //corner conditions, edge cases
        if (input == null || input.trim().length() == 0) throw new IllegalArgumentException("Invalid Input");

        //An array for storing count for character, such that index 0 stores count for 'a' and cout of 'z' at index 25
        int[] char_array = new int[26];

        //input might have characters both in upper and lower case
        final String lower_case_input = input.toLowerCase();
        //queue to store characters in sequence
        final Queue<Character> queue = new LinkedList<>();

        //and the magic begins, idea it to keep track of count using array and sequence using queue
        for (Character character : lower_case_input.toCharArray()) {
            char_array[character - 'a']++;
            //First in First Out
            queue.add(character);

            // check if
            // 1) Any characters have count more than 1, those can be removed from queue, as they are not required
            // 2) If we encounter character with count 1, we can continue with the outer loop and move to next character
            while (!queue.isEmpty()) {
                if (char_array[queue.peek() - 'a'] > 1) {
                    queue.poll();
                } else {
                    break;
                }
            }
        }

        //if queue is not empty then the head of the queue should be our answer
        if(queue.isEmpty()) {
            throw new IllegalArgumentException("No unique character found");
        } else {
            return queue.poll();
        }
    }
}



