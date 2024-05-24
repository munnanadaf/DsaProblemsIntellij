package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// from leaves to root, just reverse the normal level order traversal result
class BottomUpLevelOrderTraversal {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> subRes = new ArrayList<>();
            for(int i = 0;i<size;i++){
                TreeNode curNode = q.poll();
                if(curNode != null){    
                    subRes.add(curNode.val);
                    if(curNode.left != null)
                        q.offer(curNode.left);
                    if(curNode.right != null);
                        q.offer(curNode.right);
                }
            }
            if(subRes.size()>0)
                res.add(0,subRes);
        }
        return res;
    }
}