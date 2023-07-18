public class HouseRobber {
    public int rob(int[] nums)  {
        int rob = 0;
        int notRob = 0;
        for (int i=0; i<nums.length; i++)   {
            int currentRob = notRob + nums[i];
            notRob = Math.max(notRob, rob);
            rob = currentRob;
        }
        return Math.max(rob, notRob);
    }
}



/*  -- Not accepted my Solution :

        int len = nums.length;
        if (len == 1)
            return nums[0];

        int sumOne = 0, sumTwo = 0;
        int suumOne = 0, suumTwo = 0;
        byte i = 0, j = 1;

        sumOne += nums[i];
        sumTwo += nums[j];

        suumOne += sumOne;
        suumTwo += sumTwo;

        i += 2;
        j += 2;

        byte ii = i, jj = j;

        while (i<len && j < len && ii < len && jj < len) {
            byte tempI = (byte)(i+1);
            byte tempJ = (byte)(j+1);

            suumOne += nums[ii];
            suumTwo += nums[jj];

            ii += 2;
            jj += 2;

            if (tempI < len && nums[i] >= nums[tempI])
                sumOne += nums[i];
            else if (i == len - 3 && nums[i] < nums[len-1])
                sumOne += nums[i];

            else if (tempI < len && nums[i] < nums[tempI])    {
                i = tempI;
                sumOne += nums[i];
            }
            else
                sumOne += nums[i];

            if (tempJ < len && nums[j] >= nums[j+1])
                sumTwo += nums[j];
            else if (j == len - 3 && nums[j] < nums[len-1])
                sumTwo += nums[j];
            else if (tempJ < len && nums[j] < nums[j+1])    {
                j = tempJ;
                sumTwo += nums[j];
            }
            else
                sumTwo += nums[j];

            i += 2;
            j += 2;
        }

        if (i < len)    {
            if (i+1 < len && nums[i+1] > nums[i])
                sumOne += nums[i+1];
            else
                sumOne += nums[i];
        }

        if (j < len)    {
            if (j+1 < len && nums[j+1] > nums[j])
                sumTwo += nums[j+1];
            else
                sumTwo += nums[j];
        }


        if (ii < len)
            suumOne += nums[ii];
        if (jj < len)
            suumTwo += nums[jj];


        sumOne = Math.max(sumOne, sumTwo);
        suumOne = Math.max(suumOne, suumTwo);

        return Math.max(sumOne, suumOne);
    }
 */