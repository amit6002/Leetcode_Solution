class Solution {
    public String reverseVowels(String s) {
        int i=0;int j=s.length()-1;
        char [] arr=s.toCharArray();
    Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
       

        while(i<j){
            char a = Character.toLowerCase(arr[i]);
            char b = Character.toLowerCase(arr[j]);
            if(set.contains(a) && set.contains(b)) {
                char temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
           if (!set.contains(a)) i++;
           else if (!set.contains(b)) j--;
           else {
                i++;
                j--;
            }

        }
        return new String(arr);
    }
}