import kotlin.math.min

class Solution {
  fun minMoves(nums: IntArray, k: Int): Int {
    val arr: List<Int> = ArrayList()
    val n = nums.size
    for (i in 0 until n) {
      if (nums[i] != 0) {
        arr.add(i)
      }
    }
    val m: Int = arr.size()
    val s = IntArray(m + 1)
    for (i in 0 until m) {
      s[i + 1] = s[i] + arr[i]
    }
    var ans = (1 shl 60).toLong()
    val x = (k + 1) / 2
    val y = k - x
    for (i in x - 1 until m - y) {
      val j = arr[i]
      val ls = s[i + 1] - s[i + 1 - x]
      val rs = s[i + 1 + y] - s[i + 1]
      val a = (j + j - x + 1L) * x / 2 - ls
      val b = rs - (j + 1L + j + y) * y / 2
      ans = min(ans.toDouble(), (a + b).toDouble()).toLong()
    }
    return ans.toInt()
  }
}
