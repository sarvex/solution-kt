internal class Solution {
  fun scoreOfStudents(s: String, answers: IntArray): Int {
    val n = s.length
    val x = cal(s)
    val m = n + 1 shr 1
    val f: Array<Array<Set<Int>?>> = Array<Array<Set?>>(m) { arrayOfNulls(m) }
    for (i in 0 until m) {
      for (j in 0 until m) {
        f[i][j] = HashSet()
      }
      f[i][i].add(s[i shl 1].code - '0'.code)
    }
    for (i in m - 1 downTo 0) {
      for (j in i until m) {
        for (k in i until j) {
          for (l in f[i][k]!!) {
            for (r in f[k + 1][j]!!) {
              val op = s[k shl 1 or 1]
              if (op == '+' && l + r <= 1000) {
                f[i][j].add(l + r)
              } else if (op == '*' && l * r <= 1000) {
                f[i][j].add(l * r)
              }
            }
          }
        }
      }
    }
    val cnt = IntArray(1001)
    for (ans in answers) {
      ++cnt[ans]
    }
    var ans = 5 * cnt[x]
    for (i in 0..1000) {
      if (i != x && f[0][m - 1]!!.contains(i)) {
        ans += 2 * cnt[i]
      }
    }
    return ans
  }

  private fun cal(s: String): Int {
    var res = 0
    var pre = s[0].code - '0'.code
    var i = 1
    while (i < s.length) {
      val op = s[i]
      val cur = s[i + 1].code - '0'.code
      if (op == '*') {
        pre *= cur
      } else {
        res += pre
        pre = cur
      }
      i += 2
    }
    res += pre
    return res
  }
}
