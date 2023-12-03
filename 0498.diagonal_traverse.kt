internal class Solution {
  fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
    val m = mat.size
    val n = mat[0].size
    val ans = IntArray(m * n)
    var idx = 0
    val t: List<Int> = ArrayList()
    for (k in 0 until m + n - 1) {
      var i = if (k < n) 0 else k - n + 1
      var j = if (k < n) k else n - 1
      while (i < m && j >= 0) {
        t.add(mat[i][j])
        ++i
        --j
      }
      if (k % 2 == 0) {
        Collections.reverse(t)
      }
      for (v in t) {
        ans[idx++] = v
      }
      t.clear()
    }
    return ans
  }
}
