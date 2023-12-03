internal class Solution {
  fun leastBricks(wall: List<List<Int>>): Int {
    val cnt: Map<Int, Int> = HashMap()
    for (row in wall) {
      var width = 0
      var i = 0
      val n: Int = row.size() - 1
      while (i < n) {
        width += row[i]
        cnt.merge(width, 1) { a: Int, b: Int -> Integer.sum(a, b) }
        i++
      }
    }
    val max: Int = cnt.values().stream().max(Comparator.naturalOrder()).orElse(0)
    return wall.size() - max
  }
}
