class Solution {
    public int largestAltitude(int[] gain) {

        int current = 0;
        int highest = 0;

        for (int g : gain) {
            current += g;
            highest = Math.max(highest, current);
        }

        return highest;
    }
}