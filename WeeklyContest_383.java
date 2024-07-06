import java.util.ArrayList;
import java.util.List;

public class WeeklyContest_383 {
    public int[][] resultGrid(int[][] image, int threshold) {
        List<Integer> intensity = new ArrayList<>();
        int rowLen = image.length, columnLen = image[0].length;
        for (int i=0; i<rowLen; i++)    {
            for (int j=0; j<columnLen; j++) {
                int tempRowLen = i+2, tempColumnLen = j+2;
                int sumOfIntensity = 0, count = 0;
                boolean isValid = true;

                if (tempRowLen < rowLen && tempColumnLen < columnLen)    {
                    for (int k=i; k<=tempRowLen; k++)   {
                        for (int l=j; j<=tempColumnLen; j++)    {
                            count++;
                            sumOfIntensity += image[k][l];
                            if (l+1 <= tempColumnLen)   {
                                if (Math.abs((image[k][l]) - (image[k][l+1])) <= threshold)
                                    continue;
                                else
                                    isValid = false;
                            }
                            if (k+1 <= tempRowLen)  {
                                if (Math.abs((image[k][l]) - (image[k][l+1])) <= threshold)
                                    continue;
                                else
                                    isValid = false;
                            }
                            if(!isValid)
                                break;
                        }
                        if(!isValid)
                            break;
                    }
                }
                if (count == 9)
                    intensity.add(sumOfIntensity/9);
            }
        }

        return image;
    }

}

/* Problem #1:
public int returnToBoundaryCount(int[] nums) {
        int boundaryCount = 0;
        int currentPosition = 0;
        for (int i=0; i<nums.length; i++)   {
            currentPosition += nums[i];
            if (currentPosition == 0)
                boundaryCount++;
        }
        return boundaryCount;
    }
 */
