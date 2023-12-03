internal class NumArray(nums: IntArray) {
  private val s: IntArray

  init {
    val n = nums.size
    s = IntArray(n + 1)
    for (i in 0 until n) {
      s[i + 1] = s[i] + nums[i]
    }
  }

  fun sumRange(left: Int, right: Int): Int {
    return s[right + 1] - s[left]
  }
}
