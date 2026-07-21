class Solution {
    public int maxProfit(int[] prices) {
        int minEl=prices[0];
        int ans=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<minEl) minEl=prices[i];
            else if(prices[i]>minEl){
                ans=Math.max(ans,prices[i]-minEl);
            }
        }
        return ans;
    }
}