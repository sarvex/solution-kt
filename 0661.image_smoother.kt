internal class Solution {
  fun imageSmoother(img: Array<IntArray>): Array<IntArray> {
    val m = img.size
    val n = img[0].size
    val ans = Array(m) { IntArray(n) }
    for (i in 0 until m) {
      for (j in 0 until n) {
        var s = 0
        var cnt = 0
        for (x in i - 1..i + 1) {
          for (y in j - 1..j + 1) {
            if (x >= 0 && x < m && y >= 0 && y < n) {
              ++cnt
              s += img[x][y]
            }
          }
        }
        ans[i][j] = s / cnt
      }
    }
    return ans
  }
}
