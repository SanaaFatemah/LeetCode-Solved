class Solution {
    public String largestPalindromic(String num) {
        int [] v = new int[10];

        for(int i =0;i<num.length();i++)
        {
            v[(int)num.charAt(i)-48]++;
        }

        int single =-1;
        StringBuilder sb = new StringBuilder();

        for(int i=9;i>=0;i--)
        {
            if(sb.length() ==0 && i==0) continue;
            while(v[i] > 1)
            {
                sb.append((char)(i+48));
                v[i]-=2;
            }
            if(single == -1 && v[i] == 1) single =i;
        }
        if(sb.length()==0 && single ==-1) return "0";
        int i = sb.length()-1;
        if(single!=-1) sb.append((char)(single+48));
        for(;i>=0;i--)
        {
            sb.append(sb.charAt(i));
        }

        return sb.toString();
    }
}