internal class Solution {
  fun longestWPI(hours: IntArray): Int {
    var ans = 0
    var s = 0
    val pos: Map<Int, Int> = HashMap()
    for (i in hours.indices) {
      s += if (hours[i] > 8) 1 else -1
      if (s > 0) {
        ans = i + 1
      } else if (pos.containsKey(s - 1)) {
        ans = Math.max(ans, i - pos[s - 1]!!)
      }
      pos.putIfAbsent(s, i)
    }
    return ans
  }
}
