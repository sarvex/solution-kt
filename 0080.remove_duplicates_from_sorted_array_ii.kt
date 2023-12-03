internal class Solution {
  fun removeDuplicates(nums: IntArray): Int {
    var k = 0
    for (x in nums) {
      if (k < 2 || x != nums[k - 2]) {
        nums[k++] = x
      }
    }
    return k
  }
}
