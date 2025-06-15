/*
Example 1:

Input: caption = "Leetcode daily streak achieved"

Output: "#leetcodeDailyStreakAchieved"

Explanation:

The first letter for all words except "leetcode" should be capitalized.

Example 2:

Input: caption = "can I Go There"

Output: "#canIGoThere"

Explanation:

The first letter for all words except "can" should be capitalized.

Example 3:

Input: caption = "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"

Output: "#hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"

Explanation:

Since the first word has length 101, we need to truncate the last two letters from the word.
*/

class Solution {
    public String generateTag(String caption) {
        int n=caption.length();
         StringBuilder sb = new StringBuilder();
        sb.append("#");

        String[] cap = caption.trim().split("\\s+");
        if (cap.length > 0) {
            sb.append(cap[0].toLowerCase());
        }
      //prothom 0 th charcater ta captital hobe baki small
        for (int i = 1; i < cap.length; i++) {
            if (cap[i].length() > 0) {
                sb.append(cap[i].substring(0, 1).toUpperCase());
                sb.append(cap[i].substring(1).toLowerCase());
            }
        }
      //letter ache kina check korchi 
        StringBuilder cleaned = new StringBuilder();
        cleaned.append("#");
        for (int i = 1; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (Character.isLetter(ch)) {
                cleaned.append(ch);
            }
        }
        String ans = cleaned.toString();
        if (ans.length() > 100) {
            ans = ans.substring(0, 100);
        } // 100 er length beshi tai truncase kore dichi 

        return ans;

    }
}
