class Solution {
  fun minimumSum(num: Int): Int {
    var num = num
    val nums = IntArray(4)
    var i = 0
    while (num != 0) {
      nums[i] = num % 10
      num /= 10
      ++i
    }
    Arrays.sort(nums)
    return 10 * (nums[0] + nums[1]) + nums[2] + nums[3]
  }
}
