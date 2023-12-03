import kotlin.math.abs

internal class Solution {
  fun findDisappearedNumbers(nums: IntArray): List<Int> {
    val n = nums.size
    for (x in nums) {
      val i = (abs(x.toDouble()) - 1).toInt()
      if (nums[i] > 0) {
        nums[i] *= -1
      }
    }
    val ans: List<Int> = ArrayList()
    for (i in 0 until n) {
      if (nums[i] > 0) {
        ans.add(i + 1)
      }
    }
    return ans
  }
}
