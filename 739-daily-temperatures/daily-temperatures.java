class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();
        int [] ans = new int[temperatures.length];
        int n = temperatures.length;

        for (int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()])
            {
                stack.pop();
            }

            if(!stack.isEmpty())
            {
                ans[i] = stack.peek() - i;
            }

            stack.push(i);

        }

        return ans;

    }
}