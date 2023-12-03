internal class Solution {
  fun maxEqualRowsAfterFlips(matrix: Array<IntArray>): Int {
    val cnt: Map<String, Int> = HashMap()
    var ans = 0
    val n = matrix[0].size
    for (row in matrix) {
      val cs = CharArray(n)
      for (i in 0 until n) {
        cs[i] = (row[0] xor row[i]).toChar()
      }
      ans = Math.max(ans, cnt.merge(String(cs), 1) { a: Int, b: Int -> Integer.sum(a, b) })
    }
    return ans
  }
}
