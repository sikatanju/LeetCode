public class MIssingNumber {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int missingNum = len;
        for (int i=0; i<len; i++) {
            missingNum ^= i;
            missingNum ^= nums[i];
        }
        return missingNum;
    }
}

/* Sum solution:
public int missingNumber(int[] nums) { //sum
    int len = nums.length;
    int sum = (0+len)*(len+1)/2;
    for(int i=0; i<len; i++)
        sum-=nums[i];
    return sum;
}
 */