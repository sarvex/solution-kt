internal class Solution {
  fun removeOnes(grid: Array<IntArray>): Boolean {
    val s: Set<String> = HashSet()
    val n = grid[0].size
    for (row in grid) {
      val cs = CharArray(n)
      for (i in 0 until n) {
        cs[i] = (row[0] xor row[i]).toChar()
      }
      s.add(String(cs))
    }
    return s.size() === 1
  }
}
