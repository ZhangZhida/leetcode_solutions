

public class Solution {
    public List<List<Integer>> combinations(int target, int[] coins) {
      // Write your solution here
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      List<Integer> comb = new ArrayList<>();
      DFS(coins, comb, 0, 0, target, result);
      return result;
    }
    
    public void DFS(int[] coins, List<Integer> comb, int index, int sum, int target, List<List<Integer>> result) {
      
      int coin = coins[index];
      int num = (target - sum) / coin;
      if (index == coins.length - 1) {
        if ((target - sum) % coin == 0) {
          comb.add((target - sum) / coin);
          List<Integer> newComb = new ArrayList<>(comb);
          result.add(newComb);
          comb.remove(comb.size() - 1);
        }
        return;
      }
      for (int i = 0; i <= num; i++) {
        comb.add(i);
        DFS(coins, comb, index + 1, sum + coin * i, target, result);
        comb.remove(comb.size() - 1);
      }
    }
  }