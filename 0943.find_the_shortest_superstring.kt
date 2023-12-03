import kotlin.math.min

class Solution {
  fun shortestSuperstring(words: Array<String>): String {
    val n = words.size
    val g = Array(n) { IntArray(n) }
    for (i in 0 until n) {
      val a = words[i]
      for (j in 0 until n) {
        val b = words[j]
        if (i != j) {
          for (k in min(a.length.toDouble(), b.length.toDouble()) downTo 1) {
            if (a.substring(a.length - k) == b.substring(0, k)) {
              g[i][j] = k
              break
            }
          }
        }
      }
    }
    val dp = Array(1 shl n) { IntArray(n) }
    val p = Array(1 shl n) { IntArray(n) }
    for (i in 0 until (1 shl n)) {
      Arrays.fill(p[i], -1)
      for (j in 0 until n) {
        if (i shr j and 1 == 1) {
          val pi = i xor (1 shl j)
          for (k in 0 until n) {
            if (pi shr k and 1 == 1) {
              val v = dp[pi][k] + g[k][j]
              if (v > dp[i][j]) {
                dp[i][j] = v
                p[i][j] = k
              }
            }
          }
        }
      }
    }
    var j = 0
    for (i in 0 until n) {
      if (dp[(1 shl n) - 1][i] > dp[(1 shl n) - 1][j]) {
        j = i
      }
    }
    val arr: List<Int> = ArrayList()
    arr.add(j)
    run {
      var i = (1 shl n) - 1
      while (p[i][j] != -1) {
        val k = i
        i = i xor (1 shl j)
        j = p[k][j]
        arr.add(j)
      }
    }
    val vis: Set<Int> = HashSet(arr)
    for (i in 0 until n) {
      if (!vis.contains(i)) {
        arr.add(i)
      }
    }
    Collections.reverse(arr)
    val ans = StringBuilder(words[arr[0]])
    for (i in 1 until n) {
      val k = g[arr[i - 1]][arr[i]]
      ans.append(words[arr[i]].substring(k))
    }
    return ans.toString()
  }
}
