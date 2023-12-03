import kotlin.math.min

class Solution {
  fun minSessions(tasks: IntArray, sessionTime: Int): Int {
    val n = tasks.size
    val ok = BooleanArray(1 shl n)
    for (i in 1 until (1 shl n)) {
      var t = 0
      for (j in 0 until n) {
        if (i shr j and 1 == 1) {
          t += tasks[j]
        }
      }
      ok[i] = t <= sessionTime
    }
    val f = IntArray(1 shl n)
    Arrays.fill(f, 1 shl 30)
    f[0] = 0
    for (i in 1 until (1 shl n)) {
      var j = i
      while (j > 0) {
        if (ok[j]) {
          f[i] = min(f[i].toDouble(), (f[i xor j] + 1).toDouble()).toInt()
        }
        j = j - 1 and i
      }
    }
    return f[(1 shl n) - 1]
  }
}
