class Solution {
  fun minDeletionSize(strs: Array<String>): Int {
    val m = strs[0].length
    val n = strs.size
    var ans = 0
    for (j in 0 until m) {
      for (i in 1 until n) {
        if (strs[i][j] < strs[i - 1][j]) {
          ++ans
          break
        }
      }
    }
    return ans
  }
}
