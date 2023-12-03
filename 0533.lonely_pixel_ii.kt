internal class Solution {
  fun findBlackPixel(picture: Array<CharArray>, target: Int): Int {
    val m = picture.size
    val n = picture[0].size
    val rows = IntArray(m)
    val cols: Map<Int, List<Int>> = HashMap()
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (picture[i][j] == 'B') {
          ++rows[i]
          cols.computeIfAbsent(j) { k -> ArrayList() }.add(i)
        }
      }
    }
    val t = Array(m) { BooleanArray(m) }
    for (i in 0 until m) {
      for (k in i until m) {
        t[i][k] = i == k || all(picture[i], picture[k])
        t[k][i] = t[i][k]
      }
    }
    var res = 0
    for (i in 0 until m) {
      if (rows[i] == target) {
        for (j in 0 until n) {
          val col = cols[j]
          if (col != null && col.size() === target) {
            var check = true
            for (k in col) {
              check = check && t[i][k]
            }
            if (check) {
              ++res
            }
          }
        }
      }
    }
    return res
  }

  private fun all(row1: CharArray, row2: CharArray): Boolean {
    val n = row1.size
    for (j in 0 until n) {
      if (row1[j] != row2[j]) {
        return false
      }
    }
    return true
  }
}
