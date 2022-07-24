/*
    LeetCode Problem #2351
    First Letter to Appear Twice

    Given a string s consisting of lowercase English letters, return the first letter to appear twice.

    Note:
        - A letter a appears twice before another letter b if the second occurrence of
            a is before the second occurrence of b.
        - s will contain at least one letter that appears twice.
 */

import java.util.HashMap;

public class FirstLetterToAppearTwice {
    private HashMap<Integer, Character> chars = new HashMap<>();

    public char repeatedCharacter(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (chars.containsValue(s.charAt(i))) {
                return s.charAt(i);
            } else {
                chars.put(i, s.charAt(i));
            }
        }
        /*  Should never reach this return statement since
            constraints say s will contain at least one letter twice. */
        return ' ';
    }
}
