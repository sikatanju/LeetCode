import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class WeeklyContest409 {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int len = n;

        int[] res = new int[queries.length];

        for (int i=0; i<queries.length; i++)    {
            int[] temp = new int[len];
            int current = queries[i][0];
            int next = queries[i][1];

            if (!map.containsKey(current))  {
                map.put(current, new ArrayList<>());
                map.get(current).add(next);
            }
            else
                map.get(current).add(next);

            boolean reachedFinal = false;
            for (int j=0; j<len; j++)   {
                List<Integer> road  = new ArrayList<>();
                if (map.containsKey(j)) {
                    road = map.get(j);
                }
                if (j==0)   {
                    for (int k=0; k<road.size(); k++)   {
                        int tt = road.get(k);
                        if (temp[tt] != 0 && temp[tt] > temp[j]+1)
                            temp[tt] = temp[j]+1;
                        else if (temp[tt] == 0)
                            temp[tt] = temp[j]+1;
                    }
                    continue;
                }
                else {
                    int currentCost = temp[j-1]+1;
                    if (temp[j] != 0 && temp[j] < currentCost)  {
                    }
                    else
                        temp[j] = currentCost;
                }
                for (int k=0; k<road.size(); k++)   {
                    int tt = road.get(k);
                    if (temp[tt] != 0 && temp[tt] > temp[j]+1)
                        temp[tt] = temp[j]+1;
                    else if (temp[tt] == 0)
                        temp[tt] = temp[j]+1;
                }
            }
            res[i] = temp[len-1];
        }
        return res;
    }
}


/* Our Previous solution:
public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int len = n;

        int[] res = new int[queries.length];

        for (int i=0; i<queries.length; i++)    {
            int[] temp = new int[len];
            int current = queries[i][0];
            int next = queries[i][1];

            if (!map.containsKey(current))  {
                map.put(current, new ArrayList<>());
                map.get(current).add(next);
            }
            else
                map.get(current).add(next);

            boolean reachedFinal = false;
            for (int j=0; j<len; j++)   {
                List<Integer> road  = new ArrayList<>();
                if (map.containsKey(j)) {
                    road = map.get(j);
                }
                if (j==0)   {
                    for (int k=0; k<road.size(); k++)   {
                        int tt = road.get(k);
                        if (temp[tt] != 0 && temp[tt] > temp[j]+1)
                            temp[tt] = temp[j]+1;
                        else if (temp[tt] == 0)
                            temp[tt] = temp[j]+1;
                    }
                    continue;
                }
                else {
                    int currentCost = temp[j-1]+1;
                    if (temp[j] != 0 && temp[j] < currentCost)  {
                    }
                    else
                        temp[j] = currentCost;
                }
                for (int k=0; k<road.size(); k++)   {
                    int tt = road.get(k);
                    if (temp[tt] != 0 && temp[tt] > temp[j]+1)
                        temp[tt] = temp[j]+1;
                    else if (temp[tt] == 0)
                        temp[tt] = temp[j]+1;
                }
            }
            res[i] = temp[len-1];
        }
        return res;
    }
 */
/*
class neighborSum   {
    class Pos {
        int row;
        int column;
        public Pos(int row, int column)   {
            this.row = row;
            this.column = column;
        }
        public int getRow() {
            return this.row;
        }
        public int getColumn()  {
            return this.column;
        }
    }
    int[][] grid;
    int rowLen;
    int columnLen;
    Map<Integer, Pos> pos;
    public neighborSum(int[][] grid) {
        this.grid = grid;
        this.rowLen = grid.length;
        this.columnLen = grid.length;
        this.pos = new HashMap<>();
        for (int i=0; i<this.rowLen; i++)   {
            for (int j=0; j<this.columnLen; j++)    {
                if (!pos.containsKey(grid[i][j]))   {
                    pos.put(grid[i][j], new Pos(i, j));
                }
            }
        }
    }

    public int adjacentSum(int value) {
        Pos position = pos.get(value);
        int sum = 0;
        int row = position.getRow();
        int column = position.getColumn();

        if (row+1 < this.rowLen)
            sum += this.grid[row+1][column];
        if (row-1 >= 0)
            sum += this.grid[row-1][column];
        if (column-1 >= 0)
            sum += this.grid[row][column-1];
        if (column+1 < this.columnLen)
            sum += this.grid[row][column+1];

        return sum;
    }

    public int diagonalSum(int value) {
        Pos position = pos.get(value);
        int sum = 0;
        int row = position.getRow();
        int column = position.getColumn();

        if (row-1 >= 0 && column-1 >= 0)    {
            sum += this.grid[row-1][column-1];
        }
        if (row+1 < this.rowLen && column+1 < this.columnLen)    {
            sum += this.grid[row+1][column+1];
        }
        if (row-1 >= 0 && column+1 < this.columnLen)
            sum += this.grid[row-1][column+1];
        if (row+1 < this.rowLen && column-1 >= 0)
            sum += this.grid[row+1][column-1];

        return sum;
    }
}
*/



/*
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        LinkedList head = new LinkedList(0);
        LinkedList tail = head;
        int shortestPath = 0;
        int[] res = new int[queries.length];

        for (int i=1; i<n; i++) {
            LinkedList temp = new LinkedList(i);
            tail.next = temp;
            tail = temp;
        }

        for (int i=0; i<queries.length; i++)    {
            LinkedList temp = head;
            int count = 0;
            int currentCity = queries[i][0];
            int nextCity = queries[i][0];
            while (temp != null)    {
                if (currentCity == temp.city)  {
                    if (temp.nextCity == null)  {
                        temp.nextCity = nextCity;
                    }
                    else {
                        if (temp.nextCity > nextCity)
                            continue;
                        else
                            temp.city
                    }
                }
                count++;
                temp = temp.next;
            }
        }
        return null;
    }
 */