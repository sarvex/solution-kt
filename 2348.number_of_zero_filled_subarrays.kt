class Solution {
  fun zeroFilledSubarray(nums: IntArray): Long {
    var ans: Long = 0
    var cnt = 0
    for (v in nums) {
      cnt = if (v != 0) 0 else cnt + 1
      ans += cnt.toLong()
    }
    return ans
  }
}
