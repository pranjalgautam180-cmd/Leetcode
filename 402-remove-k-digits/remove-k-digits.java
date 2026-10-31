class Solution {
    public String removeKdigits(String num, int k) {
        Stack <Character> st = new Stack<>();
        int n = num.length();

        for(int i =0; i < n; i++){
            char digit = num.charAt(i);
            while(!st.empty() && k > 0 &&
            st.peek() > digit){
                st.pop();
                k--;
            }
            st.push(digit);
        }
        while(k > 0){
            st.pop(); k--;
        }
        String ans = "";  
        while(!st.empty()){  // stack me agar element inc order me ho to
            ans = st.pop() + ans;
        }
        int i=0;             // leading zero condition
        while(i < ans.length() && ans.charAt(i) == '0'){
            i++;
        }
        ans = ans.substring(i); // used to remove leading zeroes
        if(ans.isEmpty()){ // agar stack empty hai to zero return 
            return "0";
        }
        return ans;
    }
}