class Solution {
  fun circularGameLosers(n: Int, k: Int): IntArray {
    val vis = BooleanArray(n)
    var cnt = 0
    run {
      var i = 0
      var p = 1
      while (!vis[i]) {
        vis[i] = true
        ++cnt
        i = (i + p * k) % n
        ++p
      }
    }
    val ans = IntArray(n - cnt)
    var i = 0
    var j = 0
    while (i < n) {
      if (!vis[i]) {
        ans[j++] = i + 1
      }
      ++i
    }
    return ans
  }
}
