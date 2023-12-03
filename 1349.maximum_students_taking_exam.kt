import kotlin.math.max

class Solution {
  private var f: Array<Array<Int>>
  private var n = 0
  private var ss: IntArray
  fun maxStudents(seats: Array<CharArray>): Int {
    val m = seats.size
    n = seats[0].size
    ss = IntArray(m)
    f = Array(1 shl n) { arrayOfNulls(m) }
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (seats[i][j] == '.') {
          ss[i] = ss[i] or (1 shl j)
        }
      }
    }
    return dfs(ss[0], 0)
  }

  private fun dfs(seat: Int, i: Int): Int {
    if (f[seat][i] != null) {
      return f[seat][i]
    }
    var ans = 0
    for (mask in 0 until (1 shl n)) {
      if (seat or mask != seat || mask and (mask shl 1) != 0) {
        continue
      }
      val cnt = Integer.bitCount(mask)
      if (i == ss.size - 1) {
        ans = max(ans.toDouble(), cnt.toDouble()).toInt()
      } else {
        var nxt = ss[i + 1]
        nxt = nxt and (mask shl 1).inv()
        nxt = nxt and (mask shr 1).inv()
        ans = max(ans.toDouble(), (cnt + dfs(nxt, i + 1)).toDouble()).toInt()
      }
    }
    return ans.also { f[seat][i] = it }
  }
}
