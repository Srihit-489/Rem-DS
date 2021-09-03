class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie T = new Trie();
        for(String str : dictionary)
            T.insert(str);
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String word : words){
            String output = T.search(word);
            sb.append(output+" ");
        }
        sb.deleteCharAt(sb.length()-1);
        
        return sb.toString();
    }
    
    class Trie{
        node root;
        
        public Trie(){
            root = new node('*');
        }
        
        public String search(String word){
            node runner = root;
            for(int i = 0 ; i < word.length() ; i++){
                if(runner.myhash.containsKey(word.charAt(i))){
                    runner = runner.myhash.get(word.charAt(i));
                    if(runner.iscompleted){
                        return word.substring(0,i+1);
                    }
                }else{
                    return word;
                }
            }
            
            return word;
        }
        
        public void insert(String str){
            node runner = root;
            for(int i= 0;i<str.length();i++){
                if(runner.myhash.containsKey(str.charAt(i)))
                    runner = runner.myhash.get(str.charAt(i));
                else{
                    node newnode = new node(str.charAt(i));
                    runner.myhash.put(str.charAt(i),newnode);
                    runner = newnode;
                }
            }
            
            runner.iscompleted = true;
            return;
        }
    }
    
    class node{
        char ch;
        HashMap<Character,node> myhash;
        boolean iscompleted;
        
        public node(char ch){
            this.ch = ch;
            this.myhash = new HashMap<Character,node>();
            this.iscompleted = false;
        }
    }
}
