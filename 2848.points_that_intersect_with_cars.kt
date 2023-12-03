class Solution {
  fun numberOfPoints(nums: List<List<Int?>>): Int {
    val d = IntArray(110)
    for (e in nums) {
      d[e[0]]++
      d[e[1] + 1]--
    }
    var ans = 0
    var s = 0
    for (x in d) {
      s += x
      if (s > 0) {
        ans++
      }
    }
    return ans
  }
}
