import kotlin.math.sqrt

class Solution {
  fun numSquarefulPerms(nums: IntArray): Int {
    val n = nums.size
    val f = Array(1 shl n) { IntArray(n) }
    for (j in 0 until n) {
      f[1 shl j][j] = 1
    }
    for (i in 0 until (1 shl n)) {
      for (j in 0 until n) {
        if (i shr j and 1 == 1) {
          for (k in 0 until n) {
            if (i shr k and 1 == 1 && k != j) {
              val s = nums[j] + nums[k]
              val t = sqrt(s.toDouble()).toInt()
              if (t * t == s) {
                f[i][j] += f[i xor (1 shl j)][k]
              }
            }
          }
        }
      }
    }
    var ans: Long = 0
    for (j in 0 until n) {
      ans += f[(1 shl n) - 1][j].toLong()
    }
    val cnt: Map<Int, Int> = HashMap()
    for (x in nums) {
      cnt.merge(x, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    val g = IntArray(13)
    g[0] = 1
    for (i in 1..12) {
      g[i] = g[i - 1] * i
    }
    for (v in cnt.values()) {
      ans /= g[v].toLong()
    }
    return ans.toInt()
  }
}
