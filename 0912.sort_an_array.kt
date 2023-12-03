internal class Solution {
  private var nums: IntArray
  fun sortArray(nums: IntArray): IntArray {
    this.nums = nums
    quikcSort(0, nums.size - 1)
    return nums
  }

  private fun quikcSort(l: Int, r: Int) {
    if (l >= r) {
      return
    }
    val x = nums[l + r shr 1]
    var i = l - 1
    var j = r + 1
    while (i < j) {
      while (nums[++i] < x) {
      }
      while (nums[--j] > x) {
      }
      if (i < j) {
        val t = nums[i]
        nums[i] = nums[j]
        nums[j] = t
      }
    }
    quikcSort(l, j)
    quikcSort(j + 1, r)
  }
}
