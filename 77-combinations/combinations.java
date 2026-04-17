class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> arr=new ArrayList<>();
        back(1,arr,new ArrayList<>(),k,n);
        return arr;
    }
    static void back(int start,List<List<Integer>> arr,List<Integer> path,int k,int n){
        if(path.size()==k){
            arr.add(new ArrayList<>(path));
            return;
        }
        for(int i=start;i<=n;i++){
            path.add(i);
            back(i+1,arr,path,k,n);
            path.remove(path.size()-1);
        }
    }
}