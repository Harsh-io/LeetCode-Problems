class Solution {
    public List<List<String>> groupAnagrams(String[] str) {

        List<List<String>> ans = new ArrayList<>();
        boolean[] vis = new boolean[str.length];

        for (int i = 0; i < str.length; i++) {

            if (vis[i]) continue;
            vis[i] = true;

            List<String> group = new ArrayList<>();
            group.add(str[i]);

            int[] f1 = new int[26];

            for (int x = 0; x < str[i].length(); x++) {
                char ch = str[i].charAt(x);
                f1[ch - 'a']++;
            }

            for (int j = i + 1; j < str.length; j++) {

                if (vis[j]) continue;

                if (str[i].length() != str[j].length()) continue;

                int[] f2 = new int[26];

                for (int y = 0; y < str[j].length(); y++) {
                    char ch = str[j].charAt(y);
                    f2[ch - 'a']++;
                }

                boolean same = true;

                for (int m = 0; m < 26; m++) {
                    if (f1[m] != f2[m]) {
                        same = false;
                        break;
                    }
                }

                if (same) {
                    group.add(str[j]);
                    vis[j] = true;
                }
            }
            ans.add(group);
        }

        return ans;
    }
}