class Solution {
    public boolean isSubsequence(String s, String t) {
        char ch[]= s.toCharArray();
        char ch1[]=t.toCharArray();
   
        int i=0;int j=0;
        while(i<ch.length &&j<ch1.length){
            if(ch[i]==ch1[j]){
                i++;
            }
            j++;
        }
        return ch.length==i;
    }
}