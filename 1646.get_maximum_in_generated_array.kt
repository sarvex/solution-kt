class Solution {
  fun getMaximumGenerated(n: Int): Int {
    if (n < 2) {
      return n
    }
    val nums = IntArray(n + 1)
    nums[1] = 1
    for (i in 2..n) {
      nums[i] = if (i % 2 == 0) nums[i shr 1] else nums[i shr 1] + nums[(i shr 1) + 1]
    }
    return Arrays.stream(nums).max().getAsInt()
  }
}
