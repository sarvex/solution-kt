import kotlin.math.max

class Solution {
  fun minimumTeachings(n: Int, languages: Array<IntArray>, friendships: Array<IntArray>): Int {
    val s: Set<Int> = HashSet()
    for (e in friendships) {
      val u = e[0]
      val v = e[1]
      if (!check(u, v, languages)) {
        s.add(u)
        s.add(v)
      }
    }
    if (s.isEmpty()) {
      return 0
    }
    val cnt = IntArray(n + 1)
    for (u in s) {
      for (l in languages[u - 1]) {
        ++cnt[l]
      }
    }
    var mx = 0
    for (v in cnt) {
      mx = max(mx.toDouble(), v.toDouble()).toInt()
    }
    return s.size() - mx
  }

  private fun check(u: Int, v: Int, languages: Array<IntArray>): Boolean {
    for (x in languages[u - 1]) {
      for (y in languages[v - 1]) {
        if (x == y) {
          return true
        }
      }
    }
    return false
  }
}
