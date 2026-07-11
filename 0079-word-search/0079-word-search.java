class Solution {
    int r;
    int c;
    int[][] dir = {{1,0}, {0,1}, {-1,0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        r = board.length;
        c = board[0].length;

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(board[i][j] == word.charAt(0) && findpath(board, word, i, j, 0 ))
                return true;
            }
        }
        return false;
    }

    public boolean findpath(char[][] board, String word, int i, int j, int idx ){

        //base case
        if(idx == word.length()) return true;

        if(i<0 || j<0 || i>=r || j>=c || board[i][j] != word.charAt(idx)) return false;

        Character temp = board[i][j];
        board[i][j] = '$';

        // Explore in all four directions
       boolean found = findpath(board, word, i + 1, j, idx + 1) ||
                       findpath(board, word, i - 1, j, idx + 1) ||
                       findpath(board, word, i, j + 1, idx + 1) ||
                       findpath(board, word, i, j - 1, idx + 1);

            // Restore character
            board[i][j] = temp;

            return found;
     }    
}


// why cant we use boolean visited to check ? 
//boolean[][] visited uses extra O(m × n) space. -> Replacing the board character uses no separate visited array.