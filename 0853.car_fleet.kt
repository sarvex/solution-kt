internal class Solution {
  fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
    val n = position.size
    val idx = arrayOfNulls<Int>(n)
    for (i in 0 until n) {
      idx[i] = i
    }
    Arrays.sort(idx) { i, j -> position[j] - position[i] }
    var ans = 0
    var pre = 0.0
    for (i in idx) {
      val t = 1.0 * (target - position[i]) / speed[i]
      if (t > pre) {
        ++ans
        pre = t
      }
    }
    return ans
  }
}
