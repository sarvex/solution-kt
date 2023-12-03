internal class Solution {
  private var n = 0
  private val memo: Map<Long, Boolean> = HashMap()
  fun canWin(currentState: String): Boolean {
    var mask: Long = 0
    n = currentState.length
    for (i in 0 until n) {
      if (currentState[i] == '+') {
        mask = mask or (1 shl i).toLong()
      }
    }
    return dfs(mask)
  }

  private fun dfs(mask: Long): Boolean {
    if (memo.containsKey(mask)) {
      return memo[mask]!!
    }
    for (i in 0 until n - 1) {
      if (mask and (1 shl i).toLong() == 0L || mask and (1 shl i + 1).toLong() == 0L) {
        continue
      }
      if (dfs(mask xor (1 shl i).toLong() xor (1 shl i + 1).toLong())) {
        continue
      }
      memo.put(mask, true)
      return true
    }
    memo.put(mask, false)
    return false
  }
}
