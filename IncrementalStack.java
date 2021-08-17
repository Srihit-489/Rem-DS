class CustomStack {
    int size = 0;
    List<Integer> mylist;

    public CustomStack(int maxSize) {
        size = maxSize;
        mylist = new ArrayList<Integer>(size);
    }
    
    public void push(int x) {
        if(mylist.size() < size){
            mylist.add(x);
        }
        
    }
    
    public int pop() {
        if(mylist.size()==0)
            return -1;
        int ret = mylist.get(mylist.size()-1);
        mylist.remove(mylist.size()-1);
        return ret;
    }
    
    public void increment(int k, int val) {
        if(mylist.size() <= k){
            for(int i=0;i<mylist.size();i++){
                mylist.set(i,mylist.get(i)+val);
            }
        }else{
            int n = 0;
            while(k > 0){
                mylist.set(n,mylist.get(n)+val);
                n++;
                k--;
            }
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
