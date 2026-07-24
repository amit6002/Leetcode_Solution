class Solution {
    public int characterReplacement(String s, int k) {
        int left=0;
        int maxF=0;
        int ans=0;
        int arr[]=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'A']++;
            maxF=Math.max(maxF,arr[s.charAt(i)-'A']);
            while((i-left+1)-maxF >k){
                arr[s.charAt(left)-'A']--;
                left++;
            }
            ans=Math.max(ans,i-left+1);
        }
        return ans;
    }
}