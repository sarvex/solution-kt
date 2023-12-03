import kotlin.math.max

class Solution {
  fun maxDepthBST(order: IntArray): Int {
    val tm: TreeMap<Int, Int> = TreeMap()
    tm.put(0, 0)
    tm.put(Int.MAX_VALUE, 0)
    tm.put(order[0], 1)
    var ans = 1
    for (i in 1 until order.size) {
      val v = order[i]
      val lower: Map.Entry<Int, Int> = tm.lowerEntry(v)
      val higher: Map.Entry<Int, Int> = tm.higherEntry(v)
      val depth: Int = 1 + Math.max(lower.getValue(), higher.getValue())
      ans = max(ans.toDouble(), depth.toDouble()).toInt()
      tm.put(v, depth)
    }
    return ans
  }
}
