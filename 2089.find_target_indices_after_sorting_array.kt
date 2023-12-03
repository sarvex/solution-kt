internal class Solution {
  fun targetIndices(nums: IntArray, target: Int): List<Int> {
    Arrays.sort(nums)
    val ans: List<Int> = ArrayList()
    for (i in nums.indices) {
      if (nums[i] == target) {
        ans.add(i)
      }
    }
    return ans
  }
}
