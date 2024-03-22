class Solution {
    public int calPoints(String[] operations) {
        int result =0;
        Stack<Integer> stack = new Stack<>();
        for(String s: operations)
        {
           
                switch(s)
                {
                    case "C":
                    stack.pop();
                    break;

                    case "D":
                    int n = stack.peek();
                    stack.push(2*n);
                    break;

                    case "+":
                    int prev = stack.pop();
                    int secondPrev = stack.pop();
                    stack.push(secondPrev);
                    stack.push(prev);
                    int sum = prev + secondPrev;
                    stack.push(sum);
                    break;

                    default:
                    stack.push(Integer.parseInt(s));
                    

                }
            
        }

        while (!stack.isEmpty()) 
        {
            result += stack.pop();
        }

        return result;   
       
    }
}