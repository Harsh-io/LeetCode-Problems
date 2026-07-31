class Solution {

    public int[] makeParityAlternating(int[] arr) {

        if (arr.length == 1) return new int[]{0, 0};

        int min = arr[0];
        int max = arr[0];

        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // Pattern: even, odd, even, odd...
        int[] evenFirst = solve(arr, 0, min, max);

        // Pattern: odd, even, odd, even...
        int[] oddFirst = solve(arr, 1, min, max);

        if (evenFirst[0] < oddFirst[0]) return evenFirst;
        if (oddFirst[0] < evenFirst[0]) return oddFirst;

        return evenFirst[1] <= oddFirst[1] ? evenFirst : oddFirst;
    }

    public int[] solve(int[] arr, int start, int min, int max) {

        int cnt = 0;
        int newMin = Integer.MAX_VALUE;
        int newMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            int num = arr[i];
            int expectedParity = (start + i) % 2;

            if (Math.floorMod(num, 2) != expectedParity) {
                cnt++;

                // Move extreme elements towards the inside
                if (num == min) {
                    num++;
                } else if (num == max) {
                    num--;
                }
            }

            newMin = Math.min(newMin, num);
            newMax = Math.max(newMax, num);
        }

        return new int[]{cnt, Math.max(1, newMax - newMin)};
    }
}