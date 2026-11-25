class Solution {
    public int maxArea(int[] heights) {
      int a = 0, b = heights.length - 1;
      int result = -1;
      while(a < b) {
        result = Math.max(result, Math.min(heights[a], heights[b]) * (b - a));
        if(heights[a] < heights[b]) a++;
        else b--;
      }
      return result;
    }
}
