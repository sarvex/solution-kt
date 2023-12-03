class Solution {
  fun beautifulSubarrays(nums: IntArray): Long {
    val cnt: Map<Int, Int> = HashMap()
    cnt.put(0, 1)
    var ans: Long = 0
    var mask = 0
    for (x in nums) {
      mask = mask xor x
      ans += cnt[mask] ?: 0
      cnt.merge(mask, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    return ans
  }
}
