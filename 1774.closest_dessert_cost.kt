class Solution {
  private val arr: List<Int> = ArrayList()
  private var ts: IntArray
  private val inf = 1 shl 30
  fun closestCost(baseCosts: IntArray, toppingCosts: IntArray, target: Int): Int {
    ts = toppingCosts
    dfs(0, 0)
    Collections.sort(arr)
    var d = inf
    var ans = inf
    for (x in baseCosts) {
      for (y in arr) {
        val i = search(target - x - y)
        for (j in intArrayOf(i, i - 1)) {
          if (j >= 0 && j < arr.size()) {
            val t = Math.abs(x + y + arr[j] - target)
            if (d > t || d == t && ans > x + y + arr[j]) {
              d = t
              ans = x + y + arr[j]
            }
          }
        }
      }
    }
    return ans
  }

  private fun search(x: Int): Int {
    var left = 0
    var right: Int = arr.size()
    while (left < right) {
      val mid = left + right shr 1
      if (arr[mid] >= x) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }

  private fun dfs(i: Int, t: Int) {
    if (i >= ts.size) {
      arr.add(t)
      return
    }
    dfs(i + 1, t)
    dfs(i + 1, t + ts[i])
  }
}
