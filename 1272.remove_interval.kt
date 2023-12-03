internal class Solution {
  fun removeInterval(intervals: Array<IntArray>, toBeRemoved: IntArray): List<List<Int>> {
    val x = toBeRemoved[0]
    val y = toBeRemoved[1]
    val ans: List<List<Int>> = ArrayList()
    for (e in intervals) {
      val a = e[0]
      val b = e[1]
      if (a >= y || b <= x) {
        ans.add(Arrays.asList(a, b))
      } else {
        if (a < x) {
          ans.add(Arrays.asList(a, x))
        }
        if (b > y) {
          ans.add(Arrays.asList(y, b))
        }
      }
    }
    return ans
  }
}
