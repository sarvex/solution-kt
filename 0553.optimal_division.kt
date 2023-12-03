internal class Solution {
  fun optimalDivision(nums: IntArray): String {
    val n = nums.size
    if (n == 1) {
      return nums[0].toString() + ""
    }
    if (n == 2) {
      return nums[0].toString() + "/" + nums[1]
    }
    val ans = StringBuilder(nums[0].toString() + "/(")
    for (i in 1 until n - 1) {
      ans.append(nums[i].toString() + "/")
    }
    ans.append(nums[n - 1].toString() + ")")
    return ans.toString()
  }
}
