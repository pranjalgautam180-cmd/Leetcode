class Solution {
    public int maxVowels(String s, int k) {
        
        int maxVowel = 0;
        int count = 0;

        for(int i = 0; i < k; i++){
            if(isVowel(s.charAt(i))){
                count++;
            }
            maxVowel = count;
        }
        for(int i = k; i<s.length(); i++){
            if(isVowel(s.charAt(i-k))){
                count--;
            }
            if(isVowel(s.charAt(i))){
                count++;
            }
            maxVowel = Math.max(maxVowel , count);
        }
        return maxVowel;
    }
    private boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch ==  'i'
        || ch == 'o' || ch == 'u';
    }
}