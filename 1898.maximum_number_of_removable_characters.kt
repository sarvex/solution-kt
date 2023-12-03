class Solution {
  fun maximumRemovals(s: String, p: String, removable: IntArray): Int {
    var left = 0
    var right = removable.size
    while (left < right) {
      val mid = left + right + 1 shr 1
      if (check(s, p, removable, mid)) {
        left = mid
      } else {
        right = mid - 1
      }
    }
    return left
  }

  private fun check(s: String, p: String, removable: IntArray, mid: Int): Boolean {
    val m = s.length
    val n = p.length
    var i = 0
    var j = 0
    val ids: Set<Int> = HashSet()
    for (k in 0 until mid) {
      ids.add(removable[k])
    }
    while (i < m && j < n) {
      if (!ids.contains(i) && s[i] == p[j]) {
        ++j
      }
      ++i
    }
    return j == n
  }
}
