class Solution {
  fun maxCount(banned: IntArray, n: Int, maxSum: Int): Int {
    val ban: Set<Int> = HashSet(banned.size)
    for (x in banned) {
      ban.add(x)
    }
    var ans = 0
    var s = 0
    var i = 1
    while (i <= n && s + i <= maxSum) {
      if (!ban.contains(i)) {
        ++ans
        s += i
      }
      ++i
    }
    return ans
  }
}
