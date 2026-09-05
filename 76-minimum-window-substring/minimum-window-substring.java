import java.util.*;

class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray())
            need.put(c, need.getOrDefault(c, 0) + 1);

        int left = 0, formed = 0;
        int required = need.size();
        int minLen = Integer.MAX_VALUE, start = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            // check required frequency
            if (need.containsKey(c) &&
                window.get(c).equals(need.get(c)))
                formed++;

            while (formed == required) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char x = s.charAt(left);
                window.put(x, window.get(x) - 1);

                if (need.containsKey(x) &&
                    window.get(x) < need.get(x))
                    formed--;

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}