import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1)
            return triangle.get(0).get(0);

        int size = triangle.size();
        int[][] dp = new int[size+1][size+1];
        for (int level = size-1; level>=0; level--) {
            for (int i=0; i<=level; i++)    {
                dp[level][i] = triangle.get(level).get(i) + Math.min(dp[level+1][i], dp[level+1][i+1]);
            }
        }
        return dp[0][0];
    }
}

/* 0ms runtime:

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle.size() == 0)
			return 0;
		if (triangle.size() == 1)
			return triangle.get(0).get(0);

		int[] dp = new int[triangle.size()];
		dp[0] = triangle.get(0).get(0);
		return minimumTotal(triangle, dp, 1);
	}

	public int minimumTotal(List<List<Integer>> triangle, int[] dp, int lvlidx) {

		List<Integer> list = triangle.get(lvlidx);
		int pre = dp[0], temp;
		dp[0] += list.get(0);
		for (int i = 1; i < lvlidx; i++) {
			temp = dp[i];
			dp[i] = list.get(i) + Math.min(pre, dp[i]);
			pre = temp;
		}
		dp[lvlidx] = pre + list.get(lvlidx);

		if (lvlidx + 1 == triangle.size()) {
			int res = dp[0];
			for (int i = 1; i <= lvlidx; i++)
				res = Math.min(res, dp[i]);
			return res;
		}

		return minimumTotal(triangle, dp, lvlidx + 1);
	}
}


############ 1ms runtime :

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        Integer[][] memo=new Integer[n][n];
        return dfs(triangle,memo,0,0);
    }
    private int dfs(List<List<Integer>> triangle,Integer[][] memo,int row,int col){
        if(memo[row][col]!=null)
            return memo[row][col];
        int path=triangle.get(row).get(col);
        if(row<triangle.size()-1){
            path+=Math.min(dfs(triangle,memo,row+1,col),dfs(triangle,memo,row+1,col+1));
        }
        memo[row][col]=path;
        return path;
    }
}
 */