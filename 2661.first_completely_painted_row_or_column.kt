class Solution {
  fun firstCompleteIndex(arr: IntArray, mat: Array<IntArray>): Int {
    val m = mat.size
    val n = mat[0].size
    val idx: Map<Int, IntArray> = HashMap()
    for (i in 0 until m) {
      for (j in 0 until n) {
        idx.put(mat[i][j], intArrayOf(i, j))
      }
    }
    val row = IntArray(m)
    val col = IntArray(n)
    var k = 0
    while (true) {
      val x: Unit = idx[arr[k]]
      val i: Int = x.get(0)
      val j: Int = x.get(1)
      ++row[i]
      ++col[j]
      if (row[i] == n || col[j] == m) {
        return k
      }
      ++k
    }
  }
}
