class Solution {
  fun canChoose(groups: Array<IntArray>, nums: IntArray): Boolean {
    val n = groups.size
    val m = nums.size
    var i = 0
    var j = 0
    while (i < n && j < m) {
      if (check(groups[i], nums, j)) {
        j += groups[i].size
        ++i
      } else {
        ++j
      }
    }
    return i == n
  }

  private fun check(a: IntArray, b: IntArray, j: Int): Boolean {
    var j = j
    val m = a.size
    val n = b.size
    var i = 0
    while (i < m && j < n) {
      if (a[i] != b[j]) {
        return false
      }
      ++i
      ++j
    }
    return i == m
  }
}
