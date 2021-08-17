class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> s1 = new Stack<Character>();
        Stack<Character> s2 = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                s1.push(s.charAt(i));
            }else{
                if(s1.size()!= 0)
                    s1.pop();
                else
                    s2.push(s.charAt(i));
            }
        }
        return s1.size()+s2.size();
    }
}
