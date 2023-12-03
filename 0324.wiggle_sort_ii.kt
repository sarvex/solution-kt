internal class Solution {
  fun wiggleSort(nums: IntArray) {
    val arr = nums.clone()
    Arrays.sort(arr)
    val n = nums.size
    var i = n - 1 shr 1
    var j = n - 1
    for (k in 0 until n) {
      if (k % 2 == 0) {
        nums[k] = arr[i--]
      } else {
        nums[k] = arr[j--]
      }
    }
  }
}
