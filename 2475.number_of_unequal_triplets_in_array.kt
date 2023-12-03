class Solution {
  fun unequalTriplets(nums: IntArray): Int {
    val cnt: Map<Int, Int> = HashMap()
    for (v in nums) {
      cnt.merge(v, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    var ans = 0
    var a = 0
    val n = nums.size
    for (b in cnt.values()) {
      val c = n - a - b
      ans += a * b * c
      a += b
    }
    return ans
  }
}
