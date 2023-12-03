internal class DetectSquares {
  private val cnt: Map<Int, Map<Int, Int>> = HashMap()
  fun add(point: IntArray) {
    val x = point[0]
    val y = point[1]
    cnt.computeIfAbsent(x) { k -> HashMap() }.merge(y, 1) { a: Int, b: Int -> Integer.sum(a, b) }
  }

  fun count(point: IntArray): Int {
    val x1 = point[0]
    val y1 = point[1]
    if (!cnt.containsKey(x1)) {
      return 0
    }
    var ans = 0
    for (e in cnt.entrySet()) {
      val x2: Int = e.getKey()
      if (x2 != x1) {
        val d = x2 - x1
        val cnt1: Unit = cnt[x1]
        val cnt2: Unit = e.getValue()
        ans += (cnt2.getOrDefault(y1, 0) * cnt1.getOrDefault(y1 + d, 0)
            * cnt2.getOrDefault(y1 + d, 0))
        ans += (cnt2.getOrDefault(y1, 0) * cnt1.getOrDefault(y1 - d, 0)
            * cnt2.getOrDefault(y1 - d, 0))
      }
    }
    return ans
  }
}
