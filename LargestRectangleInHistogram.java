import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i=0; i<=len; i++)  {
            int currentHeight = (i==len ? 0: heights[i]);
            if (stack.isEmpty() || currentHeight >= heights[stack.peek()])
                stack.push(i);
            else {
                int top = stack.pop();
                maxArea = Math.max(maxArea, heights[top] * (stack.isEmpty() ? i: i-1-stack.peek()));
                i--;
            }
        }
        return maxArea;
    }
}


/* ### 2nd best 7ms runtime :

class Solution {
    public int largestRectangleArea(int[] h) {
        int max=0;
        int[] a=new int[h.length];
        int b[]=new int[h.length];

        a[0]=0;
        b[b.length-1]=b.length-1;

        for(int i=0;i<h.length;i++){
            int j=i-1;
            while(j>=0 && h[i]<=h[j]){
                j=a[j];
            }

            a[i]=j;
        }

        for(int i=h.length-1;i>=0;i--){
            int j=i+1;
            while(j<h.length && h[i]<=h[j]){
                j=b[j];
            }
            b[i]=j;

            max=Math.max(max,h[i]*(b[i]-a[i]-1));

        }
            return max;
    }
}
*/

/* ### 12ms runtime :

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n == 0) return 0; // Base Condition
        int maxArea = 0;
        int left[] = new int[n]; //fill left boundary
        int right[] = new int[n]; // fill right boundary

        left[0] = -1;
        right[n - 1] = n;

        for(int i = 1; i < n; i++){
            int prev = i - 1; // previous for comparing the heights
            while(prev >= 0 && heights[prev] >= heights[i]){
                prev = left[prev]; // we have done this to minimise the jumps we make to the left
            }
            left[i] = prev;
        }
        // Similarly we do for right
        for(int i = n - 2; i >= 0; i--){
            int prev = i + 1;
            while(prev < n && heights[prev] >= heights[i]){
                prev = right[prev];
            }
            right[i] = prev;
        }
        // once we have these two arrays fill we need width & area
        for(int i = 0; i < n; i++){
            int width = right[i] - left[i] - 1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }
        return maxArea;
    }
}

*/