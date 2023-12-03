internal class Solution {
  private var t = 0
  private var d = 0
  private var ans: String? = null
  private var s: Set<Char>? = null
  fun nextClosestTime(time: String): String {
    t = time.substring(0, 2).toInt() * 60 + time.substring(3).toInt()
    d = Int.MAX_VALUE
    s = HashSet()
    var mi = 'z'
    for (c in time.toCharArray()) {
      if (c != ':') {
        s.add(c)
        if (c < mi) {
          mi = c
        }
      }
    }
    ans = null
    dfs("")
    if (ans == null) {
      ans = "$mi$mi:$mi$mi"
    }
    return ans!!
  }

  private fun dfs(curr: String) {
    if (curr.length == 4) {
      if (!check(curr)) {
        return
      }
      val p = curr.substring(0, 2).toInt() * 60 + curr.substring(2).toInt()
      if (p > t && p - t < d) {
        d = p - t
        ans = curr.substring(0, 2) + ":" + curr.substring(2)
      }
      return
    }
    for (c in s!!) {
      dfs(curr + c)
    }
  }

  private fun check(t: String): Boolean {
    val h = t.substring(0, 2).toInt()
    val m = t.substring(2).toInt()
    return 0 <= h && h < 24 && 0 <= m && m < 60
  }
}
