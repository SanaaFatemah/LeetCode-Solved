class Solution {
    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        boolean mode = false;
         
        for(String s: source)
        {
            for(int i=0;i<s.length();i++)
            {
                if(mode)
                {
                    if(s.charAt(i) == '*' && i<s.length()-1 && s.charAt(i+1) == '/')
                    {
                        mode = false;
                        i++;
                    }
                }
                else
                {
                    if(s.charAt(i) == '/' && i<s.length()-1 && s.charAt(i+1) == '*')
                    {
                        mode = true;
                        i++;
                    }
                    else if (s.charAt(i) == '/' && i<s.length()-1 && s.charAt(i+1) == '/')
                    {
                        break;
                    }
                    else
                    {
                        sb.append(s.charAt(i)); 
                    }
                }
            }
            if(!mode && sb.length()!=0)
            {
                result.add(sb.toString());
                sb =  new StringBuilder();
            }
        }
        return result;
        
    }
}