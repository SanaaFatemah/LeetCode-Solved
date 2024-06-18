class Solution {
    public String decodeString(String s) {

        Stack<StringBuilder> strSt = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        StringBuilder curStr = new StringBuilder();
        int curNum = 0;

        for(int i =0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
                curNum = curNum*10 + (c-'0');
            }
            else if(c == '[')
            {
                numSt.push(curNum);
                strSt.push(curStr);
                curNum = 0;
                curStr = new StringBuilder();
            }
            else if(c == ']')
            {
                int count  = numSt.pop();
                StringBuilder newStr = new StringBuilder();
                for(int k=0;k<count;k++)
                {
                    newStr.append(curStr);
                }
                StringBuilder parent = strSt.pop();
                curStr = parent.append(newStr);

            }
            else
            {
                curStr.append(c);
            }
        }

        return curStr.toString();
        
    }
}