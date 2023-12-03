class Solution {
  fun digArtifacts(n: Int, artifacts: Array<IntArray>, dig: Array<IntArray>): Int {
    val s: Set<Int> = HashSet()
    for (d in dig) {
      s.add(d[0] * n + d[1])
    }
    var ans = 0
    for (a in artifacts) {
      if (check(a, s, n)) {
        ++ans
      }
    }
    return ans
  }

  private fun check(a: IntArray, s: Set<Int>, n: Int): Boolean {
    val r1 = a[0]
    val c1 = a[1]
    val r2 = a[2]
    val c2 = a[3]
    for (i in r1..r2) {
      for (j in c1..c2) {
        if (!s.contains(i * n + j)) {
          return false
        }
      }
    }
    return true
  }
}
