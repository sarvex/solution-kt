class Solution {
  fun rankTeams(votes: Array<String>): String {
    val n = votes[0].length
    val cnt = Array(26) { IntArray(n) }
    for (vote in votes) {
      for (i in 0 until n) {
        cnt[vote[i].code - 'A'.code][i]++
      }
    }
    val cs = arrayOfNulls<Char>(n)
    for (i in 0 until n) {
      cs[i] = votes[0][i]
    }
    Arrays.sort(cs) { a, b ->
      val i: Int = a - 'A'
      val j: Int = b - 'A'
      for (k in 0 until n) {
        val d = cnt[i][k] - cnt[j][k]
        if (d != 0) {
          return@sort if (d > 0) -1 else 1
        }
      }
      a - b
    }
    val ans = StringBuilder()
    for (c in cs) {
      ans.append(c)
    }
    return ans.toString()
  }
}
