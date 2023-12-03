class Solution {
  fun kthLargestValue(matrix: Array<IntArray>, k: Int): Int {
    val m = matrix.size
    val n = matrix[0].size
    val s = Array(m + 1) { IntArray(n + 1) }
    val ans: List<Int> = ArrayList()
    for (i in 0 until m) {
      for (j in 0 until n) {
        s[i + 1][j + 1] = s[i + 1][j] xor s[i][j + 1] xor s[i][j] xor matrix[i][j]
        ans.add(s[i + 1][j + 1])
      }
    }
    Collections.sort(ans)
    return ans[ans.size() - k]
  }
}
