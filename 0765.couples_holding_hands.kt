internal class Solution {
  private var p: IntArray
  fun minSwapsCouples(row: IntArray): Int {
    val n = row.size shr 1
    p = IntArray(n)
    for (i in 0 until n) {
      p[i] = i
    }
    run {
      var i = 0
      while (i < n shl 1) {
        val a = row[i] shr 1
        val b = row[i + 1] shr 1
        p[find(a)] = find(b)
        i += 2
      }
    }
    var ans = n
    for (i in 0 until n) {
      if (i == find(i)) {
        --ans
      }
    }
    return ans
  }

  private fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }
}
