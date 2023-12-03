class Solution {
  private val memo: Map<Int, Boolean> = HashMap()
  private val p = IntArray(8)

  init {
    p[0] = 1
    for (i in 1..7) {
      p[i] = p[i - 1] * 8
    }
  }

  fun nimGame(piles: IntArray): Boolean {
    return dfs(piles)
  }

  private fun dfs(piles: IntArray): Boolean {
    val st = f(piles)
    if (memo.containsKey(st)) {
      return memo[st]!!
    }
    for (i in piles.indices) {
      for (j in 1..piles[i]) {
        piles[i] -= j
        if (!dfs(piles)) {
          piles[i] += j
          memo.put(st, true)
          return true
        }
        piles[i] += j
      }
    }
    memo.put(st, false)
    return false
  }

  private fun f(piles: IntArray): Int {
    var st = 0
    for (i in piles.indices) {
      st += piles[i] * p[i]
    }
    return st
  }
}
