class Solution {
  fun minImpossibleOR(nums: IntArray): Int {
    val s: Set<Int> = HashSet()
    for (x in nums) {
      s.add(x)
    }
    var i = 0
    while (true) {
      if (!s.contains(1 shl i)) {
        return 1 shl i
      }
      ++i
    }
  }
}
