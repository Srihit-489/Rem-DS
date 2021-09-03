class Trie {
     node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new node('*');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        node runner = root;
        for(int i = 0;i<word.length();i++){
            char ch = word.charAt(i);
            if(runner.myhash.containsKey(ch)){
                runner = runner.myhash.get(ch);
            }else{
                node newnode = new node(ch);
                runner.myhash.put(ch,newnode);
                runner = newnode;
            }
        }
        
        runner.iscompleted = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        node runner = root;
        for(int i = 0;i<word.length();i++){
            if(runner.myhash.containsKey(word.charAt(i))){
                runner = runner.myhash.get(word.charAt(i));
            }else{
                return false;
            }
        }
        
        if(!runner.iscompleted)
            return false;
        
        return true;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        node runner = root;
        for(int i = 0;i<prefix.length();i++){
            if(runner.myhash.containsKey(prefix.charAt(i))){
                runner = runner.myhash.get(prefix.charAt(i));
            }else{
                return false;
            }
        }
        
       
            
        
     
