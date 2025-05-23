//Time: O(2n)
//Space: O(n)

/*
Approach:
1. Use Monotonically increasing stack to store the indices of input temperatures
2. Pop from stack until the curr temp value > stack top
3. calculate diff of indices for curr value and stack top and add it to result for that day
4. push the curr elem index to stack
*/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n= temperatures.length;
        Stack<Integer> st = new Stack<>();

        int res[]=new int[n];

        for(int i=0;i<n;i++){

            while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()]){
                int popped=st.pop();
                res[popped]=i-popped;
            }
            st.push(i);
        }
        return res;
    }
}