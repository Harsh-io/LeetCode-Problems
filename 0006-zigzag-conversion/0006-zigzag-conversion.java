class Solution {
    public String convert(String s, int n) {

        if(n == 1 || s.length() <= n)return s;
        StringBuilder[] row = new StringBuilder[n];

        for(int i=0; i<n; i++){
            row[i] = new StringBuilder();
        }

        boolean down = false;
        int i = 0;

        for(char c : s.toCharArray()){
            row[i].append(c);

            if(i == 0 || i == n-1){
                down = !down;
            }

            i += down ? 1 : -1;
        }

        StringBuilder res = new StringBuilder();
        for(int j=0; j<n; j++){
            res.append(row[j]);
        }

        return res.toString();
    }
}



//  if (numRows == 1 || s.length() <= numRows) return s;

    //     StringBuilder[] rows = new StringBuilder[numRows];
    //     for (int i = 0; i < numRows; i++) {
    //         rows[i] = new StringBuilder();
    //     }

    //     int currentRow = 0;
    //     boolean goingDown = false;

    //     for (char c : s.toCharArray()) {
    //         rows[currentRow].append(c);

    //         if (currentRow == 0 || currentRow == numRows - 1) {
    //             goingDown = !goingDown;
    //         }

    //         currentRow += goingDown ? 1 : -1;
    //     }

    //     StringBuilder result = new StringBuilder();
    //     for (StringBuilder row : rows) {
    //         result.append(row);
    //     }

    //     return result.toString();
    // }