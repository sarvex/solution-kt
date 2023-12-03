class Solution {
  fun findIndices(nums: IntArray, indexDifference: Int, valueDifference: Int): IntArray {
    var mi = 0
    var mx = 0
    for (i in indexDifference until nums.size) {
      val j = i - indexDifference
      if (nums[j] < nums[mi]) {
        mi = j
      }
      if (nums[j] > nums[mx]) {
        mx = j
      }
      if (nums[i] - nums[mi] >= valueDifference) {
        return intArrayOf(mi, i)
      }
      if (nums[mx] - nums[i] >= valueDifference) {
        return intArrayOf(mx, i)
      }
    }
    return intArrayOf(-1, -1)
  }
}
