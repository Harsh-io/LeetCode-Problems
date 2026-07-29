class Solution {

    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int[] newHeights = Arrays.copyOf(heights, heights.length + 1);

        for (int i = 0; i < newHeights.length; i++) {

            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {

                int height = newHeights[stack.pop()];
                int width = stack.isEmpty()? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }


    public int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] height = new int[cols];
        int maxArea = 0;

        //O(n + ( r + c))
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') height[j]++;
                else  height[j] = 0;
            }
            
            //O(n)
            maxArea = Math.max(maxArea, largestRectangleArea(height));
        }

        return maxArea;
    }
}
        // for (char[] row : matrix) {
        //     for (int i = 0; i < m; i++) {

        //         if (row[i] == '1') height[i]++;
        //         else height[i] = 0;
        //     }

        
//         maxArea = Math.max(maxArea, largestRectangleArea(height));
//         return maxArea;
//     }
// }
//TC: O()
//SC: O(N)