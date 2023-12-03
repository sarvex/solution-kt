class Solution {
  fun kthSmallest(mat: Array<IntArray>, k: Int): Int {
    val m = mat.size
    val n = mat[0].size
    val pre: List<Int> = ArrayList(k)
    val cur: List<Int> = ArrayList(n * k)
    pre.add(0)
    for (row in mat) {
      cur.clear()
      for (a in pre) {
        for (b in row) {
          cur.add(a + b)
        }
      }
      Collections.sort(cur)
      pre.clear()
      for (i in 0 until Math.min(k, cur.size())) {
        pre.add(cur[i])
      }
    }
    return pre[k - 1]
  }
}
