class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        if (tokens.length == 1)
        {
            return (Integer.parseInt(tokens[0]));
        }
        for (String s : tokens) {
            switch (s) {

                case "+":
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    res = num1 + num2;
                    stack.push(res);
                    break;

                case "-":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    res = num2 - num1;
                    stack.push(res);
                    break;

                case "*":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    res = num1 * num2;
                    stack.push(res);
                    break;

                case "/":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    res = num2 / num1;
                    stack.push(res);
                    break;

                default:
                    stack.push(Integer.parseInt(s));
            }

        }
        return res;

    }
}