import kotlin.math.max

class Solution {
  fun maximumANDSum(nums: IntArray, numSlots: Int): Int {
    val n = nums.size
    val m = numSlots shl 1
    val f = IntArray(1 shl m)
    var ans = 0
    for (i in 0 until (1 shl m)) {
      val cnt = Integer.bitCount(i)
      if (cnt > n) {
        continue
      }
      for (j in 0 until m) {
        if (i shr j and 1 == 1) {
          f[i] = max(f[i].toDouble(), (f[i xor (1 shl j)] + (nums[cnt - 1] and j / 2 + 1)).toDouble())
            .toInt()
        }
      }
      ans = max(ans.toDouble(), f[i].toDouble()).toInt()
    }
    return ans
  }
}
