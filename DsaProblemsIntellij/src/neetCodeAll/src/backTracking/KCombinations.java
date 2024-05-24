package backTracking;

import java.util.ArrayList;
import java.util.List;

class KCombinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		helpCombinate(1, n, k, res, new ArrayList<Integer>());
		return res;
	}
	public void helpCombinate(int curN, int N, int k, List<List<Integer>> res, List<Integer> subRes) {
		if (subRes.size() == k) {
			res.add(new ArrayList<>(subRes));
			return;
		}
		if (curN > N)
			return;
		subRes.add(curN);
		helpCombinate(curN + 1, N, k, res, subRes);
		subRes.remove(subRes.size() - 1);
		helpCombinate(curN + 1, N, k, res, subRes);
	}
}