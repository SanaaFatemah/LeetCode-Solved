class Solution {
    public String removeStars(String s) {
        Stack<Character> stack =  new Stack<>();

        for(char ch : s.toCharArray())
        {
            if(ch == '*')
            {
                stack.pop();
            }
            else
            {
                stack.push(ch);
            }
        }
        StringBuilder builder = new StringBuilder();
        while(!stack.isEmpty())
        {
            builder.append(stack.pop());

        }

        return builder.reverse().toString();
        
    }
}