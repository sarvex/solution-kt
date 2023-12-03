class Solution {
  fun addRungs(rungs: IntArray, dist: Int): Int {
    var ans = 0
    var prev = 0
    for (x in rungs) {
      ans += (x - prev - 1) / dist
      prev = x
    }
    return ans
  }
}
