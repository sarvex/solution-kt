internal class Solution {
  fun canPartition(nums: IntArray): Boolean {
    // int s = Arrays.stream(nums).sum();
    var s = 0
    for (x in nums) {
      s += x
    }
    if (s % 2 == 1) {
      return false
    }
    val m = s shr 1
    val f = BooleanArray(m + 1)
    f[0] = true
    for (x in nums) {
      for (j in m downTo x) {
        f[j] = f[j] or f[j - x]
      }
    }
    return f[m]
  }
}
