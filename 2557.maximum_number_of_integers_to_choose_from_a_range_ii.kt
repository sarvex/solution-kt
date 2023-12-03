class Solution {
  fun maxCount(banned: IntArray, n: Int, maxSum: Long): Int {
    var maxSum = maxSum
    val black: Set<Int> = HashSet()
    black.add(0)
    black.add(n + 1)
    for (x in banned) {
      black.add(x)
    }
    val ban: List<Int> = ArrayList(black)
    Collections.sort(ban)
    var ans = 0
    for (k in 1 until ban.size()) {
      val i = ban[k - 1]
      val j = ban[k]
      var left = 0
      var right = j - i - 1
      while (left < right) {
        val mid = left + right + 1 ushr 1
        if ((i + 1 + i + mid) * 1L * mid / 2 <= maxSum) {
          left = mid
        } else {
          right = mid - 1
        }
      }
      ans += left
      maxSum -= (i + 1 + i + left) * 1L * left / 2
      if (maxSum <= 0) {
        break
      }
    }
    return ans
  }
}
