//Approach 
// 1) perform horizontal and vertical cuts
// 2) make righMap and leftMap to store  ele of both sides : initially store all values in rightMap
// 3) perform horizontal and vertical cuts row/column 
// 4) after each cut move one row from rightMap -> LeftMap
// 5) if leftSum == rightSum  then return true;
// 6) if not equal -> find the ele to remove -> if exists -> check of which side and return true (if it exists on larger side)
// 5) reset parameters and perform same for vertical cut
// 7) check horizontal and vertical connectivity -> for horizontal connectivity [after removing the ele are other elements connected ?]
// a) if ele exists in the top part/row -> if rowcut{index of rowcut} >= 1{index->return true : else find the index of ele ->return false if not on edges
// b) if ele exists in the bottom part of row -> if no of rows >= 2-> return true : else find the index of ele -> return false if not on edges

import java.util.*;

class Solution {
    public boolean canPartitionGrid(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;
        long total = 0;
        long sum = 0;

        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                total += arr[i][j];
                int val = arr[i][j];
                rightMap.put(val, rightMap.getOrDefault(val, 0) + 1);
            }
        }

        //horizontal cut
        for(int i=0; i<r-1; i++){
            for(int j=0; j<c; j++){
                int val = arr[i][j];
                sum += val;
                // move element: right -> left
                leftMap.put(val, leftMap.getOrDefault(val, 0) + 1);

                rightMap.put(val, rightMap.get(val) - 1);
                if(rightMap.get(val) == 0){
                    rightMap.remove(val);
                }
            }
            long leftSum = sum;
            long rightSum = total - sum;
            if(leftSum == rightSum) return true;

            long ele = Math.abs(leftSum - rightSum); // if (sum == total-sum-ele) eg : 1+3 = 10-4-2(ele to remove)

            if(ele > 100000) continue; // single cell max value is 100000, skip if diff too large

            if(leftSum > rightSum){
                if(leftMap.containsKey((int)ele) && checkHorizontal(arr, i, ele, true)) return true;
            } else {
                if(rightMap.containsKey((int)ele) && checkHorizontal(arr, i, ele, false)) return true;
            }
        }

        leftMap.clear();
        rightMap.clear();
        sum = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                int val = arr[i][j];
                rightMap.put(val, rightMap.getOrDefault(val, 0) + 1);
            }
        }

        //vertical cut
        for(int j = 0; j < c - 1; j++){
            for(int i = 0; i < r; i++){
                int val = arr[i][j];
                sum += val;
                leftMap.put(val, leftMap.getOrDefault(val, 0) + 1);
                rightMap.put(val, rightMap.get(val) - 1);
                if(rightMap.get(val) == 0){
                    rightMap.remove(val);
                }
            }

            long leftSum = sum;
            long rightSum = total - sum;

            if(leftSum == rightSum) return true;

            long ele = Math.abs(leftSum - rightSum); // if (sum == total-sum-ele)

            if(ele > 100000) continue; // single cell max value is 100000, skip if diff too large

            if(leftSum > rightSum){
                if(leftMap.containsKey((int)ele) && checkVertical(arr, j, ele, true)) return true;
            } else {
                if(rightMap.containsKey((int)ele) && checkVertical(arr, j, ele, false)) return true;
            }
        }

        return false;
    }

    // horizontal connectivity
    private boolean checkHorizontal(int[][] grid, int rowCut, long val, boolean isTop) {
        int c = grid[0].length;

        if(isTop){
            // guard for 1-column grid — must check BEFORE rowCut >= 1 early return
            if(grid[0].length == 1){
                for(int i = 0; i <= rowCut; i++){
                    if(grid[i][0] == val){
                        if(i == 0 || i == rowCut) return true; // edge of TOP section
                    }
                }
                return false;
            }

            if(rowCut >= 1) return true;

            for(int j = 0; j < c; j++){
                if(grid[rowCut][j] == val){
                    if(j == 0 || j == c - 1) return true;
                }
            }
        } else {
            int rows = grid.length - rowCut - 1;

            // guard for 1-column grid — must check BEFORE rows >= 2 early return
            if(grid[0].length == 1){
                for(int i = rowCut + 1; i < grid.length; i++){
                    if(grid[i][0] == val){
                        if(i == rowCut + 1 || i == grid.length - 1) return true; // edge of BOTTOM section
                    }
                }
                return false;
            }

            if(rows >= 2) return true;

            int row = rowCut + 1;
            for(int j = 0; j < c; j++){
                if(grid[row][j] == val){
                    if(j == 0 || j == c - 1) return true;
                }
            }
        }

        return false;
    }

    // vertical connectivity
    private boolean checkVertical(int[][] grid, int colCut, long val, boolean isLeft) {
        int r = grid.length;

        if(isLeft){
            // added for 1-row case — must check BEFORE colCut >= 1 early return
            if(grid.length == 1){
                for(int j = 0; j <= colCut; j++){                    // only LEFT section
                    if(grid[0][j] == val){
                        if(j == 0 || j == colCut) return true;       // edges of LEFT section
                    }
                }
                return false;
            }

            if(colCut >= 1) return true;

            for(int i = 0; i < r; i++){
                if(grid[i][colCut] == val){
                    if(i == 0 || i == r - 1) return true;
                }
            }
        } else {
            int cols = grid[0].length - colCut - 1;

            // added for 1-row case — must check BEFORE cols >= 2 early return
            if(grid.length == 1){
                for(int j = colCut + 1; j < grid[0].length; j++){           // only RIGHT section
                    if(grid[0][j] == val){
                        if(j == colCut + 1 || j == grid[0].length - 1) return true; // edges of RIGHT section
                    }
                }
                return false;
            }

            if(cols >= 2) return true;

            int col = colCut + 1;
            for(int i = 0; i < r; i++){
                if(grid[i][col] == val){
                    if(i == 0 || i == r - 1) return true;
                }
            }
        }
        return false;
    }
}