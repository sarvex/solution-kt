import java.util.TreeMap

class Solution {
  fun minAreaRect(points: Array<IntArray>): Int {
    val d: TreeMap<Int, List<Int>> = TreeMap()
    for (p in points) {
      val x = p[0]
      val y = p[1]
      d.computeIfAbsent(x) { k -> ArrayList() }.add(y)
    }
    val pos: Map<Int, Int> = HashMap()
    var ans = 1 shl 30
    for (e in d.entrySet()) {
      val x: Int = e.getKey()
      val ys: Unit = e.getValue()
      Collections.sort(ys)
      val n: Int = ys.size()
      for (i in 0 until n) {
        val y1: Int = ys.get(i)
        for (j in i + 1 until n) {
          val y2: Int = ys.get(j)
          val p = y1 * 40001 + y2
          if (pos.containsKey(p)) {
            ans = Math.min(ans, (x - pos[p]!!) * (y2 - y1))
          }
          pos.put(p, x)
        }
      }
    }
    return if (ans == 1 shl 30) 0 else ans
  }
}
