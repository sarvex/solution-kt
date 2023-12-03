class Solution {
  fun tupleSameProduct(nums: IntArray): Int {
    val cnt: Map<Int, Int> = HashMap()
    for (i in 1 until nums.size) {
      for (j in 0 until i) {
        val x = nums[i] * nums[j]
        cnt.merge(x, 1) { a: Int, b: Int -> Integer.sum(a, b) }
      }
    }
    var ans = 0
    for (v in cnt.values()) {
      ans += v * (v - 1) / 2
    }
    return ans shl 3
  }
}
