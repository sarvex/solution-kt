class Solution {
  fun longestEqualSubarray(nums: List<Int?>, k: Int): Int {
    val cnt: Map<Int?, Int> = HashMap()
    var mx = 0
    var l = 0
    for (r in 0 until nums.size()) {
      cnt.merge(nums[r], 1) { a: Int, b: Int -> Integer.sum(a, b) }
      mx = Math.max(mx, cnt[nums[r]]!!)
      if (r - l + 1 - mx > k) {
        cnt.merge(nums[l++], -1) { a: Int, b: Int -> Integer.sum(a, b) }
      }
    }
    return mx
  }
}
