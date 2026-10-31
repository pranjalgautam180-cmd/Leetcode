class Solution {
    public String removeKdigits(String num, int k) {
        Stack <Character> st = new Stack();
        int n = num.length();
        // String ans = "";

        for(int i=0; i<n; i++){
            char digit = num.charAt(i);
            while(!st.empty() && k > 0 && st.peek() > digit){
                st.pop();
                k--;
            }
            st.push(digit);
        }
        while(k > 0){
            st.pop();
            k--;
        }
        String ans = "";
        while(!st.empty()){
            ans = st.pop() + ans;
        }
        int j=0;
        while(j< ans.length() && ans.charAt(j) == '0'){
            j++;
        }
        ans = ans.substring(j);
        if(ans.isEmpty()){
            return "0";
        }
        return ans;
    }
}