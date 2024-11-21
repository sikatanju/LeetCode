public class MaximumEnergyBoostFromTwoDrinks {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        long sumA = 0, sumB = 0;
        for (int i=0; i<energyDrinkA.length; i++)   {
            long aa = Math.max(sumA+energyDrinkA[i], sumB);
            long bb = Math.max(sumB+energyDrinkB[i], sumA);
            sumA = aa;
            sumB = bb;
        }
        return Math.max(sumA, sumB);
    }
}
