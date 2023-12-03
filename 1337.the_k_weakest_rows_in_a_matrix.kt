class Solution {
  fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
    val m = mat.size
    val n = mat[0].size
    val res = IntArray(m)
    val idx: List<Int> = ArrayList()
    for (i in 0 until m) {
      idx.add(i)
      val row = mat[i]
      var left = 0
      var right = n
      while (left < right) {
        val mid = left + right shr 1
        if (row[mid] == 0) {
          right = mid
        } else {
          left = mid + 1
        }
      }
      res[i] = left
    }
    idx.sort(Comparator.comparingInt { a -> res[a] })
    val ans = IntArray(k)
    for (i in 0 until k) {
      ans[i] = idx[i]
    }
    return ans
  }
}
