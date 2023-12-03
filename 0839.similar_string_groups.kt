internal class Solution {
  private var p: IntArray
  fun numSimilarGroups(strs: Array<String>): Int {
    val n = strs.size
    p = IntArray(n)
    for (i in 0 until n) {
      p[i] = i
    }
    for (i in 0 until n) {
      for (j in i + 1 until n) {
        if (check(strs[i], strs[j])) {
          p[find(i)] = find(j)
        }
      }
    }
    var ans = 0
    for (i in 0 until n) {
      if (i == find(i)) {
        ++ans
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

  private fun check(a: String, b: String): Boolean {
    var cnt = 0
    for (i in 0 until a.length) {
      if (a[i] != b[i]) {
        ++cnt
      }
    }
    return cnt <= 2
  }
}
