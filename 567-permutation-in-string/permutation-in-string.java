class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length()) return false;
        

        int [] a1 = new int[26];
        int [] a2 = new int[26];

        int k = s1.length();

        for(int i=0;i<k;i++)
        {
            a1[s1.charAt(i) - 'a']++;
            a2[s2.charAt(i) - 'a']++;
        }

        if(matches(a1,a2)) return true;

        for(int i =k;i < s2.length(); i++)
        {
            a2[s2.charAt(i) - 'a']++;
            a2[s2.charAt(i-k) - 'a']--;
            if(matches(a1,a2)) return true;
        }

        return matches(a1,a2);

        
    }

    public boolean matches(int [] a1, int [] a2)
    {
        for(int i =0;i<26;i++)
        {
            if(a1[i] != a2[i])
            {
                return false;
            }
        }
        return true;
    }
}