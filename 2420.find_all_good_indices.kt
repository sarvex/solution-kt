class Solution {
  fun goodIndices(nums: IntArray, k: Int): List<Int> {
    val n = nums.size
    val decr = IntArray(n)
    val incr = IntArray(n)
    Arrays.fill(decr, 1)
    Arrays.fill(incr, 1)
    for (i in 2 until n - 1) {
      if (nums[i - 1] <= nums[i - 2]) {
        decr[i] = decr[i - 1] + 1
      }
    }
    for (i in n - 3 downTo 0) {
      if (nums[i + 1] <= nums[i + 2]) {
        incr[i] = incr[i + 1] + 1
      }
    }
    val ans: List<Int> = ArrayList()
    for (i in k until n - k) {
      if (decr[i] >= k && incr[i] >= k) {
        ans.add(i)
      }
    }
    return ans
  }
}
