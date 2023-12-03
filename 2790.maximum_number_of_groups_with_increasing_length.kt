class Solution {
  fun maxIncreasingGroups(usageLimits: List<Int>): Int {
    Collections.sort(usageLimits)
    var k = 0
    var s: Long = 0
    for (x in usageLimits) {
      s += x.toLong()
      if (s > k) {
        ++k
        s -= k.toLong()
      }
    }
    return k
  }
}
