class Solution {
  fun avoidFlood(rains: IntArray): IntArray {
    val n = rains.size
    val ans = IntArray(n)
    Arrays.fill(ans, -1)
    val sunny: TreeSet<Int> = TreeSet()
    val rainy: Map<Int, Int> = HashMap()
    for (i in 0 until n) {
      val v = rains[i]
      if (v > 0) {
        if (rainy.containsKey(v)) {
          val t: Int = sunny.higher(rainy[v]) ?: return IntArray(0)
          ans[t] = v
          sunny.remove(t)
        }
        rainy.put(v, i)
      } else {
        sunny.add(i)
        ans[i] = 1
      }
    }
    return ans
  }
}
