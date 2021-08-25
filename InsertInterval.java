class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> mylist = new ArrayList<>();
        mylist.add(new int[]{newInterval[0],0});
        mylist.add(new int[]{newInterval[1],1});
        for(int[] arr : intervals){
            mylist.add(new int[]{arr[0],0});
            mylist.add(new int[]{arr[1],1});
        }
        Collections.sort(mylist,(a,b)->a[0] - b[0]);
        int current = -1;
        int count = 0;
        List<int[]> finallist = new ArrayList<>();
        for(int[] cur : mylist){
            if(current == -1){
                current = cur[0];
                count++;
            }else{
                count += cur[1] == 0 ? 1 : -1;
            }
            
            if(count == 0){
                finallist.add(new int[]{current,cur[0]});
                current = -1;
            }
        }
        for(int i =0;i<finallist.size()-1;i++){
            if(finallist.get(i)[1] == finallist.get(i+1)[0]){
                int[] removed = finallist.remove(i+1);
                finallist.get(i)[1] = removed[1];
                i = 0;
            }
        }
        int[][] ret = new int[finallist.size()][2];
        int i = 0;
        for(int[] cur : finallist){
            ret[i] = cur;
            i++;
        }
        return ret;
    }
}
