class Solution {
  fun findFarmland(land: Array<IntArray>): Array<IntArray> {
    val ans: List<IntArray> = ArrayList()
    val m = land.size
    val n = land[0].size
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (land[i][j] == 0 || j > 0 && land[i][j - 1] == 1 || i > 0 && land[i - 1][j] == 1) {
          continue
        }
        var x = i
        var y = j
        while (x + 1 < m && land[x + 1][j] == 1) {
          ++x
        }
        while (y + 1 < n && land[x][y + 1] == 1) {
          ++y
        }
        ans.add(intArrayOf(i, j, x, y))
      }
    }
    return ans.toArray(Array(ans.size()) { IntArray(4) })
  }
}
