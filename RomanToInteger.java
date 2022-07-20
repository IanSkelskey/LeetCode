import java.util.HashMap;

class RomanToInteger {

    private final HashMap<Character, Integer> romanValueMap = newRomanMap();

    private char currentRoman;
    private char previousRoman;

    private int currentRomanValue;
    private int previousRomanValue;

    public int romanToInt(String s) {

        int output = 0;

        if (s.length() == 1) {
            setCurrentRoman(s.charAt(0));
            setCurrentRomanValue(currentRoman);
            return currentRomanValue;
        }

        for (int i = 1; i < s.length(); i++) {

            setCurrentRoman(s.charAt(i));
            setPreviousRoman(s.charAt(i-1));

            setCurrentRomanValue(currentRoman);
            setPreviousRomanValue(previousRoman);

            if (this.currentRomanValue > this.previousRomanValue) {
                output += (this.currentRomanValue - this.previousRomanValue);
                i++;
                if (i == s.length() - 1) {
                    setCurrentRoman(s.charAt(i));
                    setCurrentRomanValue(currentRoman);
                    output += this.currentRomanValue;
                }
            } else if (i < s.length() - 1) {
                output += this.previousRomanValue;
            }  else {
                output += this.previousRomanValue;
                output += this.currentRomanValue;
            }

        }

        return output;

    }

    private void setCurrentRoman(char c) {
        this.currentRoman = c;
    }

    private void setCurrentRomanValue(char c) {
        this.currentRomanValue = this.romanValueMap.get(c);
    }

    private void setPreviousRoman(char c) {
        this.previousRoman = c;
    }

    private void setPreviousRomanValue(char c) {
        this.previousRomanValue = this.romanValueMap.get(c);
    }

    private HashMap<Character, Integer> newRomanMap() {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return map;
    }

}