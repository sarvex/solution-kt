class Solution {
  fun countDistinctIntegers(nums: IntArray): Int {
    val s: Set<Int> = HashSet()
    for (x in nums) {
      s.add(x)
    }
    for (x in nums) {
      var y = 0
      while (x > 0) {
        y = y * 10 + x % 10
        x /= 10
      }
      s.add(y)
    }
    return s.size()
  }
}
