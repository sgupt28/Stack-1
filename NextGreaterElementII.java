// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

/*
Approach: Using Monotonic stack
1. for each element smaller than the current push to the stack
2. if the incoming elem is greater than the stack top, add the incoming elem as result for stack top elem
3. Keep resolving and popping out stack elements as long as the current elem is greater
4. push the curr elem to the stack

*/
class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n=nums.length;

        int res[] =new int[n];
        Arrays.fill(res, -1);

        Stack<Integer> st = new Stack<>();

        for(int i=0;i<2*n;i++){

            while(!st.isEmpty() && nums[st.peek()]<nums[i%n]){
                int popped=st.pop();
                res[popped]=nums[i%n];
            }
            if(i<n){ //to avoid pushing the resolved elem again to the stack
                st.push(i);
            }
            else if(st.peek()==i%n){
            }
        }
        return res;
    }
}