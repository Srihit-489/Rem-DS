
class Solution{
    static int maxLength(String S){
         Stack<Integer> stack = new Stack<Integer>();
         stack.push(-1);
         int result = 0;
         for(int i = 0;i<S.length();i++){
             char ch = S.charAt(i);
             if(ch == '(')
                 stack.add(i);
                 else{
                     if(!stack.empty())
                         stack.pop();
                         
                         if(!stack.empty())
                             result = Math.max(result,i-stack.peek());
                         else
                             stack.push(i);
                     
                 }
         }
         
         return result;
    }
}
