class Solution {
  fun kthSmallestPath(destination: IntArray, k: Int): String {
    var k = k
    var v = destination[0]
    var h = destination[1]
    val n = v + h
    val c = Array(n + 1) { IntArray(h + 1) }
    c[0][0] = 1
    for (i in 1..n) {
      c[i][0] = 1
      for (j in 1..h) {
        c[i][j] = c[i - 1][j] + c[i - 1][j - 1]
      }
    }
    val ans = StringBuilder()
    for (i in n downTo 1) {
      if (h == 0) {
        ans.append('V')
      } else {
        val x = c[v + h - 1][h - 1]
        if (k > x) {
          ans.append('V')
          k -= x
          --v
        } else {
          ans.append('H')
          --h
        }
      }
    }
    return ans.toString()
  }
}
