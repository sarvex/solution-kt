import kotlin.math.max

class Solution {
  fun maxIncreasingCells(mat: Array<IntArray>): Int {
    val m = mat.size
    val n = mat[0].size
    val g: TreeMap<Int, List<IntArray>> = TreeMap()
    for (i in 0 until m) {
      for (j in 0 until n) {
        g.computeIfAbsent(mat[i][j]) { k -> ArrayList() }.add(intArrayOf(i, j))
      }
    }
    val rowMax = IntArray(m)
    val colMax = IntArray(n)
    var ans = 0
    for (e in g.entrySet()) {
      val pos: Unit = e.getValue()
      val mx = IntArray(pos.size())
      var k = 0
      for (p in pos) {
        val i: Int = p.get(0)
        val j: Int = p.get(1)
        mx[k] = (max(rowMax[i].toDouble(), colMax[j].toDouble()) + 1).toInt()
        ans = max(ans.toDouble(), mx[k++].toDouble()).toInt()
      }
      k = 0
      while (k < mx.size) {
        val i: Int = pos.get(k).get(0)
        val j: Int = pos.get(k).get(1)
        rowMax[i] = max(rowMax[i].toDouble(), mx[k].toDouble()).toInt()
        colMax[j] = max(colMax[j].toDouble(), mx[k].toDouble()).toInt()
        ++k
      }
    }
    return ans
  }
}
