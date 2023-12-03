internal class Solution {
  fun generateMatrix(n: Int): Array<IntArray> {
    val ans = Array(n) { IntArray(n) }
    var i = 0
    var j = 0
    var k = 0
    val dirs = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))
    for (v in 1..n * n) {
      ans[i][j] = v
      var x = i + dirs[k][0]
      var y = j + dirs[k][1]
      if (x < 0 || y < 0 || x >= n || y >= n || ans[x][y] > 0) {
        k = (k + 1) % 4
        x = i + dirs[k][0]
        y = j + dirs[k][1]
      }
      i = x
      j = y
    }
    return ans
  }
}
