class Solution {
  fun minimumSum(n: Int, k: Int): Int {
    var n = n
    var s = 0
    var i = 1
    val vis = BooleanArray(k + n * n + 1)
    while (n-- > 0) {
      while (vis[i]) {
        ++i
      }
      vis[i] = true
      if (k >= i) {
        vis[k - i] = true
      }
      s += i
    }
    return s
  }
}
