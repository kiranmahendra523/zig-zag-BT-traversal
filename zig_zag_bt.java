class Solution {
    void solve(TreeNode root , List<List<Integer>> ans ){
        Deque<TreeNode> qu = new ArrayDeque<>();
        qu.add(root);
        boolean lrflag = true;
        while(!qu.isEmpty()){
            int len = qu.size();
            int[] arr = new int[len];
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode curr = qu.poll();
                int index = lrflag ? i : len-i-1;
                arr[index]=curr.val;
                if (curr.left != null) qu.add(curr.left);
                if (curr.right != null) qu.add(curr.right);
                
            }
            for(int j : arr){
                temp.add(j);
            }
            ans.add(temp);
            lrflag = !(lrflag);
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        solve(root,ans);
        return ans;
    }
}
