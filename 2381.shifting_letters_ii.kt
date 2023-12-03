class Solution {
  fun shiftingLetters(s: String, shifts: Array<IntArray>): String {
    val n = s.length
    val d = IntArray(n + 1)
    for (e in shifts) {
      if (e[2] == 0) {
        e[2]--
      }
      d[e[0]] += e[2]
      d[e[1] + 1] -= e[2]
    }
    for (i in 1..n) {
      d[i] += d[i - 1]
    }
    val ans = StringBuilder()
    for (i in 0 until n) {
      val j = (s[i].code - 'a'.code + d[i] % 26 + 26) % 26
      ans.append(('a'.code + j).toChar())
    }
    return ans.toString()
  }
}
