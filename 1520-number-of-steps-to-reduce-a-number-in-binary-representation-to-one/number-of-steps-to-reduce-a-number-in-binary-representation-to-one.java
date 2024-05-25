class Solution {
    public int numSteps(String s) {

        int carry = 0; int steps =0;

        for (int i = s.length()-1;i>=1;i--)
        {
            int rightMostBit = s.charAt(i) - '0';
            if(rightMostBit + carry == 1)
            {
                carry =1;
                steps+=2;
            }
            else
            steps++;
        }
        return steps+carry;
    }
}