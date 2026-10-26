class Solution {

    // Find Next Smaller Element (NSE)
    public int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            nse[i] = st.empty() ? n : st.peek();
            st.push(i);
        }

        return nse;
    }

    // Find Previous Smaller Element or Equal (PSEE)
    public int[] findPSEE(int[] arr) {
        int n = arr.length;
        int[] psee = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            psee[i] = st.empty() ? -1 : st.peek();
            st.push(i);
        }

        return psee;
    }

    // Calculate the sum of subarray minimums
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long mod = 1_000_000_007L;

        int[] nse = findNSE(arr);
        int[] psee = findPSEE(arr);

        long total = 0;

        for (int i = 0; i < n; i++) {
            long left = i - psee[i];
            long right = nse[i] - i;

            long contribution = (left * right) % mod;
            contribution = (contribution * arr[i]) % mod;

            total = (total + contribution) % mod;
        }

        return (int) total;
    }
}

// class Solution {
//     public int sumSubarrayMins(int[] arr) {
//         int n = arr.length;
//         long mod = 1_000_000_007L;
//         long ans = 0;

//         int[] left = new int[n];
//         int[] right = new int[n];

//         Stack<Integer> st = new Stack<>();

//         // Previous Smaller Element (strictly smaller)
//         for (int i = 0; i < n; i++) {
//             while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
//                 st.pop();
//             }

//             left[i] = st.isEmpty() ? i + 1 : i - st.peek();
//             st.push(i);
//         }

//         st.clear();

//         // Next Smaller or Equal Element
//         for (int i = n - 1; i >= 0; i--) {
//             while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
//                 st.pop();
//             }

//             right[i] = st.isEmpty() ? n - i : st.peek() - i;
//             st.push(i);
//         }

//         // Calculate each element's contribution
//         for (int i = 0; i < n; i++) {
//             ans = (ans + (long) arr[i] * left[i] * right[i]) % mod;
//         }

//         return (int) ans;
//     }
// } 