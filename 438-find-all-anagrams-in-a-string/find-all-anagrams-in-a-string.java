import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) return result;

        int[] pCount = new int[26];
        int[] window = new int[26];

        // Fill pCount
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int windowSize = p.length();

        for (int i = 0; i < s.length(); i++) {
            // Add current character
            window[s.charAt(i) - 'a']++;

            // Remove left character if window exceeds size
            if (i >= windowSize) {
                window[s.charAt(i - windowSize) - 'a']--;
            }

            // Compare arrays
            if (Arrays.equals(pCount, window)) {
                result.add(i - windowSize + 1);
            }
        }

        return result;
    }
}