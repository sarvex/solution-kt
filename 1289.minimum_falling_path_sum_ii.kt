class Solution {
  fun minFallingPathSum(grid: Array<IntArray>): Int {
    var f = 0
    var g = 0
    var fp = -1
    val inf = 1 shl 30
    for (row in grid) {
      var ff = inf
      var gg = inf
      var ffp = -1
      for (j in row.indices) {
        val s = (if (j != fp) f else g) + row[j]
        if (s < ff) {
          gg = ff
          ff = s
          ffp = j
        } else if (s < gg) {
          gg = s
        }
      }
      f = ff
      g = gg
      fp = ffp
    }
    return f
  }
}
