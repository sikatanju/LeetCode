// import java.util.*;
/* 
public class threeSumReloaded {
    public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> triplets = new ArrayList<>();
		int negC = 0, posC = 0, zeroC = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int v : nums) {
			if (v == 0) {
				zeroC++;
			} else if (v > 0) {
				posC++;
			} else {
				negC++;
			}
			if (v < min)
				min = v;
			if (v > max)
				max = v;
		}
		if (zeroC > 2)
			triplets.add(new Z(0, 0, 0));
		if (negC == 0 || posC == 0)
			return triplets;
		min = Math.max(min, -2 * max);
		max = Math.min(max, -2 * min);
		int[] negNums = new int[negC], posNums = new int[posC]; // distinct
		byte[] setC = new byte[max - min + 1]; // occurrences
		negC = 0;
		posC = 0;
		for (int v : nums) {
			int dif = v - min;
			if (dif >= 0 && v <= max && setC[dif] != 2 && setC[dif]++ == 0)
				if (v < 0) {
					negNums[negC++] = v;
				} else if (v > 0) {
					posNums[posC++] = v;
				}
		}

		Arrays.sort(negNums, 0, negC--);
		Arrays.sort(posNums, 0, posC--);
		if (posC < 0)
			return triplets;
		for (int i = 0; negC >= 0; negC--) {
			int a = negNums[negC];
			int na = -a;
			int posTo = Arrays.binarySearch(posNums, i, posC, na * 2);
			if (posTo < 0)
				posTo = Math.min(posC, ~posTo);
			i = Arrays.binarySearch(posNums, i, posC, na / 2);
			if (i < 0)
				i = ~i;
			for (int posI = posTo; posI >= i; posI--) {
				int c = posNums[posI];
				int b = na - c;
				if (b > c)
					break;
				if (b >= a && setC[b - min] > 0 && (b != a || setC[a - min] > 1) && (b != c || setC[c - min] > 1))
					triplets.add(new Z(a, b, c));

			}
		}
        System.out.println (Arrays.toString(triplets.toArray()));
		return triplets;
	}
    public static void main(String[] args)  {
        int[] ara = {-1, 0, 1, 1};
        threeSumReloaded obj = new threeSumReloaded();
        obj.threeSum(ara);
    }
}

class Z extends AbstractList<Integer> {
	int a, b, c;

	public Z(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public Integer get(int i) {
		return i == 0 ? a : i == 1 ? b : c;
	}

	@Override
	public int size() {
		return 3;
	}
}

*/