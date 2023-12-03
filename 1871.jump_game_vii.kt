import kotlin.math.max

class Solution {
  fun canReach(s: String, minJump: Int, maxJump: Int): Boolean {
    val n = s.length
    val pre = IntArray(n + 1)
    pre[1] = 1
    val f = BooleanArray(n)
    f[0] = true
    for (i in 1 until n) {
      if (s[i] == '0') {
        val l = max(0.0, (i - maxJump).toDouble()).toInt()
        val r = i - minJump
        f[i] = l <= r && pre[r + 1] - pre[l] > 0
      }
      pre[i + 1] = pre[i] + if (f[i]) 1 else 0
    }
    return f[n - 1]
  }
}
