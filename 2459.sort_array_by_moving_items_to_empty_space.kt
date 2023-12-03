import kotlin.math.min

class Solution {
  fun sortArray(nums: IntArray): Int {
    val n = nums.size
    val arr = IntArray(n)
    for (i in 0 until n) {
      arr[i] = (nums[i] - 1 + n) % n
    }
    val a = f(nums, 0)
    val b = f(arr, n - 1)
    return min(a.toDouble(), b.toDouble()).toInt()
  }

  private fun f(nums: IntArray, k: Int): Int {
    val vis = BooleanArray(nums.size)
    var cnt = 0
    for (i in nums.indices) {
      if (i == nums[i] || vis[i]) {
        continue
      }
      ++cnt
      var j = nums[i]
      while (!vis[j]) {
        vis[j] = true
        ++cnt
        j = nums[j]
      }
    }
    if (nums[k] != k) {
      cnt -= 2
    }
    return cnt
  }
}
