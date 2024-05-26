class Solution {
    public String rankTeams(String[] votes) {
        int len = votes[0].length();
        int[][] map = new int[26][len+1];

        //Initialize the alphabets values at the last column, eg 0,1,2,3...26
        for(int i =0;i<26;i++)
        {
            map[i][len] = i;
        }
        //Add the count of each votes to the columns against the letters
        for (int i =0;i<votes.length;i++)
        {
            String s = votes[i];
            for(int j =0;j<len;j++)
            {
                //map[[s.charAt(j)-'A']]-> indicates against which character the count has to go against
                //[j] -> for which rank the count should be increased
                map[s.charAt(j)-'A'][j]++;
            }

        }
        //Takes 2 rows at a time and compares each element till a decision element is reached
        Arrays.sort(map, (a,b)->{
            for(int i =0;i<len;i++)
            {
                if(a[i] < b[i]) return 1;
                if(a[i] > b[i]) return -1;
            }
            return 0;
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<len;i++)
        {
            //Builds the string from the rearraged map array taking the first row as rank 1 and second row as rank 2...
            sb.append((char)('A' + map[i][len]));
        }

        return sb.toString();
                
    }
}