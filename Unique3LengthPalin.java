class Solution {
    public int countPalindromicSubsequence(String s) {
        HashMap<Character,int[]> myhash = new HashMap<Character,int[]>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(myhash.containsKey(ch)){
                myhash.get(ch)[1] = i;
            }else{
                int[] cur = new int[2];
                cur[0] = i;
                cur[1] = -1;
                myhash.put(ch,cur);
            }
        }
        int count = 0;
        for(int i = 0;i<s.length();i++){
            char start = s.charAt(i);
            if(!myhash.containsKey(start))
                continue;
            if(myhash.get(start)[1] == -1){
                myhash.remove(start);
                continue;
            }
            int[] range = myhash.get(start);
            count = count + getunique(s,range);
            myhash.remove(start);
        }
        
        return count;
    }
    
    public int getunique(String s,int[] range){
        HashSet<Character> unique = new HashSet<Character>();
        for(int i = range[0]+1 ; i < range[1] ; i++){
            unique.add(s.charAt(i));
        }
        return unique.size();
    }
}
