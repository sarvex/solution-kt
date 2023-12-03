class Solution {
  fun minOperations(nums: IntArray): Int {
    val count: Map<Int, Int> = HashMap()
    for (num in nums) {
      // count.put(num, count.getOrDefault(num, 0) + 1);
      count.merge(num, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    var ans = 0
    for (c in count.values()) {
      if (c < 2) {
        return -1
      }
      val r = c % 3
      val d = c / 3
      ans += when (r) {
        0 -> {
          d
        }

        else -> {
          d + 1
        }
      }
    }
    return ans
  }
}
