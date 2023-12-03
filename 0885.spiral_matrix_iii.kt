internal class Solution {
  fun spiralMatrixIII(rows: Int, cols: Int, rStart: Int, cStart: Int): Array<IntArray> {
    var rStart = rStart
    var cStart = cStart
    val cnt = rows * cols
    val ans = Array(cnt) { IntArray(2) }
    ans[0] = intArrayOf(rStart, cStart)
    if (cnt == 1) {
      return ans
    }
    var k = 1
    var idx = 1
    while (true) {
      val dirs = arrayOf(intArrayOf(0, 1, k), intArrayOf(1, 0, k), intArrayOf(0, -1, k + 1), intArrayOf(-1, 0, k + 1))
      for (dir in dirs) {
        val r = dir[0]
        val c = dir[1]
        var dk = dir[2]
        while (dk-- > 0) {
          rStart += r
          cStart += c
          if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
            ans[idx++] = intArrayOf(rStart, cStart)
            if (idx == cnt) {
              return ans
            }
          }
        }
      }
      k += 2
    }
  }
}
