class Solution {
  fun pivotArray(nums: IntArray, pivot: Int): IntArray {
    val n = nums.size
    val ans = IntArray(n)
    var k = 0
    for (x in nums) {
      if (x < pivot) {
        ans[k++] = x
      }
    }
    for (x in nums) {
      if (x == pivot) {
        ans[k++] = x
      }
    }
    for (x in nums) {
      if (x > pivot) {
        ans[k++] = x
      }
    }
    return ans
  }
}
