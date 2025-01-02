public class ConcatenationOfArray {
    public int[] getConcatenation(int[] nums) {
        int[] ara = new int[nums.length*2];
        int i=0, j=0;

        while (i<nums.length)
            ara[j++] = nums[i++];

        i = 0;
        while (i<nums.length)
            ara[j++] = nums[i++];

        return ara;
    }
}
