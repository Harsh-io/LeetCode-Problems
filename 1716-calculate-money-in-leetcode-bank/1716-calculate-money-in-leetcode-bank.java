class Solution {
    public int totalMoney(int n) {
        int sum = 0;
        int cnt = 1;
        int monday = 1;

        for (int i = 1; i <= n; i++) {
            sum += cnt;
            cnt++;

            if (i % 7 == 0) {
                monday++;
                cnt = monday;
            }
        }

        return sum;
    }
}