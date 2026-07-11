class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int sumA = 0;
        int sumB = 0;

        for (int x : aliceSizes)
            sumA += x;

        for (int x : bobSizes)
            sumB += x;

        int diff = (sumA - sumB) / 2;

        HashSet<Integer> set = new HashSet<>();

        for (int x : bobSizes)
            set.add(x);

        for (int x : aliceSizes) {
            int need = x - diff;

            if (set.contains(need))
                return new int[]{x, need};
        }

        return new int[]{};
    }
}
