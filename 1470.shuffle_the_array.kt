class Solution {
  fun shuffle(nums: IntArray, n: Int): IntArray {
    val ans = IntArray(n shl 1)
    var i = 0
    var j = 0
    while (i < n) {
      ans[j++] = nums[i]
      ans[j++] = nums[i + n]
      ++i
    }
    return ans
  }
}
