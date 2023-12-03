internal class Solution {
  fun removeDuplicates(nums: IntArray): Int {
    var k = 0
    for (x in nums) {
      if (k == 0 || x != nums[k - 1]) {
        nums[k++] = x
      }
    }
    return k
  }
}
