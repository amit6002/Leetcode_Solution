class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0)
            return true;
        int lastFlowerIndex = flowerbed[0] == 1 ? 0 : -1;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 &&
                    (i == 0 || flowerbed[i - 1] == 0) &&
                    (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {

                n--;
                lastFlowerIndex = i;
                flowerbed[i] = 1;
            }
            if (n == 0)
                break;
        }

        return n == 0 ? true : false;
    }
}