class Solution {

    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            char l = s.charAt(left); // store values 
            char r = s.charAt(right);

            if (!isAlphaNum(l)) {  // check other than alpha and numeric
                left++;
            }
            else if (!isAlphaNum(r)) {
                right--;
            }
            else {

                if (Character.toLowerCase(l) != Character.toLowerCase(r)) {  // changes upper to lower for compare
                    return false;
                }

                left++;
                right--;
            }
        }

        return true;
    }

    private boolean isAlphaNum(char c) {

        return (c >= 'a' && c <= 'z') ||  // for use build in function
               (c >= 'A' && c <= 'Z') || // !isLetterOrDigit
               (c >= '0' && c <= '9');
    }
}