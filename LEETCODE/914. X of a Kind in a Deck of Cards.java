class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency of each card
        for (int card : deck) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        int gcd = 0;

        // Find GCD of all frequencies
        for (int freq : map.values()) {
            gcd = findGCD(gcd, freq);
        }

        return gcd > 1;
    }

    private int findGCD(int a, int b) {//for finding GCD ONLY gcd(2,3)=1
        while (b != 0) {
            int temp = b;//3,2,1
            b = a % b;//2,1
            a = temp;//3,2
        }
        return a;
    }
}
