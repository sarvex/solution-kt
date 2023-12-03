internal class Solution {
  fun removeElement(nums: IntArray, `val`: Int): Int {
    var k = 0
    for (x in nums) {
      if (x != `val`) {
        nums[k++] = x
      }
    }
    return k
  }
}
