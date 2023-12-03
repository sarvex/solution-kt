internal class Solution {
  private val memo: Map<Int, Boolean> = HashMap()
  fun canIWin(maxChoosableInteger: Int, desiredTotal: Int): Boolean {
    val s = (1 + maxChoosableInteger) * maxChoosableInteger / 2
    return if (s < desiredTotal) {
      false
    } else dfs(0, 0, maxChoosableInteger, desiredTotal)
  }

  private fun dfs(state: Int, t: Int, maxChoosableInteger: Int, desiredTotal: Int): Boolean {
    if (memo.containsKey(state)) {
      return memo[state]!!
    }
    var res = false
    for (i in 1..maxChoosableInteger) {
      if (state shr i and 1 == 0) {
        if (t + i >= desiredTotal
          || !dfs(state or 1 shl i, t + i, maxChoosableInteger, desiredTotal)
        ) {
          res = true
          break
        }
      }
    }
    memo.put(state, res)
    return res
  }
}
