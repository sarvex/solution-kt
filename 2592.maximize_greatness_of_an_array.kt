class Solution {
  fun maximizeGreatness(nums: IntArray): Int {
    Arrays.sort(nums)
    var i = 0
    for (x in nums) {
      if (x > nums[i]) {
        ++i
      }
    }
    return i
  }
}
