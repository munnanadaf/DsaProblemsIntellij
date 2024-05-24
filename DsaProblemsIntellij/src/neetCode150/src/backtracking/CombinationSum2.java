package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSum2 {
     public List<List<Integer>> combinationSum2(int[] cand, int target) {
        Arrays.sort(cand);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> subRes = new ArrayList<Integer>();
        dfs(cand, 0, target, subRes, res);
    return res;
}
void dfs(int[] cand, int cur, int target, List<Integer> subRes, List<List<Integer>> res) {
    if (target == 0) {
        res.add(new ArrayList(subRes));
        return ;
    }
    if (target < 0) return;
    for (int i = cur; i < cand.length; i++){
        // avoiding duplicates, except first element
        if (i > cur && cand[i] == cand[i-1]) 
            continue;
        subRes.add(subRes.size(), cand[i]);
        dfs(cand, i+1, target - cand[i], subRes, res);
        subRes.remove(subRes.size()-1);
    }
}
}