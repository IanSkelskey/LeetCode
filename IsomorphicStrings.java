/*
    LeetCode Problem #205
    Isomorphic Strings

    Given two strings s and t, determine if they are isomorphic.

    Two strings s and t are isomorphic if the characters in s can be replaced to get t.

    All occurrences of a character must be replaced with another character while preserving the order of characters.
    No two characters may map to the same character, but a character may map to itself.
 */

import java.util.HashMap;

class IsomorphicStrings {
    private HashMap<Character, Character> map = new HashMap<>();

    public boolean isIsomorphic(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if(!map.containsValue(t.charAt(i))){
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        StringBuilder string = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                string.setCharAt(i, map.get(s.charAt(i)));
            }
        }
        s = string.toString();
        System.out.println(s + " " + t);
        return s.equals(t);
    }
}