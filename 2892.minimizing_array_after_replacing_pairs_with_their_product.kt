class Solution {
  fun minArrayLength(nums: IntArray, k: Int): Int {
    var ans = 1
    var y = nums[0].toLong()
    for (i in 1 until nums.size) {
      val x = nums[i]
      if (x == 0) {
        return 1
      }
      if (x * y <= k) {
        y *= x.toLong()
      } else {
        y = x.toLong()
        ++ans
      }
    }
    return ans
  }
}
