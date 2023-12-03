class Solution {
  fun mostSimilar(n: Int, roads: Array<IntArray>, names: Array<String>, targetPath: Array<String>): List<Int> {
    val g: Array<List<Int>?> = arrayOfNulls(n)
    Arrays.setAll(g) { i -> ArrayList() }
    for (r in roads) {
      val a = r[0]
      val b = r[1]
      g[a].add(b)
      g[b].add(a)
    }
    val m = targetPath.size
    val inf = 1 shl 30
    val f = Array(m) { IntArray(n) }
    val pre = Array(m) { IntArray(n) }
    for (i in 0 until m) {
      Arrays.fill(f[i], inf)
      Arrays.fill(pre[i], -1)
    }
    for (j in 0 until n) {
      f[0][j] = if (targetPath[0] == names[j]) 0 else 1
    }
    for (i in 1 until m) {
      for (j in 0 until n) {
        for (k in g[j]!!) {
          val t = f[i - 1][k] + if (targetPath[i] == names[j]) 0 else 1
          if (t < f[i][j]) {
            f[i][j] = t
            pre[i][j] = k
          }
        }
      }
    }
    var mi = inf
    var k = 0
    for (j in 0 until n) {
      if (f[m - 1][j] < mi) {
        mi = f[m - 1][j]
        k = j
      }
    }
    val ans: List<Int> = ArrayList()
    for (i in m - 1 downTo 0) {
      ans.add(k)
      k = pre[i][k]
    }
    Collections.reverse(ans)
    return ans
  }
}
