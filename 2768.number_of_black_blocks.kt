class Solution {
  fun countBlackBlocks(m: Int, n: Int, coordinates: Array<IntArray>): LongArray {
    val cnt: Map<Long, Int> = HashMap(coordinates.size)
    val dirs = intArrayOf(0, 0, -1, -1, 0)
    for (e in coordinates) {
      val x = e[0]
      val y = e[1]
      for (k in 0..3) {
        val i = x + dirs[k]
        val j = y + dirs[k + 1]
        if (i >= 0 && i < m - 1 && j >= 0 && j < n - 1) {
          cnt.merge(1L * i * n + j, 1) { a: Int, b: Int -> Integer.sum(a, b) }
        }
      }
    }
    val ans = LongArray(5)
    ans[0] = (m - 1L) * (n - 1)
    for (x in cnt.values()) {
      ++ans[x]
      --ans[0]
    }
    return ans
  }
}
