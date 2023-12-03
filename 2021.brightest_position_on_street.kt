internal class Solution {
  fun brightestPosition(lights: Array<IntArray>): Int {
    val d: TreeMap<Int, Int> = TreeMap()
    for (x in lights) {
      val l = x[0] - x[1]
      val r = x[0] + x[1]
      d.merge(l, 1) { a: Int, b: Int -> Integer.sum(a, b) }
      d.merge(r + 1, -1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    var ans = 0
    var s = 0
    var mx = 0
    for (x in d.entrySet()) {
      val v: Int = x.getValue()
      s += v
      if (mx < s) {
        mx = s
        ans = x.getKey()
      }
    }
    return ans
  }
}
