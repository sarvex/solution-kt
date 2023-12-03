class Solution {
  fun maximumBags(capacity: IntArray, rocks: IntArray, additionalRocks: Int): Int {
    var additionalRocks = additionalRocks
    val n = capacity.size
    val d = IntArray(n)
    for (i in 0 until n) {
      d[i] = capacity[i] - rocks[i]
    }
    Arrays.sort(d)
    var ans = 0
    for (v in d) {
      additionalRocks -= if (v <= additionalRocks) {
        ++ans
        v
      } else {
        break
      }
    }
    return ans
  }
}
