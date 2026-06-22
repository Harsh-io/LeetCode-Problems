class Solution {
    public int maxNumberOfBalloons(String str) {
        int m = str.length();
        if (m < 7) return 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int b = map.getOrDefault('b', 0);
        int a = map.getOrDefault('a', 0);
        int l = map.getOrDefault('l', 0) / 2;
        int o = map.getOrDefault('o', 0) / 2;
        int n = map.getOrDefault('n', 0);

        return Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
    }
}