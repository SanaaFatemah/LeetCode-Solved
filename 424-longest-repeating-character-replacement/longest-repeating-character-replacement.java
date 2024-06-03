class Solution {
    public int characterReplacement(String s, int k) {

        int [] arr =  new int [26];
        
        int beg =0; int longestCount =0; int maxLen =0;
        for(int end =0;end<s.length();end++)
        {
            arr[s.charAt(end) - 'A']++;

            longestCount = Math.max(longestCount, arr[s.charAt(end) - 'A']);

            int currentWindow = end-beg+1;

            if(currentWindow-longestCount > k)
            {
                arr[s.charAt(beg)-'A']--;
                beg++;

            }

            maxLen = Math.max(maxLen, end-beg+1);
        }
        return maxLen;
        
    }
}