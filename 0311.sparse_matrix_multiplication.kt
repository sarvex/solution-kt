internal class Solution {
  fun multiply(mat1: Array<IntArray>, mat2: Array<IntArray>): Array<IntArray> {
    val m = mat1.size
    val n = mat2[0].size
    val ans = Array(m) { IntArray(n) }
    val g1 = f(mat1)
    val g2 = f(mat2)
    for (i in 0 until m) {
      for (p in g1[i]!!) {
        val k = p[0]
        val x = p[1]
        for (q in g2[k]!!) {
          val j = q[0]
          val y = q[1]
          ans[i][j] += x * y
        }
      }
    }
    return ans
  }

  private fun f(mat: Array<IntArray>): Array<List<IntArray>?> {
    val m = mat.size
    val n = mat[0].size
    val g: Array<List<IntArray>?> = arrayOfNulls(m)
    Arrays.setAll(g) { i -> ArrayList() }
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (mat[i][j] != 0) {
          g[i].add(intArrayOf(j, mat[i][j]))
        }
      }
    }
    return g
  }
}
