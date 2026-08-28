class Solution {
    public int numberOfSubstrings(String s) {

        int left = 0;
        int count = 0;

        // Frequency of a, b and c
        int[] freq = new int[3];

        for (int right = 0; right < s.length(); right++) {

            // Add current character to the window
            freq[s.charAt(right) - 'a']++;

            // Window contains a, b and c
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {

                // Every substring starting from left
                // and ending at right or later is valid
                count += s.length() - right;

                // Remove the leftmost character
                freq[s.charAt(left) - 'a']--;

                // Move left forward
                left++;
            }
        }

        return count;
    }
}