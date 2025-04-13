class Solution {
   public String smallestPalindrome(String s) {
        int n = s.length();
        char[] ans = new char[n];
        Arrays.fill(ans, ' ');
        
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        // Place the odd character (if any) in the middle // to make it palindrome 
        for (int i = 0; i < 26; i++) {
            if ((cnt[i] & 1) == 1) {
                ans[n / 2] = (char) ('a' + i);
                cnt[i]--;
                break;
            }
        }

        // Fill both sides of the palindrome symmetrically when even , we knoiw one has to be even no two odd freq character will be there 
        int j = 0;
        for (int i = 0; i < 26; i++) {
            cnt[i] /= 2;
            while (cnt[i]-- > 0) {
                ans[j] = ans[n - j - 1] = (char) ('a' + i);
                j++;
            }
        }

        return new String(ans);
    }
}©leetcode
