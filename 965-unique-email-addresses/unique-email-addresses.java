class Solution {
    public int numUniqueEmails(String[] emails) {
        List<String> formattedEmailList = new ArrayList<>();
        for (String email: emails)
        {
            String [] splitEmail = email.split("@");
            //ignore everything to the right of +
            int index = splitEmail[0].indexOf("+");
            //getting only the characters to the left of +
            if (index >= 0) {
                splitEmail[0] = splitEmail[0].substring(0, index);
            }
            //Replace all . with space
            splitEmail[0] = splitEmail[0].replace(".", "");
            //after fornatting the email, checking if the list already contains one copy of it
            if (!formattedEmailList.contains(splitEmail[0] + "@" +  splitEmail[1]))
            {
                //adding it to the list if it doesnt contain
                formattedEmailList.add(splitEmail[0] + "@" +  splitEmail[1]);
            }
    }

    return formattedEmailList.size();
}
}